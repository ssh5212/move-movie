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
                <p class="vtext-small">내가 좋아하는 영화 속 한 장면에 내가 나올 수 없을까?</p>
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
                    <button type="button" class="btn btn-secondary">바로가기</button>
                </div>
            </div>

            <!-- 소개 2 -->
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-6 intro-half-text mb-5">
                    <h1>최고의 인생샷</h1>
                    <br />
                    <p>가장 좋아하는 장소에서<br />최고의 인생샷을 찍고 공유해보아요!</p>
                    <br />
                    <button type="button" class="btn btn-secondary">바로가기</button>
                </div>
                <div class="col-md-6 intro-half-img mb-5">
                    <img src="@/assets/img/intro-half-img02.jpg" width="100%" alt="intro-half-img02" />
                </div>
            </div>

            <!-- 소개 3 -->
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-10 intro-half-text mb-5">
                    <img src="@/assets/img/intro-half-img03.jpg" width="100%" alt="intro-half-img03" class="mb-5" />
                    <h1>나만의 여행지를<br />다른 사람들에게 소개해주세요!</h1>
                    <br />
                    <button type="button" class="btn btn-secondary">바로가기</button>
                </div>
            </div>
        </div>
        <!-- [E] body -->

        <div class="margin-div"></div>
    </div>
</template>

<script>
export default {};
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
</style>
