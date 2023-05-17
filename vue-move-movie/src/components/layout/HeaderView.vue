<template>
    <div>
        <div id="header">
            <b-navbar toggleable="md">
                <b-container fluid="xl">
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
                        <!-- main logo -->
                        <b-navbar-nav>
                            <b-nav-item href="#">영화 찾아보기</b-nav-item>
                            <b-nav-item href="#">버킷 살펴보기</b-nav-item>
                            <b-nav-item href="#">공지사항</b-nav-item>
                        </b-navbar-nav>
                    </b-collapse>
                    <b-collapse id="nav-collapse" class="justify-content-end d-none d-md-block" is-nav>
                        <b-icon-person-square class="justify-content-end"></b-icon-person-square>
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
        };
    },
    methods: {},
};
</script>

<style scoped>
#header {
    background-color: #ffffff;
}
.header-logo {
    height: 35px;
    width: auto;
}
</style>
