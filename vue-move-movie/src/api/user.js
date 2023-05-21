import { apiInstance } from "@/api/index";

const api = apiInstance();

async function login(user_email, success, fail) {
    await api.post(`/user/login`, JSON.stringify(user_email)).then(success).catch(fail);
}

async function findById(user_email, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/user/info/${user_email}`).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
    api.defaults.headers["refresh-token"] = sessionStorage.getItem("refresh-token"); //axios header에 refresh-token 셋팅
    await api.post(`/user/refresh`, user).then(success).catch(fail);
}

async function logout(user_email, success, fail) {
    console.log(user_email);
    await api.get(`/user/logout/${user_email}`).then(success).catch(fail);
}

async function register(user, success, fail) {
    console.log(user);
    await api.post(`/user/register`, user).then(success).catch(fail);
}

async function edit(user, success, fail) {
    console.log(user);
    await api.post(`/user/edit`, user).then(success).catch(fail);
}

export { login, findById, tokenRegeneration, logout, register, edit };
