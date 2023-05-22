<template>
    <div class="px-3 py-2">
        <div class="badge-parent">
            <img class="my-3 p-2" alt="avatar1" :src="this.bucketItem.spot_img_src || require('@/assets/img/no_img_x.png')" style="width: 100%" />
            <!-- 클릭 시 제거 기능 구현 필요함 -->
            <div class="notification-badge" @click="deleteItem">
                <span>-</span>
            </div>
            <p>{{ this.bucket.spot_name }}</p>
        </div>
    </div>
</template>

<script>
import { mapState } from "vuex";
const mediaStore = "mediaStore";
export default {
    name: "BucketItem",
    props: {
        bucketItem: Object,
    },
    computed: {
        ...mapState(mediaStore, ["bucket"]),
    },
    methods: {
        deleteItem() {
            let rot = 1; // 해당 스폿이 버킷에 포함되어 있는지 판단
            this.bucket.forEach((b) => {
                if (!b.spot_pk == this.mediaSpot.spot_pk) {
                    rot++;
                } else {
                    this.bucket.splice(rot, 1);
                }
            });
        },
    },
};
</script>

<style>
.badge-parent {
    position: relative;
}

.notification-badge {
    position: absolute;
    top: 13px; /* 원하는 위치로 조정하세요 */
    right: -5px; /* 원하는 위치로 조정하세요 */
    background-color: red; /* 배지의 배경색 */
    color: white; /* 배지의 텍스트 색상 */
    border-radius: 50%; /* 원형 배지를 위해 원하는 값을 지정하세요 */
    width: 30px; /* 배지의 너비 */
    height: 30px; /* 배지의 높이 */
    justify-content: center;
    align-items: center;
    font-size: 20px; /* 텍스트 크기 */
    font-weight: bold; /* 텍스트 굵기 */
}
.notification-badge:hover {
    cursor: pointer;
}
</style>
