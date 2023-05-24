<template>
    <div class="px-3 py-2">
        <div class="badge-parent">
            <img class="my-3 p-2" alt="avatar1" :src="img_src || require('@/assets/img/no_img_x.png')" style="width: 100%" />
            <!-- 클릭 시 제거 기능 구현 필요함 -->
            <div class="notification-badge" @click="deleteItem">
                <span>-</span>
            </div>
            <p>{{ this.bucketItem.spot_name }}</p>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex';
const mediaStore = 'mediaStore';
import { mapMutations } from 'vuex';
const toastStore = 'toastStore';
export default {
    name: 'BucketItem',
    props: {
        bucketItem: Object,
    },
    created() {
        this.img_src = process.env.VUE_APP_API_BASE_URL + this.bucketItem.spot_img_src;
    },
    computed: {
        ...mapState(mediaStore, ['bucket']),
    },
    methods: {
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        deleteItem() {
            let rot = 0; // 해당 스폿이 버킷에 포함되어 있는지 판단
            // console.log("this.bucketItem.spot_pk" + this.bucketItem.spot_pk);
            this.bucket.forEach(b => {
                // console.log("rot" + rot);
                // console.log("b.spot_pk" + b.spot_pk);
                if (!(b.spot_pk === this.bucketItem.spot_pk)) {
                    rot++;
                } else {
                    this.bucket.splice(rot, 1);
                    // 토스트에 출력할 데이터
                    let toast_data = {
                        title: 'Success',
                        sub: 'Bucket Bag',
                        content: '스폿 삭제를 완료하였습니다.',
                    };

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                }
            });
        },
    },
    data() {
        return {
            img_src: '',
        };
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
