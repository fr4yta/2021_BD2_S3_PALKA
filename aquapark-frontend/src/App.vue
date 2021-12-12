<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style lang="scss">
$background: #F2F7FF;
$black: #000;
$hover: #75E3EA;
$btn-background: #75E3EA;
$title: rgba(51, 51, 51, 0.33);
$white: #FFF;
@import '~bootstrap/dist/css/bootstrap.css';
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap');
* {
  scroll-behavior: smooth;
}

html, body {
  background-color: $background;
  font-family: 'Inter', sans-serif;
}

div.container-fluid {
  background: url('assets/upper_background.svg') no-repeat;
  background-size: cover;
  background-position: top;
}

a {
  text-decoration: none;
  color: $black;
}

.btn:focus {
  box-shadow: none !important;
  background-color: $btn-background;
}

.btn:hover {
  background-color: $hover;
}

a:hover {
  color: $hover;
}

ul.menu {
  list-style-type: none;
  margin: 0 !important;
}

li.menu-item {
  margin: 0 15px;
}

.navbar {
  justify-content: flex-start;
}

h1.greetings {
  padding-top: 70px;
  font-size: 2.5vw;
  font-weight: bold;
  color: $black;
}

.btn-priceList {
  padding: 12px 24px;
  margin-top: 20px;
  background: $btn-background;
  border: none;
}

.title {
  font-size: 4vw;
  text-align: center;
  color: $title;
  font-weight: bold;
  margin-top: 200px;
}

.attractions-row {
  margin-top: 70px;
  text-align: center;
}

.attraction {
  background: $white;
  padding: 50px;
  border-radius: 12px;
  -webkit-box-shadow: 8px 8px 46px -40px $black;
  -moz-box-shadow: 8px 8px 46px -40px $black;
  box-shadow: 8px 8px 46px -40px $black;
}

.col-sm-4 {
  @media (min-width: 576px) {
    flex: 0 0 auto;
    width: 30%;
    margin: 0 auto;
  }
}

.attraction-title {
  font-size: 2.5vw;
  color: $btn-background;
  font-weight: bold;
}

.priceList .priceBox {
  padding: 56px;
  border-radius: 12px;
  -webkit-box-shadow: 8px 8px 46px -40px $black;
  -moz-box-shadow: 8px 8px 46px -40px $black;
  box-shadow: 8px 8px 46px -40px $black;

  p.price {
    font-size: 2vw;
    font-weight: bold;
  }
}

.btn-buyTicket {
  padding: 12px 24px;
  margin-top: 20px;
  background: $btn-background !important;
  border: none;
}

.modal-body {
  .btn-buyTicket {
    width: 100%;
    margin: 0 auto;
  }
}

/* Tickets quantity */
$border: 2px solid #ddd;
.quantity-toggle {
  display: flex;
  justify-content: center;

  input {
    border: 0;
    border-top: $border;
    border-bottom: $border;
    width: 2.5rem;
    text-align: center;
    padding: 0 .5rem;
  }

  button {
    border: $border;
    padding: .5rem;
    background: #f5f5f5;
    color: #888;
    font-size: 1rem;
    cursor: pointer;
  }
}

.finalPrice {
  padding: 10px;
  font-size: 3vw;
  font-weight: bold;
  text-align: center;
}

.notLoggedIn {
  background: url('assets/login_bg.svg') no-repeat;
  background-size: cover;
  height: 100vh !important;

  .loginLogo {
    padding: 170px 0 0 0;
    margin: 0 auto;
    display: block;
  }

  input {
    display: block;
    margin: 10px auto;
    border: 1px solid $white;
    box-sizing: border-box;
    border-radius: 4px;
    text-align: center;
    background: none;
    padding: 10px 20px;
    width: 30%;
    color: $white;
  }

  .btn-login {
    padding: 12px 24px;
    margin-top: 32px !important;
    background: $btn-background !important;
    border: none;
    width: 30%;
    margin: 0 auto;
    display: block;
  }

  .register {
    color: $white;
    text-align: center;
    padding: 10px 0;

    a {
      color: $btn-background;
    }
  }
}
</style>