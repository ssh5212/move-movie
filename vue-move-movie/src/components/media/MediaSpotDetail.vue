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
                                    <img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87032/87032_320.jpg" alt="..." style="width: 100%" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card-body">
                                    <p class="card-text">영화명 :</p>
                                    <p class="card-text">감독 :</p>
                                    <p class="card-text">제작사 :</p>
                                    <p class="card-text">출연 배우 :</p>
                                    <p class="card-text">제작년도 :</p>
                                    <p class="card-text">개봉일 :</p>
                                    <p class="card-text">누적 매출액 :</p>
                                    <p class="card-text">주제곡 :</p>
                                    <p class="card-text">삽입곡 :</p>
                                    <p class="card-text">줄거리 :</p>
                                    <p class="card-text">촬영장소 :</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- [E] Movie -->
            </div>

            <hr class="mb-4" />
            <!-- 상세 스팟 -->
            <div class="card mb-3 my-5" style="width: 100%">
                <div class="row no-gutters align-items-center">
                    <div class="col-md-3 p-3 d-flex justify-content-center align-items-center">
                        <img src="https://via.placeholder.com/1920x1080" alt="..." style="width: 100%" />
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">spot title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">사랑시 고백구 행복동</small></p>
                        </div>
                    </div>
                    <div class="col-md-1 d-flex flex-column justify-content-center align-items-center">
                        <!-- <b-icon-basket2 id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2> -->
                        <b-icon-basket2-fill id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2-fill>
                        <!-- <b-icon-heart id="b-icon" class="h2 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart> -->
                        <b-icon-heart-fill id="b-icon" class="h2 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                        <p class="card-text text-center"><small class="text-muted">1000</small></p>
                    </div>
                </div>
            </div>
            <!-- 상세 스팟 -->
            <div class="card mb-3 my-5" style="width: 100%">
                <div class="row no-gutters align-items-center">
                    <div class="col-md-3 p-3 d-flex justify-content-center align-items-center">
                        <img src="https://via.placeholder.com/1920x1080" alt="..." style="width: 100%" />
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">spot title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">사랑시 고백구 행복동</small></p>
                        </div>
                    </div>
                    <div class="col-md-1 d-flex flex-column justify-content-center align-items-center">
                        <!-- <b-icon-basket2 id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2> -->
                        <b-icon-basket2-fill id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2-fill>
                        <!-- <b-icon-heart id="b-icon" class="h2 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart> -->
                        <b-icon-heart-fill id="b-icon" class="h2 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                        <p class="card-text text-center"><small class="text-muted">1000</small></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {
    name: 'MediaSpotList',
    components: {},
    data() {
        return {
            message: '',
        };
    },

    created() {},

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
    },
};
</script>

<style></style>
