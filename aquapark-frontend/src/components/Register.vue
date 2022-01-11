<template>
  <div class="notLoggedIn">
    <div class="logo">
      <img src="../assets/login_logo.svg" alt="Logo" class="img-fluid loginLogo">
    </div>
    <div class="login" style="display: block;">
      <input type="text" v-model="username" placeholder="NAZWA UŻYTKOWNIKA" @keypress.enter="submitRegister">
      <input type="email" v-model="email" placeholder="E-MAIL" @keypress.enter="submitRegister">
      <input type="password" v-model="password" placeholder="HASŁO" @keypress.enter="submitRegister">
      <input type="password" v-model="repeatedPassword" placeholder="POTWIERDŹ HASŁO" @keypress.enter="submitRegister">
      <a class="btn btn-success btn-login" @click="submitRegister">ZAREJESTRUJ SIĘ</a>
      <p class="register">Masz konto?
        <router-link to="login">Zaloguj się</router-link>!
      </p>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Register',
  data: function () {
    return {
      username: '',
      email: '',
      password: '',
      repeatedPassword: ''
    }
  },
  methods: {
    submitRegister() {
      let self = this
      axios.post('http://localhost:8081/api/auth/register', {
        username: this.username,
        email: this.email,
        password: this.password,
        repeatedPassword: this.repeatedPassword
      })
          .then(() => {
            self.$toastr.s("Utworzono konto. Możesz się zalogować.")
            self.$router.push('login')
          })
          .catch((err) => {
            if (err.response.status === 400) {
              if (err.response.data.message)
                self.$toastr.e(err.response.data.message)
              else
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