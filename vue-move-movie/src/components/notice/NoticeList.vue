<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">공지사항</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-end my-5 align-items-center">
                <div class="col-md-auto">
                    <button type="button" class="btn btn-secondary my-3" @click="moveWrite">등록</button>
                </div>
                <div class="col-md-12">
                    <b-table striped hover :items="noticeList" :fields="fields" @row-clicked="movedetail"></b-table>
                </div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {
    name: "NoticeList",
    components: {},
    data() {
        return {
            fields: [],
            noticeList: [
                {
                    notice_pk: 0,
                    notice_title: "Dickerson",
                    notice_content: "Macdonald",
                    hit: 17,
                    user_pk: 13,
                },
                {
                    notice_pk: 1,
                    notice_title: "ersonDick",
                    notice_content: "Macdondon",
                    hit: 17,
                    user_pk: 13,
                },
                {
                    notice_pk: 2,
                    notice_title: "Dirsoncke",
                    notice_content: "Mdonanald",
                    hit: 17,
                    user_pk: 13,
                },
                {
                    notice_pk: 3,
                    notice_title: "kersonDickerson",
                    notice_content: "Macdonald",
                    hit: 17,
                    user_pk: 13,
                },
            ],
        };
    },
    created() {},
    methods: {
        movedetail(item) {
            this.$router.push({
                name: `noticeDetail`,
                params: { no: item.notice_pk },
            });
        },

        moveWrite() {
            this.$router.push({ name: `noticeWrtie` });
        },
    },
};
</script>

<style scoped></style>
