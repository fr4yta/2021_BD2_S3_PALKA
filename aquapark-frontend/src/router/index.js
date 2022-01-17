import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import Admin from '../components/Admin'
import Users from "../components/admin/Users";
import PriceListsShow from "../components/admin/PriceListsShow";
import User from "../components/User";
import UserTickets from "../components/user/UserTickets";
import UserEdit from "../components/user/UserEdit";
import PriceListsAdd from "../components/admin/PriceListsAdd";

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
            showAdminMenu: true
        }
    },
    {
        path: '/admin/users',
        name: 'Users',
        component: Users,
        meta: {
            showAdminMenu: true
        }
    },
    {
        path: '/admin/price_lists/show',
        name: 'PriceListsShow',
        component: PriceListsShow,
        meta: {
            showAdminMenu: true
        }
    },
    {
        path: '/admin/price_lists/add',
        name: 'PriceListsAdd',
        component: PriceListsAdd,
        meta: {
            showAdminMenu: true
        }
    },
    {
        path: '/user',
        name: 'User',
        component: User,
        meta: {
            showUserMenu: true
        }
    },
    {
        path: '/user/edit',
        name: 'UserEdit',
        component: UserEdit,
        meta: {
            showUserMenu: true
        }
    },
    {
        path: '/user/tickets',
        name: 'UserTickets',
        component: UserTickets,
        meta: {
            showUserMenu: true
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router