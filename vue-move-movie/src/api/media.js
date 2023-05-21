import { movieInstance } from "@/api/index";

const api = movieInstance();

async function mediaList(params, success, fail) {
    await api.get(``, { params: params }).then(success).catch(fail);
}

export { mediaList };
