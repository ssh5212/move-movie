<template>
    <div class="d-flex justify-content-end fixed-bottom" style="margin-right: 30px; margin-bottom: 30px">
        <!-- 수정된 부분 -->
        <b-button v-b-toggle.sidebar-backdrop>
            <b-icon-person-square class="justify-content-end" style="margin-top: 6px; margin-bottom: 2px"></b-icon-person-square>
        </b-button>

        <b-sidebar id="sidebar-backdrop" title="Sidebar with backdrop" :backdrop-variant="variant" backdrop shadow right>
            <div class="px-3 py-2">
                <b-form-group label="Backdrop variant" label-for="backdrop-variant">
                    <b-form-select id="backdrop-variant" v-model="variant" :options="variants"></b-form-select>
                </b-form-group>
            </div>
        </b-sidebar>
    </div>
</template>

<script>
export default {
    name: "SidebarView",
    components: {},
    data() {
        return {
            message: "",
            variant: "dark",
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>
