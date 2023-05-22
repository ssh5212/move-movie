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
            <div class="row justify-content-xl-center my-5 align-items-start">
                <!-- [S] map -->
                <div class="col-lg-7 pb-2 pt-5">
                    <h3 class="pb-2">작품 스팟</h3>
                    <div id="map" style="width: 100%; height: 377px"></div>
                </div>
                <!-- [E] map -->

                <!-- [S] Movie -->
                <div class="col-lg-5 pb-2 pt-5">
                    <h3 class="pb-2">작품 소개</h3>
                    <div class="card p-3" style="max-width: auto">
                        <div class="row no-gutters">
                            <div class="col-md-6">
                                <div class="h-100 d-flex align-items-center">
                                    <img :src="mediaTitle.stills || require('@/assets/img/no_img.png')" alt="..." style="width: 100%" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card-body">
                                    <h4 class="">{{ mediaTitle.title }}</h4>
                                    <p class="card-text-left"><b>제작년도</b> : {{ mediaTitle.prodYear }}</p>
                                    <p class="card-text-left"><b>장르</b> : {{ mediaTitle.genre }}</p>
                                    <p class="card-text-left"><b>키워드</b> : {{ mediaTitle.keywords }}</p>
                                    <p class="card-text-left"><b>상세</b> : <a :href="mediaTitle.kmdbUrl">KMDB 홈페이지</a></p>
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
import { mediaList, spotList } from "@/api/media.js";

export default {
    name: "MediaSpotList",
    components: { MediaSpotListItem },
    data() {
        return {
            mediaSpotList: [],
            mediaSpot: Object,
            mediaTitle: Object,
            title: String,
            listCount: 1,
        };
    },

    created() {
        this.title = this.$route.params.title.replace(/\s+/g, " ");
        this.searchMedia();
        this.searchSpot();
    },

    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }

        // this.loadArea(); // 지역 불러오기
        // this.addEventMethod(); // 이벤트 등록
    },

    methods: {
        // 관련 스폿 리스트 가져오기
        searchSpot() {
            let params = this.title;

            spotList(params, ({ data }) => {
                // console.log(data[1]);
                this.mediaSpotList = data.spots;
                console.log("++++++++++++++++++++++");
                console.log(this.mediaSpotList);
            });
        },

        searchMedia() {
            const params = {
                listCount: this.listCount, // 한 화면에 최대 영화 출력 수
                title: this.title, // 타이틀 명으로 검색
                query: this.title, // 정확도를 높이기 위해 query로 동시에 검색
            };

            mediaList(
                params,
                ({ data }) => {
                    const resultData = data["Data"][0]["Result"][0];
                    console.log(resultData);

                    // resultData.forEach((e) => {
                    this.mediaTitle = {
                        title: resultData.title.replace(/!HS |!HE /g, "").trim(),
                        kmdbUrl: resultData.kmdbUrl,
                        prodYear: resultData.prodYear, // 제작년도
                        // prodYear: e.regDatestr.slice(0, 4), // 개봉년도
                        keywords: resultData.keywords,
                        stills: resultData.posters.split("|")[0],
                        genre: resultData.genre,
                    };
                    // this.mediaTitleList.push(this.mediaTitle);
                    console.log(this.mediaTitle);
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
