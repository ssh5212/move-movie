<template>
  <div>
    <!-- [S] body -->
    <div class="container">
      <!-- 실제 내용 -->
      <div class="row justify-content-xl-center my-5 align-items-center">
        <div class="col-md-5">col-5</div>
        <div class="col-md-5">col-5</div>
        <div class="col-md-3">col-3</div>
        <div class="col-md-12 m-5">
          <h1>안녕ㅎ div안에 넣으면 가운데 정렬이 되도록 되어 있지</h1>
          <p>난설명이야 div안에 넣으면 가운데 정렬이 되도록 되어 있지</p>
        </div>
        <div>
          <p>난아무 세팅이 없는 div에 들어가있어 그래도 가운데로 가지</p>
        </div>
      </div>
    </div>
    <!-- [E] body -->
  </div>
</template>

<script>
export default {
  name: "NoticeView",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>