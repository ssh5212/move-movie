<template>
    <div>
        <div id="header">
            <b-navbar toggleable="md" class="fixed-top" :style="headerColor">
                <b-container fluid="xl">
                    <!-- 로고 -->
                    <b-navbar-brand href="#">
                        <b-navbar-brand href="#">
                            <router-link to="/">
                                <img src="@/assets/logo.png" class="d-inline-block align-middle header-logo" width="100px" alt="ssafy" />
                            </router-link>
                        </b-navbar-brand>
                        <span>MoveMovie</span>
                    </b-navbar-brand>
                    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
                    <b-collapse id="nav-collapse" is-nav>
                        <b-navbar-nav>
                            <b-nav-item href="#">영화 찾아보기</b-nav-item>
                            <b-nav-item href="#">버킷 살펴보기</b-nav-item>
                            <b-nav-item href="#">공지사항</b-nav-item>
                        </b-navbar-nav>
                    </b-collapse>
                    <!-- 오른쪽 사이드바 버튼 -->
                    <b-collapse id="nav-collapse" class="justify-content-end d-none d-md-block" is-nav>
                        <b-icon-person-square class="justify-content-end h5"></b-icon-person-square>
                    </b-collapse>
                </b-container>
            </b-navbar>
        </div>
        <div class="d-none d-md-block">hello</div>
        <div class="d-none d-md-block">hide on screens smaller than lg</div>
    </div>
</template>

<script>
export default {
    name: 'HeaderView',
    components: {},
    data() {
        return {
            userid: '',
            headerColor: 'background-color: transparent;',
        };
    },
    mounted() {
        document.addEventListener('scroll', this.scroll);
    },

    methods: {
        // 스크롤 시 색상 효과
        scroll() {
            if (window.scrollY > this.$refs.scrollTest.offsetTop) {
                this.headerColor = 'background-color: transparent;';
            } else {
                this.headerColor = 'background-color: white; opacity:0.8;';
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
</style>
