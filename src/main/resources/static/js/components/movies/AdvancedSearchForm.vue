<template>
    <v-container>
        <v-flex>
            <h2>Advanced Title Search
            </h2>
            <v-form @submit.prevent="search" ref="form">
                <v-text-field
                        clearable
                        label="Title"
                        v-model="movie.title">
                </v-text-field>
                <b>Title Type</b>
                <v-layout class="mb-3" row wrap>
                    <v-flex :key="item.value" sm3 v-for="item in titleOptions">
                        <v-checkbox
                                :label="item.text"
                                :value="item.value"
                                height="10"
                                hide-details
                                v-model="movie.titleType"
                        />
                    </v-flex>
                </v-layout>
                <b>Release Year</b>
                <v-layout row wrap>
                    <v-text-field
                            clearable
                            label="From:"
                            max="2100"
                            min="1874" placeholder="1874"
                            step="1"
                            type="number"
                            v-model="movie.releaseDateFrom"
                    ></v-text-field>
                    <v-text-field
                            clearable
                            label="To:"
                            max="2100"
                            min="1875" placeholder="2100"
                            step="1"
                            type="number"
                            v-model="movie.releaseDateTo"
                    ></v-text-field>
                </v-layout>
                <b>IMDB Rating</b>
                <v-layout row>
                    <v-flex
                            shrink
                            style="width: 45px"
                    >
                        <v-text-field
                                :max="10"
                                :min="1"
                                :step="0.1"
                                @change="setRatingFrom"
                                hide-details
                                single-line
                                type="number"
                                v-model="userRating[0]"
                        ></v-text-field>
                    </v-flex>

                    <v-flex class="mx-2">
                        <v-range-slider
                                :max="10"
                                :min="1"
                                :step="0.1"
                                @change="setBothRatings"
                                v-model="userRating"
                        ></v-range-slider>
                    </v-flex>

                    <v-flex
                            shrink
                            style="width: 45px"
                    >
                        <v-text-field
                                :max="10"
                                :min="1"
                                :step="0.1"
                                @@change="setRatingTo"
                                class="mt-0"
                                hide-details
                                single-line
                                type="number"
                                v-model="userRating[1]"
                        ></v-text-field>
                    </v-flex>
                </v-layout>

                <b>Number of Votes</b>
                <v-layout row wrap>
                    <v-text-field
                            clearable
                            label="From:"
                            min="0"
                            step="100"
                            type="number"
                            v-model="movie.numOfVotesFrom"
                    ></v-text-field>
                    <v-text-field
                            clearable
                            label="To:"
                            min="0"
                            step="100"
                            type="number"
                            v-model="movie.numOfVotesTo"
                    ></v-text-field>
                </v-layout>
                <b>Genres</b>
                <v-layout class="mb-3" row wrap>
                    <v-flex :key="item.value" sm3 v-for="item in genresOptions">
                        <v-checkbox
                                :label="item.text"
                                :value="item.value"
                                height="10"
                                hide-details
                                v-model="movie.genres"
                        />
                    </v-flex>
                </v-layout>
                <v-btn type="submit" color="info">Search</v-btn>
            </v-form>
        </v-flex>
    </v-container>
</template>

<script>
    export default {
        props: ['movies'],
        data() {
            return {
                movie: {
                    title: null,
                    titleType: [],
                    releaseDateFrom: null,
                    releaseDateTo: null,
                    userRatingFrom: null,
                    userRatingTo: null,
                    numOfVotesFrom: null,
                    numOfVotesTo: null,
                    genres: []
                },
                userRating: [1, 10],
                titleOptions: [
                    {text: 'Movie', value: 'movie'},
                    {text: 'TV Movie', value: 'tvMovie'},
                    {text: 'TV Series', value: 'tvSeries'},
                    {text: 'TV Episode', value: 'tvEpisode'},
                    {text: 'TV Special', value: 'tvSpecial'},
                    {text: 'Mini-series', value: 'tvMiniSeries'},
                    {text: 'Video Game', value: 'videoGame'},
                    {text: 'Short Film', value: 'short'},
                    {text: 'Video', value: 'video'},
                    {text: 'TV Short', value: 'tvShort'},
                ],
                genresOptions: [
                    {text: 'Action', value: 'Action'},
                    {text: 'Adventure', value: 'Adventure'},
                    {text: 'Animation', value: 'Animation'},
                    {text: 'Biography', value: 'Biography'},
                    {text: 'Comedy', value: 'Comedy'},
                    {text: 'Crime', value: 'Crime'},
                    {text: 'Documentary', value: 'Documentary'},
                    {text: 'Drama', value: 'Drama'},
                    {text: 'Family', value: 'Family'},
                    {text: 'Fantasy', value: 'Fantasy'},
                    {text: 'Film-Noir', value: 'Film-Noir'},
                    {text: 'Game-Show', value: 'Game-Show'},
                    {text: 'History', value: 'History'},
                    {text: 'Horror', value: 'Horror'},
                    {text: 'Music', value: 'Music'},
                    {text: 'Musical', value: 'Musical'},
                    {text: 'Mystery', value: 'Mystery'},
                    {text: 'News', value: 'News'},
                    {text: 'Reality-TV', value: 'Reality-TV'},
                    {text: 'Romance', value: 'Romance'},
                    {text: 'Sci-Fi', value: 'Sci-Fi'},
                    {text: 'Sport', value: 'Sport'},
                    {text: 'Talk-Show', value: 'Talk-Show'},
                    {text: 'Thriller', value: 'Thriller'},
                    {text: 'War', value: 'War'},
                    {text: 'Western', value: 'Western'},
                ]
            }
        },
        methods: {
            search() {
                let query = {
                    title: this.movie.title,
                    titleType: (this.movie.titleType.length > 0 ? this.movie.titleType.join(',') : null),
                    releaseDateFrom: this.movie.releaseDateFrom,
                    releaseDateTo: this.movie.releaseDateTo,
                    userRatingFrom: this.movie.userRatingFrom,
                    userRatingTo: this.movie.userRatingTo,
                    numOfVotesFrom: this.movie.numOfVotesFrom,
                    numOfVotesTo: this.movie.numOfVotesTo,
                    genres: (this.movie.genres.length > 0 ? this.movie.genres.join(',') : null),
                };
                this.$store.dispatch('setRequestUrl', 'search/advanced')
                this.$store.dispatch('resetNumOfPages')
                this.$store.dispatch('resetNumOfTotalElements')
                this.$store.dispatch('setQuery', query)
                this.$store.dispatch('Search', query)
                    .then(() => this.$router.push('/searchresults'))
            },
            setRatingFrom() {
                this.movie.userRatingFrom = this.userRating[0]
            },
            setRatingTo() {
                this.movie.userRatingTo = this.userRating[1]
            },
            setBothRatings() {
                this.movie.userRatingFrom = this.userRating[0];
                this.movie.userRatingTo = this.userRating[1]
            }
        }
    }
</script>

<style scoped>

</style>