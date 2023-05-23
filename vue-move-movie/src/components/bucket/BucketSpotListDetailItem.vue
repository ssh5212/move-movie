<template>
  <div>
    <div class="m-3">
      <img :src="img_src" alt="img" />
      <div>{{ spot.spot_name }}</div>
      <!-- <div v-if="this.checkUserInfo.user_pk == this.$props.user_pk"> -->
      <div>
        <input type="checkbox" v-model="isChecked" @change="updatechecked" />
      </div>
    </div>
  </div>
</template>

<script>
import { spotByspotpk } from "@/api/spot.js";
import { updateCheck, selectCheck } from "@/api/mybucket.js";
import { mapGetters } from "vuex";

const userStore = "userStore";
export default {
  name: "BucketSpotListDetailItem",
  props: {
    spot_pk: Number,
    user_pk: Number,
  },
  components: {},
  data() {
    return {
      spot: { spot_name: "" },
      img_src: null,
      login_user_pk: null,
      isChecked: false,
    };
  },
  computed: {
    ...mapGetters(userStore, ["checkUserInfo"]),
  },
  created() {
    let tmp = {
      user_pk: this.$props.user_pk,
      spot_pk: this.$props.spot_pk,
    };
    selectCheck(tmp, ({ data }) => {
      this.isChecked = data.spotCheck.checked;
    });

    spotByspotpk(this.spot_pk, ({ data }) => {
      this.spot = data.spot;
      this.img_src = this.spot.spot_img_src;
      if (!this.img_src) {
        this.img_src = "https://via.placeholder.com/130x100";
      }
    });

    console.log(this.checkUserInfo);
  },
  methods: {
    //updatechecked
    updatechecked() {
      // user_pk, spot_pk, bucket_pk, checked
      let check = null;
      if (this.isChecked == false) {
        check = 0;
      } else {
        check = 1;
      }

      let obj = {
        bucket_pk: this.bucket_pk,
        spot_pk: this.$props.spot_pk,
        ckecked: check,
      };

      updateCheck(obj, ({ data }) => {
        console.log(data);
      });
    },
  },
};
</script>

<style scoped></style>