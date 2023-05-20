<template>
    <!-- 영화 1 -->
    <div class="col-md-3 my-4 position-relative">
        <div class="card bg-dark text-white img-bg-dark">
            <div class="img-bg-dark">
                <img :src="mediaTitle.movie_posterurl" class="card-img" name="1" @click="moveSpotList" />
            </div>
        </div>
        <div class="card-overlay">
            <h3 class="h3 card-text">{{ mediaTitle.movie_title }}</h3>
            <p class="card-text mb-1 hide-overflow">{{ mediaTitle.movie_keywords }}</p>
            <p class="card-text mb-1 hide-overflow">{{ mediaTitle.movie_plot }}</p>
            <br />
        </div>
    </div>
</template>

<script>
export default {
    name: 'MediaTitleListItem',
    props: {
        mediaTitle: Object,
    },
    created() {
        console.log(this.mediaTitle);
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

<style>
.hide-overflow {
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    text-overflow: ellipsis;
}
</style>
