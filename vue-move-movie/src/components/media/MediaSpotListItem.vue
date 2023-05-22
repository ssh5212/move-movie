<template>
    <!-- 스팟 -->
    <div class="card mb-3 my-5" style="width: 100%">
        <div class="row no-gutters align-items-center">
            <div class="col-md-3 p-3 d-flex justify-content-center align-items-center">
                <img :src="mediaSpot.spot_img_src || require('@/assets/img/no_img_x.png')" alt="..." style="width: 100%" />
            </div>
            <div class="col-md-8">
                <div class="card-body" @click="moveSpotDetail">
                    <h4 class="card-title text-left mb-5">{{ mediaSpot.spot_name }}</h4>
                    <p class="text-left">영화명 : {{ mediaSpot.spot_movie_title }}</p>
                    <p class="text-left">주소 : {{ mediaSpot.spot_address }}</p>
                    <!-- <p class="card-text-left">
                        <small class="text-muted">작성자 : {{ mediaSpot.spot_address }}</small>
                    </p> -->
                </div>
            </div>
            <div class="col-md-1 d-flex flex-column justify-content-center align-items-center">
                <!-- [function - 필수] : 장바구니 담기 기능 구현 -->
                <!-- <b-icon-basket2 id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2> -->
                <b-icon-basket2-fill id="b-icon" class="h3 pt-1 bucket-btn" @click="addThisSpot"></b-icon-basket2-fill>
                <!-- [function - 필수] : 장바구니 하트 개수 출력 기능 구현 -->
                <!-- <b-icon-heart-fill id="b-icon" class="h3 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                <p class="card-text-left text-center"><small class="text-muted">1000</small></p> -->
            </div>
        </div>
    </div>
</template>

<script>
import { mapState } from "vuex";
const mediaStore = "mediaStore";
export default {
    name: "MediaSpotListItem",

    props: {
        mediaSpot: Object,
    },

    computed: {
        ...mapState(mediaStore, ["bucket"]),
    },

    created() {
        console.log(this.mediaSpot);
    },
    methods: {
        moveSpotDetail() {
            this.$router.push({
                name: "spotDetail",
                params: { no: this.mediaSpot.spot_pk },
            });
        },
        addThisSpot() {
            // bucket이 비어 있는 경우
            if (this.bucket.length == 0) {
                this.bucket.push(this.mediaSpot);
            } else {
                let isok = 1; // 해당 스폿이 버킷에 포함되어 있는지 판단
                this.bucket.forEach((b) => {
                    if (b.spot_pk == this.mediaSpot.spot_pk) {
                        isok = 0;
                    }
                });
                if (isok == 1) {
                    this.bucket.push(this.mediaSpot);
                }
            }
            console.log(this.bucket);
        },
    },
};
</script>

<style>
.bucket-btn:hover {
    color: rgba(0, 0, 0, 0.9) !important;
    cursor: pointer;
}
</style>
