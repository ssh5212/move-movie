<template>
    <div id="app">
        <div id="wrap-content">
            <ToastView></ToastView>
            <header-view></header-view>
            <router-view />
            <sidebar-view></sidebar-view>
        </div>

        <footer-view></footer-view>
    </div>
</template>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

nav {
    padding: 30px;
}

nav a {
    font-weight: bold;
    color: #2c3e50;
}

nav a.router-link-exact-active {
    color: #42b983;
}

#top-margin {
    /* background-color: red; */
    width: auto;
    height: 75px;
    visibility: hidden;
}

/* 각 아이템간 분리 */
.margin-div {
    margin-bottom: 96px;
}
.padding-div {
    margin-bottom: 96px;
}

/* footer 고정을 위한 코드 */
html,
body {
    margin: 0;
    padding: 0;
    height: 100%;
}
#app {
    min-height: 100%;
    position: relative;
}

#wrap-content {
    /* margin-top: 100px; */
    padding-bottom: 143px; /* footer의 높이 */
}

#footer {
    width: 100%;
    height: 143px; /* footer의 높이 */
    position: absolute;
    bottom: 0;
    left: 0;
}

/* 각 화면의 시작 이미지 */
.jb-box {
    overflow: hidden;
    margin: 0px auto;
    position: relative;
}

.jb-box img {
    object-fit: cover;
    width: 100%;
    height: 500px;
}

.jc-text {
    position: absolute;
    top: 50%;
    width: 100%;
    color: whitesmoke;
}

.vtext-big {
    font-weight: 700;
    font-size: 70px;
}

.v-application {
    font-family: "Jeju Gothic", sans-serif !important;
}
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
.jejugothic * {
    font-family: "Jeju Gothic", sans-serif;
}
</style>

<script>
import HeaderView from "@/components/layout/HeaderView.vue";
import FooterView from "@/components/layout/FooterView.vue";
import SidebarView from "@/components/layout/SidebarView.vue";
import ToastView from "@/components/layout/ToastView.vue";

export default {
    name: "HomeView",
    components: {
        HeaderView,
        FooterView,
        SidebarView,
        ToastView,
    },
};
</script>
