<template>
    <div class="col-md-4 my-4">
        <div class="card">
            <img :src="img_src" class="card-img-top p-3 pt-5" />
            <div class="card-body pb-5" style="text-align: left">
                <h5 class="card-title" style="text-align: left">
                    {{ spotInstance.spot_instance_title }}
                </h5>
                <p>{{ spotInstance.spot_instance_content }}</p>
                <!-- <b-icon-heart-fill id="b-icon" class="h5 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                <span class="card-text">
                    <small class="text-muted">{{ spotInstance.spot_instance_content }}</small>
                </span> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "MediaSpotDetailItem",
    props: {
        spotInstance: Object,
    },
    data() {
        return {
            img_src: "https://via.placeholder.com/1920x1080",
        };
    },
    created() {
        console.log(this.$props.spotInstance);
        this.img_src = process.env.VUE_APP_API_BASE_URL + this.$props.spotInstance.spot_instance_img_src;
    },
    methods: {
        // moveSpotDetail() {
        //     this.$router.push({
        //         name: 'spotDetail',
        //         params: { no: this.mediaSpot.spot_pk },
        //     });
        // },
    },
};
</script>

<style></style>
