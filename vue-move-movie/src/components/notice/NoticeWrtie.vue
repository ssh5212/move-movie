<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">공지사항</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-12">
                    <b-card class="bg-transparent">
                        <b-card-header>
                            <div class="row">
                                <div class="col-md-3"></div>
                                <b-form-input class="col-md-6" v-model="notice.notice_title" placeholder="Enter title"></b-form-input>
                                <div class="col-md-3"></div>
                            </div>
                            <div class="row">
                                <!-- <div class="col-md-2">유저명 : {{ notice.user_pk }}</div> -->
                                <div class="col-md-8"></div>
                                <!-- <div class="col-md-2">등록일 : {{ notice.registertime }}</div> -->
                            </div>
                        </b-card-header>
                        <b-card-body class="px-0">
                            <p class="card-text">
                                <b-form-textarea
                                    id="textarea"
                                    v-model="notice.notice_content"
                                    placeholder="Enter something..."
                                    rows="3"
                                    max-rows="6"
                                ></b-form-textarea>
                            </p>
                        </b-card-body>
                        <b-card-footer>
                            <div class="row">
                                <div class="col-md-12"></div>
                                <b-button class="mr-3" variant="primary" @click="register">등록</b-button>
                                <b-button variant="primary" @click="moveList">취소</b-button>
                            </div>
                        </b-card-footer>
                    </b-card>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "NoticeWrite",
    components: {},
    data() {
        return {
            notice: Object,
        };
    },
    created() {
        //
    },
    methods: {
        register() {
            // 등록하는 로직

            this.moveList();
        },
        moveList() {
            this.$router.push({ name: `notice` });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style scoped></style>
