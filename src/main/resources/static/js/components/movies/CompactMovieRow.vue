<template>
    <v-container>
        <v-flex>
            <v-list-tile>
                <v-list-tile-content>
                    {{movie.title}} ({{movie.startYear}})
                </v-list-tile-content>
                <v-list-tile-avatar>
                    {{movie.rating}}
                </v-list-tile-avatar>
                <v-list-tile-action v-if="isAuthenticated">
                    <v-btn @click="markUnmarkAsWatched"
                           color="grey"
                           flat icon v-if="isInWatchlist && !isWatched">
                        <v-icon>done</v-icon>
                    </v-btn>
                    <v-btn @click="markUnmarkAsWatched"
                           color="green"
                           flat icon v-else-if="isInWatchlist && isWatched">
                        <v-icon>done</v-icon>
                    </v-btn>
                    <v-btn @click="removeFromWatchlist"
                           color="green"
                           flat icon v-if="isInWatchlist">
                        <v-icon>bookmark</v-icon>
                    </v-btn>
                    <v-btn @click="addToWatchlist"
                           color="grey"
                           flat icon v-else>
                        <v-icon>bookmark</v-icon>
                    </v-btn>
                </v-list-tile-action>
            </v-list-tile>
        </v-flex>
    </v-container>
</template>

<script>
    export default {
        props: ['movie'],
        methods: {
            addToWatchlist() {
                let title = {id: this.movie.id};
                this.$http.post('/user/watchlist', title)
                    .then(res => this.$store.dispatch('addToWatchlist', res.data))
            },
            removeFromWatchlist() {
                let title = {id: this.movie.id};
                this.$http.delete('/user/watchlist', {data: title})
                    .then(() => this.$store.dispatch('removeFromWatchlist', title))
            },
            markUnmarkAsWatched() {
                let title = {id: this.movie.id};
                this.$http.put('/user/watchlist', title)
                    .then(() => this.movie.watched = !this.movie.watched)
            }
        },
        computed: {
            isAuthenticated() {
                return this.$store.getters.isAuthenticated
            },
            user() {
                return this.$store.getters.user
            },
            watchlist() {
                if (this.isAuthenticated) {
                    return this.user.watchlist
                } else return []
            },
            isInWatchlist() {
                return _.some(this.watchlist, {'id': this.movie.id})
            },
            isWatched() {
                return _.some(this.watchlist, {'id': this.movie.id, 'watched': true})
            }
        }
    }
</script>

<style scoped>

</style>