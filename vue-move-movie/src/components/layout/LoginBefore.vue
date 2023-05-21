<template>
    <!-- 오른쪽 사이드바 -->
    <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 18px">
        <!-- 수정된 부분 -->
        <b-button v-b-toggle.sidebar-backdrop class="d-sm-block d-md-none">
            <b-icon-person-square class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-person-square>
        </b-button>

        <b-sidebar id="sidebar-backdrop" title="" :backdrop-variant="variant" backdrop shadow right>
            <div class="px-3 py-2">
                <img class="rounded-circle my-3" style="width: 100px" alt="avatar1" src="https://via.placeholder.com/300x411" />
                <h2 class="mt-2 mb-4">로그인이 필요합니다.</h2>

                <div class="progress mb-4 mx-4">
                    <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                </div>

                <button type="button" class="btn btn-dark mb-4" style="width: auto" @click="moveLogin">로그인</button><br />
                <button type="button" class="btn btn-dark mb-4" style="width: auto" @click="moveRegister">회원가입</button><br />
            </div>
        </b-sidebar>
    </div>
</template>

<script>
export default {
    data() {
        return {
            variant: "",
        };
    },
    methods: {
        moveLogin() {
            this.$router.push({
                name: "login",
            });
        },
        moveRegister() {
            this.$router.push({
                name: "register",
            });
        },
    },
};
</script>

<style></style>
