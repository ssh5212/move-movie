<template>
    <div>
        <div id="map" style="width: 100%; height: 100px"></div>
    </div>
</template>

<script>
export default {
    name: "KakaoMap",
    components: {},
    data() {
        return {
            map: null,
            positions: [],
            markers: [],
        };
    },
    props: {
        mediaSpotList: [],
    },
    watch: {
        mediaSpotList() {
            console.log("충전소", this.mediaSpotList);
            this.positions = [];
            this.mediaSpotList.forEach((mediaSpot) => {
                let obj = {};
                obj.title = mediaSpot.spot_name;
                obj.latlng = new window.kakao.maps.LatLng(mediaSpot.spot_lat, mediaSpot.spot_lon);
                console.log("========obj");
                console.log(obj);

                this.positions.push(obj);
            });
            this.loadMaker();
        },
    },
    created() {
        // console.log("==========================");
        // console.log(this.mediaSpotList);
    },
    mounted() {
        // api 스크립트 소스 불러오기 및 지도 출력
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }
    },
    methods: {
        // api 불러오기
        loadScript() {
            const script = document.createElement("script");
            script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=" + process.env.VUE_APP_KAKAO_MAP_API_KEY + "&autoload=false";
            /* global kakao */
            script.onload = () => window.kakao.maps.load(this.loadMap);

            document.head.appendChild(script);
        },
        // 맵 출력하기
        loadMap() {
            const container = document.getElementById("map");
            const options = {
                center: new window.kakao.maps.LatLng(33.450701, 126.570667),
                level: 3,
            };

            this.map = new window.kakao.maps.Map(container, options);
            //   this.loadMaker();
        },
        // 지정한 위치에 마커 불러오기
        loadMaker() {
            // 현재 표시되어있는 marker들이 있다면 marker에 등록된 map을 없애준다.
            console.log("1111");
            this.deleteMarker();
            console.log("2222");
            // 마커 이미지를 생성합니다
            //   const imgSrc = require("@/assets/map/markerStar.png");
            // 마커 이미지의 이미지 크기 입니다
            //   const imgSize = new kakao.maps.Size(24, 35);
            //   const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

            // 마커를 생성합니다
            this.markers = [];
            this.positions.forEach((position) => {
                const marker = new kakao.maps.Marker({
                    map: this.map, // 마커를 표시할 지도
                    position: position.latlng, // 마커를 표시할 위치
                    title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    //   image: markerImage, // 마커의 이미지
                });
                this.markers.push(marker);
            });
            console.log("마커수 ::: " + this.markers.length);

            // 4. 지도를 이동시켜주기
            // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
            const bounds = this.positions.reduce((bounds, position) => bounds.extend(position.latlng), new kakao.maps.LatLngBounds());

            this.map.setBounds(bounds);
        },
        deleteMarker() {
            console.log("마커 싹 지우자!!!", this.markers.length);
            if (this.markers.length > 0) {
                this.markers.forEach((item) => {
                    console.log(item);
                    item.setMap(null);
                });
            }
        },
    },
};
</script>

<!-- <script>
// import { serviceKey, serviceKey_go } from "@/assets/js/key.js";

export default {
    name: "SearchAttraction",
    components: {},
    data() {
        return {
            // serviceKey,
            // serviceKey_go,
            map: null,
            positions: null,
            marker: null,
        };
    },
    props: {
        mediaSpotList: [],
    },
    watch: {
        mediaSpotList() {
            console.log("충전소", this.mediaSpotList);
            this.positions = [];
            this.chargers.forEach((charger) => {
                let obj = {};
                obj.title = charger.statNm;
                obj.latlng = new window.kakao.maps.LatLng(charger.lat, charger.lng);

                this.positions.push(obj);
            });
            this.loadMaker();
        },
    },
    created() {},

    mounted() {
        this.loadScript();
        // if (window.kakao && window.kakao.maps) {
        //     this.loadMap();
        // } else {
        // }

        // this.loadArea(); // 지역 불러오기
        // this.addEventMethod(); // 이벤트 등록
        this.displayMarker();
    },
    methods: {
        // //api 불러오기
        // loadScript() {
        //     const script = document.createElement("script");
        //     // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=067b8aa6c249b51bc098f93ee739672f&autoload=false&libraries=services,clusterer,drawing";
        //     script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=" + process.env.VUE_APP_KAKAO_MAP_API_KEY + "&autoload=false&libraries=services,clusterer,drawing";
        //     script.onload = () => {
        //         window.kakao.maps.load(this.loadMap);
        //     };

        //     document.head.appendChild(script);
        // },

        // //맵 출력하기
        // loadMap() {
        //     var mapContainer = document.getElementById("map"); // 지도를 표시할 div
        //     var mapOption = {
        //         center: new window.kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
        //         level: 5, // 지도의 확대 레벨
        //     };

        //     this.map = new window.kakao.maps.Map(mapContainer, mapOption);
        // },

        // // loadArea =>  시도 Option 영역 추가하기
        // makeOption(data) {
        //     let areas = data;
        //     // let areas = data.response.body.items.item;
        //     let sel = document.getElementById("search-area");
        //     areas.forEach((area) => {
        //         let opt = document.createElement("option");
        //         opt.setAttribute("value", area.sido_code);
        //         opt.appendChild(document.createTextNode(area.sido_name));
        //         sel.appendChild(opt);
        //     });
        // },

        // // 시도 추가하는 코드임 ㅋ
        // loadArea() {
        //     var areaUrl = "http://localhost:9003/enjoytrip/api/sido";

        //     fetch(areaUrl, { method: "GET" })
        //         .then(console.log(areaUrl))
        //         .then((response) => response.json())
        //         .then((data) => this.makeOption(data));
        // },

        // addEventMethod() {
        //     document.getElementById("btn-search").addEventListener("click", () => {
        //         let searchUrl = "http://localhost:9003/enjoytrip/api/listAttractionSearch?";

        //         let areaCode = document.getElementById("search-area").value;
        //         let contentTypeId = document.getElementById("search-content-id").value;
        //         let keyword = document.getElementById("search-keyword").value;

        //         if (parseInt(areaCode)) searchUrl += "&areaCode=" + areaCode;
        //         if (parseInt(contentTypeId)) searchUrl += "&contentTypeId=" + contentTypeId;
        //         if (!keyword) {
        //             alert("검색어 입력 필수!!!");
        //             return;
        //         } else searchUrl += "&keyword=" + keyword;

        //         console.log(searchUrl);

        //         fetch(searchUrl)
        //             .then((response) => response.json())
        //             .then((data) => this.makeList(data));
        //     });
        // },

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

        displayMarker() {
            // 마커 이미지의 이미지 주소입니다
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

            for (var i = 0; i < this.positions.length; i++) {
                // 마커 이미지의 이미지 크기 입니다
                var imageSize = new window.kakao.maps.Size(24, 35);

                // 마커 이미지를 생성합니다
                var markerImage = new window.kakao.maps.MarkerImage(imageSrc, imageSize);

                // 마커를 생성합니다
                this.marker = new window.kakao.maps.Marker({
                    map: this.map, // 마커를 표시할 지도
                    position: this.positions[i].latlng, // 마커를 표시할 위치
                    title: this.positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image: markerImage, // 마커 이미지
                });
            }

            // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
            this.map.setCenter(this.positions[0].latlng);
        },
    },
};
</script> -->
