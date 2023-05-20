<template>
    <div>
        <!-- 상세 스팟 -->
        <div class="card mb-3 my-5" style="width: 100%">
            <div class="row no-gutters align-items-center">
                <div class="col-md-3 p-3 d-flex justify-content-center align-items-center">
                    <img src="https://via.placeholder.com/1920x1080" alt="..." style="width: 100%" />
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">spot title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted">사랑시 고백구 행복동</small></p>
                    </div>
                </div>
                <div class="col-md-1 d-flex flex-column justify-content-center align-items-center">
                    <!-- <b-icon-basket2 id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2> -->
                    <b-icon-basket2-fill id="b-icon" class="h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-basket2-fill>
                    <b-icon-heart-fill id="b-icon" class="h2 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                    <p class="card-text text-center"><small class="text-muted">1000</small></p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style></style>
