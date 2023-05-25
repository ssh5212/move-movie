<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">영화 스팟 상세 화면</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <!-- [S] Movie -->
                <div class="col-lg-7 pb-2 pt-5">
                    <h3 class="pb-2">작중 스팟 장면</h3>
                    <img :src="img_src || require('@/assets/img/no_img_x.png')" alt="..." style="width: 100%" />

                    <h4 class="pt-4 pb-3">{{ mediaSpot.spot_name }}</h4>
                    <p class="mb-2 text-left">촬영 영화 : {{ mediaSpot.spot_movie_title }}</p>
                    <p class="mb-2 text-left">주소 : {{ mediaSpot.spot_address }}</p>
                    <p class="text-left">스팟 소개 : {{ mediaSpot.spot_scene_desc }}</p>
                    <!-- <p class="mb-2 text-left">스팟 등록자 : 연예인원영</p> -->

                    <button class="btn btn-dark m-2 mb-4 col-md-5 col-11" variant="primary" @click="moveSpotCreate">내 사진 올리기</button>
                    <button class="btn btn-dark m-2 mb-4 col-md-5 col-11" variant="primary" @click="moveRelationBucket">스폿 관련 버킷 리스트 보기</button>

                    <b-icon-basket2-fill id="b-icon" class="h2 col-md-1 m-0 bucket-btn" @click="addThisSpot"></b-icon-basket2-fill>
                </div>
                <!-- [E] Movie -->

                <!-- [S] map -->
                <div class="col-lg-5 pb-2 pt-5">
                    <h3 class="pb-2">작품 스팟</h3>
                    <div id="map" style="width: 100%; height: 600px"></div>
                </div>
                <!-- [E] map -->
            </div>

            <hr class="mb-4" />
            <!-- [S] 스팟 인스턴스-->
            <h3 class="pb-2 mt-5">사용자 스팟 사진</h3>

            <!-- 화면 1 -->
            <div class="row justify-content-center my-5 align-items-center">
                <template v-if="spotInstanceList.length == 0">
                    <p>등록된 사용자 스팟 사진이 없습니다.</p>
                </template>
                <template v-else>
                    <MediaSpotDetailItem v-for="(spotInstance, index) in spotInstanceList" :key="index" :spotInstance="spotInstance"></MediaSpotDetailItem>
                </template>
            </div>

            <!-- [E] 상세 스팟 -->
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MediaSpotDetailItem from '@/components/media/MediaSpotDetailItem.vue';
import { mapState, mapMutations } from 'vuex';
import { getSpotInstance } from '@/api/media.js';
import { spotByspotpk } from '@/api/spot.js';
const toastStore = 'toastStore';
const mediaStore = 'mediaStore';

export default {
    name: 'MediaSpotDetail',
    components: { MediaSpotDetailItem },

    computed: {
        ...mapState(mediaStore, ['bucket', 'media']),
    },

    data() {
        return {
            img_src: null,
            spotInstanceList: [],
            mediaSpot: Object,
            spots_tmp: [],
        };
    },

    created() {
        console.log(this.$route.params.no);

        // spot_pk 를 통해 spot 데이터 불러오기
        spotByspotpk(this.$route.params.no, ({ data }) => {
            console.log(data.spot);
            this.mediaSpot = data.spot;
        });
        // img src set
        getSpotInstance(
            this.$route.params.no,
            ({ data }) => {
                // console.log(data.spots);
                this.spotInstanceList = data.spots;
                // console.log(this.spotInstance[0]);
            },
            error => {
                console.log(error);
            }
        );
        //
        setTimeout(() => {
            this.img_src = process.env.VUE_APP_API_BASE_URL + this.mediaSpot.spot_img_src;
        }, 200);
    },

    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }

        // 해당 부분 마커 찍기
        setTimeout(() => {
            this.spots_tmp.push(this.mediaSpot);
            this.makeSpotList();
            this.loadMaker();
        }, 300);
    },

    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        ...mapMutations(mediaStore, ['SET_MEDIA']),
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        //api 불러오기
        loadScript() {
            const script = document.createElement('script');
            script.src = '//dapi.kakao.com/v2/maps/sdk.js?appkey=067b8aa6c249b51bc098f93ee739672f&autoload=false&libraries=services,clusterer,drawing';
            script.onload = () => {
                window.kakao.maps.load(this.loadMap);
            };

            document.head.appendChild(script);
        },
        addThisSpot() {
            // bucket이 비어 있는 경우
            if (this.bucket.length == 0) {
                this.bucket.push(this.mediaSpot);
                // 토스트에 출력할 데이터
                let toast_data = {
                    title: 'Success', // Error, Delete, Login 등 상태를 표기
                    sub: 'Bucket Bag', // 상태가 일어난 위치 표기
                    content: 'Bucket Bag에 담겼습니다.', // 내용 표기
                };

                this.SET_TOAST(toast_data);
                this.SET_TOAST_CNT();
            } else {
                let isok = 1; // 해당 스폿이 버킷에 포함되어 있는지 판단
                this.bucket.forEach(b => {
                    if (b.spot_pk == this.mediaSpot.spot_pk) {
                        isok = 0;
                        // 토스트에 출력할 데이터
                        let toast_data = {
                            title: 'Fail', // Error, Delete, Login 등 상태를 표기
                            sub: 'Bucket Bag', // 상태가 일어난 위치 표기
                            content: 'Bucket Bag에 이미 존재합니다.', // 내용 표기
                        };

                        this.SET_TOAST(toast_data);
                        this.SET_TOAST_CNT();
                    }
                });
                if (isok == 1) {
                    this.bucket.push(this.mediaSpot);
                }
            }
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

        moveSpotCreate() {
            this.$router.push({
                name: 'spotDetailCreate',
                params: { no: this.$route.params.no },
            });
            window.scrollTo(0, 0);
        },

        // [function - 필수] 검색 기능 구현 완료 후 연결하기
        moveRelationBucket() {
            this.$router.push({
                name: 'bucketList',
                params: { no: this.mediaSpot.spot_instance_pk },
            });
            window.scrollTo(0, 0);
        },

        // 스폿의 인스턴스 가져오기
        getSpotInstance() {
            console.log(this.$route.params.no);
            // const params = this.$route.params.no;
            getSpotInstance(
                this.$route.params.no,
                ({ data }) => {
                    // console.log(data.spots);
                    this.spotInstanceList = data.spots;
                    console.log(this.spotInstance);
                    // console.log(this.spotInstance[0]);
                },
                error => {
                    console.log(error);
                }
            );
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

<style>
.bucket-btn:hover {
    color: rgba(0, 0, 0, 0.9) !important;
    cursor: pointer;
}
</style>
