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
                    <div class="badge-parent">
                        <img class="my-3 p-2" alt="avatar1" src="https://via.placeholder.com/1920x1080" style="width: 100%" />
                        <!-- 클릭 시 제거 기능 구현 필요함 -->
                        <div class="notification-badge">
                            <span>-</span>
                        </div>
                        <p>해당 스폿 명</p>
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
            mediaTitleList: [],
            mediaTitle: Object,
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped>
.badge-parent {
    position: relative;
}

.notification-badge {
    position: absolute;
    top: 13px; /* 원하는 위치로 조정하세요 */
    right: -5px; /* 원하는 위치로 조정하세요 */
    background-color: red; /* 배지의 배경색 */
    color: white; /* 배지의 텍스트 색상 */
    border-radius: 50%; /* 원형 배지를 위해 원하는 값을 지정하세요 */
    width: 30px; /* 배지의 너비 */
    height: 30px; /* 배지의 높이 */
    justify-content: center;
    align-items: center;
    font-size: 20px; /* 텍스트 크기 */
    font-weight: bold; /* 텍스트 굵기 */
}
.notification-badge:hover {
    cursor: pointer;
}
</style>
