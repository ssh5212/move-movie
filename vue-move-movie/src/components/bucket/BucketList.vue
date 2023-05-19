<template>
  <div>
    <div class="row">
      <bucket-list-item
        class="col-md-4"
        v-for="(bucketList, index) in bucketListList"
        :key="index"
        :BucketList="bucketList"
      ></bucket-list-item>
    </div>
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
    this.bucketList = {
      title: "title_1",
      content: "content_1",
      spotList: [
        {
          spot_pk: 0,
          spot_name: "goodplace",
          spot_img_src: "@/assets/img/350x250.png",
        },
      ],
    };

    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
    this.bucketListList.push(this.bucketList);
  },
  methods: {},
};
</script>

<style scoped></style>