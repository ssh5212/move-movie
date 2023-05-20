<template>
    <!-- 상세 스팟 -->
    <div class="card mb-3 my-5" style="width: 100%">
        <div class="row no-gutters align-items-center">
            <div class="col-md-3 p-3 d-flex justify-content-center align-items-center">
                <img :src="mediaSpot.spot_img_src" alt="..." style="width: 100%" />
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">{{ mediaSpot.mediaTitle }}</h5>
                    <p class="card-text">{{ mediaSpot.spot_filming_seq }}</p>
                    <p class="card-text">
                        <small class="text-muted">{{ mediaSpot.spot_address }}</small>
                    </p>
                </div>
            </div>
            <div class="col-md-1 d-flex flex-column justify-content-center align-items-center">
                <!-- [function - 필수] : 장바구니 담기 기능 구현 -->
                <!-- <b-icon-basket2 id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2> -->
                <b-icon-basket2-fill id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2-fill>
                <!-- [function - 필수] : 장바구니 하트 개수 출력 기능 구현 -->
                <b-icon-heart-fill id="b-icon" class="h2 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                <p class="card-text text-center"><small class="text-muted">1000</small></p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MediaSpotListItem',
    props: {
        mediaSpot: Object,
    },
    created() {
        console.log(this.mediaSpot);
    },
    methods: {
        moveSpotList() {
            this.$router.push({
                name: 'spotList',
                params: { no: this.mediaTitle.movie_pk },
            });
        },
    },
};
</script>

<style></style>
