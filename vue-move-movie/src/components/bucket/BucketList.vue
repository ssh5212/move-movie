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
    // test start
    this.bucketList = {
      bucket_pk: 77,
      title: "title_1",
      content: "content_1",
      spotList: [
        {
          spot_pk: 0,
          spot_name: "goodplace",
          spot_img_src: "https://placekitten.com/1000/300",
        },
      ],
    };
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
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

<style scoped>
</style>