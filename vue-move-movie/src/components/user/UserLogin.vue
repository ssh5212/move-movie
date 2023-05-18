<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">Login</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <!-- 로그인 form -->
                    <form class="form-signin">
                        <div class="text-center mb-4">
                            <img class="mb-4" src="@/assets/logo.png" alt="" width="72" height="auto" />
                            <h1 class="mb-3 font-weight-normal">Hello Morld!</h1>
                            <p>필름의 한 장 속으로 뛰어들 준비는 되셨나요?</p>
                        </div>
                        <hr class="mb-4" />

                        <div class="form-label-group m-3">
                            <label for="inputEmail">Email address</label>
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus />
                        </div>

                        <div class="form-label-group m-3">
                            <label for="password">Password</label>
                            <input type="password" id="password" class="form-control" placeholder="Password" required />
                        </div>

                        <div class="checkbox m-3">
                            <label> <input type="checkbox" value="remember-me" /> Remember me </label>
                        </div>
                        <hr class="mb-4" />

                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {};
</script>

<style></style>
