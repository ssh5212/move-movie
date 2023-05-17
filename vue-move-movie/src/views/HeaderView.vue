<template>
    <div>
        <div id="header">
            <b-navbar toggleable="md">
                <b-container fluid="xl">
                    <b-navbar-brand href="#">NavBar</b-navbar-brand>

                    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

                    <b-collapse id="nav-collapse" is-nav>
                        <b-navbar-nav>
                            <b-nav-item href="#">영화 찾아보기</b-nav-item>
                            <b-nav-item href="#">버킷 살펴보기</b-nav-item>
                            <b-nav-item href="#">공지사항</b-nav-item>
                        </b-navbar-nav>
                    </b-collapse>
                </b-container>
            </b-navbar>
        </div>
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
    background-color: #f8edeb;
}
</style>
