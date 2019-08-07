import Vue from 'vue'
import Router from 'vue-router'
import Home from 'components/Home'
import AuthGuard from './auth-guard'
import Signup from 'components/user/Signup'
import Signin from 'components/user/Signin'
import Search from 'components/movies/Search'
import Bookmarks from 'components/user/Bookmarks'
import SearchResult from 'components/movies/SearchResult'
import PasswordReset from 'components/user/PasswordReset'
import ForgotPassword from 'components/user/ForgotPassword'
import CollaborationForm from 'components/movies/CollaborationForm'
import AdvancedSearchForm from 'components/movies/AdvancedSearchForm'

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/signin',
            name: 'SignIn',
            component: Signin
        },
        {
            path: '/signup',
            name: 'SignUp',
            component: Signup
        },
        {
            path: '/bookmarks',
            name: 'Bookmarks',
            component: Bookmarks,
            beforeEnter: AuthGuard
        },
        {
            path: '/collaborations',
            name: 'Collaborations',
            component: CollaborationForm,
        },
        {
            path: '/searchresults',
            name: 'Searchresults',
            component: SearchResult,
        },
        {
            path: '/search',
            name: 'Search',
            component: Search,
        },
        {
            path: '/advanced',
            name: 'AdvancedSearchForm',
            component: AdvancedSearchForm,
        },
        {
            path: '/passwordreset',
            name: 'Passwordreset',
            component: PasswordReset,
        },
        {
            path: '/forgotpassword',
            name: 'ForgotPassword',
            component: ForgotPassword,
        },
        {
            path: '*',
            component: Home
        }

    ]
})

