<template>
    <div>
        <v-autocomplete
                :items="items"
                :loading="isLoading"
                :search-input.sync="search"
                @change="$emit('nameSelected', model)"
                chips
                clearable
                hide-details
                item-text="name"
                no-filter
                prepend-inner-icon="search"
                solo
                v-model="model"
        >
            <template slot="no-data">
                <v-list-tile>
                    <v-list-tile-title>
                        Search for name
                    </v-list-tile-title>
                </v-list-tile>
            </template>
            <template
                    slot="selection"
                    slot-scope="{ item, selected }"
            >
                <span v-text="item"></span>
            </template>
        </v-autocomplete>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                isLoading: false,
                items: [],
                search: null,
                delay: 500,
                model: null
            }
        },
        methods: {
            querySelections(v) {
                this.isLoading = true;
                if (this.search !== null && this.search.length > 2) {
                    this.$http.get('/search/name',
                        {
                            params: {
                                name: this.search
                            }

                        })
                        .then(res => this.items = res.data)
                }
                if (this.search === null) this.isLoading = false
            }
        },
        watch: {
            search() {
                this.debounce();
            }
        },
        created() {
            this.debounce = _.debounce(this.querySelections, this.delay)
        },

    }
</script>

<style scoped>

</style>