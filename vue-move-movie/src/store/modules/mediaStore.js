import { sidoList, gugunList, mediaList } from "@/api/media.js";

const mediaStore = {
    namespaced: true,
    state: {
        sidos: [{ value: null, text: "선택하세요" }],
        guguns: [{ value: null, text: "선택하세요" }],
        medias: [],
        media: null,
    },
    getters: {},
    mutations: {
        CLEAR_SIDO_LIST(state) {
            state.sidos = [{ value: null, text: "선택하세요" }];
        },
        CLEAR_GUGUN_LIST(state) {
            state.guguns = [{ value: null, text: "선택하세요" }];
        },
        CLEAR_MEDIA_LIST(state) {
            state.medias = [];
            state.media = null;
        },
        SET_SIDO_LIST(state, sidos) {
            sidos.forEach((sido) => {
                state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
            });
        },
        SET_GUGUN_LIST(state, guguns) {
            guguns.forEach((gugun) => {
                state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
            });
        },
        SET_MEDIA_LIST(state, medias) {
            state.medias = medias;
        },
        SET_DETAIL_MEDIA(state, media) {
            state.media = media;
        },
    },
    actions: {
        getSido: ({ commit }) => {
            sidoList(
                ({ data }) => {
                    commit("SET_SIDO_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        getGugun: ({ commit }, sidoCode) => {
            const params = { sido: sidoCode };
            gugunList(
                params,
                ({ data }) => {
                    commit("SET_GUGUN_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        getMediaList: ({ commit }, gugunCode) => {
            const SERVICE_KEY = process.env.VUE_APP_API_BASE_URL;
            const params = {
                LAWD_CD: gugunCode,
                DEAL_YMD: "202207",
                serviceKey: decodeURIComponent(SERVICE_KEY),
            };

            mediaList(
                params,
                ({ data }) => {
                    commit("SET_MEDIA_LIST", data.response.body.items.item);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        // detailMedia: ({ commit }, house) => {
        //     // 나중에 house.일련번호를 이용하여 API 호출
        //     commit("SET_DETAIL_MEDIA", house);
        // },
    },
};

export default mediaStore;
