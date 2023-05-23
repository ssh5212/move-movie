// const { defineConfig } = require("@vue/cli-service");
// module.exports = defineConfig({
//     devServer: {
//         proxy: {
//             "/api": {
//                 target: "https://www.google.com",
//                 changeOrigin: true,
//                 pathRewrite: {
//                     "^/api": "",
//                 },
//             },
//         },
//     },
//     transpileDependencies: true,
// });

module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'https://dapi.kakao.com/v2/local/search/address.json',
                changeOrigin: true,
            },
        },
    },
};
