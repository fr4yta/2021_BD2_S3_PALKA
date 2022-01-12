import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import Admin from '../components/Admin'
import Users from "../components/admin/Users";
import PriceLists from "../components/admin/PriceLists";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/admin',
        name: 'Admin',
        component: Admin,
        meta: {
            showMenu: true
        }
    },
    {
        path: '/admin/users',
        name: 'Users',
        component: Users,
        meta: {
            showMenu: true
        }
    },
    {
        path: '/admin/price_lists/show',
        name: 'PriceLists',
        component: PriceLists,
        meta: {
            showMenu: true
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router