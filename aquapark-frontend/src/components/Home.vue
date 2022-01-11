<template>
  <div class="container-fluid">
    <div class="container">
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
          <router-link to="login">
            <li class="menu-item d-inline-block text-uppercase">
              logowanie
            </li>
          </router-link>
        </ul>
      </nav>
      <div class="welcome row">
        <div class="col-sm-6">
          <h1 class="greetings">Witaj w centrum rodzinnej rozrywki w Gliwicach!</h1>
          <a href="#priceList" class="btn btn-primary btn-priceList">Zobacz cennik</a>
        </div>
        <div class="col-sm-6" style="text-align: center;">
          <img src="../assets/shark.svg" alt="Shark" class="img-fluid">
        </div>
      </div>
      <div class="attractions" id="attractions">
        <h2 class="title">Atrakcje</h2>
        <div class="row attractions-row">
          <div class="col-sm-4 attraction" data-bs-toggle="modal" data-bs-target="#attractionModal">
            <p class="attraction-title">Pirate Bay</p>
            <p class="attraction-desc">Basen dla najmłodszych wyposażony w siedem bezpiecznych zjeżdżalni.</p>
          </div>
          <div class="col-sm-4 attraction" data-bs-toggle="modal" data-bs-target="#attractionModal">
            <p class="attraction-title">Shark Slide</p>
            <p class="attraction-desc">Ze zjeżdżalni do akwarium, prosto do paszczy rekina!</p>
          </div>
          <div class="col-sm-4 attraction" data-bs-toggle="modal" data-bs-target="#attractionModal">
            <p class="attraction-title">Volcano</p>
            <p class="attraction-desc">Jacuzzi dla 32 osób jednocześnie tryskające wodą w kolorze lawy.</p>
          </div>
        </div>
      </div>
      <div class="priceList" id="priceList">
        <h2 class="title">Cennik</h2>
        <div class="priceBox">
          <div class="row">
            <div class="col-sm-6">
              <h2>Ulgowy (rodzinny)</h2>
              <p>Cena za osobę, ulgowy dla dzieci poniżej lat 13</p>
            </div>
            <div class="col-sm-6" style="text-align: right;">
              <p class="price">25 zł / h</p>
              <a data-bs-toggle="modal" data-bs-target="#priceModal" class="btn btn-success btn-buyTicket"
                 @click="reduced = 1">Kup bilet</a>
            </div>
          </div>
        </div>
        <div class="priceBox">
          <div class="row">
            <div class="col-sm-6">
              <h2>Normalny</h2>
            </div>
            <div class="col-sm-6" style="text-align: right;">
              <p class="price">30 zł / h</p>
              <a data-bs-toggle="modal" data-bs-target="#priceModal" class="btn btn-success btn-buyTicket"
                 @click="reduced = 0">Kup bilet</a>
            </div>
          </div>
        </div>
      </div>

      <!-- Attraction modal -->
      <div class="modal fade" id="attractionModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Informacja</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Zamknij"></button>
            </div>
            <div class="modal-body">
              Wszystkie atrakcje są wliczone w cenę biletu.
            </div>
          </div>
        </div>
      </div>

      <!-- Price modal -->
      <div class="modal fade" id="priceModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Kup bilet</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Zamknij"></button>
            </div>
            <div class="modal-body">
              <div class="quantity-toggle">
                <button @click="decrement()">&mdash;</button>
                <input type="text" :value="quantity" readonly>
                <button @click="increment()">&#xff0b;</button>
              </div>
              <p class="finalPrice" v-if="reduced">{{ price1 * quantity }} zł</p>
              <p class="finalPrice" v-if="!reduced">{{ price2 * quantity }} zł</p>
              <a href="kup" class="btn btn-success btn-buyTicket">Kup bilet</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      reduced: false,
      quantity: 1,
      price1: 25,
      price2: 30,
      loggedIn: false
    }
  },
  methods: {
    increment() {
      this.quantity++
    },
    decrement() {
      if (this.quantity === 1) {
        alert('Wartość mniejsza niż 1 nie jest możliwa do kupienia.')
      } else {
        this.quantity--
      }
    },
    isLoggedIn() {
      if (localStorage.getItem('token'))
        this.loggedIn = true
    }
  }
}
</script>