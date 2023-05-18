<template>
  <div>
    <b-card>
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
          Some quick example text to build on the card and make up the bulk of
          the card's content. Some quick example text to build on the card and
          make up the bulk of the card's content. Some quick example text to
          build on the card and make up the bulk of the card's content. Some
          quick example text to build on the card and make up the bulk of the
          card's content.
        </p>
      </b-card-body>
      <b-card-footer>
        <div class="row">
          <div class="col-md-9"></div>

          <b-button class="mr-3" variant="primary" @click="moveList"
            >목록</b-button
          >
          <b-button class="mr-3" variant="primary" @click="moveModify"
            >수정</b-button
          >
          <b-button variant="primary" @click="moveDelete">삭제</b-button>
        </div>
      </b-card-footer>
    </b-card>
    <section class="gradient-custom">
      <div class="container my-1 py-1">
        <div class="row d-flex justify-content-center">
          <div class="col-md-12 col-md-12 col-lg-12 col-xl-12">
            <div class="card">
              <div class="card-body p-4">
                <div class="row">
                  <div class="col">
                    <div class="d-flex flex-start">
                      <img
                        class="rounded-circle shadow-1-strong me-3"
                        src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(10).webp"
                        alt="avatar"
                        width="65"
                        height="65"
                      />
                      <div class="flex-grow-1 flex-shrink-1">
                        <div>
                          <div
                            class="d-flex justify-content-between align-items-center"
                          >
                            <p class="mb-1">
                              Maria Smantha
                              <span class="small">- 2 hours ago</span>
                            </p>
                            <a href="#!"
                              ><i class="fas fa-reply fa-xs"></i
                              ><span class="small"> reply</span></a
                            >
                          </div>
                          <p class="small mb-0">
                            It is a long established fact that a reader will be
                            distracted by the readable content of a page.
                          </p>
                        </div>

                        <div class="d-flex flex-start mt-4">
                          <a class="me-3" href="#">
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
                              <div
                                class="d-flex justify-content-between align-items-center"
                              >
                                <p class="mb-1">
                                  Simona Disa
                                  <span class="small">- 3 hours ago</span>
                                </p>
                              </div>
                              <p class="small mb-0">
                                letters, as opposed to using 'Content here,
                                content here', making it look like readable
                                English.
                              </p>
                            </div>
                          </div>
                        </div>

                        <div class="d-flex flex-start mt-4">
                          <a class="me-3" href="#">
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
                              <div
                                class="d-flex justify-content-between align-items-center"
                              >
                                <p class="mb-1">
                                  John Smith
                                  <span class="small">- 4 hours ago</span>
                                </p>
                              </div>
                              <p class="small mb-0">
                                the majority have suffered alteration in some
                                form, by injected humour, or randomised words.
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
    </section>
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
    },
    moveModify() {
      this.$router.push({
        name: `noticeModify`,
        params: { no: this.notice_no },
      });
    },
    moveDelete() {
      this.$router.push({
        name: `noticeDelete`,
        params: { no: this.notice_no },
      });
    },
  },
};
</script>

<style scoped>
</style>