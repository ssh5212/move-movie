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
    {
        // [function - 필수] : user 경로로 들어왔을 때 로그인 되어 있다면 메인 화면으로, 로그인 되어 있지 않다면 로그인 화면으로 이동
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
    {
        path: '/bucket',
        name: 'bucket',
        component: () => import('@/views/BucketView.vue'),
        redirect: '/bucket/list',
        children: [
            {
                path: 'list',
                name: 'bucketList',
                component: () => import('@/components/bucket/BucketList.vue'),
            },
            {
                path: 'view/:no',
                name: 'bucketDetail',
                component: () => import('@/components/bucket/BucketSpotListDetail.vue'),
            },
            {
                path: 'create',
                name: 'bucketCreate',
                component: () => import('@/components/bucket/BucketSpotListCreate.vue'),
            },
        ],
    },
    {
        path: '/media',
        name: 'media',
        redirect: '/media/list/title',
        component: () => import('@/views/MediaView.vue'),
        children: [
            {
                path: 'list/title',
                name: 'titleList',
                component: () => import('@/components/media/MediaTitleList.vue'),
            },
            // {
            //     path: 'list/location',
            //     name: 'locationList',
            //     component: () => import('@/components/media/MediaLocationList.vue'),
            // },
            {
                path: 'spot/list/:no',
                name: 'spotList',
                component: () => import('@/components/media/MediaSpotList.vue'),
            },
            {
                path: 'spot/detail/:no',
                name: 'spotDetail',
                component: () => import('@/components/media/MediaSpotDetail.vue'),
            },
            {
                path: 'spot/create',
                name: 'spotcreate',
                component: () => import('@/components/media/MediaSpotCreate.vue'),
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
