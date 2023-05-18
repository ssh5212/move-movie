import Vue from 'vue';
import VueRouter from 'vue-router';
import HomeView from '../views/HomeView.vue';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView,
    },
    {
        path: '/notice',
        name: 'notice',
        component: () => import('@/views/NoticeView.vue'),
        redirect: '/notice/list',
        children: [
            {
                path: 'list',
                name: 'noticeList',
                component: () => import('@/components/notice/NoticeList.vue'),
            },
            {
                path: 'view/:no',
                name: 'noticeDetail',
                component: () => import('@/components/notice/NoticeDetail.vue'),
            },
            {
                path: 'write',
                name: 'noticeWrtie',
                component: () => import('@/components/notice/NoticeWrtie.vue'),
            },
            {
                path: 'delete',
                name: 'noticeDelete',
                component: () => import('@/components/notice/NoticeDelete.vue'),
            },
            {
                path: 'modify',
                name: 'noticeModify',
                component: () => import('@/components/notice/NoticeModify.vue'),
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
