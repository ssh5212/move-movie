<template>
    <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 16px; margin-bottom: 16px">
        <!-- 수정된 부분 -->
        <b-button v-b-toggle.sidebar-backdrop class="d-none d-sm-block d-md-none">
            <b-icon-person-square class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-person-square>
        </b-button>

        <b-sidebar id="sidebar-backdrop" title="" :backdrop-variant="variant" backdrop shadow right>
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
