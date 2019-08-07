<template>
    <v-container>
        <v-flex>
            <v-layout align-start justify-space-between row>
                <v-flex xs6>
                    <v-card class="ma-2">
                        <v-card-title primary-title>
                            <div>
                                <div class="headline">Movies, TV & Video Games</div>
                            </div>
                        </v-card-title>
                        <v-card-text>
                            Want comedies from 1970 with at least 1000 votes and average rating of 7.5?
                        </v-card-text>
                        <v-card-actions>
                            <router-link to="/advanced">
                                <b>Advanced title search</b>
                            </router-link>
                        </v-card-actions>
                    </v-card>
                </v-flex>
                <v-flex xs6>
                    <v-card class="ma-2">
                        <v-card-title primary-title>
                            <div>
                                <div class="headline">Collaborations</div>
                            </div>
                        </v-card-title>
                        <v-card-text>
                            Want a list of titles in which both Brad Pitt and George Clooney appeared?
                        </v-card-text>
                        <v-card-actions>
                            <router-link to="/collaborations">
                                <b>Search Collaborations</b>
                            </router-link>
                        </v-card-actions>
                    </v-card>
                </v-flex>

            </v-layout>
        </v-flex>
    </v-container>
</template>

<script>
    export default {}
</script>

<style scoped>

</style>