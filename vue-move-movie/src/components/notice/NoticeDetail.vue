<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">상세 페이지</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <!-- 본문 내용 -->
                <div class="col-md-12">
                    <b-card class="bg-transparent">
                        <b-card-header>
                            <h2 class="mb-0">{{ notice.notice_title }}</h2>
                            <div class="row">
                                <div class="col-md-2">유저명 : {{ notice.user_pk }}</div>
                                <div class="col-md-8"></div>
                                <div class="col-md-2">등록일 : {{ notice.registertime }}</div>
                            </div>
                        </b-card-header>
                        <b-card-body>
                            <p class="card-text">
                                {{ notice.notice_content }}
                                Some quick example text to build on the card and make up the bulk of the card's content. Some quick example text to build on the
                                card and make up the bulk of the card's content. Some quick example text to build on the card and make up the bulk of the card's
                                content. Some quick example text to build on the card and make up the bulk of the card's content.
                            </p>
                        </b-card-body>
                        <b-card-footer>
                            <div class="row">
                                <div class="col-md-9"></div>

                                <b-button class="mr-3" variant="primary" @click="moveList">목록</b-button>
                                <b-button class="mr-3" variant="primary" @click="moveModify">수정</b-button>
                                <b-button variant="primary" @click="moveDelete">삭제</b-button>
                            </div>
                        </b-card-footer>
                    </b-card>
                </div>

                <!-- [S] 댓글 내용 -->
                <div class="container my-5 py-5">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-12">
                            <!-- col-lg-10 col-xl-8 -->
                            <div class="bg-transparent card">
                                <div class="card-body p-4">
                                    <h4 class="text-center mb-4 pb-2">Nested comments section</h4>

                                    <div class="row">
                                        <div class="col">
                                            <!-- 댓글 -->
                                            <div class="d-flex flex-start">
                                                <img
                                                    class="rounded-circle shadow-1-strong me-3"
                                                    src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(10).webp"
                                                    alt="avatar"
                                                    width="65"
                                                    height="65"
                                                    style="padding-right: 10px"
                                                />
                                                <div class="flex-grow-1 flex-shrink-1">
                                                    <div class="py-2">
                                                        <div class="d-flex justify-content-between align-items-center">
                                                            <p class="mb-1">Maria Smantha <span class="small">- 2 hours ago</span></p>
                                                            <a href="#!"><i class="fas fa-reply fa-xs"></i><span class="small"> reply</span></a>
                                                        </div>
                                                        <p class="small mb-0 text-left">It is a long established fact th</p>
                                                    </div>
                                                    <!-- 대댓글 -->
                                                    <div class="d-flex flex-start mt-4 py-2">
                                                        <a class="me-3" href="#" style="padding-right: 10px">
                                                            <img
                                                                class="rounded-circle shadow-1-strong"
                                                                src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
                                                                alt="avatar"
                                                                width="65"
                                                                height="65"
                                                            />
                                                        </a>
                                                        <div class="flex-grow-1 flex-shrink-1">
                                                            <div>
                                                                <div class="d-flex justify-content-between align-items-center">
                                                                    <p class="mb-1">Simona Disa <span class="small">- 3 hours ago</span></p>
                                                                </div>
                                                                <p class="small mb-0 text-left">
                                                                    letters, as opposed to using 'Content here, content here', making it look like readable
                                                                    English.
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <!-- 대댓글 -->
                                                    <div class="d-flex flex-start mt-4 py-2">
                                                        <a class="me-3" href="#" style="padding-right: 10px">
                                                            <img
                                                                class="rounded-circle shadow-1-strong"
                                                                src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(32).webp"
                                                                alt="avatar"
                                                                width="65"
                                                                height="65"
                                                            />
                                                        </a>
                                                        <div class="flex-grow-1 flex-shrink-1">
                                                            <div>
                                                                <div class="d-flex justify-content-between align-items-center">
                                                                    <p class="mb-1">John Smith <span class="small">- 4 hours ago</span></p>
                                                                </div>
                                                                <p class="small mb-0 text-left">
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                    the majority have suffered alteration in some form, by injected humour, or randomised words.
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- [E] 댓글 내용 -->
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {
    name: "NoticeDetail",
    components: {},
    data() {
        return {
            notice_no: Number,
            notice: Object,
        };
    },
    created() {
        console.log(this.$route.params.no);
        this.notice_no = this.$route.params.no;

        //axios를 통해 notice 정보를 가져온다.

        //test 용도
        this.notice = {
            notice_pk: "no",
            notice_title: "title",
            notice_content: "content",
            hit: 10,
            registertime: "2023.01.01",
            user_pk: 0,
        };
    },
    methods: {
        moveList() {
            this.$router.push({ name: `notice` });
            window.scrollTo(0, 0);
        },
        moveModify() {
            this.$router.push({
                name: `noticeModify`,
                params: { no: this.notice_no },
            });
            window.scrollTo(0, 0);
        },
        moveDelete() {
            this.$router.push({
                name: `noticeDelete`,
                params: { no: this.notice_no },
            });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style scoped>
.image-div {
    background: url(https://cdn.pixabay.com/photo/2022/08/23/06/55/village-7405160_960_720.jpg) no-repeat;
    background-attachment: fixed;
}
</style>
