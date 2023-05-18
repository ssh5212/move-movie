<template>
    <div class="home">
        <div id="margin-top" style="height: 70px"></div>
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
        <div class="row my-5">
            <div class="col-md-5">col-8</div>
            <div class="col-md-2">col-2</div>
            <div class="col-md-5">col-8</div>
        </div>
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
</style>
