import { apiInstance } from '@/api/index';

const api = apiInstance();

// 리스트 전체 가져옴
async function bucketListAll(params, success, fail) {
    await api.get('/bucket/all').then(success).catch(fail);
}

// http://localhost:9003/movemovie/bucket/bucket/1
async function bucketBybucketpk(params, success, fail) {
    await api.get(`/bucket/bucket/${params}`).then(success).catch(fail);
}

// spot이 포함된 버킷리스트를 가져옴  : spot_pk
async function bucketListSpot(params, success, fail) {
    await api.get('/bucket', { params: params }).then(success).catch(fail);
}

// bucket_pk 에 하트 추가
async function bucketHeartPlus(params, success, fail) {
    await api.get('/bucket/heart_plus', { params: params }).then(success).catch(fail);
}

// heart가 높은순으로 가져오기
async function bucketListheart(success, fail) {
    await api.get('/bucket/bucket_heart_desc').then(success).catch(fail);
}

// bucket 만들기 bucketDto와 spots 가지고 있음.
async function bucketCreate(params, success, fail) {
    await api.post('/bucket/bucket_create', params).then(success).catch(fail);
}

// bucket_pk 삭제하기
async function bucketDelete(params, success, fail) {
    await api.delete(`/bucket/${params}`).then(success).catch(fail);
}

// http://localhost:9003/movemovie/bucket/byuser/12
async function bucketByuserpk(params, success, fail) {
    await api.get(`/bucket/byuser/${params}`).then(success).catch(fail);
}

export { bucketListAll, bucketListSpot, bucketHeartPlus, bucketListheart, bucketCreate, bucketDelete, bucketBybucketpk, bucketByuserpk };

// async function mediaList(params, success, fail) {
//     await api.get(``, { params: params }).then(success).catch(fail);
// }

// async function spotDetailList(params, success, fail) {
//     await localApi.get(`/spot/spot/${params}`).then(success).catch(fail);
// }
