<template>
    <div>
        <!-- 왼쪽 사이드바 -->
        <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 78px">
            <!-- 수정된 부분 -->
            <b-button v-b-toggle.sidebar-left class="d-sm-block d-md-none">
                <b-icon-basket2-fill class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-basket2-fill>
            </b-button>

            <!-- [function - 필수] 기능 구현 : 왼쪽 사이드바 (바구니)에 들어갈 내용으로 수정 필요 -->
            <b-sidebar id="sidebar-left" title="" :backdrop-variant="variant" backdrop shadow left>
                <div class="px-3 py-2">
                    <img class="rounded-circle my-3" alt="avatar1" src="https://mdbcdn.b-cdn.net/img/new/avatars/9.webp" />
                    <h2 class="mb-2">연예인 원영</h2>
                    <h4 class="mb-3">lv. 999</h4>

                    <div class="progress mb-4 mx-4">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                    </div>

                    <button type="button" class="btn btn-dark mb-4">마이페이지</button><br />

                    <h5>내 버킷리스트 진행도</h5>
                    <div class="mb-4">
                        <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                        <div class="progress" style="height: 5px">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                        </div>
                    </div>
                </div>
            </b-sidebar>
        </div>

        <!-- 오른쪽 사이드바 -->
        <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 18px">
            <!-- 수정된 부분 -->
            <b-button v-b-toggle.sidebar-backdrop class="d-sm-block d-md-none">
                <b-icon-person-square class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-person-square>
            </b-button>

            <b-sidebar id="sidebar-backdrop" title="" :backdrop-variant="variant" backdrop shadow right>
                <div class="px-3 py-2">
                    <!-- [function - 필수] 데이터 바인딩 : 사용자 데이터로 동적으로 바뀌도록 해야 함 -->

                    <img class="rounded-circle my-3" alt="avatar1" src="https://mdbcdn.b-cdn.net/img/new/avatars/9.webp" />
                    <h2 class="mb-2">연예인 원영</h2>
                    <h4 class="mb-3">lv. 999</h4>

                    <div class="progress mb-4 mx-4">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                    </div>
                    <!-- [function - 필수] 이동 : 마이페이지 -->

                    <button type="button" class="btn btn-dark mb-4">마이페이지</button><br />

                    <!-- [function - 필수] 데이터 바인딩 : 버킷 리스트 연결 -->
                    <h5>내 버킷리스트 진행도</h5>
                    <div class="mb-4">
                        <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                        <div class="progress" style="height: 5px">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                        </div>
                    </div>

                    <div class="mb-4">
                        <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                        <div class="progress" style="height: 5px">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                        </div>
                    </div>

                    <div class="mb-4">
                        <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                        <div class="progress" style="height: 5px">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                        </div>
                    </div>

                    <div class="mb-4">
                        <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                        <div class="progress" style="height: 5px">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                        </div>
                    </div>

                    <div class="mb-4">
                        <p style="text-align: left; margin-bottom: 5px">리포 따라가기</p>
                        <div class="progress" style="height: 5px">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" height></div>
                        </div>
                    </div>
                </div>
            </b-sidebar>
        </div>
    </div>
</template>

<script>
export default {
    name: 'SidebarView',
    components: {},
    data() {
        return {
            message: '',
            variant: 'dark',
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>
