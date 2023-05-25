<template>
    <div>
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img :src="getRandomImagePath()" alt="" width="1920" height="auto" />
                <!-- <img src="@/assets/img/title-img-00.png" alt="" width="1920" height="auto" /> -->
            </div>

            <div class="jc-text">
                <p class="vtext-big">타이틀로 영화 검색</p>
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
                <template v-if="mediaTitleList.length == 0">
                    <p>등록된 스팟 사진이 없습니다.</p>
                </template>
                <template v-else>
                    <MediaTitleListItem v-for="(mediaTitle, index) in mediaTitleList" :key="index" :mediaTitle="mediaTitle"></MediaTitleListItem>
                </template>
            </div>
        </div>

        <!-- [E] body -->
    </div>
</template>

<script>
import MediaTitleListItem from '@/components/media/MediaTitleListItem.vue';
import { mediaList } from '@/api/media.js';
const toastStore = 'toastStore';
import { mapMutations } from 'vuex';
export default {
    name: 'MediaTitleList',
    components: { MediaTitleListItem },
    data() {
        return {
            mediaTitleList: [],
            mediaTitle: Object,
            title: '', // 타이틀 명 검색 시
            actor: '', // 배우 검색 시
            keyword: '', // 키워드 검색 시
            listCount: 120,
            sort: 'prodYear,1',
        };
    },
    created() {
        this.searchMedia();
    },
    methods: {
        getRandomImagePath() {
            const randomNumber = Math.floor(Math.random() * 3); // 0에서 5 사이의 랜덤한 숫자 생성
            console.log(randomNumber);
            return `/img/title-img-01.png`;
        },
        ...mapMutations(toastStore, ['SET_TOAST', 'SET_TOAST_CNT']),
        searchMedia() {
            this.mediaTitleList = [];
            const params = {
                listCount: this.listCount, // 한 화면에 최대 영화 출력 수
                title: this.title, // 타이틀 명 검색 시
                query: this.title, // 정확도를 높이기 위해 query로 동시에 검색
                actor: this.actor, // 배우 검색 시
                keyword: this.keyword, // 키워드 검색 시
                sort: this.sort,
            };

            mediaList(
                params,
                ({ data }) => {
                    // console.log(data["Data"][0]["Result"]);
                    const resultData = data['Data'][0]['Result'];
                    console.log(resultData);
                    resultData.forEach(e => {
                        // 성인물 제외
                        //  && e.genre !== "드라마"
                        if (e.rating !== '18세관람가(청소년관람불가)' && e.posters !== '') {
                            this.mediaTitle = {
                                // title: e.title,
                                title: e.title.replace(/ !HS | !HE /g, '').trim(),
                                kmdbUrl: e.kmdbUrl,
                                prodYear: e.prodYear, // 제작년도
                                // prodYear: e.regDatestr.slice(0, 4), // 개봉년도
                                keyword: e.keyword,
                                stlls: e.posters.split('|')[0],
                                docid: e.DOCID,
                            };
                            // console.log('e.DOCID : ' + e.DOCID);
                            this.mediaTitleList.push(this.mediaTitle);
                        }

                        // console.log(this.mediaTitle);
                    });
                },
                error => {
                    console.log(error);
                    // 토스트에 출력할 데이터
                    let toast_data = {
                        title: 'Error', // Success, Fail 등 상태를 표기
                        sub: 'Movie List', // 상태가 일어난 위치 or 기능 표기
                        content: '영화 로딩 중 에러가 발생하였습니다.', // 내용 표기
                    };

                    this.SET_TOAST(toast_data);
                    this.SET_TOAST_CNT();
                }
            );
        },
        searchByTitle() {
            this.searchMedia();
        },
    },
};
</script>

<style></style>
