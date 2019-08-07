<template>
    <v-container>
        <v-flex>
            <div v-if="movies.length > 0">
                <div class="text-xs-center" v-if="query">
                    <v-pagination
                            :length="numOfPages"
                            @input="changePage"
                            v-model="page"
                    ></v-pagination>
                </div>
                <v-btn-toggle v-model="compactView">
                    <v-spacer></v-spacer>
                    <v-btn flat>
                        <v-icon>view_agenda</v-icon>
                        Detailed
                    </v-btn>
                    <v-btn flat>
                        <v-icon>view_headline</v-icon>
                        Compact
                    </v-btn>
                </v-btn-toggle>
                <v-list v-if="compactView === 0">
                    <movie-row :key="movie.id" :movie="movie" v-for="movie in movies"/>
                </v-list>
                <v-list v-else-if="compactView === 1">
                    <compact-movie-row :key="movie.id" :movie="movie" v-for="movie in movies"/>
                </v-list>
            </div>
            <div class="text-xs-center" v-if="query">
                <v-pagination
                        :length="numOfPages"
                        @input="changePage"
                        v-model="page"
                ></v-pagination>
            </div>
        </v-flex>
    </v-container>
</template>

<script>
    import MovieRow from "./DetailedMovieRow";
    import CompactMovieRow from "./CompactMovieRow";

    export default {
        components: {
            MovieRow,
            CompactMovieRow
        },
        data() {
            return {
                compactView: 0,
                page: 1,
            }
        },
        computed: {
            movies() {
                return this.$store.getters.searchResult
            },
            query() {
                return this.$store.getters.query
            },
            numOfPages() {
                return this.$store.getters.numOfPages
            }
        },
        methods: {
            changePage(page) {
                this.query.page = page - 1;
                this.$store.dispatch('Search', this.query)
            }
        }
    }
</script>

<style scoped>

</style>