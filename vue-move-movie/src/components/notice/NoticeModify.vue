<template>
  <div>
    <b-card>
      <b-card-header>
        <div class="row">
          <div class="col-md-3"></div>
          <b-form-input
            class="col-md-6"
            v-model="notice.notice_title"
            placeholder="Enter your name"
          ></b-form-input>
          <div class="col-md-3"></div>
        </div>
        <div class="row">
          <div class="col-md-2">유저명 : {{ notice.user_pk }}</div>
          <div class="col-md-8"></div>
          <div class="col-md-2">등록일 : {{ notice.registertime }}</div>
        </div>
      </b-card-header>
      <b-card-body>
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
          <div class="col-md-10"></div>

          <b-button class="mr-3" variant="primary" @click="Modify"
            >수정</b-button
          >
          <b-button variant="primary" @click="moveList">취소</b-button>
        </div>
      </b-card-footer>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "NoticeModify",
  components: {},
  data() {
    return {
      notice: Object,
    };
  },
  created() {
    // test
    this.notice = {
      notice_pk: "no",
      notice_title: "title",
      notice_content: "content",
      hit: 10,
      registertime: "2023.01.01",
      user_pk: 0,
    };

    // select notice
  },
  methods: {
    Modify() {
      // 수정 로직

      this.moveList();
    },
    moveList() {
      this.$router.push({ name: `notice` });
    },
  },
};
</script>

<style scoped></style>