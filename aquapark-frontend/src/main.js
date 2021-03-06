import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap'

import VueToastr from 'vue-toastr'
import axios from 'axios'
import VueSidebarMenu from 'vue-sidebar-menu'
import 'vue-sidebar-menu/dist/vue-sidebar-menu.css'

Vue.config.productionTip = false

Vue.use(VueToastr, {
    defaultPosition: "toast-bottom-center",
    defaultStyle: {"color": "white"}
});

Vue.use(VueSidebarMenu)

/**
 * Headers for all requests sent from app
 */
axios.interceptors.request.use((config) => {
    config.headers.Authorization = 'Bearer ' + localStorage.getItem('token');
    return config;
}, (error) => {
    return Promise.reject(error);
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')