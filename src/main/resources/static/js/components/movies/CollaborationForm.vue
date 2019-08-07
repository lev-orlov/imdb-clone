<template>
    <v-container>
        <v-flex lg4 sm6 xs12>
            <h2>Two People in same title</h2>
            <v-form>
                <h3>Name1:</h3>
                <name-autocomplete class="ma-2" v-on:nameSelected="name1change"/>
                <h3>Name2:</h3>
                <name-autocomplete class="ma-2" v-on:nameSelected="name2change"/>
            </v-form>
            <v-btn :disabled="!isFieldsFilled" @click="search" color="info">Search</v-btn>
        </v-flex>
    </v-container>
</template>

<script>
    import NameAutocomplete from "./NameAutocomplete";

    export default {
        components: {
            NameAutocomplete,
        },
        data() {
            return {
                name1: null,
                name2: null,
            }
        },
        methods: {
            search() {
                let query = {
                    name1: this.name1,
                    name2: this.name2
                };
                this.$store.dispatch('setRequestUrl', 'search/collaborations');
                this.$store.dispatch('resetNumOfPages');
                this.$store.dispatch('setQuery', query);
                this.$store.dispatch('Search', query)
                    .then(() => this.$router.push('/searchresults'))
            },
            name1change(d) {
                this.name1 = d
            },
            name2change(d) {
                this.name2 = d
            }
        },
        computed: {
            isFieldsFilled() {
                return (this.name1 != null && this.name2 != null)
            }
        }
    }
</script>

<style scoped>

</style>