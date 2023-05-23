import { movieInstance, apiInstance } from "@/api/index";

const api = movieInstance();
const localApi = apiInstance();

async function mediaList(params, success, fail) {
    await api.get(``, { params: params }).then(success).catch(fail);
}

async function spotList(params, success, fail) {
    await localApi.get(`/spot/spot/${params}`).then(success).catch(fail);
}

async function spotDetailList(params, success, fail) {
    await localApi.get(`/spot/spot/${params}`).then(success).catch(fail);
}

async function spotLocationList(coordinate, success, fail) {
    await api.post(`/spot/spot_area`, coordinate).then(success).catch(fail);
}

function sidoList(success, fail) {
    localApi.get(`/spot/sido`).then(success).catch(fail);
}

async function gugunList(params, success, fail) {
    await localApi.get(`/spot/gugun/${params}`).then(success).catch(fail);
}

function mediaLoctionList(params, success, fail) {
    localApi.get(``, { params: params }).then(success).catch(fail);
}

async function getMediaList(params, success, fail) {
    await localApi.get(`/spot/spot_area/${params}`).then(success).catch(fail);
}

export { mediaList, spotList, spotDetailList, spotLocationList, sidoList, gugunList, mediaLoctionList, getMediaList };
