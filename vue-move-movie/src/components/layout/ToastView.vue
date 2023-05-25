<template>
    <div>
        <button type="button" class="btn btn-primary" id="liveToastBtn" @click="showToast" style="display: none">Show live toast</button>

        <div class="position-fixed p-3" style="z-index: 999; top: 80px; right: 0">
            <div ref="toast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true" data-delay="6000">
                <div class="toast-header">
                    <strong class="mr-auto">{{ toast_store.title }}</strong>
                    <small>{{ toast_store.sub }}</small>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close" @click="hideToast">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body">{{ toast_store.content }}</div>
            </div>
        </div>
    </div>
</template>

<script>
const toastStore = "toastStore";
import { mapState, mapMutations } from "vuex";
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
    computed: {
        ...mapState(toastStore, ["toast_store"]),
        ...mapMutations(toastStore, ["SET_TOAST"]),

        // check_store_title() {
        //     return this.toast_store.title;
        // },
        // check_store_sub() {
        //     return this.toast_store.sub;
        // },
        // check_store_content() {
        //     return this.toast_store.content;
        // },
        check_store_count() {
            return this.toast_store.count;
        },
    },
    watch: {
        // check_store_title(val) {
        //     console.log(val);
        //     this.showToast();
        // },
        // check_store_sub(val) {
        //     console.log(val);
        //     this.showToast();
        // },
        // check_store_content(val) {
        //     console.log(val);
        //     this.showToast();
        // },
        check_store_count(val) {
            console.log("check_store_count");
            console.log(val);
            this.showToast();
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
