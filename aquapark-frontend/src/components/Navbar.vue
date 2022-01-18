<template>
  <nav class="navbar">
    <img src="../assets/logo.svg" alt="Logo" class="img-fluid d-inline-block">
    <ul class="menu">
      <a href="#attractions">
        <li class="menu-item d-inline-block text-uppercase">
          atrakcje
        </li>
      </a>
      <a href="#priceList">
        <li class="menu-item d-inline-block text-uppercase">
          cennik
        </li>
      </a>
      <router-link to="help">
        <li class="menu-item d-inline-block text-uppercase">
          pomoc
        </li>
      </router-link>
      <router-link to="login" v-if="!loggedIn">
        <li class="menu-item d-inline-block text-uppercase">
          logowanie
        </li>
      </router-link>
      <li class="menu-item d-inline-block text-uppercase" @click="logout" style="cursor: pointer;" v-else>
        wyloguj się
      </li>
      <router-link to="user" v-if="loggedIn">
        <li class="btn btn-success btn-buyTicket" style="margin: 0; padding: 0 20px;">
          Panel klienta
        </li>
      </router-link>
      <router-link to="admin" v-if="loggedIn && admin">
        <li class="btn btn-success btn-buyTicket" style="margin: 0 20px; padding: 0 20px;">
          Panel administracyjny
        </li>
      </router-link>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'Navbar',
  data() {
    return {
      loggedIn: false,
      admin: false
    }
  },
  methods: {
    isLoggedIn() {
      if (localStorage.getItem('token')) {
        this.loggedIn = true
        if (localStorage.getItem('userRole') === 'admin')
          this.admin = true
      }
    },
    logout() {
      localStorage.clear()
      this.$router.go()
    }
  },
  mounted() {
    this.isLoggedIn();
  }
}
</script>