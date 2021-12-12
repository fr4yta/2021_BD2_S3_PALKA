<template>
  <div class="notLoggedIn">
    <div class="logo">
      <img src="../assets/login_logo.svg" alt="Logo" class="img-fluid loginLogo">
    </div>
    <div class="login" style="display: block;">
      <input type="text" placeholder="E-MAIL">
      <input type="password" placeholder="HASŁO">
      <a href="#" class="btn btn-success btn-login">ZALOGUJ SIĘ</a>
      <p class="register">Nie masz konta?
        <router-link to="register">Zarejestruj się</router-link>!
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login"
}
</script>