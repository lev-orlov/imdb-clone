<template>
    <v-container>
        <v-flex>
            <div v-if="watchlist.length > 0">
                <v-btn-toggle v-model="compactView">
                    <v-spacer></v-spacer>
                    <v-btn flat>
                        <v-icon>view_list</v-icon>
                        Detailed
                    </v-btn>
                    <v-btn flat>
                        <v-icon>view_headline</v-icon>
                        Compact
                    </v-btn>
                </v-btn-toggle>
                <v-list v-if="compactView === 0">
                    <movie-row :key="movie.id" :movie="movie" v-for="movie in watchlist"/>
                </v-list>
                <v-list v-else-if="compactView === 1">
                    <compact-movie-row :key="movie.id" :movie="movie" v-for="movie in watchlist"/>
                </v-list>
            </div>
        </v-flex>
    </v-container>
</template>

<script>
    import MovieRow from "../movies/DetailedMovieRow"
    import CompactMovieRow from "../movies/CompactMovieRow"

    export default {
        components: {
            MovieRow,
            CompactMovieRow
        },
        data() {
            return {
                compactView: 0,
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
        }
    }
</script>

<style scoped>

</style>