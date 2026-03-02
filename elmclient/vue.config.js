const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
    configureWebpack: {
        devServer: {
            port: 8082,

        }
    },
    transpileDependencies: true,
    lintOnSave: false
});
