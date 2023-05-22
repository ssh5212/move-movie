import { apiInstance } from "@/api/index";

const api = apiInstance();

// http://localhost:9003/movemovie/bucketList/{bucket_pk}
async function bucketListBybucketpk(params, success, fail) {
    await api.get(`/bucketList/${params}`).then(success).catch(fail);
}
// http://localhost:9003/movemovie/bucketList/all
async function bucketListall(params, success, fail) {
    await api.get(`/bucketList/all`).then(success).catch(fail);
}
// http://localhost:9003/movemovie/bucketList/spot/{spot_pk}
async function bucketListByspotpk(params, success, fail) {
    await api.get(`/bucketList/spot/${params}`).then(success).catch(fail);
}

export { bucketListBybucketpk, bucketListall, bucketListByspotpk };
