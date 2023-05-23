<template>
    <div>
        <div id="map"></div>
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
        mediaSpotList: {
            immediate: true,
            handler() {
                if (this.mediaSpotList.length != 0) {
                    this.makeMediaSpotList();
                }
            },
        },
    },
    created() {},
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
            // this.loadMaker();
        },

        makeMediaSpotList() {
            console.log("충전소", this.mediaSpotList);
            this.positions = [];
            this.mediaSpotList.forEach((mediaSpot) => {
                // console.log("----------");
                // console.log(mediaSpot);
                // console.log("----------");
                console.log(window.kakao.maps);
                let obj = {};
                obj.title = mediaSpot.spot_name;
                obj.latlng = new kakao.maps.LatLng(mediaSpot.spot_lat, mediaSpot.spot_lon);
                // console.log("========obj");
                // console.log(obj);

                this.positions.push(obj);
            });
            this.loadMaker();
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
            // console.log("마커수 ::: " + this.markers.length);

            // 4. 지도를 이동시켜주기
            // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
            const bounds = this.positions.reduce((bounds, position) => bounds.extend(position.latlng), new kakao.maps.LatLngBounds());

            this.map.setBounds(bounds);
        },
        deleteMarker() {
            // console.log("마커 싹 지우자!!!", this.markers.length);
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
