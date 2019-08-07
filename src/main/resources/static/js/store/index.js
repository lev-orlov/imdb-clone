import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";


Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        searchResult: [],
        query: null,
        user: null,
        error: null,
        requestUrl: null,
        numOfPages: 1,
        totalElements: 0,
        authorities: []
    },
    mutations: {
        fillResult(state, payload) {
            state.searchResult = payload
        },
        setQuery(state, payload) {
            state.query = payload
        },
        setUser(state, payload) {
            state.user = payload
        },
        setError(state, payload) {
            state.error = payload
        },
        clearError(state) {
            state.error = null
        },
        setRequestUrl(state, payload) {
            state.requestUrl = payload
        },
        incrementNumOfPages(state) {
            state.numOfPages++
        },
        resetNumOfPages(state) {
            state.numOfPages = 1
        },
        setTotalElements(state, payload) {
            state.totalElements = payload
        },
        addToWatchlist(state, payload) {
            state.user.watchlist.push(payload)
        },
        removeFromWatchlist(state, payload) {
            for (let i = 0; i < state.user.watchlist.length; i++) {
                if (_.isEqual(state.user.watchlist[i].id, payload.id)) {
                    state.user.watchlist.splice(i, 1);
                }
            }
        },

    },
    actions: {
        Search({commit, state}, payload) {
            axios.get(state.requestUrl, {params: payload})
                .then(res => {
                    let totElem = res.data.totalElements;
                    let numOfElem = res.data.numberOfElements;
                    let size = res.data.size;
                    commit('fillResult', res.data.content);
                    if (state.totalElements < totElem && numOfElem === size) {
                        commit('incrementNumOfPages');
                        commit('setTotalElements', res.data.totalElements);
                    }
                })
        },
        fillResult({commit}, payload) {
            commit('fillResult', payload)
        },
        setQuery({commit}, payload) {
            commit('setQuery', payload)
        },
        setRequestUrl({commit}, payload) {
            commit('setRequestUrl', payload)
        },
        setUser({commit}, payload) {
            commit('setUser', payload)
        },
        setError({commit}, payload) {
            commit('setError', payload)
        },
        clearError({commit}) {
            commit('clearError')
        },
        resetNumOfPages({commit}) {
            commit('resetNumOfPages')
        },
        resetNumOfTotalElements({commit}) {
            commit('setTotalElements', 1)
        },
        addToWatchlist({commit}, payload) {
            commit('addToWatchlist', payload)
        },
        removeFromWatchlist({commit}, payload) {
            commit('removeFromWatchlist', payload)
        },
        signUp({commit}, payload) {
            axios.post('/user/registration', payload)
                .then(res => commit('setUser', res.data))
                .catch(error => commit('setError', error.response.data))
        },
        signIn({commit}, payload) {
            axios.post('/login', {}, {params: payload})
                .then(res => commit('setUser', res.data))
                .catch(error => commit('setError', error.response.data))
        }

    },
    getters: {
        searchResult(state) {
            return state.searchResult
        },
        requestUrl(state) {
            return state.requestUrl
        },
        numOfPages(state) {
            return state.numOfPages
        },
        user(state) {
            return state.user
        },
        isAuthenticated(state) {
            return state.user !== null && state.user !== '' && state.user !== undefined
        },
        isAdmin(state) {
            return state.user !== null && state.user !== '' && state.user !== undefined && state.user.authorities.includes('ADMIN');

        },
        error(state) {
            return state.error
        },
        query(state) {
            return state.query
        }
    }
});