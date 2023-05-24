import { sidoList, gugunList, getMediaList } from '@/api/media.js';

const mediaStore = {
    namespaced: true,
    state: {
        sidos: [{ value: null, text: '선택하세요' }],
        guguns: [{ value: null, text: '선택하세요' }],
        medias: [],
        media: null,
        bucket: [],
    },
    getters: {},
    mutations: {
        CLEAR_SIDO_LIST(state) {
            state.sidos = [{ value: null, text: '선택하세요' }];
        },
        CLEAR_GUGUN_LIST(state) {
            state.guguns = [{ value: null, text: '선택하세요' }];
        },
        CLEAR_MEDIA_LIST(state) {
            state.medias = [];
            state.media = null;
        },
        CLEAR_BUCKET_LIST(state) {
            state.bucket = [];
        },
        SET_SIDO_LIST(state, s) {
            // console.log(s);
            s.spots.forEach(sido => {
                state.sidos.push({ value: sido.sido_code, text: sido.sido_name });
            });
        },
        SET_GUGUN_LIST(state, g) {
            g.spots.forEach(gugun => {
                state.guguns.push({ value: gugun.gugun_code, text: gugun.gugun_name });
            });
        },
        SET_MEDIA_LIST(state, m) {
            // console.log(m.spots);
            // m.spots.forEach((media) => {
            //     state.medias.push(media);
            // });
            state.medias = m.spots;
        },
        SET_DETAIL_MEDIA(state, media) {
            state.media = media;
        },
        SET_MEDIA(state, payload) {
            state.media = payload;
        },
    },
    actions: {
        getSido: ({ commit }) => {
            sidoList(
                ({ data }) => {
                    commit('SET_SIDO_LIST', data);
                },
                error => {
                    console.log(error);
                }
            );
        },
        getGugun: ({ commit }, sidoCode) => {
            const params = sidoCode;
            gugunList(
                params,
                ({ data }) => {
                    commit('SET_GUGUN_LIST', data);
                },
                error => {
                    console.log(error);
                }
            );
        },
        getMediaList: ({ commit }, gugunCode) => {
            const params = gugunCode;
            getMediaList(
                params,
                ({ data }) => {
                    commit('SET_MEDIA_LIST', data);
                },
                error => {
                    console.log(error);
                }
            );
        },
        // detailMedia: ({ commit }, house) => {
        //     // 나중에 house.일련번호를 이용하여 API 호출
        //     commit("SET_DETAIL_MEDIA", house);
        // },

        // async spotEdit({ commit }, spot) {
        //     console.log(spot);
        //     await edit(spot, ({ data }) => {
        //         if (data.message === "success") {
        //             console.log("good");
        //         } else {
        //             commit("SET_IS_LOGIN", false);
        //             console.log("bad");
        //         }
        //     });
        // },
    },
};

export default mediaStore;
