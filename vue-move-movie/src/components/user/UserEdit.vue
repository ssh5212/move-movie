<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="/img/title-login.png" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">회원정보 수정</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="text-center mb-4">
                        <img class="mb-4" src="@/assets/logo.png" alt="" width="72" height="auto" />
                        <h1 class="mb-3 font-weight-normal">Melcome Move Movie!</h1>
                        <p>필름의 한 장 속으로 뛰어들 준비는 되셨나요?</p>
                    </div>
                    <hr class="my-5" />

                    <!-- <h1 class="mb-3">Billing address</h1> -->
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email">ID <span class="text-muted"></span></label>
                            <input type="email" class="form-control" id="email" placeholder="you@example.com" v-model="user.user_email" readonly />
                            <div class="invalid-feedback">Please enter a valid email address for shipping updates.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="" v-model="user.user_pw" required />
                            <div class="invalid-feedback">Please enter your shipping address.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password-check">Password Check</label>
                            <input type="password" class="form-control" id="password-check" placeholder="" v-model="user_pw" required />
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

                        <div class="mb-3">
                            <label for="fileInput">fileInput</label><br />
                            <input type="file" id="fileInput" ref="fileInput" @change="handleFileUpload" />
                            <img
                                v-if="Object.keys(selectedImage).length > 0"
                                :src="selectedImage"
                                alt="Uploaded Image"
                                class="rounded-circle my-2"
                                style="width: 220px; height: 220px; object-fit: cover"
                            /><br />
                        </div>

                        <hr class="my-5" />
                        <button class="btn btn-dark btn-lg btn-block" type="button" @click="edit">수정하기</button>
                    </form>
                </div>

                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
const userStore = 'userStore';
import { mapMutations } from 'vuex';
const toastStore = 'toastStore';

export default {
    name: 'UserEdit',
    data() {
        return {
            // [feature : 필수] 비밀번호 체크 기능 추가
            user: Object,
            user_pw: '',
            selectedImage: Object,
        };
    },
    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        ...mapActions(userStore, ['userEdit']),
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),

        edit() {
            this.userEdit(this.user);
            let toast_data = {
                title: 'Success', // Success, Fail 등 상태를 표기
                sub: 'UserEdit', // 상태가 일어난 위치 or 기능 표기
                content: '수정 내용이 반영되었습니다.', // 내용 표기
            };

            this.SET_TOAST(toast_data);
            this.SET_TOAST_CNT();
            this.goHome();
        },
        goHome() {
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
    computed: {
        // 사용자 정보 불러오기
        ...mapGetters(userStore, ['checkUserInfo']),
    },
    created() {
        this.user = this.checkUserInfo;
    },
};
</script>

<style></style>
