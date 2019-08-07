<template>
    <v-container>
        <v-flex>
            <v-img contain
                   src="https://i.imgur.com/bD1nohT.png"
            ></v-img>
            <v-btn flat color="orange">GitHub</v-btn>

            <v-btn v-if="isAdmin"
                   :loading=loading1
                   color="blue-grey"
                   class="white--text"
                   @click=uploadCSV
            >
                upload csv
                <v-icon right dark>cloud_upload</v-icon>
            </v-btn>
            <v-btn v-if="isAdmin"
                   :loading=loading2
                   color="blue-grey"
                   class="white--text"
                   @click=fillTables>
                fill tables
                <v-icon right dark>unarchive</v-icon>
            </v-btn>
        </v-flex>
    </v-container>
</template>

<script>
    export default {
        data() {
            return {
                loading1: false,
                loading2: false
            }
        },
        methods: {
            uploadCSV() {
                this.loading1 = true
                this.$http.get('/admin/downloadcsv', {timeout: 300000})
                    .then(() => this.loading1 = false);
            },
            fillTables() {
                this.loading2 = true
                this.$http.get('/admin/filltables', {timeout: 300000})
                    .then(() => this.loading2 = false);
            }

        },
        computed: {
            isAdmin() {
                return this.$store.getters.isAdmin
            }
        }
    }
</script>

<style scoped>

</style>