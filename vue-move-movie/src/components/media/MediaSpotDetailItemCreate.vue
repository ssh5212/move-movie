<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img
                    src="@/assets/img/intro-half-img01.jpg"
                    alt=""
                    width="1920"
                    height="auto"
                />
            </div>

            <div class="jc-text">
                <p class="vtext-big">Register</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="text-center mb-5">
                        <img
                            class="mb-4"
                            src="@/assets/logo.png"
                            alt=""
                            width="72"
                            height="auto"
                        />
                        <h1 class="mb-3 font-weight-normal">
                            Melcome Move Movie!
                        </h1>
                        <p>필름의 한 장 속으로 뛰어들 준비는 되셨나요?</p>
                    </div>
                    <hr class="my-5" />

                    <div class="mb-3">
                        Title :
                        <b-input
                            v-model="spotInstance.spot_instance_title"
                        ></b-input>
                        <img
                            v-if="Object.keys(selectedImage).length > 0"
                            :src="selectedImage"
                            alt="Uploaded Image"
                            class="rounded-circle my-2"
                            style="
                                width: 220px;
                                height: 220px;
                                object-fit: cover;
                            "
                        /><br />
                        <input
                            type="file"
                            id="fileInput"
                            ref="fileInput"
                            @change="handleFileUpload"
                        /><br />
                    </div>
                    <!-- <h1 class="mb-3">Billing address</h1> -->
                    <form class="needs-validation" novalidate>
                        <b-row class="mt-2">
                            <b-col sm="12">
                                <b-form-textarea
                                    id="textarea-default"
                                    placeholder="Default textarea"
                                    v-model="spotInstance.spot_instance_content"
                                ></b-form-textarea>
                            </b-col>
                        </b-row>

                        <hr class="my-5" />
                        <button
                            class="btn btn-dark btn-lg btn-block"
                            type="button"
                            @click="upload"
                        >
                            스팟 인증 하기
                        </button>
                    </form>
                </div>

                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import axios from "axios";
import FormData from "form-data";
import { mapActions, mapGetters } from "vuex";
const userStore = "userStore";

export default {
    name: "MediaSpotDetailItemCreate",
    data() {
        return {
            spotInstance: {
                spot_instance_title: "your title",
                spot_instance_content: "your content",
                spot_pk: 0,
                user_pk: 0,
            },
            selectedImage: Object,
            file: Object,
            pw_check: null,
        };
    },
    computed: {
        ...mapGetters(userStore, ["checkUserInfo"]),
    },
    created() {
        this.spotInstance.spot_pk = this.$route.params.no;
        this.spotInstance.user_pk = this.checkUserInfo.user_pk;
        console.log(this.selectedImage);
    },
    methods: {
        ...mapActions(userStore, ["userRegister"]),
        upload() {
            const data = new FormData();

            // 사용자 정보를 JSON 형태로 추가
            const jsonString = JSON.stringify(this.spotInstance);
            const blob = new Blob([jsonString], { type: "application/json" });
            data.append("spotInstance", blob);
            // data.append("UserDto", JSON.stringify(this.userDto), {
            //     contentType: "application/json",
            // });
            // data.append("UserDto", this.user);

            // 파일을 스트림으로 읽어 추가
            data.append("file", this.file);

            const config = {
                method: "post",
                maxBodyLength: Infinity,
                url: process.env.VUE_APP_API_BASE_URL + "/SpotInst",
                headers: {
                    "Content-Type": "multipart/form-data",
                },
                data: data,
            };

            axios
                .request(config)
                .then((response) => {
                    console.log(JSON.stringify(response.data));
                    this.movehome();
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        movehome() {
            this.$router.push({ name: "spotDetail" });
        },
        handleFileUpload(event) {
            this.file = event.target.files[0];
            console.log(this.file instanceof File);
            this.selectedImage = URL.createObjectURL(this.file);
            // this.selectedImage = event.target.files[0];
        },
    },
};
</script>

<style></style>
