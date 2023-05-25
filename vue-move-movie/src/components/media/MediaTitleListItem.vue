<template>
    <!-- 영화 1 -->
    <div class="col-md-4 col-lg-3 my-4 position-relative media-item">
        <div class="card bg-dark text-white img-bg-dark">
            <div>
                <img :src="this.mediaTitle.stlls || require('@/assets/img/no_img.png')" class="card-img" name="1" @click="moveSpotList" />
            </div>
        </div>
        <div class="card-overlay" @mouseover="handleMouseOver" @mouseleave="handleMouseLeave" @click="moveSpotList">
            <h3 class="h3 card-text">{{ mediaTitle.title }}</h3>
            <p></p>
            <p class="card-text mb-1 hide-overflow">
                {{ mediaTitle.prodYear }}
            </p>
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

    created() {},
    methods: {
        moveSpotList() {
            console.log('DDDDDDDDDDDDocid' + this.docid);
            this.$router.push({
                name: 'spotList',
                params: { title: this.mediaTitle.title, prodYear: this.mediaTitle.prodYear, docid: this.mediaTitle.docid },
            });
            window.scrollTo(0, 0);
        },

        // 이미지 처리
        handleMouseOver() {
            const imgBgDark = this.$el.querySelector('.img-bg-dark');
            if (imgBgDark) {
                imgBgDark.style.filter = 'brightness(0.6)';
                imgBgDark.style.cursor = 'pointer';
            }
        },
        handleMouseLeave() {
            const imgBgDark = this.$el.querySelector('.img-bg-dark');
            if (imgBgDark) {
                imgBgDark.style.filter = '';
                imgBgDark.style.cursor = '';
            }
        },
    },
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

/* .card-overlay:hover + .img-bg-dark {
    filter: brightness(0.6);
    cursor: pointer;
} */
.card-overlay:hover .card-text {
    opacity: 1;
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
