<template>
    <div>
        <div class="m-3">
            <img src="https://via.placeholder.com/130x100" alt="img" />
            <div>{{ spot }}</div>
        </div>
    </div>
</template>

<script>
export default {
    name: "BucketSpotListDetailItem",
    props: {
        spot: null,
    },
    components: {},
    data() {
        return {
            message: "",
        };
    },
    created() {
        console.log(this.spot);
    },
    methods: {},
};
</script>

<style scoped></style>