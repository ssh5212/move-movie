<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="/img/title-login.png" alt="" width="1920" height="auto" />
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
                    <img class="rounded-circle my-5" alt="avatar1" :src="img_src" style="width: 220px; height: 220px" />
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
                    <mybucket-progress v-for="(bucket, index) in BucketList" :key="index" :bucket="bucket" />
                </div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MybucketProgress from '@/components/bucket/MybucketProgress.vue';
import { bucketByuserpk } from '@/api/bucket.js';
import { mapGetters } from 'vuex';
const userStore = 'userStore';

export default {
    data() {
        return {
            img_src: String,
            BucketList: [],
        };
    },
    components: {
        MybucketProgress,
    },
    created() {
        this.img_src = process.env.VUE_APP_API_BASE_URL + this.checkUserInfo.user_profile_img_src;

        bucketByuserpk(this.checkUserInfo.user_pk, ({ data }) => {
            console.log(data);
            this.BucketList = data.BucketList;
            console.log(this.BucketList.length);
        });
    },
    computed: {
        ...mapGetters(userStore, ['checkUserInfo']),
    },
    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/title-img-0${randomNumber}.png`;
        },
        goEdit() {
            this.$router.push({ name: 'edit' });
            window.scrollTo(0, 0);
        },
        // [function] : 탈퇴 기능 구현 필요
        goDropout() {},
    },
    mounted() {
        console.log('mount');
        console.log(userStore.checkUserInfo);
    },
};
</script>

<style></style>
