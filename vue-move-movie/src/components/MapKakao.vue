// import { serviceKey, serviceKey_go } from "@/assets/js/key.js";
<template>
    <div>
        <div id="map"></div>
    </div>
</template>

<script>
export default {
    name: "SearchAttraction",
    components: {},
    data() {
        return {
            serviceKey: null,
            serviceKey_go: null, // null 해도 되나?
            map: null,
            positions: null,
            marker: null,
        };
    },
    created() {
        this.serviceKey = process.env.VUE_APP_KAKAO_MAP_API_KEY;
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

        // loadArea =>  시도 Option 영역 추가하기
        makeOption(data) {
            let areas = data;
            // let areas = data.response.body.items.item;
            let sel = document.getElementById("search-area");
            areas.forEach((area) => {
                let opt = document.createElement("option");
                opt.setAttribute("value", area.sido_code);
                opt.appendChild(document.createTextNode(area.sido_name));
                sel.appendChild(opt);
            });
        },

        // 시도 추가하는 코드임 ㅋ
        loadArea() {
            var areaUrl = "http://localhost:9003/enjoytrip/api/sido";

            fetch(areaUrl, { method: "GET" })
                .then(console.log(areaUrl))
                .then((response) => response.json())
                .then((data) => this.makeOption(data));
        },

        addEventMethod() {
            document.getElementById("btn-search").addEventListener("click", () => {
                let searchUrl = "http://localhost:9003/enjoytrip/api/listAttractionSearch?";

                let areaCode = document.getElementById("search-area").value;
                let contentTypeId = document.getElementById("search-content-id").value;
                let keyword = document.getElementById("search-keyword").value;

                if (parseInt(areaCode)) searchUrl += "&areaCode=" + areaCode;
                if (parseInt(contentTypeId)) searchUrl += "&contentTypeId=" + contentTypeId;
                if (!keyword) {
                    alert("검색어 입력 필수!!!");
                    return;
                } else searchUrl += "&keyword=" + keyword;

                console.log(searchUrl);

                fetch(searchUrl)
                    .then((response) => response.json())
                    .then((data) => this.makeList(data));
            });
        },

        makeList(data) {
            document.querySelector("table").setAttribute("style", "display: ;");
            //let trips = data.response.body.items.item;
            let trips = data;
            let tripList = ``;
            this.positions = [];
            trips.forEach((area) => {
                tripList +=
                    "<tr on-click=moveCenter(" +
                    area.lat +
                    "," +
                    area.lon +
                    ");>" +
                    "<td><img src=" +
                    area.first_img_1 +
                    " width=100px ></td>" +
                    "<td>" +
                    area.title +
                    "</td>" +
                    "<td>" +
                    area.addr1 +
                    " " +
                    area.addr2 +
                    "</td>" +
                    "<td>" +
                    area.lat +
                    "</td>" +
                    "<td>" +
                    area.lon +
                    "</td>" +
                    "</tr>";

                let markerInfo = {
                    title: area.title,
                    latlng: new window.kakao.maps.LatLng(area.lat, area.lon),
                };
                this.positions.push(markerInfo);
            });
            document.getElementById("trip-list").innerHTML = tripList;
            this.displayMarker();
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
</script>
