<template>
  <div class="container-fluid container-admin" style="padding-left: 360px;">
    <h2>Cenniki</h2>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Nazwa</th>
        <th scope="col">Aktywna od</th>
        <th scope="col">Aktywna do</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="priceList in priceLists" :key="priceList.id">
        <th>{{ priceList.id }}</th>
        <td>{{ priceList.name }}</td>
        <td>{{ getHumanDate(priceList.validFrom) }}</td>
        <td>{{ getHumanDate(priceList.validTo) }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
import moment from 'moment'

export default {
  name: 'PriceLists',
  data() {
    return {
      priceLists: []
    }
  },
  methods: {
    getPriceLists() {
      let self = this
      axios.get('http://localhost:8081/api/priceList/priceLists')
          .then((res) => {
            self.priceLists = res.data
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
    this.getPriceLists()
  }
}
</script>