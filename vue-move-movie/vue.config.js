const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
    devServer: {
        proxy: {
            "/api": {
                target: "https://www.google.com",
                changeOrigin: true,
                pathRewrite: {
                    "^/api": "",
                },
            },
        },
    },
    transpileDependencies: true,
});
