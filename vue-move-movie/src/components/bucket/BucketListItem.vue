<template>
  <div>
    <b-card-group deck>
      <b-card
        :img-src="BucketList.spotList[0].spot_img_src"
        img-alt="Card image"
        img-top
      >
        <b-card-text>
          Some quick example text to build on the card and make up the bulk of
          the card's content.
          {{ BucketList.spotList[0].spot_img_src }}
        </b-card-text>
      </b-card>
    </b-card-group>
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
  created() {
    console.log(this.BucketList.spotList[0].spot_img_src);
  },
  methods: {},
};
</script>

<style scoped></style>