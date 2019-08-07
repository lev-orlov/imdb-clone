<template>
    <v-flex>
        <v-card class="my-2">
            <v-card-title>
                <div>
                    <div class="headline">
                        {{movie.title}} ({{movie.startYear}})
                    </div>
                    <small text="muted">{{movie.genres.toString()}}</small>
                    <v-btn :href="`https://www.com.group.imdb.com/title/`+`${movie.id}`"
                           class="black--text"
                           color="amber"
                           round
                           small
                           target="_blank"
                    >
                        IMDB
                    </v-btn>
                    <b>{{movie.rating}}</b>
                    <v-icon color="amber"
                            v-if="movie.rating">star
                    </v-icon>
                    <div v-if="movie.stars">Stars: {{movie.stars}}</div>
                </div>
                <v-layout
                        align-start
                        justify-end
                        v-if="isAuthenticated">
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
                </v-layout>
            </v-card-title>
        </v-card>
    </v-flex>
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
                return this.movie.watched
            }
        }
    }
</script>

<style scoped>

</style>