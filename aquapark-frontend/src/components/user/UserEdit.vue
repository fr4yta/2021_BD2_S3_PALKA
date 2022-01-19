<template>
  <div class="container-fluid container-admin" style="padding-left: 360px;">
    <h2>Zmiana hasła klienta</h2>
    <br>
    <input type="password" v-model="password.oldPassword" placeholder="Stare hasło">
    <br>
    <input type="password" v-model="password.newPassword" placeholder="Nowe hasło">
    <br>
    <input type="password" v-model="password.repeatedNewPassword" placeholder="Powtórz nowe hasło">
    <br><br>
    <a @click="changePassword" class="btn btn-success">Zmień hasło</a>
  </div>
</template>

<script>
import axios from "axios"

function changePass() {
  return {
    oldPassword: '',
    newPassword: '',
    repeatedNewPassword: ''
  }
}

export default {
  name: 'UserEdit',
  data() {
    return {
      password: changePass()
    }
  },
  methods: {
    changePassword() {
      let self = this
      axios.post('http://localhost:8081/api/users/edit', this.password)
          .then(() => {
            self.$toastr.s("Hasło zmienione.")
          })
          .catch((err) => {
            console.log(err)
            /*if (err.response.status === 400) {
              self.$toastr.e("Niepoprawnie wypełnione lub puste pola.")
            } else if (err.response.status === 401) {
              self.$toastr.e("Błąd autoryzacji.")
            } else {
              self.$toastr.e("Wystąpił błąd wewnętrzny.")
            }*/
          })
    },
  }
}
</script>