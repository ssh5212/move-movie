<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">title</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container mt-5">
            <!-- 실제 내용 -->
            <!-- button -->
            <div class="row justify-content-xl-end">
                <b-button class="mr-2">나의 버킷으로 등록하기</b-button>
            </div>
            <div style="background-color: #ced0c3">
                <!-- list -->
                <div class="mt-5">
                    <div class="row justify-content-xl-center m-0" style="background-color: #4b6a70">
                        <!-- detailitem.vue로 빼야함 -->
                        <bucket-spot-list-detail-item v-for="(spot, index) in spots" :key="index" :spot_pk="spot.spot_pk"></bucket-spot-list-detail-item>
                    </div>
                </div>
                <!-- [S] map -->
                <div class="container mt-5">
                    <div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
                </div>
                <!-- [E] map -->
                <!--  content -->
                <div class="mt-5 mb-5">
                    {{ content }}
                </div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import { bucketListBybucketpk } from "@/api/bucketList.js";
import BucketSpotListDetailItem from "@/components/bucket/BucketSpotListDetailItem.vue";

export default {
    name: "BucketSpotListDetail",
    components: {
        BucketSpotListDetailItem,
    },
    data() {
        return {
            spots: [],
            content: null,
        };
    },
    created() {
        bucketListBybucketpk(this.$route.params.no, ({ data }) => {
            this.spots = data.BucketDetailList;
        });
        this.content = this.$route.query.content;
    },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }
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
    },
};
</script>

<style scoped></style>
