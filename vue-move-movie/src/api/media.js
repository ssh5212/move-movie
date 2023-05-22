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

export { mediaList, spotList, spotDetailList };
