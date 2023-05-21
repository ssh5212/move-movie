<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
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
                        <hr class="mb-4" />

                        <div class="form-label-group m-3">
                            <label for="inputEmail">Email address</label>
                            <input id="inputEmail" class="form-control" placeholder="Email address" v-model="user.user_email" required autofocus />
                        </div>

                        <div class="form-label-group m-3">
                            <label for="password">Password</label>
                            <input type="password" id="password" class="form-control" placeholder="Password" v-model="user.user_pw" required />
                        </div>

                        <div class="checkbox m-3">
                            <label> <input type="checkbox" value="remember-me" /> Remember me </label>
                        </div>
                        <hr class="mb-4" />

                        <button class="btn btn-lg btn-primary btn-block" type="button" @click="confirm">Sign in</button>
                    </form>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const userStore = "userStore";

export default {
    name: "UserLogin",
    data() {
        return {
            user: {
                user_email: null,
                user_pw: null,
            },
        };
    },
    computed: {
        ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
    },
    methods: {
        ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
        async confirm() {
            console.log(this.user);
            await this.userConfirm(this.user);
            let token = sessionStorage.getItem("access-token");
            console.log(this.isLogin);
            if (this.isLogin) {
                await this.getUserInfo(token);
                this.$router.push({ name: "home" });
            }
        },
    },

    movePage() {
        this.$router.push({ name: "register" });
    },
};
</script>

<style></style>
