import jwtDecode from 'jwt-decode';
import router from '@/router';
import { login, findById, tokenRegeneration, logout, register, edit } from '@/api/user';

const userStore = {
    namespaced: true,
    state: {
        isLogin: false,
        isLoginError: false,
        userInfo: null,
        isValidToken: false,
        tmp: 0,
    },
    getters: {
        checkUserInfo: function (state) {
            return state.userInfo;
        },
        checkToken: function (state) {
            return state.isValidToken;
        },
        checkTmp: function (state) {
            return state.tmp;
        },
    },
    mutations: {
        SET_IS_LOGIN: (state, isLogin) => {
            state.isLogin = isLogin;
        },
        SET_IS_LOGIN_ERROR: (state, isLoginError) => {
            state.isLoginError = isLoginError;
        },
        SET_IS_VALID_TOKEN: (state, isValidToken) => {
            state.isValidToken = isValidToken;
        },
        SET_USER_INFO: (state, userInfo) => {
            state.isLogin = true;
            state.userInfo = userInfo;
        },
        SET_TMP_PLUS: (state) => {
            state.tmp += 1;
        },
    },
    actions: {
        async userConfirm({ commit }, user) {
            await login(
                user,
                ({ data }) => {
                    if (data.message === 'success') {
                        let accessToken = data['access-token'];
                        let refreshToken = data['refresh-token'];
                        // console.log("login success token created!!!! >> ", accessToken, refreshToken);
                        commit('SET_IS_LOGIN', true);
                        commit('SET_IS_LOGIN_ERROR', false);
                        commit('SET_IS_VALID_TOKEN', true);

                        // sessionStorage
                        sessionStorage.setItem('access-token', accessToken);
                        sessionStorage.setItem('refresh-token', refreshToken);
                    } else {
                        commit('SET_IS_LOGIN', false);
                        commit('SET_IS_LOGIN_ERROR', true);
                        commit('SET_IS_VALID_TOKEN', false);
                    }
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        async getUserInfo({ commit, dispatch }, token) {
            let decodeToken = jwtDecode(token);
            console.log('2. getUserInfo() decodeToken :: ', decodeToken);
            await findById(
                decodeToken.user_email,
                ({ data }) => {
                    if (data.message === 'success') {
                        commit('SET_USER_INFO', data.userInfo);
                        console.log('3. getUserInfo data >> ', data);
                    } else {
                        console.log('유저 정보 없음!!!!');
                    }
                },
                async (error) => {
                    console.log('getUserInfo() error code [토큰 만료되어 사용 불가능.] ::: ', error.response.status);
                    commit('SET_IS_VALID_TOKEN', false);
                    await dispatch('tokenRegeneration');
                }
            );
        },
        async tokenRegeneration({ commit, state }) {
            console.log('토큰 재발급 >> 기존 토큰 정보 : {}', sessionStorage.getItem('access-token'));
            await tokenRegeneration(
                JSON.stringify(state.userInfo),
                ({ data }) => {
                    if (data.message === 'success') {
                        let accessToken = data['access-token'];
                        console.log('재발급 완료 >> 새로운 토큰 : {}', accessToken);
                        sessionStorage.setItem('access-token', accessToken);
                        commit('SET_IS_VALID_TOKEN', true);
                    }
                },
                async (error) => {
                    // HttpStatus.UNAUTHORIZE(401) : RefreshToken 기간 만료 >> 다시 로그인!!!!
                    if (error.response.status === 401) {
                        console.log('갱신 실패');
                        // 다시 로그인 전 DB에 저장된 RefreshToken 제거.
                        await logout(
                            state.userInfo.userid,
                            ({ data }) => {
                                if (data.message === 'success') {
                                    console.log('리프레시 토큰 제거 성공');
                                } else {
                                    console.log('리프레시 토큰 제거 실패');
                                }
                                alert('RefreshToken 기간 만료!!! 다시 로그인해 주세요.');
                                commit('SET_IS_LOGIN', false);
                                commit('SET_USER_INFO', null);
                                commit('SET_IS_VALID_TOKEN', false);
                                router.push({ name: 'login' });
                            },
                            (error) => {
                                console.log(error);
                                commit('SET_IS_LOGIN', false);
                                commit('SET_USER_INFO', null);
                            }
                        );
                    }
                }
            );
        },
        async userLogout({ commit }, user_emain) {
            await logout(
                user_emain,
                ({ data }) => {
                    if (data.message === 'success') {
                        commit('SET_IS_LOGIN', false);
                        console.log(this.isLogin);
                        commit('SET_USER_INFO', null);
                        commit('SET_IS_VALID_TOKEN', false);
                        console.log('로그아웃 성공!!');
                    } else {
                        console.log('유저 정보 없음!!!!');
                    }
                },
                (error) => {
                    console.log(error);
                }
            );
        },

        //{commit 무조건 있긴해야함}
        // commit이 필요없으면 굳이 안써도 됨
        // this is trash code
        async userRegister({ commit }, user) {
            console.log(user);
            await register(user, ({ data }) => {
                if (data.message === 'success') {
                    console.log('good');
                } else {
                    commit('SET_IS_LOGIN', false);
                    console.log('bad');
                }
            });
        },

        async userEdit({ commit }, user) {
            console.log(user);
            await edit(user, ({ data }) => {
                if (data.message === 'success') {
                    console.log('good');
                } else {
                    commit('SET_IS_LOGIN', false);
                    console.log('bad');
                }
            });
        },
    },
};

export default userStore;
