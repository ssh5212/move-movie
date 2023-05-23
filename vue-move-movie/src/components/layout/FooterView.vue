<template>
    <div id="footer">
        <div id="outer-footer">
            <div id="inner-footer" class="container justify-content-end align-items-center p-4">
                <div class="row align-items-end">
                    <div class="col-lg-1 h-100 text-center text-lg-start my-auto">
                        <a href="https://www.ssafy.com/ksp/jsp/swp/swpMain.jsp" target="_blank">
                            <img class="px-4 px-lg-0 my-3" src="@/assets/img/logo-ssafy.png" alt="" height="46px" />
                        </a>
                    </div>
                    <div class="col-lg-7 h-100 text-center text-lg-start my-3">
                        <p class="text-muted small mb-4 mb-lg-0">
                            주소: 98-39, Dongseo-daero, Yuseong-gu, Daejeon, Republic of Korea <br />
                            대표번호: 1588-1588 사업자번호 : 123-4567-987
                        </p>
                        <p class="text-muted small mb-4 mb-lg-0">
                            &copy; Move Movie 2023. All Rights Reserved. &nbsp; ⋅ &nbsp; Designed by
                            <a href="https://angelplayer.tistory.com">SSH</a> &
                            <a href="https://github.com/eldertree777">HJW</a>
                        </p>
                    </div>
                    <div class="col-lg-4 h-100 text-center text-lg-end my-auto">
                        <div class="row justify-content-center">
                            <ul class="list-inline my-3">
                                <li class="list-inline-item mx-3">
                                    <a href="https://www.samsung.com/sec/" target="_blank">
                                        <img src="@/assets/img/logo-samsung.png" alt="" height="20px" />
                                    </a>
                                </li>
                                <li class="list-inline-item mx-3">
                                    <a href="https://api.visitkorea.or.kr/#/" target="_blank">
                                        <img src="@/assets/img/logo-tour-api.png" alt="" height="20px" />
                                    </a>
                                </li>
                                <li class="list-inline-item mx-3">
                                    <a href="https://kto.visitkorea.or.kr/kor.kto" target="_blank">
                                        <img src="@/assets/img/logo-visited-kor.png" alt="" height="20px" />
                                    </a>
                                </li>
                                <li class="list-inline-item mx-3">
                                    <a href="https://www.mcst.go.kr/kor/main.jsp" target="_blank">
                                        <img src="@/assets/img/logo-mcst.png" alt="" height="20px" style="color: #000" />
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "FooterView",
    components: {},
    data() {
        return {
            message: "",
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped>
#outer-footer {
    background-color: rgba(255, 255, 255, 0.6);
}
</style>
