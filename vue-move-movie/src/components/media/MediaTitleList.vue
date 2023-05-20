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
                <!-- 여기에 Media Item 생성 -->
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {
    name: 'MediaTitleList',
    components: {},
    data() {
        return {
            message: '',
        };
    },
    created() {},
    methods: {
        moveCreate() {
            this.$router.push({
                name: `bucketCreate`,
            });
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
