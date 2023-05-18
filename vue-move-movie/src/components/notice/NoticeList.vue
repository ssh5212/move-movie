<template>
  <div>
    <div class="row mb-3">
      <b-col class="col-md-1"></b-col>
      <h1>공지사항</h1>
      <b-col class="col-md-11"></b-col>
      <!-- <b-button class="col-md-1" variant="success" @click="moveWrite">
        등록
      </b-button> -->
      <button
        type="button"
        class="col-md-1 btn btn-secondary"
        @click="moveWrite"
      >
        등록
      </button>
    </div>
    <b-table
      striped
      hover
      :items="noticeList"
      :fields="fields"
      @row-clicked="movedetail"
    >
    </b-table>
  </div>
</template>

<script>
export default {
  name: "NoticeList",
  components: {},
  data() {
    return {
      fields: [],
      noticeList: [
        {
          notice_pk: 0,
          notice_title: "Dickerson",
          notice_content: "Macdonald",
          hit: 17,
          user_pk: 13,
        },
        {
          notice_pk: 1,
          notice_title: "ersonDick",
          notice_content: "Macdondon",
          hit: 17,
          user_pk: 13,
        },
        {
          notice_pk: 2,
          notice_title: "Dirsoncke",
          notice_content: "Mdonanald",
          hit: 17,
          user_pk: 13,
        },
        {
          notice_pk: 3,
          notice_title: "kersonDickerson",
          notice_content: "Macdonald",
          hit: 17,
          user_pk: 13,
        },
      ],
    };
  },
  created() {},
  methods: {
    movedetail(item) {
      this.$router.push({
        name: `noticeDetail`,
        params: { no: item.notice_pk },
      });
    },

    moveWrite() {
      this.$router.push({ name: `noticeWrtie` });
    },
  },
};
</script>

<style scoped></style>