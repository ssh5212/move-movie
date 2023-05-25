<template>
    <div class="home">
        <!-- <div id="margin-top" style="height: 77px"></div> -->
        <!-- [S] Movie -->
        <div class="jb-box">
            <video muted autoplay loop>
                <source src="@/assets/video/home_movie.mp4" type="video/mp4" />
                <strong>404 Invalid video file</strong>
            </video>

            <div class="jb-text">
                <h1 class="vtext-big">영화와 함께 여행을 떠나보세요!</h1>
                <h4 class="vtext-small pt-3" style="color: white">내가 좋아하는 영화 속 한 장면에 내가 나올 수 없을까?</h4>
            </div>
        </div>
        <!-- [E] Movie -->

        <div class="margin-div"></div>

        <!-- [S] body -->
        <div class="container">
            <!-- 소개 1 -->
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-6 intro-half-img mb-5">
                    <img src="@/assets/img/intro-half-img01.jpg" width="100%" alt="intro-half-img01" />
                </div>
                <div class="col-md-6 intro-half-text mb-5">
                    <h1>영화 속 장면을 찾아서</h1>
                    <br />
                    <p>내가 좋아하는 영화의<br />실제 장소를 찾아가보세요!</p>
                    <br />
                    <button type="button" class="btn btn-secondary" @click="moveTitle">바로가기</button>
                </div>
            </div>

            <!-- 소개 2 -->
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-6 intro-half-text mb-5">
                    <h1>최고의 인생샷</h1>
                    <br />
                    <p>가장 좋아하는 장소에서<br />최고의 인생샷을 찍고 공유해보아요!</p>
                    <br />
                    <button type="button" class="btn btn-secondary" @click="moveLocation">바로가기</button>
                </div>
                <div class="col-md-6 intro-half-img mb-5">
                    <img src="@/assets/img/intro-half-img02.jpg" width="100%" alt="intro-half-img02" />
                </div>
            </div>

            <!-- 소개 3 -->
            <div class="row justify-content-center my-5 align-items-center">
                <div class="col-md-10 intro-half-text mb-5">
                    <img src="@/assets/img/intro-half-img03.jpg" width="100%" alt="intro-half-img03" class="mb-5" />
                    <h1>나만의 여행지를<br />다른 사람들에게 소개해주세요!</h1>
                    <br />
                    <button type="button" class="btn btn-secondary" @click="moveBucket">바로가기</button>
                </div>
            </div>
        </div>
        <!-- [E] body -->

        <div class="margin-div"></div>
    </div>
</template>

<script>
export default {
    name: "HomeView",
    methods: {
        moveTitle() {
            this.$router.push({
                name: "media",
            });
            window.scrollTo(0, 0);
        },
        moveLocation() {
            this.$router.push({
                name: "locationList",
            });
            window.scrollTo(0, 0);
        },
        moveBucket() {
            this.$router.push({
                name: "bucket",
            });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style>
/* 헤더 동영상 */
.jb-box {
    overflow: hidden;
    margin: 0px auto;
    position: relative;
}

video {
    object-fit: cover;
    width: 100%;
    height: 100vh;
}

.jb-box img {
    object-fit: cover;
    width: 100%;
    height: 500px;
}

.jb-text {
    position: absolute;
    top: 75%;
    width: 100%;
}

.jb-text p {
    text-align: center;
    color: #ffffff;
}
.jb-text h1 {
    text-align: center;
    color: #ffffff;
}

@media (max-width: 768px) {
    .intro-half-img {
        order: -1;
    }

    .intro-half-text {
        order: 1;
    }
}

@media (max-width: 576px) {
    /* 작은 화면(sm)에 대한 스타일 */
    .vtext-big {
        font-size: 40px;
    }
    .vtext-small {
        font-size: 18px;
    }
    h1 {
        font-size: 24px;
    }
    h2 {
        font-size: 20px;
    }
    h3 {
        font-size: 16px;
    }
}

@media (min-width: 576px) and (max-width: 768px) {
    /* 중간 화면(md)에 대한 스타일 */
    .vtext-big {
        font-size: 60px;
    }
    .vtext-small {
        font-size: 22px;
    }
    h1 {
        font-size: 30px;
    }
    h2 {
        font-size: 26px;
    }
    h3 {
        font-size: 22px;
    }
}
</style>
