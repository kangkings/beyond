import { createApp } from 'vue'
import App from './App.vue'
import router from '/router';
import { createPinia } from 'pinia'
// import piniaPersistedstate from "pinia-plugin-persistedstate"

const pinia = createPinia();
const app = createApp(App);
// pinia.use(piniaPersistedstate);

app.use(pinia);
app.use(router);

app.mount('#app')

