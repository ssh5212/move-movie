<template>
    <div id="user-login-vue">
        <!-- [S] Intro Image -->
        <div class="jb-box">
            <div class="top-img">
                <img src="@/assets/img/intro-half-img01.jpg" alt="" width="1920" height="auto" />
            </div>

            <div class="jc-text">
                <p class="vtext-big">Register</p>
            </div>
        </div>
        <!-- [E] Intro Image -->
        <!-- [S] body -->
        <div class="container">
            <div class="row justify-content-xl-center my-5 align-items-center">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <div class="text-center mb-4">
                        <img class="mb-4" src="@/assets/logo.png" alt="" width="72" height="auto" />
                        <h1 class="mb-3 font-weight-normal">Hello Morld!</h1>
                        <p>필름의 한 장 속으로 뛰어들 준비는 되셨나요?</p>
                    </div>
                    <hr class="mb-4" />

                    <!-- <h1 class="mb-3">Billing address</h1> -->
                    <form class="needs-validation" novalidate>
                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted"></span></label>
                            <input type="email" class="form-control" id="email" placeholder="you@example.com" />
                            <div class="invalid-feedback">Please enter a valid email address for shipping updates.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password">Password</label>
                            <input type="text" class="form-control" id="password" placeholder="" required />
                            <div class="invalid-feedback">Please enter your shipping address.</div>
                        </div>

                        <div class="mb-3">
                            <label for="password-check">Password Check</label>
                            <input type="text" class="form-control" id="password-check" placeholder="" required />
                        </div>
                        <div class="mb-3">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="" required />
                            <div class="invalid-feedback">Please enter your shipping address.</div>
                        </div>

                        <div class="mb-3">
                            <label for="nickname">NickName</label>
                            <input type="text" class="form-control" id="nickname" placeholder="" required />
                        </div>

                        <hr class="mb-4" />
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
                    </form>
                </div>

                <div class="col-md-1"></div>
            </div>
        </div>
        <!-- [E] body -->
    </div>
</template>

<script>
export default {};
</script>

<style></style>
