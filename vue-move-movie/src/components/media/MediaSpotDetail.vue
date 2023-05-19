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

                    <button class="btn btn-dark m-2 mb-4 col-md-5 col-11" variant="primary" @click="Modify">내 사진 올리기</button>
                    <button class="btn btn-dark m-2 mb-4 col-md-5 col-11" variant="primary" @click="Modify">스폿 관련 버킷 리스트 보기</button>

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
            <!-- [S] 상세 스팟 -->
            <h3 class="pb-2 mt-5">사용자 스팟 사진</h3>

            <!-- 영화 1 -->
            <div class="col-md-4 my-4 position-relative">
                <div class="card">
                    <img src="https://via.placeholder.com/1920x1080" class="card-img-top p-3 pt-5" />
                    <div class="card-body pb-5" style="text-align: left">
                        <h5 class="card-title" style="text-align: left">포토 제목</h5>
                        <b-icon-heart-fill id="b-icon" class="h5 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                        <span class="card-text"><small class="text-muted">1000</small></span>
                    </div>
                </div>
            </div>

            <!-- [E] 상세 스팟 -->
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
