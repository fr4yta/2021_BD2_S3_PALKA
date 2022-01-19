<template>
  <div class="container-fluid">
    <div class="container">
      <Navbar></Navbar>
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
        <div class="priceBox" v-for="priceItem in priceItems" :key="priceItem.id">
          <div class="row">
            <div class="col-sm-6">
              <h2>{{ priceItem.ticket.ticketType.type === 'normal' ? 'Normalny' : 'Ulgowy' }}</h2>
            </div>
            <div class="col-sm-6" style="text-align: right;">
              <p class="price">{{ priceItem.price }} zł / h</p>
              <a @click="buyTicket(priceItem.id)"
                 class="btn btn-success btn-buyTicket">Kup bilet</a>
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
    </div>
  </div>
</template>

<script>
import Navbar from './Navbar'
import axios from 'axios'

export default {
  name: 'Home',
  components: {Navbar},
  data() {
    return {
      priceItems: [],
      price: null
    }
  },
  methods: {
    buyTicket(id) {
      let self = this
      let date = Math.floor(Date.now() / 1000) + 2592000
      axios.post('http://localhost:8081/api/purchase', {
        priceItemId: id,
        entryDate: date // 30d
      })
          .then(() => {
            self.$toastr.s("Bilet zakupiony. Znajdziesz go w swoim panelu klienta.")
            self.$router.push('user/tickets')
          }).catch(() => {
        self.$toastr.e("Wystąpił błąd przy zakupie biletu. Skontaktuj się z kierownictwem aquaparku.")
      })
    },
    getPriceItems() {
      let self = this
      axios.get('http://localhost:8081/api/priceList/actualPriceItems')
          .then((res) => {
            self.priceItems = res.data
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
    },
  },
  mounted() {
    this.getPriceItems()
  }
}
</script>