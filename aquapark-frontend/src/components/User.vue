<template>
  <div class="container-fluid container-admin">
    <h2>Panel klienta</h2>
  </div>
</template>

<script>
export default {
  name: 'User',
  mounted() {
    if (localStorage.getItem('userRole') !== 'user' && localStorage.getItem('userRole') !== 'admin')
      this.$router.push('/')
  }
}
</script>

<style>
@import 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css';

.container-admin {
  padding-left: 360px;
  padding-top: 10px;
}
</style>