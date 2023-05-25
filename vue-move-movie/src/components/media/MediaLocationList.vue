<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">위치로 영화 검색</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <!-- Search -->
                <div class="col-lg-12 pb-2 pt-5">
                    <h3 class="pb-2">검색</h3>
                    <MediaSearchBar></MediaSearchBar>
                </div>
                <!-- map -->
                <div class="col-lg-12 pb-2 pt-5">
                    <h3 class="pb-2">작품 스팟</h3>
                    <div id="map" style="width: 100%; height: 600px"></div>
                </div>
            </div>

            <hr class="mb-5" />
            <!-- 화면 1 -->
            <MediaSpotListItem v-for="(mediaSpot, index) in medias" :key="index" :mediaSpot="mediaSpot"></MediaSpotListItem>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MediaSearchBar from "./MediaSearchBar.vue";
import MediaSpotListItem from "@/components/media/MediaSpotListItem.vue";
import { mapState } from "vuex";
const mediaStore = "mediaStore";

export default {
    name: "MediaLocationList",
    components: { MediaSearchBar, MediaSpotListItem },
    data() {
        return {
            spotInstance: Object, // 미디어는 별도로 불러오도록 일단 구현
            mediaSpot: Object,
            positions: [],
        };
    },

    computed: {
        ...mapState(mediaStore, ["medias", "bucket"]),
    },

    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }
    },

    watch: {
        medias(newName) {
            console.log(newName);
            setTimeout(() => {
                this.makeSpotList();
                if (this.medias.length > 0) {
                    this.loadMaker();
                }
            }, 300);
        },
    },

    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        // [S] kakao

        //api 불러오기
        loadScript() {
            const script = document.createElement("script");
            script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=067b8aa6c249b51bc098f93ee739672f&autoload=false&libraries=services,clusterer,drawing";
            script.onload = () => {
                window.kakao.maps.load(this.loadMap);
            };

            document.head.appendChild(script);
        },

        //맵 출력하기
        loadMap() {
            var mapContainer = document.getElementById("map"); // 지도를 표시할 div
            var mapOption = {
                center: new window.kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
                level: 5, // 지도의 확대 레벨
            };

            this.map = new window.kakao.maps.Map(mapContainer, mapOption);
        },

        makeSpotList() {
            this.positions = [];
            this.medias.forEach((mediaSpot) => {
                let obj = {};
                obj.title = mediaSpot.spot_name;
                obj.latlng = new window.kakao.maps.LatLng(mediaSpot.spot_lat, mediaSpot.spot_lon);

                this.positions.push(obj);
            });
            console.log(this.positions);
        },
        loadMaker() {
            // 마커를 생성합니다
            this.markers = [];
            this.positions.forEach((position) => {
                const marker = new window.kakao.maps.Marker({
                    map: this.map, // 마커를 표시할 지도
                    position: position.latlng, // 마커를 표시할 위치
                    title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                });
                this.markers.push(marker);
            });

            // 4. 지도를 이동시켜주기
            // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
            const bounds = this.positions.reduce((bounds, position) => bounds.extend(position.latlng), new window.kakao.maps.LatLngBounds());

            this.map.setBounds(bounds);
        },
        // [E] kakao

        moveSpotCreate() {
            this.$router.push({
                name: "spotCreate",
            });
            window.scrollTo(0, 0);
        },

        // [function - 필수] 검색 기능 구현 완료 후 연결하기
        moveRelationBucket() {
            this.$router.push({
                name: "bucketList",
                params: { no: this.spotInstance.spot_instance_pk },
            });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style></style>
