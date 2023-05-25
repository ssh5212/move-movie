<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">상세 버킷 리스트</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container mt-5">
            <!-- 실제 내용 -->
            <!-- button -->
            <div class="row justify-content-xl-end">
                <b-button class="mr-2">나의 버킷으로 등록하기</b-button>
            </div>
            <div>
                <!--  content -->
                <div v-if="bucket" class="mt-5 mb-5">
                    <h3>버킷명 : {{ bucket.bucket_content }}</h3>
                </div>
                <hr class="my-5" />
                <!-- list -->
                <div class="mt-5">
                    <h4>버킷 스폿 목록</h4>
                    <div class="row justify-content-xl-center m-0">
                        <!-- detailitem.vue로 빼야함 -->
                        <bucket-spot-list-detail-item
                            v-for="(spot, index) in spots"
                            :key="index"
                            :spot_pk="spot.spot_pk"
                            :isMine="bucket.user_pk == checkUserInfo.user_pk"
                        ></bucket-spot-list-detail-item>
                    </div>
                </div>
                <!--  -->
                <!-- [S] map -->
                <div class="container mt-5">
                    <div id="map" class="mb-5" style="width: 100%; height: 400px"></div>
                </div>
                <hr class="my-5" />
                <!-- [E] map -->
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import { bucketListBybucketpk } from '@/api/bucketList.js';
import BucketSpotListDetailItem from '@/components/bucket/BucketSpotListDetailItem.vue';
import { spotByspotpk } from '@/api/spot.js';
import { bucketBybucketpk } from '@/api/bucket.js';
import { mapGetters } from 'vuex';

const userStore = 'userStore';

export default {
    name: 'BucketSpotListDetail',
    components: {
        BucketSpotListDetailItem,
    },
    data() {
        return {
            spots: [],
            spots_tmp: [],
            positions: [],
            markers: [],
            map: null,
            bucket: {
                content: '',
                user_pk: -1,
            },
        };
    },
    computed: {
        ...mapGetters(userStore, ['checkUserInfo']),
    },
    async created() {
        await bucketBybucketpk(this.$route.params.no, ({ data }) => {
            this.bucket = data.Bucket;
        });

        await bucketListBybucketpk(this.$route.params.no, ({ data }) => {
            this.spots = data.BucketDetailList;
            this.spots.forEach(spot => {
                spotByspotpk(spot.spot_pk, ({ data }) => {
                    this.spots_tmp.push(data.spot);
                });
            });
        });
    },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }

        setTimeout(() => {
            this.makeSpotList();
            this.loadMaker();
        }, 300);
    },
    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        //api 불러오기
        loadScript() {
            const script = document.createElement('script');
            script.src = '//dapi.kakao.com/v2/maps/sdk.js?appkey=067b8aa6c249b51bc098f93ee739672f&autoload=false&libraries=services,clusterer,drawing';
            script.onload = () => {
                window.kakao.maps.load(this.loadMap);
            };

            document.head.appendChild(script);
        },

        //맵 출력하기
        loadMap() {
            var mapContainer = document.getElementById('map'); // 지도를 표시할 div
            var mapOption = {
                center: new window.kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
                level: 5, // 지도의 확대 레벨
            };

            this.map = new window.kakao.maps.Map(mapContainer, mapOption);
        },

        makeSpotList() {
            this.positions = [];
            this.spots_tmp.forEach(mediaSpot => {
                let obj = {};
                obj.title = mediaSpot.spot_name;
                obj.latlng = new window.kakao.maps.LatLng(mediaSpot.spot_lat, mediaSpot.spot_lon);

                this.positions.push(obj);
            });
        },

        loadMaker() {
            // 마커를 생성합니다
            this.markers = [];
            this.positions.forEach(position => {
                const marker = new window.kakao.maps.Marker({
                    map: this.map, // 마커를 표시할 지도
                    position: position.latlng, // 마커를 표시할 위치
                    title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    //   image: markerImage, // 마커의 이미지
                });
                this.markers.push(marker);
            });
            // console.log("마커수 ::: " + this.markers.length);

            // 4. 지도를 이동시켜주기
            // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
            const bounds = this.positions.reduce((bounds, position) => bounds.extend(position.latlng), new window.kakao.maps.LatLngBounds());

            this.map.setBounds(bounds);
        },
    },
};
</script>

<style scoped></style>
