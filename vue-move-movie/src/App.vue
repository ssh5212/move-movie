<template>
    <div id="app">
        <header-view></header-view>
        <router-view />
        <sidebar-view></sidebar-view>
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
</style>

<script>
import HeaderView from "@/components/layout/HeaderView.vue";
import FooterView from "@/components/layout/FooterView.vue";
import SidebarView from "@/components/layout/SidebarView.vue";

export default {
    name: "HomeView",
    components: {
        HeaderView,
        FooterView,
        SidebarView,
    },
};
</script>
