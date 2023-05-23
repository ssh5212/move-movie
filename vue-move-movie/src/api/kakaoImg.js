const axios = require('axios');

const headers = {
    Authorization: 'KakaoAK {REST_API_KEY}',
};

const url = 'https://dapi.kakao.com/v2/search/image';
const params = {
    sort: 'accuracy',
    page: 1,
    size: 1,
    query: '검색어',
};

axios
    .get(url, { headers, params })
    .then((response) => {
        console.log(response.data);
    })
    .catch((error) => {
        console.error(error);
    });
