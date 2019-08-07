import Vue from 'vue'
import App from 'App.vue'
import Vuetify from 'vuetify'
import Axios from 'axios'
import lodash from 'lodash'
import router from './routes'
import {store} from './store'
import 'vuetify/dist/vuetify.min.css'
import AlertCmp from './components/Alert'

Vue.use(Vuetify);
Vue.use(lodash);
Vue.component('app-alert', AlertCmp);
Vue.prototype.$http = Axios;

const CSRF_TOKEN = document.cookie.match(new RegExp(`XSRF-TOKEN=([^;]+)`))[1];
Axios.create({
    headers: {
        common: {
            'X-CSRF-TOKEN': CSRF_TOKEN,
        },
    },
});

new Vue({
    el: '#app',
    router,
    store,
    render: a => a(App),
    created() {
        this.$http.get('/user')
            .then(res => {
                this.$store.dispatch('setUser', res.data)
            })
    }
});