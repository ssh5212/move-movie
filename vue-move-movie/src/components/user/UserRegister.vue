<template>
    <div id="user-login-vue">
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
                    <hr class="mb-4" />

                    <!-- <h1 class="mb-3">Billing address</h1> -->
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted"></span></label>
                            <input type="email" class="form-control" id="email" placeholder="you@example.com" v-model="user.user_email" />
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

                        <hr class="mb-4" />
                        <button class="btn btn-primary btn-lg btn-block" type="button" @click="register">Continue to checkout</button>
                    </form>
                </div>

                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
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
            pw_check: null,
        };
    },
    methods: {
        ...mapActions(userStore, ["userRegister"]),
        register() {
            this.userRegister(this.user);
            alert("회원 등록 완료");
            this.movehome();
        },
        movehome() {
            this.$router.push({ name: "home" });
        },
    },
};
</script>

<style></style>
