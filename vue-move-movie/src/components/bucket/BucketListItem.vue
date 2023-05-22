<template>
    <div>
        <!-- <b-card
      overlay
      :img-src="this.BucketList.spotList[0].spot_img_src"
      img-alt="Card Image"
      text-variant=""
      :title="this.BucketList.title"
      sub-title="UserId"
    >
      <b-card-text class=""> {{ this.BucketList.content }} </b-card-text>
    </b-card> -->
        <b-card id="bucket-list-item" :title="this.BucketList.bucket_title" img-src="https://placekitten.com/1000/300" img-alt="Image" img-top @click="movedetail">
            <b-card-text class="small">
                {{ this.BucketList.bucket_content }}
            </b-card-text>
        </b-card>
    </div>
</template>

<script>
// "https://placekitten.com/1000/300"
export default {
    name: "BucketListItem",
    props: {
        BucketList: Object,
    },
    components: {},
    data() {
        return {
            message: "",
        };
    },
    created() {},
    methods: {
        movedetail() {
            this.$router.push({
                name: `bucketDetail`,
                params: { no: this.BucketList.bucket_pk },
            });
        },
    },
};
</script>

<style scoped>
#bucket-list-item:hover {
    background-color: #2f48582d;
    cursor: pointer;
}
</style>
