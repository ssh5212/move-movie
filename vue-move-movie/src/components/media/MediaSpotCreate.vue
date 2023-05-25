<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">스팟 등록</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <div class="container">
            <div class="row justify-content-center my-5 align-items-center">
                <div class="col-md-8">
                    <div class="text-center mb-5">
                        <img class="mb-4" src="@/assets/logo.png" alt="" width="72" height="auto" />
                        <h1 class="mb-3 font-weight-normal">Make your Spot!</h1>
                        <p>당신의 장소를 알려주세요!</p>
                    </div>
                    <hr class="my-5" />
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email">spot_name<span class="text-muted"></span></label>
                            <input type="text" class="form-control" id="email" placeholder="" v-model="spot.spot_name" />
                        </div>

                        <div class="mb-3">
                            <label for="spot_movie_title">spot_movie_title</label>
                            <input type="text" class="form-control" id="spot_movie_title" placeholder="" v-model="spot.spot_movie_title" readonly />
                        </div>

                        <MediaSearchBar @msg="bindmsg"></MediaSearchBar>
                        <!-- <MediaSearchBar :sido_code="sido_code" :gugun_code="gugun_code" @msg="bindmsg"></MediaSearchBar> -->

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
                            <input type="text" class="form-control" id="spot_road_address" placeholder="정확한 주소명 미 기입 시 등록이 되지 않습니다!" v-model="spot.spot_address" />
                        </div>

                        <div class="mb-3">
                            <label for="spot_road_address">spot_road_address</label>
                            <input type="text" class="form-control" id="spot_road_address" placeholder="" v-model="spot.spot_road_address" />
                        </div>

                        <!-- <div class="mb-3">
                            <label for="spot_filming_seq">spot_filming_seq</label>
                            <input type="text" class="form-control" id="spot_filming_seq" placeholder="" v-model="spot.spot_filming_seq" />
                        </div> -->

                        <div class="mb-3 pb-3">
                            <input class="float-left mb-2" type="file" id="fileInput" ref="fileInput" @change="handleFileUpload" />
                            <!-- <button class="btn btn-dark btn-lg btn-block" @click="uploadFile">파일 업로드</button> -->
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
import axios from 'axios';
import MediaSearchBar from './MediaSearchBar.vue';
// import { register } from "@/api/media.js";
import { mapState } from 'vuex';
const mediaStore = 'mediaStore';
import { mapMutations } from 'vuex';
const toastStore = 'toastStore';

export default {
    name: 'MediaSpotCreate',
    components: { MediaSearchBar },

    data() {
        return {
            spot: {
                spot_name: '',
                spot_scene_desc: '',
                spot_img_src: '',
                spot_lat: '',
                spot_lon: '',
                spot_address: '',
                spot_road_address: '',
                spot_filming_seq: '',
                spot_movie_title: '',
                gugun_code: '',
                sido_code: '',
            },
            Address: String,
            selectedImage: Object,
            apiURL: 'https://dapi.kakao.com/v2/local/search/address.json',
            query: '',
            apiKey: '',
            file: Object,
        };
    },
    computed: {
        ...mapState(mediaStore, ['sidos', 'guguns', 'medias']),
    },
    created() {
        this.spot.spot_movie_title = this.$route.params.spot.title.replace(/\s+/g, ' ').trim();
        this.apiKey = process.env.VUE_APP_KAKAO_MAP_API_KEY2;
    },

    methods: {
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        bindmsg(msg) {
            this.spot.gugun_code = msg.gugunCode;
            this.spot.sido_code = msg.sidoCode;
        },
        spotRegister() {
            const throwData = new FormData();

            const requestURL = `${this.apiURL}?query=${this.spot.spot_address}`;
            const headers = {
                Authorization: `KakaoAK ${process.env.VUE_APP_KAKAO_MAP_API_KEY2}`,
            };

            fetch(requestURL, { headers })
                .then(response => response.json())
                .then(data => {
                    this.spot.spot_lat = data.documents[0].address.y;
                    this.spot.spot_lon = data.documents[0].address.x;

                    const jsonString = JSON.stringify(this.spot);
                    const blob = new Blob([jsonString], {
                        type: 'application/json',
                    });
                    throwData.append('SpotDto', blob);

                    throwData.append('file', this.file);

                    // const params = throwData;

                    const config = {
                        method: 'post',
                        maxBodyLength: Infinity,
                        url: 'http://localhost:9003/movemovie/spot',
                        headers: {
                            'Content-Type': 'multipart/form-data',
                        },
                        data: throwData,
                    };

                    axios
                        .request(config)
                        .then(response => {
                            console.log(response);
                            setTimeout(() => this.moveMedia(), 500);
                        })
                        .catch(error => {
                            console.log(error);
                            let toast_data = {
                                title: 'Fail', // Success, Fail 등 상태를 표기
                                sub: 'Spot Create', // 상태가 일어난 위치 or 기능 표기
                                content: '등록 과정 중 문제가 발생하였습니다.', // 내용 표기
                            };

                            this.SET_TOAST(toast_data);
                            this.SET_TOAST_CNT();
                        });

                    // register(params, ({ data }) => {
                    //     console.log(data);
                    // });
                    // setTimeout(() => this.moveMedia(), 500);
                })
                .catch(error => {
                    console.error(error);
                    let toast_data = {
                        title: 'Fail', // Success, Fail 등 상태를 표기
                        sub: 'Spot Create', // 상태가 일어난 위치 or 기능 표기
                        content: '도로명 표기가 잘못되었습니다.', // 내용 표기
                    };

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                });
        },
        moveMedia() {
            // this.$router.push({ name: 'home' });
            this.$router.push({
                name: 'media',
                params: { title: this.spot.spot_movie_title, prodYear: 2023 },
            });
            window.scrollTo(0, 0);
        },

        handleFileSelect(event) {
            this.selectedFile = event.target.files[0];
        },

        // uploadFile() {
        //     const formData = new FormData();
        //     formData.append("file", this.selectedFile);

        //     axios
        //         .post(`${process.env.VUE_APP_API_BASE_URL}/api/file/upload`, formData)
        //         .then((response) => {
        //             // 파일 업로드 성공 시 처리
        //             console.log(response);
        //         })
        //         .catch((error) => {
        //             // 파일 업로드 실패 시 처리
        //             console.error(error);
        //         });
        // },
        handleFileUpload(event) {
            this.file = event.target.files[0];
            this.selectedImage = URL.createObjectURL(this.file);
            // this.selectedImage = event.target.files[0];
        },
    },
};
</script>

<style scoped></style>
