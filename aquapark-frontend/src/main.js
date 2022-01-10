import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap'

import VueToastr from 'vue-toastr'
import axios from 'axios'

Vue.config.productionTip = false

Vue.use(VueToastr, {
    defaultPosition: "toast-bottom-center",
    defaultStyle: {"color": "white"}
});

/**
 * Headers for all requests sent from app
 */
axios.interceptors.request.use((config) => {
    config.headers.Authorization = 'Bearer ' + localStorage.getItem('jwt-token');
    return config;
}, (error) => {
    return Promise.reject(error);
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')