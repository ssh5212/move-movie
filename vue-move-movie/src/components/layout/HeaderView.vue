<template>
    <div>
        <div id="header">
            <b-navbar toggleable="md" class="fixed-top py-3" :style="headerColor">
                <b-container fluid="xl">
                    <!-- 로고 -->
                    <b-navbar-brand>
                        <router-link to="/" style="text-decoration: none; cursor: pointer">
                            <img src="@/assets/logo.png" class="d-inline-block align-middle header-logo mr-2" width="100px" alt="ssafy" />
                            <span style="color: black">MoveMovie</span>
                        </router-link>
                    </b-navbar-brand>
                    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
                    <b-collapse id="nav-collapse" is-nav>
                        <b-navbar-nav>
                            <b-nav-item><router-link to="/media" class="nav-link p-md-0">타이틀 기반 검색</router-link></b-nav-item>
                            <b-nav-item><router-link to="/media/list/location" class="nav-link p-md-0">주소 기반 검색</router-link></b-nav-item>
                            <b-nav-item><router-link to="/bucket" class="nav-link p-md-0">버킷 살펴보기</router-link></b-nav-item>
                            <!-- <b-nav-item><router-link to="/notice" class="nav-link p-md-0">공지사항</router-link></b-nav-item> -->
                        </b-navbar-nav>
                    </b-collapse>

                    <!-- 오른쪽 사이드바 버튼 -->
                    <b-collapse id="nav-collapse" class="justify-content-end d-none d-md-block" is-nav>
                        <div class="pr-3 user-info-header" v-if="userInfo">
                            <b>{{ userInfo.user_nickname }}님, 반가워요!</b>
                        </div>
                        <b-icon-basket2-fill id="b-icon-basket2-fill" class="justify-content-end h2 pt-1 mr-3" v-b-toggle.sidebar-left></b-icon-basket2-fill>
                        <b-icon-person-square id="b-icon-person-square" class="justify-content-end h2 pt-1" v-b-toggle.sidebar-backdrop></b-icon-person-square>
                    </b-collapse>
                </b-container>
            </b-navbar>
        </div>
    </div>
</template>

<script>
import { throttle } from 'lodash';
import { mapState } from 'vuex';

const userStore = 'userStore';

export default {
    name: 'HeaderView',
    components: {},
    data() {
        return {
            target: null, // 스크롤 이벤트 저장 변수
            headerColor: 'background-color: rgba(255, 255, 255, 0.9);', // 스크롤 변경 시 마다 색상 변경 바인딩
            scrollTop: 0, // 스크롤 위치 저장 변수
        };
    },
    computed: {
        ...mapState(userStore, ['userInfo']),
    },
    mounted() {
        // 화면 전환시 이벤트 생성
        this.target = throttle(this.handleScroll, 1000); // 쓰로틀링 적용 (1초)
        window.addEventListener('scroll', this.handleScroll);
    },

    beforeUnmount() {
        // 화면 전환시 기존 이벤트 제거
        window.removeEventListener('scroll', this.handleScroll);
    },

    methods: {
        // 현재 스크롤 위치를 확인하고 색상 변경 여부 판단
        handleScroll() {
            if (window.pageYOffset > 0) {
                this.headerColor = 'background-color: rgba(255, 255, 255, 0.9);';
            } else {
                this.headerColor = 'background-color: rgba(255, 255, 255, 0.9);';
            }
        },
    },
};
</script>

<style scoped>
.header-logo {
    height: 35px;
    width: auto;
}

/* 버튼처럼 호버되면 변하게 변경 */
#b-icon-person-square,
#b-icon-basket2-fill {
    color: rgba(0, 0, 0, 0.6) !important;
}
#b-icon-person-square:hover,
#b-icon-basket2-fill:hover {
    color: rgba(0, 0, 0, 0.8) !important;
    cursor: pointer;
}

.nav-link {
    color: rgba(0, 0, 0, 0.7) !important;
}
.nav-link:hover {
    color: rgba(0, 0, 0, 0.9) !important;
    cursor: pointer;
}

@media (max-width: 900px) {
    .user-info-header {
        display: none;
    }
}
</style>
