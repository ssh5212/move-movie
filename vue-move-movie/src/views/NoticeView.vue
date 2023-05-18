<template>
  <div>
    <!-- [S] body -->
    <div class="container">
      <!-- 실제 내용 -->
      <div class="row justify-content-xl-center my-5 align-items-center">
        <div class="col-md-6 offset-md-3 mt-3">
          <h2>Notice</h2>
        </div>
      </div>
      <router-view />
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