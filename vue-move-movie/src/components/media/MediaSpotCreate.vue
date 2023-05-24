<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">Register</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-8">
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email">spot_name<span class="text-muted"></span></label>
                            <input type="text" class="form-control" id="email" placeholder="" v-model="spot.spot_name" />
                        </div>

                        <div class="mb-3">
                            <label for="spot_movie_title">spot_movie_title</label>
                            <input type="text" class="form-control" id="spot_movie_title" placeholder="" v-model="spot.spot_movie_title" readonly />
                        </div>

                        <MediaSearchBar :sido_code="sido_code" :gugun_code="gugun_code" @msg="bindmsg"></MediaSearchBar>

                        <div class="mb-3">
                            <label for="spot_scene_desc">spot_scene_desc</label>
                            <input type="text" class="form-control" id="spot_scene_desc" placeholder="" v-model="spot.spot_scene_desc" />
                        </div>

                        <!-- <div class="mb-3">
                            <label for="spot_lat">spot_lat</label>
                            <input type="text" class="form-control" id="spot_lat" placeholder="" v-model="spot.spot_lat" />
                        </div>

                        <div class="mb-3">
                            <label for="spot_lon">spot_lon</label>
                            <input type="text" class="form-control" id="spot_lon" placeholder="" v-model="spot.spot_lon" />
                        </div> -->

                        <div class="mb-3">
                            <label for="spot_road_address">spot_address</label>
                            <input
                                type="text"
                                class="form-control"
                                id="spot_road_address"
                                placeholder="대전광역시 유성구 동서대로 125"
                                v-model="spot.spot_address"
                            />
                        </div>

                        <div class="mb-3">
                            <label for="spot_road_address">spot_road_address</label>
                            <input
                                type="text"
                                class="form-control"
                                id="spot_road_address"
                                placeholder="대전광역시 유성구 동서대로 125"
                                v-model="spot.spot_road_address"
                            />
                        </div>

                        <div class="mb-3">
                            <label for="spot_filming_seq">spot_filming_seq</label>
                            <input type="text" class="form-control" id="spot_filming_seq" placeholder="" v-model="spot.spot_filming_seq" />
                        </div>

                        <div class="mb-3">
                            <input class="float-left mb-2" type="file" ref="fileInput" @change="handleFileSelect" />
                            <button class="btn btn-dark btn-lg btn-block" @click="uploadFile">파일 업로드</button>
                        </div>

                        <hr class="my-5" />
                        <button class="btn btn-dark btn-lg btn-block" type="button" @click="spotRegister">등록</button>
                    </form>
                    <div class="col-md-2"></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import MediaSearchBar from "./MediaSearchBar.vue";
import { register } from "@/api/media.js";
import { mapState } from "vuex";
const mediaStore = "mediaStore";

export default {
    name: "MediaSpotCreate",
    components: { MediaSearchBar },

    data() {
        return {
            spot: {
                spot_name: "",
                spot_scene_desc: "",
                spot_img_src: "",
                spot_lat: "",
                spot_lon: "",
                spot_address: "",
                spot_road_address: "",
                spot_filming_seq: "",
                spot_movie_title: "",
                gugun_code: "",
                sido_code: "",
            },
            Address: String,
            selectedImage: Object,
            apiURL: "https://dapi.kakao.com/v2/local/search/address.json",
            query: "",
            apiKey: "",
        };
    },
    computed: {
        ...mapState(mediaStore, ["sidos", "guguns", "medias"]),
    },
    created() {
        console.log(this.$route.params.spot);
        console.log(this.$route.params.spot.title);
        this.spot.spot_movie_title = this.$route.params.spot.title;
        this.apiKey = process.env.VUE_APP_KAKAO_MAP_API_KEY2;
    },

    methods: {
        bindmsg(msg) {
            console.log("이걸 받나");
            console.log(msg);
            this.spot.gugun_code = msg.gugunCode;
            this.spot.sido_code = msg.sidoCode;
            console.log("우오와응");
            console.log(this.spot.gugun_code);
            console.log(this.spot.sido_code);
        },
        spotRegister() {
            const requestURL = `${this.apiURL}?query=${this.spot.spot_address}`;
            console.log(requestURL);
            console.log(process.env.VUE_APP_KAKAO_MAP_API_KEY2);
            const headers = {
                Authorization: `KakaoAK ${process.env.VUE_APP_KAKAO_MAP_API_KEY2}`,
            };

            fetch(requestURL, { headers })
                .then((response) => response.json())
                .then((data) => {
                    // console.log("주소를 통한 위경도");
                    // console.log(data.documents[0].address.x);
                    // console.log(data.documents[0].address.y);
                    this.spot.spot_lat = data.documents[0].address.x;
                    this.spot.spot_lon = data.documents[0].address.y;
                    // console.log("vuex의 시도구군");
                    // console.log(this.sidoCode);
                    // console.log("vuex의 시도구군");

                    // console.log(this.spot.spot_lon);
                    // console.log(this.spot.spot_lon);

                    const params = this.spot;
                    register(params, ({ data }) => {
                        console.log(data);
                    });
                })
                .then(() => {
                    this.moveMedia();
                })
                .catch((error) => {
                    console.error(error);
                });
        },
        moveMedia() {
            // this.$router.push({ name: 'home' });
            this.$router.push({
                name: "spotList",
                params: { title: this.spot.spot_movie_title, prodYear: 2023 },
            });
        },

        handleFileSelect(event) {
            console.log(event.target.files[0]);
            this.selectedFile = event.target.files[0];
        },

        uploadFile() {
            const formData = new FormData();
            formData.append("file", this.selectedFile);

            axios
                .post(`${process.env.VUE_APP_API_BASE_URL}/api/file/upload`, formData)
                .then((response) => {
                    // 파일 업로드 성공 시 처리
                    console.log(response);
                })
                .catch((error) => {
                    // 파일 업로드 실패 시 처리
                    console.error(error);
                });
        },
    },
};
</script>

<style scoped></style>
