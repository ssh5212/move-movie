const toastStore = {
    namespaced: true,
    state: {
        toast_store: {
            title: '',
            sub: '',
            content: '',
            count: 0,
        },
    },
    mutations: {
        SET_TOAST: (state, v) => {
            state.toast_store.title = v.title;
            state.toast_store.sub = v.sub;
            state.toast_store.content = v.content;
        },
        SET_TOAST_CNT: state => {
            state.toast_store.count = state.toast_store.count + 1;
        },
    },
};

export default toastStore;
