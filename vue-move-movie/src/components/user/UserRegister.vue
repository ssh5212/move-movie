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

                    <!-- <h1 class="mb-3">Billing address</h1> -->
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email"
                                >Email <span class="text-muted"></span
                            ></label>
                            <input
                                type="email"
                                class="form-control"
                                id="email"
                                placeholder="you@example.com"
                                v-model="user.user_email"
                            />
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping
                                updates.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="password">Password</label>
                            <input
                                type="password"
                                class="form-control"
                                id="password"
                                placeholder=""
                                v-model="user.user_pw"
                                required
                            />
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="password-check">Password Check</label>
                            <input
                                type="password"
                                class="form-control"
                                id="password-check"
                                placeholder=""
                                v-model="pw_check"
                                required
                            />
                        </div>
                        <div class="mb-3">
                            <label for="name">Name</label>
                            <input
                                type="text"
                                class="form-control"
                                id="name"
                                placeholder=""
                                v-model="user.user_name"
                                required
                            />
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="nickname">NickName</label>
                            <input
                                type="text"
                                class="form-control"
                                id="nickname"
                                placeholder=""
                                v-model="user.user_nickname"
                                required
                            />
                        </div>

                        <div class="mb-3">
                            <label for="fileInput">fileInput</label><br />
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
                            />
                            <b-button @click="uploadImage">업로드</b-button
                            ><br />
                        </div>

                        <hr class="my-5" />
                        <button
                            class="btn btn-dark btn-lg btn-block"
                            type="button"
                            @click="test"
                        >
                            Continue to checkout
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
import { mapActions } from "vuex";
const userStore = "userStore";

export default {
    name: "UserRegister",
    data() {
        return {
            user: {
                user_email: null,
                user_pw: null,
                user_name: null,
                user_nickname: "default",
            },
            selectedImage: Object,
            file: Object,
            pw_check: null,
        };
    },
    created() {
        console.log(this.selectedImage);
    },
    methods: {
        ...mapActions(userStore, ["userRegister"]),
        register() {
            const formData = new FormData();
            formData.append("UserDto", this.user, {
                contentType: "application/json",
            });
            formData.append("file", this.selectedImage);

            axios
                .post("http://localhost:9003/movemovie/user", formData, {
                    headers: {
                        "Content-Type": "multipart/form-data",
                    },
                })
                .then((resonse) => {
                    console.log(resonse);
                    alert("회원 등록 완료");
                    this.movehome();
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        test() {
            // const fs = require("fs");

            // 파일 경로
            // const filePath = "/C:/Users/elder/Desktop/새 폴더 (2)/sqld.jpg";

            const data = new FormData();

            // 사용자 정보를 JSON 형태로 추가
            const jsonString = JSON.stringify(this.user);
            const blob = new Blob([jsonString], { type: "application/json" });
            data.append("UserDto", blob);
            // data.append("UserDto", JSON.stringify(this.userDto), {
            //     contentType: "application/json",
            // });
            // data.append("UserDto", this.user);

            // 파일을 스트림으로 읽어 추가
            data.append("file", this.file);
            console.log("123");
            const config = {
                method: "post",
                maxBodyLength: Infinity,
                url: "http://localhost:9003/movemovie/user",
                headers: {
                    "Content-Type": "multipart/form-data",
                },
                data: data,
            };

            axios
                .request(config)
                .then((response) => {
                    console.log(JSON.stringify(response.data));
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        movehome() {
            this.$router.push({ name: "home" });
        },
        handleFileUpload(event) {
            this.file = event.target.files[0];
            console.log(this.file instanceof File);
            this.selectedImage = URL.createObjectURL(this.file);
            // this.selectedImage = event.target.files[0];
        },
        // handleFileUpload() {
        //   const file = this.$refs.fileInput.files[0];
        //   const reader = new FileReader();

        //   reader.onload = (e) => {
        //     const imageUrl = e.target.result;
        //     const imageId = Date.now(); // 고유한 ID 생성을 위해 현재 시간 사용 (실제로는 서버에서 ID를 생성하거나 다른 방식으로 사용해야 함)

        //     this.selectedImage = { id: imageId, url: imageUrl };
        //     this.$refs.fileInput.value = ""; // 파일 선택을 초기화하기 위해 인풋값 비우기
        //   };

        //   reader.readAsDataURL(file);
        // },
        uploadImage() {
            // 이미지 업로드 로직을 추가하세요 (서버와 통신 등)
            // 여기서는 이미지를 로컬에 저장하는 예제이므로 추가적인 로직이 필요하지 않습니다.
        },
    },
};
</script>

<style></style>
