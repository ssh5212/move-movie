<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">title</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container mt-5">
            <!-- 실제 내용 -->
            <!-- button -->
            <div class="row justify-content-xl-start">
                <h2 class="ml-3">나의 버킷 생성하기</h2>
            </div>
            <div class="row justify-content-xl-end mr-0">
                <b-button @click="register">생성</b-button>
            </div>
            <div>
                <!-- list -->
                <div class="mt-5">
                    <div class="row justify-content-xl-center m-0" style="background-color: #4b6a70">
                        <!-- detailitem.vue로 빼야함 -->
                        <div class="m-3">
                            <img src="https://via.placeholder.com/130x100" alt="img" />
                            <div>text</div>
                        </div>
                        <div class="m-3">
                            <img src="https://via.placeholder.com/130x100" alt="img" />
                            <div>text</div>
                        </div>
                        <div class="m-3">
                            <img src="https://via.placeholder.com/130x100" alt="img" />
                            <div>text</div>
                        </div>
                        <div class="m-3">
                            <img src="https://via.placeholder.com/130x100" alt="img" />
                            <div>text</div>
                        </div>
                        <div class="m-3">
                            <img src="https://via.placeholder.com/130x100" alt="img" />
                            <div>text</div>
                        </div>
                    </div>
                </div>
                <!-- title -->
                <div class="mt-5">제목</div>
                <div class="mb-5">
                    <b-row class="mt-1 justify-content-xl-center">
                        <b-form-input id="textarea-default" placeholder="Default title"></b-form-input>
                    </b-row>
                </div>
                <!--  content -->
                <div>내용</div>
                <div class="mb-5">
                    <b-row class="mt-2 justify-content-xl-center">
                        <b-form-textarea id="textarea-default" placeholder="Default content"></b-form-textarea>
                    </b-row>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'BucketSpotListCreate',
    components: {},
    data() {
        return {
            message: '',
        };
    },
    created() {},
    methods: {
        register() {
            // 등록 로직

            this.moveList();
        },
        moveList() {
            this.$router.push({
                name: `bucket`,
            });
        },
    },
};
</script>

<style scoped></style>
