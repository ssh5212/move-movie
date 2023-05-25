<template>
    <div>
        <div class="m-4">
            <img :src="img_src" alt="img" style="width: 300px; height: 200px" class="pb-2" />
            <div>{{ spot.spot_name }}</div>
            <div v-if="isMine">
                <div>
                    <input type="checkbox" v-model="isChecked" @change="updatechecked" :disabled="isChecked" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { spotByspotpk } from '@/api/spot.js';
import { updateCheck, selectCheck } from '@/api/mybucket.js';
import { mapGetters, mapMutations } from 'vuex';

const userStore = 'userStore';
export default {
    name: 'BucketSpotListDetailItem',
    props: {
        spot_pk: Number,
        isMine: Boolean,
        // user_pk: Number,
    },
    components: {},
    data() {
        return {
            spot: { spot_name: '' },
            img_src: null,
            login_user_pk: null,
            isChecked: true,
            requestChecked: 0,
        };
    },
    computed: {
        ...mapGetters(userStore, ['checkUserInfo']),
    },
    created() {
        if (this.$props.isMine) {
            let tmp = {
                user_pk: this.checkUserInfo.user_pk,
                spot_pk: this.$props.spot_pk,
            };
            selectCheck(tmp, ({ data }) => {
                if (data.spotCheck[0].checked == 0) {
                    this.isChecked = false;
                    this.requestChecked = 1;
                } else {
                    this.isChecked = true;
                    this.requestChecked = 0;
                }
            });
        }

        spotByspotpk(this.spot_pk, ({ data }) => {
            this.spot = data.spot;
            this.img_src = process.env.VUE_APP_API_BASE_URL + this.spot.spot_img_src;
            console.log(this.img_src);
            if (!this.img_src) {
                this.img_src = 'https://via.placeholder.com/130x100';
            }
        });

        // console.log(this.checkUserInfo);
    },
    methods: {
        ...mapMutations('userStore', ['SET_TMP_PLUS']),
        //updatechecked
        updatechecked() {
            // user_pk, spot_pk, bucket_pk, checked

            let obj = {
                user_pk: this.checkUserInfo.user_pk,
                spot_pk: this.$props.spot_pk,
                checked: this.requestChecked,
            };
            updateCheck(obj, ({ data }) => {
                console.log(data);
                this.requestChecked = 1 - this.requestChecked;
                this.SET_TMP_PLUS();
            });
        },
    },
};
</script>

<style scoped></style>
