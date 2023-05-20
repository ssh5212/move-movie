<template>
  <div>
    <!-- [S] Intro Image -->
    <div class="jb-box">
      <div class="top-img">
        <img
          src="@/assets/img/intro-half-img01.jpg"
          alt=""
          width="1920"
          height="auto"
        />
      </div>

      <div class="jc-text">
        <p class="vtext-big">영화 스팟 등록!!</p>
      </div>
    </div>
    <!-- [E] Intro Image -->

    <!-- [S] body -->
    <div class="container">
      <!-- 실제 내용 -->
      <div class="row justify-content-xl-center my-5 align-items-center">
        <!-- start row -->
        <div
          class="row justify-content-xl-between align-items-center col-md-12"
        >
          <!-- 좌 -->
          <div class="col-md-6">
            <b-button class="col-md-12" v-b-modal.modal-upload
              >이미지 추가</b-button
            >

            <b-modal id="modal-upload" title="이미지 추가">
              <input type="file" ref="fileInput" @change="handleFileUpload" />
              <b-button @click="uploadImage">업로드</b-button>
            </b-modal>
          </div>
          <!-- 우 -->
          <div class="col-md-6">
            <div class="">
              <div class="text-left">상세주소</div>
              <div class="text-left">{{ Address }}</div>
              <div class="text-left">
                (※ 상세주소가 맞지 않다면 주소 찾기로 수정해주세요!)
              </div>
            </div>
          </div>
        </div>
        <!-- end row  -->
        <!-- start row -->
        <div
          class="row justify-content-xl-between align-items-center col-md-12"
        >
          <!-- 좌 -->
          <div class="col-md-6">
            <!-- 이미지 -->
            <div class="mt-3">
              <img :src="selectedImage" alt="Uploaded Image" width="100%" />
            </div>
          </div>
          <!-- 우 -->
          <div class="col-md-6">
            <!-- 글 제목 입력 -->
            <div>
              <div class="text-left">제목</div>
              <div>
                <b-form-input type="text"></b-form-input>
              </div>
            </div>
            <!-- 글 내용 입력 -->
            <div>
              <div class="text-left mt-3">내용</div>
              <div>
                <b-row class="mt-2">
                  <b-form-textarea
                    id="textarea-default"
                    placeholder="Default textarea"
                    class="ml-3"
                  ></b-form-textarea>
                </b-row>
              </div>
            </div>
          </div>
        </div>
        <!-- end row  -->
        <!-- start row -->
        <div
          class="row justify-content-xl-between align-items-center col-md-12 mt-4"
        >
          <!-- 좌 -->
          <div class="col-md-6">
            <b-button class="col-md-12">주소 찾기</b-button>
          </div>
          <!-- 우 -->
          <div class="col-md-6">
            <b-button class="col-md-12">등록 하기</b-button>
          </div>
        </div>
        <!-- end row  -->
      </div>
    </div>
    <!-- [E] body -->
  </div>
</template>

<script>
export default {
  name: "MediaSpotCreate",
  components: {},
  data() {
    return {
      Address: String,
      selectedImage: Object,
    };
  },
  created() {
    this.Address = "대전 한밭대 근처 어딘가";
  },
  methods: {
    handleFileUpload(event) {
      const file = event.target.files[0];
      this.selectedImage = URL.createObjectURL(file);
    },
    // handleFileUpload() {
    //   const file = this.$refs.fileInput.files[0];
    //   const reader = new FileReader();

    //   reader.onload = (e) => {
    //     const imageUrl = e.target.result;
    //     const imageId = Date.now(); // 고유한 ID 생성을 위해 현재 시간 사용 (실제로는 서버에서 ID를 생성하거나 다른 방식으로 사용해야 함)

    //     this.selectedImage = { id: imageId, url: imageUrl };
    //     this.$refs.fileInput.value = ""; // 파일 선택을 초기화하기 위해 인풋값 비우기
    //   };

    //   reader.readAsDataURL(file);
    // },
    uploadImage() {
      // 이미지 업로드 로직을 추가하세요 (서버와 통신 등)
      // 여기서는 이미지를 로컬에 저장하는 예제이므로 추가적인 로직이 필요하지 않습니다.
    },
  },
};
</script>

<style scoped></style>