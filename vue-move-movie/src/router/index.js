import Vue from 'vue';
import VueRouter from 'vue-router';
import HomeView from '../views/HomeView.vue';
import UserView from '../views/UserView.vue';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView,
    },
    {
        path: '/user',
        name: 'user',
        component: UserView,
        children: [
            {
                // 로그인
                path: 'login',
                name: 'login',
                component: () => import(/* webpackChunkName: "user" */ '@/components/user/UserLogin.vue'),
            },
            {
                // 회원가입
                path: 'register',
                name: 'register',
                component: () => import(/* webpackChunkName: "user" */ '@/components/user/UserRegister.vue'),
            },
            {
                // 개인화면
                path: 'mypage',
                name: 'mypage',
                component: () => import(/* webpackChunkName: "user" */ '@/components/user/UserPage.vue'),
            },
        ],
    },
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
});

export default router;
