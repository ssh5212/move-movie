<template>
    <div>
        <div class="mb-4">
            <p style="text-align: left; margin-bottom: 5px" @click="movebucket">
                {{ this.$props.bucket.bucket_title }}
            </p>
            <div class="progress">
                <b-progress :value="(checknums / checkmax) * 100" :max="100" show-progress animated style="width: 100%"></b-progress>
            </div>
        </div>
    </div>
</template>

<script>
import { selectUserBucket } from '@/api/mybucket.js';

export default {
    name: 'MybucketProgress',
    components: {},
    props: {
        bucket: Object,
    },
    data() {
        return {
            message: '',
            MyBucketList: [],
            checknums: 1,
            checkmax: 1,
        };
    },
    created() {
        let mybucket = {
            bucket_pk: this.$props.bucket.bucket_pk,
            user_pk: this.$props.bucket.user_pk,
        };
        let checknnum = 0;
        selectUserBucket(mybucket, ({ data }) => {
            this.MyBucketList = data.MyBucket;
            this.checkmax = this.MyBucketList.length;
            this.MyBucketList.forEach(MyBucket => {
                if (MyBucket.checked == 1) {
                    checknnum++;
                }
            });

            this.checknums = checknnum;
        });
    },
    methods: {
        movebucket() {
            this.$router.push({
                name: `bucketDetail`,
                params: { no: this.$props.bucket.bucket_pk },
            });
            window.scrollTo(0, 0);
        },
    },
};
</script>

<style scoped></style>
