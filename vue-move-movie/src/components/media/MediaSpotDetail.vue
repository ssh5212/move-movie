<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">영화 스팟 검색</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <!-- [S] Movie -->
                <div class="col-lg-7 pb-2 pt-5">
                    <h3 class="pb-2">작중 스팟 장면</h3>
                    <img src="https://via.placeholder.com/1920x1080" alt="..." style="width: 100%" />

                    <h4 class="pt-4 pb-3">[건축학개론] 남주와 여주가 만나서 엘렐레</h4>
                    <p class="mb-2 text-left">주소 : 사랑시 고백구 행복동</p>
                    <p class="mb-2 text-left">스팟 등록자 : 연예인원영</p>
                    <p class="text-left">스팟 소개 : 영화 중반부에 남주와 여주가 함께 걸어가는 장면입니다.</p>

                    <button class="btn btn-dark m-2 mb-4 col-md-5 col-11" variant="primary" @click="moveSpotCreate">내 사진 올리기</button>
                    <button class="btn btn-dark m-2 mb-4 col-md-5 col-11" variant="primary" @click="moveRelationBucket">스폿 관련 버킷 리스트 보기</button>

                    <b-icon-basket2-fill id="b-icon" class="h2 col-md-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-basket2-fill>
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
            <div class="row justify-content-xlㅌ-center my-5 align-items-center">
                <MediaSpotDetailItem v-for="(spotInstance, index) in spotInstanceList" :key="index" :spotInstance="spotInstance"></MediaSpotDetailItem>
            </div>

            <!-- [E] 상세 스팟 -->
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MediaSpotDetailItem from '@/components/media/MediaSpotDetailItem.vue';

export default {
    name: 'MediaSpotDetail',
    components: { MediaSpotDetailItem },
    data() {
        return {
            spotInstanceList: [],
            spotInstance: Object, // 미디어는 별도로 불러오도록 일단 구현
            mediaSpot: Object,
        };
    },

    created() {
        this.mediaSpot = {
            spot_pk: 77,
            spot_name: 'b',
            spot_scene_desc: 'c',
            spot_img_src: 'https://placekitten.com/192/108',
            spot_lat: 11,
            spot_lon: 22,
            spot_address: 'ㅍㅍㅍ',
            spot_road_address: 'b',
            spot_characters: 'b',
            spot_movie_title: 'b',
            spot_filming_seq: 'b',
            user_pk: 77,
            sido_code: 'b',
            gugun_code: 'b',
        };

        this.spotInstance = {
            spot_instance_pk: 66,
            spot_instance_title: 'c',
            spot_instance_heart: 'c',
            spot_instance_content: 'c',
            spot_instance_img_src: 'https://placekitten.com/100/100',
            registertime: 'c',
            spot_pk: 66,
            user_pk: 66,
        };
        this.spotInstanceList.push(this.spotInstance);
        this.spotInstanceList.push(this.spotInstance);
        this.spotInstanceList.push(this.spotInstance);
    },

    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }

        this.loadArea(); // 지역 불러오기
        this.addEventMethod(); // 이벤트 등록
    },

    methods: {
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

        

        moveSpotCreate() {
            this.$router.push({
                name: 'spotCreate',
            });
        },

        // [function - 필수] 검색 기능 구현 완료 후 연결하기
        moveRelationBucket() {
            this.$router.push({
                name: 'bucketList',
                params: { no: this.spotInstance.spot_instance_pk },
            });
        },
    },
};
</script>

<style></style>
