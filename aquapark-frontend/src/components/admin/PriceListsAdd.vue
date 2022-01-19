<template>
  <div class="container-fluid container-admin" style="padding-left: 360px;">
    <h2>Dodaj nową pozycję do cennika</h2>
    <br>
    <label>Cena:</label>
    <br>
    <input type="number" placeholder="Cena" v-model="newPriceItem.price" required>
    <br>
    <br>
    <label>Typ biletu:</label>
    <br>
    <select v-model="newPriceItem.ticketId">
      <option value="1" selected>Normalny</option>
      <option value="2">Ulgowy</option>
    </select>
    <br><br>
    <a class="btn btn-success" type="submit" @click="addNewPriceItem">Dodaj</a>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Cena</th>
        <th scope="col">Typ biletu</th>
        <th scope="col">Akcje</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="priceItem in priceItems" :key="priceItem.id">
        <th>{{ priceItem.id }}</th>
        <td>{{ priceItem.price }} zł</td>
        <td>{{ priceItem.ticket.ticketType.type === 'normal' ? 'Normalny' : 'Ulgowy' }}</td>
        <td><a class="del" @click="deleteItem(priceItem.id)">Usuń</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

function newPriceItem() {
  return {
    price: null,
    priceListId: 2,
    priceItemTypeId: 1,
    ticketId: 1 // 1 - normalny, 2 - ulgowy
  }
}

export default {
  name: 'PriceListsAdd',
  data() {
    return {
      newPriceItem: newPriceItem(),
      priceItems: []
    }
  },
  methods: {
    deleteItem(id) {
      let self = this
      axios.post('http://localhost:8081/api/priceList/priceItem/' + id + '/delete')
          .then(() => {
            self.$toastr.s("Pomyślnie usunięto pozycję z cennika.")
            this.$router.go()
          }).catch(() => {
        self.$toastr.e("Błąd przy usuwaniu. Skontaktuj się z programistą.")
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
    addNewPriceItem() {
      if (this.newPriceItem.price < 1) {
        this.$toastr.e("Niepoprawnie wypełnione lub puste pola.")
        return
      }

      let self = this
      axios.post('http://localhost:8081/api/priceList/addItems', [this.newPriceItem])
          .then(() => {
            self.$toastr.s("Pomyślnie dodano nową pozycję do cennika.")
            this.getPriceItems()
            this.$router.go()
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
    this.getPriceItems()
  }
}
</script>

<style scoped>
.del:hover {
  cursor: pointer;
}
</style>