<template>
    <!-- 스팟 -->
    <div class="card mb-3 my-5" style="width: 100%">
        <div class="row no-gutters align-items-center">
            <div class="col-md-3 p-3 d-flex justify-content-center align-items-center">
                <img :src="img_src || require('@/assets/img/no_img_x.png')" alt="..." style="width: 100%" />
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h4 class="card-title text-left mb-5" @click="moveSpotDetail">
                        {{ mediaSpot.spot_name }}
                    </h4>
                    <p class="text-left">영화명 : {{ mediaSpot.spot_movie_title }}</p>
                    <p class="text-left">주소 : {{ mediaSpot.spot_address }}</p>
                </div>
            </div>
            <div class="col-md-1 d-flex flex-column justify-content-center align-items-center">
                <b-icon-basket2-fill id="b-icon" class="h3 pt-1 mb-3 bucket-btn" @click="addThisSpot"></b-icon-basket2-fill>
                <!-- [function - 필수] : 장바구니 하트 개수 출력 기능 구현 -->
                <!-- <b-icon-heart-fill id="b-icon" class="h3 pt-1 m-0" v-b-toggle.sidebar-backdrop></b-icon-heart-fill>
                <p class="card-text-left text-center"><small class="text-muted">1000</small></p> -->
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
const mediaStore = 'mediaStore';
const toastStore = 'toastStore';
export default {
    name: 'MediaSpotListItem',

    computed: {
        ...mapState(mediaStore, ['bucket']),
    },

    created() {
        if (
            this.mediaSpot.spot_img_src == '/images/spotfile/' ||
            this.mediaSpot.spot_img_src == ' ' ||
            this.mediaSpot.spot_img_src == null ||
            this.mediaSpot.spot_img_src == `${process.env.VUE_APP_API_BASE_URL}null`
        ) {
            this.img_src = '';
        } else {
            this.img_src = process.env.VUE_APP_API_BASE_URL + this.mediaSpot.spot_img_src;
        }
    },
    methods: {
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        ...mapMutations(mediaStore, ['SET_MEDIA']),
        moveSpotDetail() {
            this.SET_MEDIA(this.mediaSpot); // mediaStore의 media 상태 업데이트

            this.$router.push({
                name: 'spotDetail',
                params: { no: this.mediaSpot.spot_pk },
            });
            window.scrollTo(0, 0);
        },
        addThisSpot() {
            // bucket이 비어 있는 경우
            if (this.bucket.length == 0) {
                this.bucket.push(this.mediaSpot);
                // 토스트에 출력할 데이터
                let toast_data = {
                    title: 'Success', // Error, Delete, Login 등 상태를 표기
                    sub: 'Bucket Bag', // 상태가 일어난 위치 표기
                    content: 'Bucket Bag에 담겼습니다.', // 내용 표기
                };

                this.SET_TOAST(toast_data);
                this.SET_TOAST_CNT();
            } else {
                let isok = 1; // 해당 스폿이 버킷에 포함되어 있는지 판단
                this.bucket.forEach(b => {
                    if (b.spot_pk == this.mediaSpot.spot_pk) {
                        isok = 0;
                        // 토스트에 출력할 데이터
                        let toast_data = {
                            title: 'Fail', // Error, Delete, Login 등 상태를 표기
                            sub: 'Bucket Bag', // 상태가 일어난 위치 표기
                            content: 'Bucket Bag에 이미 존재합니다.', // 내용 표기
                        };

                        this.SET_TOAST(toast_data);
                        this.SET_TOAST_CNT();
                    }
                });
                if (isok == 1) {
                    this.bucket.push(this.mediaSpot);
                    // 토스트에 출력할 데이터
                    let toast_data = {
                        title: 'Success', // Error, Delete, Login 등 상태를 표기
                        sub: 'Bucket Bag', // 상태가 일어난 위치 표기
                        content: 'Bucket Bag에 담겼습니다.', // 내용 표기
                    };

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                }
            }
        },
    },
    data() {
        return {
            img_src: '',
        };
    },
    props: {
        mediaSpot: Object,
    },
};
</script>

<style>
.bucket-btn:hover {
    color: rgba(0, 0, 0, 0.9) !important;
    cursor: pointer;
}
.card-title:hover {
    color: rgba(0, 0, 0, 0.9) !important;
    cursor: pointer;
}
</style>
