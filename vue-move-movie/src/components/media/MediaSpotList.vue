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
                <!-- [S] map -->
                <div class="col-md-7 pb-2 pt-5">
                    <h3 class="pb-2">작품 스팟</h3>
                    <div id="map" style="width: 100%; height: 377px"></div>
                </div>
                <!-- [E] map -->

                <!-- [S] Movie -->
                <div class="col-md-5 pb-2 pt-5">
                    <h3 class="pb-2">작품 소개</h3>
                    <div class="card p-3" style="max-width: 540px">
                        <div class="row no-gutters">
                            <div class="col-md-6">
                                <div class="h-100 d-flex align-items-center">
                                    <img :src="mediaTitle.movie_posterurl" alt="..." style="width: 100%" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card-body">
                                    <p class="">영화명 : {{ mediaTitle.movie_title }}</p>
                                    <p class="card-text-left">감독1111111111111111111 : {{ mediaTitle.movie_director_name }}</p>
                                    <p class="card-text-left">제작사 : {{ mediaTitle.movie_actor_name }}</p>
                                    <p class="card-text-left">출연 배우 : {{ mediaTitle.movie_company }}</p>
                                    <p class="card-text-left">제작년도 : {{ mediaTitle.movie_plot }}</p>
                                    <p class="card-text-left">개봉일 : {{ mediaTitle.movie_genre }}</p>
                                    <p class="card-text-left">누적 매출액 : {{ mediaTitle.movie_title }}</p>
                                    <p class="card-text-left">주제곡 : {{ mediaTitle.movie_keywords }}</p>
                                    <p class="card-text-left">삽입곡 : {{ mediaTitle.movie_posterurl }}</p>
                                    <p class="card-text-left">줄거리 : {{ mediaTitle.movie_vod_url }}</p>
                                    <p class="card-text-left">촬영장소 : {{ mediaTitle.user_pk }}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- [E] Movie -->
            </div>

            <hr class="mb-4" />
            <!-- 상세 스팟 -->
            <MediaSpotListItem v-for="(mediaSpot, index) in mediaSpotList" :key="index" :mediaSpot="mediaSpot"></MediaSpotListItem>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MediaSpotListItem from "@/components/media/MediaSpotListItem.vue";
import { mediaList } from "@/api/media.js";

export default {
    name: "MediaSpotList",
    components: { MediaSpotListItem },
    data() {
        return {
            mediaSpotList: [],
            mediaSpot: Object,
            mediaTitle: Object, // 미디어는 별도로 불러오도록 일단 구현
            searchTitle: String,
            searchYear: String,
        };
    },

    created() {
        console.log("===================");
        console.log(this.$route.params.title);
    },

    mounted() {
        console.log("========================= 1");

        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }
        console.log("========================= 2");

        // this.loadArea(); // 지역 불러오기
        // this.addEventMethod(); // 이벤트 등록
    },

    methods: {
        searchMedia() {
            this.mediaTitleList = [];
            const params = {
                listCount: this.listCount, // 한 화면에 최대 영화 출력 수
                title: this.title, // 타이틀 명 검색 시
                actor: this.actor, // 배우 검색 시
                keyword: this.keyword, // 키워드 검색 시
            };

            mediaList(
                params,
                ({ data }) => {
                    console.log(data["Data"][0]["Result"]);
                    const resultData = data["Data"][0]["Result"][0];
                    // resultData.forEach((e) => {
                    this.mediaTitle = {
                        title: resultData.title.replace(/!HS |!HE /g, "").trim(),
                        kmdbUrl: resultData.kmdbUrl,
                        prodYear: resultData.prodYear,
                        keyword: resultData.keyword,
                        stlls: resultData.stlls.split("|")[0],
                    };
                    // this.mediaTitleList.push(this.mediaTitle);
                    // console.log(this.mediaTitle);
                    // });
                },
                (error) => {
                    console.log(error);
                }
            );
        },

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
    },
};
</script>

<style>
.img-bg-dark {
    filter: brightness(1);
    transition: 0.5s;
}

.img-bg-dark:hover {
    filter: brightness(0.6);
    cursor: pointer;
}
.card-overlay {
    position: absolute;
    top: 80%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: white;
    text-shadow: 3px 3px 5px rgba(0, 0, 0, 1);
    width: 200px;
}

.card-text-left {
    text-align: left;
    margin-bottom: 4px;
}
</style>
