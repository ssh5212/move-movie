<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">버킷 살펴보기</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <!-- 실제 내용 -->
            <div class="row justify-content-xl-center my-5 align-items-center"></div>
            <div class="row justify-content-xl-end mb-3 mr-0">
                <button class="btn btn-dark" @click="moveBucketCreate">버킷 리스트 생성하기</button>
            </div>
            <div class="row justify-content-xl-between">
                <bucket-list-item
                    class="col-md-4 mb-1 py-4"
                    v-for="(bucketList, index) in bucketListList"
                    :key="index"
                    :BucketList="bucketList"
                ></bucket-list-item>
            </div>
            <div class="pt-5"></div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import BucketListItem from "@/components/bucket/BucketListItem.vue";
import { bucketListheart } from "@/api/bucket.js";
import { mapState } from "vuex";
import { mapMutations } from "vuex";
const toastStore = "toastStore";
const mediaStore = "mediaStore";

export default {
    name: "BucketList",
    components: { BucketListItem },
    data() {
        return {
            bucketListList: [],
            bucketList: Object,
        };
    },
    created() {
        bucketListheart(({ data }) => {
            this.bucketListList = data.BucketList;
        });
        // test end
    },
    computed: {
        ...mapState(mediaStore, ["bucket"]),
    },
    methods: {
        ...mapMutations(toastStore, ["SET_TOAST", "SET_TOAST_CNT"]),
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 4); // 0에서 5 사이의 랜덤한 숫자 생성
            return `/img/title-img-0${randomNumber}.png`;
        },
        moveBucketCreate() {
            // pass
            if (!this.bucket) {
                // bucketCreate
                this.$router.push({
                    name: "bucketCreate",
                });
                window.scrollTo(0, 0);
            } else {
                let toast_data = {
                    title: "Fail", // Success, Fail 등 상태를 표기
                    sub: "Bucket List", // 상태가 일어난 위치 or 기능 표기
                    content: "버킷이 비어있습니다.", // 내용 표기
                };

                this.SET_TOAST(toast_data);
                this.SET_TOAST_CNT();
            }
        },
    },
};
</script>

<style scoped></style>
