<template>
    <div>
        <div class="m-3">
            <img :src="img_src" alt="img" />
            <div>{{ spot.spot_name }}</div>
        </div>
    </div>
</template>

<script>
import { spotByspotpk } from "@/api/spot.js";

export default {
    name: "BucketSpotListDetailItem",
    props: {
        spot_pk: Number,
    },
    components: {},
    data() {
        return {
            spot: null,
            img_src: null,
        };
    },
    created() {
        spotByspotpk(this.spot_pk, ({ data }) => {
            this.spot = data.spot;
            console.log(this.spot.spot_name);
            this.img_src = this.spot.spot_img_src;
            if (!this.img_src) {
                this.img_src = "https://via.placeholder.com/130x100";
            }
        });
    },
    methods: {},
};
</script>

<style scoped></style>