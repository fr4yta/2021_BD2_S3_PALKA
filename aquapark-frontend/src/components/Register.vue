<template>
  <div class="notLoggedIn">
    <div class="logo">
      <img src="../assets/login_logo.svg" alt="Logo" class="img-fluid loginLogo">
    </div>
    <div class="login" style="display: block;">
      <input type="text" placeholder="E-MAIL">
      <input type="password" placeholder="HASŁO">
      <input type="password" placeholder="POTWIERDŹ HASŁO">
      <a href="#" class="btn btn-success btn-login">ZAREJESTRUJ SIĘ</a>
      <p class="register">Masz konto? <router-link to="login">Zaloguj się</router-link>!</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register"
}
</script>