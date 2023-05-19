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
                <!-- 영화 1 -->
                <a href=""></a>
                <div class="col-md-3 my-4 position-relative">
                    <div class="card bg-dark text-white img-bg-dark">
                        <div class="img-bg-dark">
                            <img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87032/87032_320.jpg" class="card-img" />
                        </div>
                    </div>
                    <div class="card-overlay">
                        <h3 class="h3 card-text">Card title</h3>
                        <p class="card-text mb-1">사랑시 고백구 행복동 11번가 37번리 맛집입니다.</p>
                        <p class="card-text mb-1">Last updated 3 mins ago</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {
    name: "MediaTitleList",
    components: {},
    data() {
        return {
            message: "",
        };
    },
    created() {},
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
