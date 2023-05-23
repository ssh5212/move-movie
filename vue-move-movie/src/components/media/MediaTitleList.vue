<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">영화 검색</p>
            </div>
        </div>
        <!-- [E] Intro Image -->

        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-end">
                <div class="col-md-5">
                    <div class="input-group pt-5 mt-5">
                        <input
                            type="text"
                            class="form-control"
                            placeholder="영화 제목을 입력하세요"
                            aria-label="영화 제목을 입력하세요"
                            aria-describedby="searchTitle"
                            v-model="title"
                            @keydown.enter="searchByTitle"
                        />
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="button" id="searchTitle" @click="searchByTitle">Button</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row justify-content-xl-center my-5 align-items-center">
                <MediaTitleListItem v-for="(mediaTitle, index) in mediaTitleList" :key="index" :mediaTitle="mediaTitle"></MediaTitleListItem>
            </div>
        </div>

        <!-- [E] body -->
    </div>
</template>

<script>
import MediaTitleListItem from "@/components/media/MediaTitleListItem.vue";
import { mediaList } from "@/api/media.js";

export default {
    name: "MediaTitleList",
    components: { MediaTitleListItem },
    data() {
        return {
            mediaTitleList: [],
            mediaTitle: Object,
            title: "", // 타이틀 명 검색 시
            actor: "", // 배우 검색 시
            keyword: "", // 키워드 검색 시
            listCount: 50,
        };
    },
    created() {
        this.searchMedia();
    },
    methods: {
        searchMedia() {
            this.mediaTitleList = [];
            const params = {
                listCount: this.listCount, // 한 화면에 최대 영화 출력 수
                title: this.title, // 타이틀 명 검색 시
                query: this.title, // 정확도를 높이기 위해 query로 동시에 검색
                actor: this.actor, // 배우 검색 시
                keyword: this.keyword, // 키워드 검색 시
            };

            mediaList(
                params,
                ({ data }) => {
                    console.log(data["Data"][0]["Result"]);
                    const resultData = data["Data"][0]["Result"];
                    resultData.forEach((e) => {
                        // 성인물 제외
                        //  && e.genre !== "드라마"
                        if (e.rating !== "18세관람가(청소년관람불가)") {
                            this.mediaTitle = {
                                // title: e.title,
                                title: e.title.replace(/ !HS | !HE /g, "").trim(),
                                kmdbUrl: e.kmdbUrl,
                                prodYear: e.prodYear, // 제작년도
                                // prodYear: e.regDatestr.slice(0, 4), // 개봉년도
                                keyword: e.keyword,
                                stlls: e.posters.split("|")[0],
                            };
                            this.mediaTitleList.push(this.mediaTitle);
                        }

                        // console.log(this.mediaTitle);
                    });
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        searchByTitle() {
            this.searchMedia();
        },
    },
};
</script>

<style>
.img-bg-dark {
    filter: brightness(1);
    transition: 0.5s;
}

.img-bg-dark:hover {
    filter: brightness(0.6);
    cursor: pointer;
}
.card-overlay {
    position: absolute;
    top: 80%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: white;
    text-shadow: 3px 3px 5px rgba(0, 0, 0, 1);
    width: 200px;
}

.card-text {
    opacity: 0;
    transition: opacity 0.5s;
}

.img-bg-dark:hover + .card-overlay .card-text {
    opacity: 1;
}
</style>
