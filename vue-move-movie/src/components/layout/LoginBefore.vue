<template>
    <!-- 오른쪽 사이드바 -->
    <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 18px">
        <!-- 수정된 부분 -->
        <b-button v-b-toggle.sidebar-backdrop class="d-sm-block d-md-none">
            <b-icon-person-square class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-person-square>
        </b-button>

        <b-sidebar id="sidebar-backdrop" title="" :backdrop-variant="variant" backdrop shadow right>
            <div class="px-3 py-2">
                <img class="rounded-circle my-3" style="width: 220px; height: 220px; object-fit: cover" alt="avatar1" src="https://t1.daumcdn.net/cfile/tistory/2513B53E55DB206927" />
                <h3 class="mt-3 mb-4">로그인이 필요합니다.</h3>

                <button type="button" class="btn btn-dark mb-4" style="width: 80%" @click="moveLogin">로그인</button><br />
                <button type="button" class="btn btn-dark mb-4" style="width: 80%" @click="moveRegister">회원가입</button><br />
            </div>
        </b-sidebar>
    </div>
</template>

<script>
export default {
    data() {
        return {
            variant: '',
        };
    },
    methods: {
        moveLogin() {
            this.$router.push({
                name: 'login',
            });
            window.scrollTo(0, 0);
        },
        moveRegister() {
            this.$router.push({
                name: 'register',
            });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style></style>
