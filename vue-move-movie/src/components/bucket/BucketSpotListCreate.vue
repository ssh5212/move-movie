<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img
                    src="@/assets/img/intro-half-img01.jpg"
                    alt=""
                    width="1920"
                    height="auto"
                />
            </div>

            <div class="jc-text">
                <p class="vtext-big">title</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container mt-5">
            <!-- 실제 내용 -->
            <!-- button -->
            <div class="row justify-content-xl-start">
                <h2 class="ml-3">나의 버킷 생성하기</h2>
            </div>
            <div class="row justify-content-xl-end mr-0">
                <b-button @click="register">생성</b-button>
            </div>
            <div>
                <!-- list -->
                <div class="mt-5">
                    <div
                        class="row justify-content-xl-center m-0"
                        style="background-color: #4b6a70"
                    >
                        <!-- detailitem.vue로 빼야함 -->
                        <bucket-spot-list-detail-item
                            v-for="(spot, index) in bucket"
                            :key="index"
                            :spot_pk="spot.spot_pk"
                        ></bucket-spot-list-detail-item>
                    </div>
                </div>
                <!-- title -->
                <div class="mt-5">제목</div>
                <div class="mb-5">
                    <b-row class="mt-1 justify-content-xl-center">
                        <b-form-input
                            id="textarea-default"
                            placeholder="Default title"
                            v-model="title"
                        ></b-form-input>
                    </b-row>
                </div>
                <!--  content -->
                <div>내용</div>
                <div class="mb-5">
                    <b-row class="mt-2 justify-content-xl-center">
                        <b-form-textarea
                            id="textarea-default"
                            placeholder="Default content"
                            v-model="content"
                        ></b-form-textarea>
                    </b-row>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import BucketSpotListDetailItem from "@/components/bucket/BucketSpotListDetailItem.vue";
import { mapState, mapMutations } from "vuex";
import { bucketCreate } from "@/api/bucket";

const mediaStore = "mediaStore";
const userStore = "userStore";

export default {
    name: "BucketSpotListCreate",
    components: {
        BucketSpotListDetailItem,
    },
    data() {
        return {
            title: "",
            content: "",
            spot: [],
        };
    },
    computed: {
        ...mapState(mediaStore, ["bucket"]),
        ...mapState(userStore, ["userInfo"]),
    },
    created() {
        console.log(this.bucket);
        // 버킷 리스트 데이터 가져오기
        // 유저 정보 가져오기
    },
    methods: {
        ...mapMutations(mediaStore, ["CLEAR_BUCKET_LIST"]),
        async register() {
            // 등록 로직
            var spots = [];
            this.bucket.forEach((data) => {
                spots.push({ spot_pk: data.spot_pk });
            });

            const requestData = {
                bucketDto: {
                    bucket_content: this.title,
                    bucket_title: this.content,
                    user_pk: this.userInfo.user_pk,
                },
                spots: spots,
            };

            await bucketCreate(
                requestData,
                ({ data }) => {
                    console.log(data);
                    this.CLEAR_BUCKET_LIST();
                    this.moveList();
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        moveList() {
            this.$router.push({
                name: `bucket`,
            });
        },
    },
};
</script>

<style scoped></style>
