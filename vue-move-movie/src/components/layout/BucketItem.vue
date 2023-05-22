<template>
    <div class="px-3 py-2">
        <div class="badge-parent">
            <img class="my-3 p-2" alt="avatar1" :src="this.bucketItem.spot_img_src || require('@/assets/img/no_img_x.png')" style="width: 100%" />
            <!-- 클릭 시 제거 기능 구현 필요함 -->
            <div class="notification-badge">
                <span>-</span>
            </div>
            <p>해당 스폿 명</p>
        </div>
    </div>
</template>

<script>
export default {
    name: "BucketItem",
    props: {
        bucketItem: Object,
    },
    methods: {},
};
</script>

<style></style>
