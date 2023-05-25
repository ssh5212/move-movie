<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">스팟 사진 등록</p>
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
        moveBucketCreate() {
            // pass
            if (!this.bucket) {
                // bucketCreate
                this.$router.push({
                    name: "bucketCreate",
                });
            } else {
                alert("당신의 버킷을 채우세요!");
            }
        },
    },
};
</script>

<style scoped></style>
