<template>
  <div>
    <div id="header">
      <b-navbar toggleable="md" class="fixed-top py-3" :style="headerColor">
        <b-container fluid="xl">
          <!-- 로고 -->
          <b-navbar-brand href="#">
            <router-link to="/">
              <img
                src="@/assets/logo.png"
                class="d-inline-block align-middle header-logo"
                width="100px"
                alt="ssafy"
              />
            </router-link>
            <span>MoveMovie</span>
          </b-navbar-brand>
          <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
          <b-collapse id="nav-collapse" is-nav>
            <b-navbar-nav>
              <b-nav-item href="#">영화 찾아보기</b-nav-item>
              <b-nav-item href="/bucket">버킷 살펴보기</b-nav-item>
              <b-nav-item href="/notice">공지사항</b-nav-item>
            </b-navbar-nav>
          </b-collapse>
          <!-- 오른쪽 사이드바 버튼 -->
          <b-collapse
            id="nav-collapse"
            class="justify-content-end d-none d-md-block"
            is-nav
          >
            <b-icon-person-square
              id="b-icon-person-square"
              class="justify-content-end h2 pt-1"
              v-b-toggle.sidebar-backdrop
            ></b-icon-person-square>
          </b-collapse>
        </b-container>
      </b-navbar>
    </div>
  </div>
</template>

<script>
import { throttle } from "lodash";
export default {
  name: "HeaderView",
  components: {},
  data() {
    return {
      target: null, // 스크롤 이벤트 저장 변수
      headerColor: "background-color: white; opacity:0.9;", // 스크롤 변경 시 마다 색상 변경 바인딩
      scrollTop: 0, // 스크롤 위치 저장 변수
    };
  },

  mounted() {
    // 화면 전환시 이벤트 생성
    this.target = throttle(this.handleScroll, 1000); // 쓰로틀링 적용 (1초)
    window.addEventListener("scroll", this.handleScroll);
  },

  beforeUnmount() {
    // 화면 전환시 기존 이벤트 제거
    window.removeEventListener("scroll", this.handleScroll);
  },

  methods: {
    // 현재 스크롤 위치를 확인하고 색상 변경 여부 판단
    handleScroll() {
      if (window.pageYOffset > 0) {
        this.headerColor = "background-color: white; opacity:0.9;";
      } else {
        this.headerColor = "background-color: white; opacity:0.9;";
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
#b-icon-person-square {
  color: rgba(0, 0, 0, 0.5);
}
#b-icon-person-square:hover {
  background-color: rgba(0, 0, 0, 0.7);
  cursor: pointer;
}
</style>
