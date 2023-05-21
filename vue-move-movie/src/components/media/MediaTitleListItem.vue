<template>
    <!-- 영화 1 -->
    <div class="col-md-3 my-4 position-relative">
        <div class="card bg-dark text-white img-bg-dark">
            <div class="img-bg-dark">
                <img :src="this.mediaTitle.stlls || require('@/assets/img/no_img.png')" class="card-img" name="1" @click="moveSpotList" />
            </div>
        </div>
        <div class="card-overlay">
            <h3 class="h3 card-text">{{ mediaTitle.title }}</h3>
            <p></p>
            <p class="card-text mb-1 hide-overflow">{{ mediaTitle.prodYear }}</p>
            <br />
        </div>
    </div>
</template>

<script>
export default {
    name: "MediaTitleListItem",
    props: {
        mediaTitle: Object,
    },

    created() {},
    methods: {
        moveSpotList() {
            this.$router.push({
                name: "spotList",
                params: { title: this.mediaTitle.title, prodYear: this.mediaTitle.prodYear },
            });
        },
    },
};
</script>

<style>
.hide-overflow {
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    text-overflow: ellipsis;
}

.card .img-bg-dark {
    position: relative;
    width: 100%;
    height: 0;
    padding-bottom: 141.51%; /* (75 / 53) * 100 */
    display: flex;
    justify-content: center;
}

.card .img-bg-dark img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>
