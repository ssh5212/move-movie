<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="/img/title-login.png" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">Login</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <!-- 로그인 form -->
                    <form class="form-signin">
                        <div class="text-center mb-4">
                            <img class="mb-4" src="@/assets/logo.png" alt="" width="72" height="auto" />
                            <h1 class="mb-3 font-weight-normal">Hello Morld!</h1>
                            <p>필름의 한 장 속으로 뛰어들 준비는 되셨나요?</p>
                        </div>
                        <hr class="my-5" />

                        <div class="form-label-group m-3">
                            <label for="inputEmail">ID</label>
                            <input id="inputEmail" class="form-control" placeholder="ID" v-model="user.user_email" required autofocus />
                        </div>

                        <div class="form-label-group m-3">
                            <label for="password">Password</label>
                            <input type="password" id="password" class="form-control" placeholder="Password" v-model="user.user_pw" required />
                        </div>
                        <!-- 
                        <div class="checkbox m-3">
                            <label> <input type="checkbox" value="remember-me" /> Remember me </label>
                        </div> -->
                        <hr class="my-5" />

                        <button class="btn btn-lg btn-dark btn-block" type="button" @click="confirm">Sign in</button>
                    </form>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';
const userStore = 'userStore';
import { mapMutations } from 'vuex';
const toastStore = 'toastStore';

export default {
    name: 'UserLogin',
    data() {
        return {
            user: {
                user_email: null,
                user_pw: null,
            },
        };
    },
    computed: {
        ...mapState(userStore, ['isLogin', 'isLoginError', 'userInfo']),
    },
    methods: {
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        ...mapActions(userStore, ['userConfirm', 'getUserInfo']),
        async confirm() {
            console.log(this.user);
            await this.userConfirm(this.user);
            let token = sessionStorage.getItem('access-token');
            console.log(this.isLogin);
            if (this.isLogin) {
                await this.getUserInfo(token);
                this.$router.push({ name: 'home' });
                window.scrollTo(0, 0);
                let toast_data = {
                    title: 'Success', // Success, Fail 등 상태를 표기
                    sub: 'Login', // 상태가 일어난 위치 or 기능 표기
                    content: `${this.user.user_email}님 좋은 여행되세요!!`, // 내용 표기
                };

                this.SET_TOAST(toast_data);
                this.SET_TOAST_CNT();
            } else {
                let toast_data = {
                    title: 'Fail', // Success, Fail 등 상태를 표기
                    sub: 'Login', // 상태가 일어난 위치 or 기능 표기
                    content: '입력된 정보가 잘못되었습니다.', // 내용 표기
                };

                this.SET_TOAST(toast_data);
                this.SET_TOAST_CNT();
            }
        },
    },

    movePage() {
        this.$router.push({ name: 'register' });
        window.scrollTo(0, 0);
    },
};
</script>

<style></style>
