import { createRouter, createWebHistory } from 'vue-router'

// import App from '@/App.vue';
import UserMainPage from '@/pages/User/UserMainPage.vue';
import UserMypage from '@/pages/User/UserMypage.vue'

const router = createRouter({
    history: createWebHistory(),
    routes : [
        { path: '/', component: UserMainPage },
        { path: '/user/mypage', component: UserMypage},
    ]
})

export default router;