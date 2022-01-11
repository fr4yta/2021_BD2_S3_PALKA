<template>
  <div class="notLoggedIn">
    <div class="logo">
      <img src="../assets/login_logo.svg" alt="Logo" class="img-fluid loginLogo">
    </div>
    <div class="login" style="display: block">
      <input type="text" placeholder="LOGIN" v-model="username" @keypress.enter="submitLogin">
      <input type="password" placeholder="HASŁO" v-model="password" @keypress.enter="submitLogin">
      <a class="btn btn-success btn-login" @click="submitLogin">ZALOGUJ SIĘ</a>
      <p class="register">Nie masz konta?
        <router-link to="register">Zarejestruj się</router-link>!
      </p>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Login',
  data: function () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    submitLogin() {
      let self = this
      axios.post('http://localhost:8081/api/auth/login', {
        username: this.username,
        password: this.password,
      })
          .then((res) => {
            localStorage.setItem('token', res.data)
            self.$router.push('/')
          })
          .catch((err) => {
            if (err.response.status === 400) {
              self.$toastr.e("Niepoprawnie wypełnione lub puste pola.")
            } else if (err.response.status === 401) {
              self.$toastr.e("Błąd autoryzacji.")
            } else {
              self.$toastr.e("Wystąpił błąd wewnętrzny.")
            }
          })
    }
  }
}
</script>