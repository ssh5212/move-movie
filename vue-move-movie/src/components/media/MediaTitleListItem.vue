<template>
    <div>
        <!-- 영화 1 -->
        <div class="col-md-3 my-4 position-relative">
            <div class="card bg-dark text-white img-bg-dark">
                <div class="img-bg-dark">
                    <!-- 이게 먼저 클릭되니 여기에 옵션 주고 onclick 주면 될듯 -->
                    <img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87032/87032_320.jpg" class="card-img" name="1" @click="moveSpotlist" />
                </div>
            </div>
            <div class="card-overlay">
                <h3 class="h3 card-text">Card title</h3>
                <p class="card-text mb-1">사랑시 고백구 행복동 11번가 37번리 맛집입니다.</p>
                <p class="card-text mb-1">Last updated 3 mins ago</p>
            </div>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style></style>
