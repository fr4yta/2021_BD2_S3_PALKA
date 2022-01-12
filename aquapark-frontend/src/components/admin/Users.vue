<template>
  <div class="container-fluid container-admin" style="padding-left: 360px;">
    <h2>Użytkownicy</h2>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Nazwa użytkownika</th>
        <th scope="col">E-mail</th>
        <th scope="col">Aktywny</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user in users" :key="user.id">
        <th>{{ user.id }}</th>
        <td>{{ user.username }}</td>
        <td>{{ user.email }}</td>
        <td>{{ user.enabled === true ? 'TAK' : 'NIE' }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Users',
  data() {
    return {
      users: []
    }
  },
  methods: {
    getUsers() {
      let self = this
      axios.get('http://localhost:8081/api/users')
          .then((res) => {
            self.users = res.data
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
  },
  mounted() {
    this.getUsers()
  }
}
</script>