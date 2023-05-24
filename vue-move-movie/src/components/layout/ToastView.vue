<template>
    <div>
        <p>d</p>
        <p>d</p>
        <p>d</p>
        <p>d</p>
        <p>d</p>
        <button type="button" class="btn btn-primary" id="liveToastBtn" @click="showToast">Show live toast</button>

        <div class="position-fixed p-3" style="z-index: 999; top: 80px; right: 0">
            <div ref="toast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000">
                <div class="toast-header">
                    <strong class="mr-auto">Bootstrap</strong>
                    <small>11 mins ago</small>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close" @click="hideToast">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body">Hello, world! This is a toast message.</div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "ToastView",
    methods: {
        showToast() {
            const toast = this.$refs.toast;
            toast.classList.remove("hide");
            toast.classList.add("show");
            setTimeout(() => {
                this.hideToast();
            }, 3000);
        },
        hideToast() {
            const toast = this.$refs.toast;
            toast.classList.remove("show");
            toast.classList.add("hide");
        },
    },
};
</script>

<style scoped>
.hide {
    display: none;
}
.show {
    display: block;
}
</style>
