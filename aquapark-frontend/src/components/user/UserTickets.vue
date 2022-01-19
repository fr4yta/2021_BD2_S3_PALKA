<template>
  <div class="container-fluid container-admin" style="padding-left: 360px;">
    <h2>Moje bilety</h2>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Kupiony</th>
        <th scope="col">Cena</th>
        <th scope="col">Typ</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="ticket in tickets" :key="ticket.id">
        <th>{{ ticket.id }}</th>
        <td>{{ getHumanDate(ticket.purchaseDate) }}</td>
        <td>{{ ticket.priceItem.price }} zł</td>
        <td>{{ ticket.priceItem.ticket.ticketType.type === 'normal' ? 'Normalny' : 'Ulgowy' }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
import moment from 'moment'

export default {
  name: 'UserTickets',
  data() {
    return {
      tickets: []
    }
  },
  methods: {
    getTickets() {
      let self = this
      axios.get('http://localhost:8081/api/purchase/getAll')
          .then((res) => {
            self.tickets = res.data
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
    getHumanDate(timestamp) {
      return moment(timestamp).format('DD/MM/YYYY');
    }
  },
  mounted() {
    this.getTickets()
  }
}
</script>