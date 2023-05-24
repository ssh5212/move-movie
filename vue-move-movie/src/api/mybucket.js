import { apiInstance } from '@/api/index';

const api = apiInstance();

// http://localhost:9003/movemovie/mybucket/checkedupdate
async function updateCheck(params, success, fail) {
    await api.post(`/mybucket/checkedupdate`, params).then(success).catch(fail);
}

// movemovie/mybucket/selectCheck
async function selectCheck(params, success, fail) {
    await api.post(`/mybucket/selectCheck`, params).then(success).catch(fail);
}

// http://localhost:9003/movemovie/mybucket/selectUserBucket
async function selectUserBucket(params, success, fail) {
    await api.post(`/mybucket/selectUserBucket`, params).then(success).catch(fail);
}
export { updateCheck, selectCheck, selectUserBucket };
