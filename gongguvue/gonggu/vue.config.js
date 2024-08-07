const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrgin: true,
        pathRewrite: {"^/api": ""}
  
      }
    }

  },
  transpileDependencies: true
})
