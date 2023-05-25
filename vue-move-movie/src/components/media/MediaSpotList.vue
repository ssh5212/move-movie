<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
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
                    <!-- <KakaoMap :mediaSpotList="mediaSpotList"></KakaoMap> -->
                    <div id="map" style="width: 100%; height: 500px"></div>
                </div>
                <!-- [E] map -->

                <!-- [S] Movie -->
                <div class="col-lg-5 pb-2 pt-5">
                    <h3 class="pb-2">작품 소개</h3>
                    <div class="card p-3" style="max-width: auto">
                        <div class="row no-gutters">
                            <div class="col-md-6">
                                <div class="h-100 d-flex align-items-center">
                                    <img :src="mediaTitle.stlls || require('@/assets/img/no_img.png')" style="width: 100%" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card-body">
                                    <h4 class="">{{ mediaTitle.title }}</h4>
                                    <p class="card-text-left"><b>제작년도</b> : {{ mediaTitle.prodYear }}</p>
                                    <p class="card-text-left"><b>장르</b> : {{ mediaTitle.genre }}</p>
                                    <p class="card-text-left"><b>키워드</b> : {{ mediaTitle.keyword }}</p>
                                    <p class="card-text-left">
                                        <b>상세</b> :
                                        <a :href="mediaTitle.kmdbUrl">KMDB 홈페이지</a>
                                    </p>
                                </div>

                                <!-- <button class="btn btn-dark m-2 mb-4 col-md-5 col-11 mb-3" variant="primary" @click="moveRelationBucket">스폿 관련 버킷 리스트 보기</button> -->
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-dark my-3" style="width: 100%" variant="primary" @click="moveSpotCreate">스팟 생성하기</button>
                </div>
                <!-- [E] Movie -->
            </div>

            <hr class="mb-5" />

            <!-- 상세 스팟 -->
            <template v-if="mediaSpotListLoaded">
                <MediaSpotListItem v-for="(mediaSpot, index) in mediaSpotList" :key="index" :mediaSpot="mediaSpot"></MediaSpotListItem>
            </template>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MediaSpotListItem from '@/components/media/MediaSpotListItem.vue';
import { mediaList, spotList } from '@/api/media.js';
// import KakaoMap from "@/components/KakaoMap.vue";

export default {
    name: 'MediaSpotList',
    components: { MediaSpotListItem },

    async created() {
        this.title = this.$route.params.title;
        this.docid = this.$route.params.docid;
        console.log('===========');
        console.log(this.$route.params.title);
        console.log('route : ' + this.$route.params.docid);
        this.searchMedia();
        await this.searchSpot();
    },

    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            console.log('test');
            this.loadScript();
        }

        setTimeout(() => {
            if (this.mediaSpotList.length > 0) {
                this.makeSpotList();
                this.loadMaker();
            }
        }, 300);
    },

    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        // 관련 스폿 리스트 가져오기
        searchSpot() {
            let params = this.$route.params.title;

            spotList(params, ({ data }) => {
                this.mediaSpotList = data.spots;
                this.mediaSpotListLoaded = true; // 데이터 로드 완료 상태로 설정
            });
        },

        searchMedia() {
            const params = {
                listCount: this.listCount, // 한 화면에 최대 영화 출력 수
                title: this.title, // 타이틀 명으로 검색
                query: this.title, // 정확도를 높이기 위해 query로 동시에 검색
            };

            // mediaList(
            //     params,
            //     ({ data }) => {
            //         const resultData = data['Data'][0]['Result'][0];

            //         // resultData.forEach((e) => {
            //         this.mediaTitle = {
            //             title: this.$route.params.title,
            //             kmdbUrl: resultData.kmdbUrl,
            //             prodYear: resultData.prodYear, // 제작년도
            //             // prodYear: e.regDatestr.slice(0, 4), // 개봉년도
            //             keywords: resultData.keywords,
            //             stills: resultData.posters.split('|')[0],
            //             genre: resultData.genre,
            //         };
            //         // this.mediaTitleList.push(this.mediaTitle);
            //         // });
            //     },
            //     error => {
            //         console.log(error);
            //     }
            // );

            mediaList(
                params,
                ({ data }) => {
                    const resultData = data['Data'][0]['Result'];
                    resultData.forEach(e => {
                        console.log(e.DOCID);
                        if (e.DOCID === this.docid) {
                            this.mediaTitle = {
                                title: e.title.replace(/ !HS | !HE /g, '').trim(),
                                kmdbUrl: e.kmdbUrl,
                                prodYear: e.prodYear, // 제작년도
                                keyword: e.keyword,
                                genre: e.genre,
                                stlls: e.posters.split('|')[0],
                                docid: e.DOCID,
                            };
                        }
                    });
                },
                error => {
                    console.log(error);
                    // 토스트에 출력할 데이터
                    let toast_data = {
                        title: 'Error', // Success, Fail 등 상태를 표기
                        sub: 'Spot List', // 상태가 일어난 위치 or 기능 표기
                        content: '영화 로딩 중 에러가 발생하였습니다.', // 내용 표기
                    };

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                }
            );
        },
        moveSpotCreate() {
            this.$router.push({
                name: 'spotCreate',
                params: { spot: this.mediaTitle },
            });
            window.scrollTo(0, 0);
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
            // this.positions = [];
            this.mediaSpotList.forEach(mediaSpot => {
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
    data() {
        return {
            mediaSpotList: [],
            mediaSpot: Object,
            mediaTitle: Object,
            title: String,
            docid: String,
            listCount: 20,
            mediaSpotListLoaded: false,
            positions: [],
        };
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
#map {
    width: 100%;
    height: 400px;
}
</style>
