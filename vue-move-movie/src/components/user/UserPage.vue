<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">My Page</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-4" style="background-color: white">
                    <img class="rounded-circle my-5" alt="avatar1" src="https://mdbcdn.b-cdn.net/img/new/avatars/9.webp" />
                    <h1 class="mb-2">{{ checkUserInfo.user_email }}</h1>
                    <h3 class="mb-4">{{ checkUserInfo.user_exp }}</h3>

                    <div class="progress mb-4 mx-4">
                        <b-progress :value="checkUserInfo.user_exp" :max="100" show-progress animated></b-progress>
                    </div>

                    <button type="button" class="btn btn-dark mb-2" @click="goEdit">개인정보 수정하기</button><br />
                    <button type="button" class="btn btn-dark mb-5" @click="goDropout">탈퇴하기</button>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-7 overflow-auto" style="overflow: scroll; height: 631px; background-color: white">
                    <h1 class="my-5">내 버킷리스트</h1>

                    <div class="mb-4">
                        <h5 style="text-align: left">리포 따라가기</h5>
                        <div class="progress" style="height: 20px">
                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                        </div>
                        <p class="mt-1" style="text-align: right">자세히 보기 ></p>
                    </div>

                    <div class="mb-4">
                        <h5 style="text-align: left">리포 따라가기</h5>
                        <div class="progress" style="height: 20px">
                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                        </div>
                        <p class="mt-1" style="text-align: right">자세히 보기 ></p>
                    </div>

                    <div class="mb-4">
                        <h5 style="text-align: left">리포 따라가기</h5>
                        <div class="progress" style="height: 20px">
                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                        </div>
                        <p class="mt-1" style="text-align: right">자세히 보기 ></p>
                    </div>

                    <div class="mb-4">
                        <h5 style="text-align: left">리포 따라가기</h5>
                        <div class="progress" style="height: 20px">
                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                        </div>
                        <p class="mt-1" style="text-align: right">자세히 보기 ></p>
                    </div>

                    <div class="mb-4">
                        <h5 style="text-align: left">리포 따라가기</h5>
                        <div class="progress" style="height: 20px">
                            <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                        </div>
                        <p class="mt-1" style="text-align: right">자세히 보기 ></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import { mapGetters } from "vuex";
const userStore = "userStore";

export default {
    data() {
        return {};
    },
    computed: {
        ...mapGetters(userStore, ["checkUserInfo"]),
    },
    methods: {
        goEdit() {
            this.$router.push({ name: "edit" });
        },
        // [function] : 탈퇴 기능 구현 필요
        goDropout() {},
    },
    mounted() {
        console.log("mount");
        console.log(userStore.checkUserInfo);
    },
};
</script>

<style></style>
