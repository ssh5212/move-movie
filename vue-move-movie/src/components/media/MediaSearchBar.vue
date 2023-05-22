<template>
    <b-row class="mt-4 mb-4 text-center">
        <b-col class="sm-3">
            <b-form-select v-model="sidoCode" :options="sidos" @change="gugunList"></b-form-select>
        </b-col>
        <b-col class="sm-3">
            <b-form-select v-model="gugunCode" :options="guguns" @change="searchMedia"></b-form-select>
        </b-col>
    </b-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const mediaStore = "mediaStore";

export default {
    name: "MediaSearchBar",
    data() {
        return {
            sidoCode: null,
            gugunCode: null,
        };
    },
    computed: {
        ...mapState(mediaStore, ["sidos", "guguns", "medias"]),
        // sidos() {
        //   return this.$store.state.sidos;
        // },
    },
    created() {
        // this.$store.dispatch("getSido");
        // this.sidoList();
        this.CLEAR_SIDO_LIST();
        this.CLEAR_MEDIA_LIST();
        this.getSido();
    },
    methods: {
        ...mapActions(mediaStore, ["getSido", "getGugun", "getMediaList"]),
        ...mapMutations(mediaStore, ["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_MEDIA_LIST"]),
        // sidoList() {
        //   this.getSido();
        // },
        gugunList() {
            // console.log(this.sidoCode);
            this.CLEAR_GUGUN_LIST();
            this.gugunCode = null;
            console.log("디스 시도 코드 " + this.sidoCode);
            if (this.sidoCode) this.getGugun(this.sidoCode);
        },
        searchMedia() {
            console.log("method실행");
            // if (this.gugunCode) this.getHouseList(this.gugunCode);
        },
    },
};
</script>

<style></style>
