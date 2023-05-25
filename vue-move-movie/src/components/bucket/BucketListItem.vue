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
        <b-card id="bucket-list-item" :title="this.BucketList.bucket_content" :img-src="img_src" img-alt="Image" img-top @click="movedetail">
            <b-card-text class="small">
                {{ this.BucketList.bucket_title }}
            </b-card-text>
        </b-card>
    </div>
</template>

<script>
import { bucketListBybucketpk } from '@/api/bucketList.js';
import { spotByspotpk } from '@/api/spot.js';
// "https://placekitten.com/1000/300"
export default {
    name: 'BucketListItem',
    props: {
        BucketList: Object,
    },
    components: {},
    data() {
        return {
            img_src: 'https://placekitten.com/1000/300',
        };
    },
    created() {
        // 넘어온 bucket_pk 기반으로 spot의 첫사진의 img_src를 가져옴
        bucketListBybucketpk(this.$props.BucketList.bucket_pk, ({ data }) => {
            spotByspotpk(data.BucketDetailList[0].spot_pk, ({ data }) => {
                console.log(data.spot.spot_img_src);
                this.img_src = process.env.VUE_APP_API_BASE_URL + data.spot.spot_img_src;

                // 만약 img_src 가없으면 위 data에서 정의한 defualt 값으로 화면에 뿌려줌. (고양이)
                // if (!data.spot.spot_img_src) {
                //     this.img_src = data.spot.spot_img_src;
                // }
            });
        });
    },
    methods: {
        movedetail() {
            this.$router.push({
                name: `bucketDetail`,
                params: { no: this.BucketList.bucket_pk },
            });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style scoped>
#bucket-list-item:hover {
    cursor: pointer;
}
</style>
