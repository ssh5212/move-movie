<template>
    <div>
        <!-- 왼쪽 사이드바 -->
        <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 78px">
            <b-button v-b-toggle.sidebar-left class="d-sm-block d-md-none">
                <b-icon-basket2-fill class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-basket2-fill>
            </b-button>

            <button type="button" class="btn btn-dark mb-4" style="width: 80%" @click="moveBucketCreate">버킷 등록하기</button><br />

            <!-- [function - 필수] 기능 구현 : 왼쪽 사이드바 (바구니)에 들어갈 내용으로 수정 필요 -->
            <b-sidebar id="sidebar-left" title="" :backdrop-variant="variant" backdrop shadow left>
                <BucketItem v-for="(bucketItem, index) in bucket" :key="index" :bucketItem="bucketItem"></BucketItem>
            </b-sidebar>
        </div>

        <!-- 오른쪽 사이드바 -->
        <div v-if="userInfo">
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
import BucketItem from "./BucketItem.vue";
import { mapState } from "vuex";

const userStore = "userStore";
const mediaStore = "mediaStore";
export default {
    name: "SidebarView",
    components: { LoginAfter, LoginBefore, BucketItem },
    data() {
        return {
            mediaTitleList: [],
            mediaTitle: Object,
            variant: "",
        };
    },
    created() {},
    computed: {
        ...mapState(userStore, ["isLogin", "userInfo"]),
        ...mapState(mediaStore, ["bucket"]),
    },
    methods: {
        moveBucketCreate() {
            // pass
        },
    },
};
</script>

<style scoped></style>
