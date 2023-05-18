<template>
  <div></div>
</template>

<script>
// import http from "@/util/http-common.js";

export default {
  name: "NoticeDelete",
  components: {},
  data() {
    return {
      notice_no: Number,
    };
  },
  created() {
    // axios를 통한 삭제
    this.notice_no = this.$route.params.no;
    console.log(`infono 삭제!! : ${this.notice_no}`);
    // http.delete(`/enjoytrip/restInfo/${infono}`).then(({ data }) => {
    //   console.log(data);
    //   this.$router.push({ path: "Board" });
    // });
  },
  methods: {},
};
</script>

<style scoped></style>