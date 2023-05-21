<template>
    <div>
        <!-- 왼쪽 사이드바 -->
        <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 78px">
            <!-- 수정된 부분 -->
            <b-button v-b-toggle.sidebar-left class="d-sm-block d-md-none">
                <b-icon-basket2-fill class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-basket2-fill>
            </b-button>

            <!-- [function - 필수] 기능 구현 : 왼쪽 사이드바 (바구니)에 들어갈 내용으로 수정 필요 -->
            <b-sidebar id="sidebar-left" title="" :backdrop-variant="variant" backdrop shadow left>
                <div class="px-3 py-2">
                    <div class="badge-parent">
                        <img class="my-3 p-2" alt="avatar1" src="https://via.placeholder.com/1920x1080" style="width: 100%" />
                        <!-- 클릭 시 제거 기능 구현 필요함 -->
                        <div class="notification-badge">
                            <span>-</span>
                        </div>
                        <p>해당 스폿 명</p>
                    </div>
                </div>
            </b-sidebar>
        </div>

        <!-- 오른쪽 사이드바 -->
        <div v-if="isLogin">
            <LoginAfter></LoginAfter>
        </div>
        <div v-else>
            <LoginBefore></LoginBefore>
        </div>
    </div>
</template>

<script>
import LoginAfter from "@/components/layout/LoginAfter.vue";
import LoginBefore from "@/components/layout/LoginBefore.vue";
import { mapState } from "vuex";

const userStore = "userStore";
export default {
    name: "SidebarView",
    components: { LoginAfter, LoginBefore },
    data() {
        return {
            mediaTitleList: [],
            mediaTitle: Object,
        };
    },
    created() {},
    computed: {
        ...mapState(userStore, ["isLogin"]),
    },
};
</script>

<style scoped>
.badge-parent {
    position: relative;
}

.notification-badge {
    position: absolute;
    top: 13px; /* 원하는 위치로 조정하세요 */
    right: -5px; /* 원하는 위치로 조정하세요 */
    background-color: red; /* 배지의 배경색 */
    color: white; /* 배지의 텍스트 색상 */
    border-radius: 50%; /* 원형 배지를 위해 원하는 값을 지정하세요 */
    width: 30px; /* 배지의 너비 */
    height: 30px; /* 배지의 높이 */
    justify-content: center;
    align-items: center;
    font-size: 20px; /* 텍스트 크기 */
    font-weight: bold; /* 텍스트 굵기 */
}
.notification-badge:hover {
    cursor: pointer;
}
</style>
