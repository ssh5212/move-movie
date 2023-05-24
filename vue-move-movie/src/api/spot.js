import { apiInstance } from "@/api/index";

const api = apiInstance();

async function spotBymovie(params, success, fail) {
    await api.get(`/spot/spot/${params}`).then(success).catch(fail);
}

async function spotAll(success, fail) {
    await api.get(`/spot/sido`).then(success).catch(fail);
}

async function spotBygugun(params, success, fail) {
    await api.get(`/spot/spot_area/${params}`).then(success).catch(fail);
}

// params spot_pk
async function spotByspotpk(params, success, fail) {
    await api.get(`/spot/${params}`).then(success).catch(fail);
}

async function register(params, success, fail) {
    console.log(params);
    await api.post(`/spot`, params).then(success).catch(fail);
}

export { spotBymovie, spotAll, spotBygugun, spotByspotpk, register };
