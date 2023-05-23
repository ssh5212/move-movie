<template>
  <div>
    <!-- [S] body -->
    <div class="container">
      <!-- 실제 내용 -->
      <div class="row justify-content-xl-center my-5 align-items-center"></div>
      <div class="row justify-content-xl-end mb-3 mr-0">
        <button @click="moveCreate">버킷 리스트 생성하기</button>
      </div>
      <div class="row justify-content-xl-between">
        <bucket-list-item
          class="col-md-4 mb-1"
          v-for="(bucketList, index) in bucketListList"
          :key="index"
          :BucketList="bucketList"
        ></bucket-list-item>
      </div>
    </div>
    <!-- [E] body -->
  </div>
</template>

<script>
import BucketListItem from "@/components/bucket/BucketListItem.vue";
import { bucketListheart } from "@/api/bucket.js";
export default {
  name: "BucketList",
  components: { BucketListItem },
  data() {
    return {
      bucketListList: [],
      bucketList: Object,
    };
  },
  created() {
    bucketListheart(({ data }) => {
      this.bucketListList = data.BucketList;
    });
    // test end
  },
  methods: {
    moveCreate() {
      this.$router.push({
        name: `bucketCreate`,
      });
    },
  },
};
</script>

<style scoped></style>
