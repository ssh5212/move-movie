<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">영화 검색</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <MediaTitleListItem v-for="(mediaTitle, index) in mediaTitleList" :key="index" :mediaTitle="mediaTitle"></MediaTitleListItem>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
import MediaTitleListItem from '@/components/media/MediaTitleListItem.vue';

export default {
    name: 'MediaTitleList',
    components: { MediaTitleListItem },
    data() {
        return {
            mediaTitleList: [],
            mediaTitle: Object,
        };
    },
    created() {
        this.mediaTitle = {
            movie_pk: 88,
            movie_title: '1',
            movie_director_name: '1',
            movie_actor_name: '1',
            movie_company: '1',
            movie_plot: '21111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111112',
            movie_genre: '1',
            movie_keywords: '31111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111113',
            movie_posterurl: 'https://placekitten.com/300/400',
            movie_vod_url: '1',
            user_pk: 0,
        };
        this.mediaTitleList.push(this.mediaTitle);
        this.mediaTitleList.push(this.mediaTitle);
        this.mediaTitleList.push(this.mediaTitle);
    },
    methods: {},
};
</script>

<style>
.img-bg-dark {
    filter: brightness(1);
    transition: 0.5s;
}

.img-bg-dark:hover {
    filter: brightness(0.6);
    cursor: pointer;
}
.card-overlay {
    position: absolute;
    top: 80%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: white;
    text-shadow: 3px 3px 5px rgba(0, 0, 0, 1);
    width: 200px;
}

.card-text {
    opacity: 0;
    transition: opacity 0.5s;
}

.img-bg-dark:hover + .card-overlay .card-text {
    opacity: 1;
}
</style>
