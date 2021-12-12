<template>
  <div class="container-fluid">
    <div class="container">
      <nav class="navbar">
        <img src="../assets/logo.svg" alt="Logo" class="img-fluid d-inline-block">
        <ul class="menu">
          <a href="#">
            <li class="menu-item d-inline-block text-uppercase">
              atrakcje
            </li>
          </a>
          <a href="#">
            <li class="menu-item d-inline-block text-uppercase">
              cennik
            </li>
          </a>
          <a href="#">
            <li class="menu-item d-inline-block text-uppercase">
              logowanie
            </li>
          </a>
        </ul>
      </nav>
      <div class="welcome row">
        <div class="col-sm-6">
          <h1 class="greetings">Witaj w centrum rodzinnej rozrywki w Gliwicach!</h1>
          <a href="#" class="btn btn-primary btn-priceList">Zobacz cennik</a>
        </div>
        <div class="col-sm-6" style="text-align: center;">
          <img src="../assets/shark.svg" alt="Shark" class="img-fluid">
        </div>
      </div>
      <div class="attractions">
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
      <div class="priceList">
        <h2 class="title">Cennik</h2>
        <div class="priceBox">
          <div class="row">
            <div class="col-sm-6">
              <h2>Ulgowy (rodzinny)</h2>
              <p>Cena za osobę, ulgowy dla dzieci poniżej lat 13</p>
            </div>
            <div class="col-sm-6" style="text-align: right;">
              <p class="price">25 zł / h</p>
              <a data-bs-toggle="modal" data-bs-target="#priceModal" class="btn btn-success btn-buyTicket">Kup bilet</a>
            </div>
          </div>
        </div>
        <div class="priceBox">asd</div>
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
              <h5 class="modal-title">Informacja</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Zamknij"></button>
            </div>
            <div class="modal-body">
              Wszystkie atrakcje są wliczone w cenę biletu.
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home"
}
</script>

<style lang="scss" scoped>

</style>