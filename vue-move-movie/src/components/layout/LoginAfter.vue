<template>
    <!-- 오른쪽 사이드바 -->
    <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 18px">
        <!-- 수정된 부분 -->
        <b-button v-b-toggle.sidebar-backdrop class="d-sm-block d-md-none">
            <b-icon-person-square class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-person-square>
        </b-button>

        <b-sidebar id="sidebar-backdrop" title="" :backdrop-variant="variant" backdrop shadow right>
            <div class="px-3 py-2">
                <!-- [function - 필수] 데이터 바인딩 : 사용자 데이터로 동적으로 바뀌도록 해야 함 -->
                <img class="rounded-circle my-3" alt="avatar1" src="https://mdbcdn.b-cdn.net/img/new/avatars/9.webp" />
                <h2 class="mb-2">{{ checkUserInfo.user_nickname }}</h2>
                <h4 class="mb-3">exp : {{ checkUserInfo.user_exp }}</h4>

                <div class="progress mb-4 mx-4">
                    <!-- <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div> -->
                    <b-progress :value="checkUserInfo.user_exp" :max="100" show-progress animated></b-progress>
                </div>
                <!-- [function - 필수] 이동 : 마이페이지 -->
                <div>
                    <b-button type="button" class="btn btn-dark mb-2 mt-2" style="width: 80%" @click="logout">로그아웃</b-button>
                </div>
                <div>
                    <button type="button" class="btn btn-dark mb-5 mt-2" style="width: 80%" @click="moveMypage">마이페이지</button>
                </div>

                <!-- [function - 필수] 데이터 바인딩 : 버킷 리스트 연결 -->
                <h4 class="mb-3">내 버킷리스트 진행도</h4>
                <div class="mb-4">
                    <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                    <div class="progress" style="height: 5px">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                    </div>
                </div>

                <div class="mb-4">
                    <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                    <div class="progress" style="height: 5px">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                    </div>
                </div>

                <div class="mb-4">
                    <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                    <div class="progress" style="height: 5px">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                    </div>
                </div>

                <div class="mb-4">
                    <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                    <div class="progress" style="height: 5px">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                    </div>
                </div>

                <div class="mb-4">
                    <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                    <div class="progress" style="height: 5px">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                    </div>
                </div>
            </div>
        </b-sidebar>
    </div>
</template>

<script>
import { mapGetters, mapActions, mapState } from "vuex";
const userStore = "userStore";

export default {
    methods: {
        ...mapActions(userStore, ["userLogout"]),
        moveMypage() {
            this.$router.push({
                name: "mypage",
            });
        },
        logout() {
            sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
            sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
            this.userLogout(this.userInfo.user_email);
            console.log("success logout!");
            this.movehome();
        },
        movehome() {
            const currentRoute = this.$route.path;
            const newRoute = "/";
            if (currentRoute !== newRoute) {
                this.$router.push(newRoute);
            }
        },
    },
    data() {
        return {
            ...mapState(userStore, ["userInfo", "isLogin"]),
            variant: "",
        };
    },
    computed: {
        ...mapGetters(userStore, ["checkUserInfo"]),
    },
    created() {
        console.log(this.checkUserInfo);
    },
};
</script>

<style></style>
