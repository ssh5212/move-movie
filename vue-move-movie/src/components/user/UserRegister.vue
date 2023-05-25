<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="/img/title-login.png" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">Register</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-center my-5">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="text-center mb-5">
                        <img class="mb-4" src="@/assets/logo.png" alt="" width="72" height="auto" />
                        <h1 class="mb-3 font-weight-normal">Melcome Move Movie!</h1>
                        <p>필름의 한 장 속으로 뛰어들 준비는 되셨나요?</p>
                    </div>
                    <hr class="my-5" />

                    <!-- <h1 class="mb-3">Billing address</h1> -->
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email">ID<span class="text-muted"></span></label>
                            <input type="email" class="form-control" id="email" placeholder="" v-model="user.user_email" />
                            <div class="invalid-feedback">Please enter a valid email address for shipping updates.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="" v-model="user.user_pw" required />
                            <div class="invalid-feedback">Please enter your shipping address.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password-check">Password Check</label>
                            <input type="password" class="form-control" id="password-check" placeholder="" v-model="pw_check" required />
                        </div>
                        <div class="mb-3">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="" v-model="user.user_name" required />
                            <div class="invalid-feedback">Please enter your shipping address.</div>
                        </div>

                        <div class="mb-3">
                            <label for="nickname">NickName</label>
                            <input type="text" class="form-control" id="nickname" placeholder="" v-model="user.user_nickname" required />
                        </div>

                        <div class="mb-3 align-items-left">
                            <!-- <label for="fileInput">fileInput</label><br /> -->
                            <img
                                v-if="Object.keys(selectedImage).length > 0"
                                :src="selectedImage"
                                alt="Uploaded Image"
                                class="rounded-circle my-2"
                                style="width: 220px; height: 220px; object-fit: cover"
                            /><br />
                            <input type="file" id="fileInput" ref="fileInput" @change="handleFileUpload" />
                            <b-button @click="uploadImage" style="visibility: hidden">업로드 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</b-button><br />
                        </div>

                        <hr class="my-5" />
                        <button class="btn btn-dark btn-lg btn-block" type="button" @click="register">회원가입</button>
                    </form>
                </div>

                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import axios from 'axios';
import FormData from 'form-data';
import { mapActions } from 'vuex';
const userStore = 'userStore';
import { mapMutations } from 'vuex';
const toastStore = 'toastStore';

export default {
    name: 'UserRegister',
    data() {
        return {
            user: {
                user_email: null,
                user_pw: null,
                user_name: null,
                user_nickname: '',
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
        ...mapActions(userStore, ['userRegister']),
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        // register() {
        //   const formData = new FormData();
        //   formData.append("UserDto", this.user, {
        //     contentType: "application/json",
        //   });
        //   formData.append("file", this.selectedImage);

        //   axios
        //     .post("http://localhost:9003/movemovie/user", formData, {
        //       headers: {
        //         "Content-Type": "multipart/form-data",
        //       },
        //     })
        //     .then((resonse) => {
        //       console.log(resonse);
        //       alert("회원 등록 완료");
        //       this.movehome();
        //     })
        //     .catch((error) => {
        //       console.log(error);
        //     });
        // },
        register() {
            const data = new FormData();

            // 사용자 정보를 JSON 형태로 추가
            const jsonString = JSON.stringify(this.user);
            const blob = new Blob([jsonString], { type: 'application/json' });
            data.append('UserDto', blob);
            // data.append("UserDto", JSON.stringify(this.userDto), {
            //     contentType: "application/json",
            // });
            // data.append("UserDto", this.user);

            // 파일을 스트림으로 읽어 추가
            data.append('file', this.file);

            const config = {
                method: 'post',
                maxBodyLength: Infinity,
                // url: "http://localhost:9003/movemovie/user",
                url: process.env.VUE_APP_API_BASE_URL + '/user',
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
                data: data,
            };

            axios
                .request(config)
                .then(response => {
                    let toast_data = {
                        title: 'Success', // Success, Fail 등 상태를 표기
                        sub: 'Register', // 상태가 일어난 위치 or 기능 표기
                        content: `초면이네요 ${this.user.user_name}님, 반가워요!`, // 내용 표기
                    };
                    console.log(JSON.stringify(response.data));
                    this.movehome();

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                })
                .catch(error => {
                    console.log(error);
                    let toast_data = {
                        title: 'Fail', // Success, Fail 등 상태를 표기
                        sub: 'Register', // 상태가 일어난 위치 or 기능 표기
                        content: '회원가입 중 문제가 발생하였습니다.', // 내용 표기
                    };

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                });
        },
        movehome() {
            this.$router.push({ name: 'home' });
            window.scrollTo(0, 0);
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
