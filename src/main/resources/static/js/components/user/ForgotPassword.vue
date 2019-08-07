<template>
    <div>
        <v-container fill-height fluid>
            <v-layout align-center flex justify-center>
                <v-flex lg4 sm6 xs12>
                    <v-card class="elevation-12">
                        <v-toolbar color="blue">
                            <v-toolbar-title><h4>Send password reset token</h4></v-toolbar-title>
                        </v-toolbar>
                        <v-card-text>
                            <div v-if="error">
                                <app-alert :text="error.message" @dismissed="onDismissed"></app-alert>
                            </div>
                            <div>
                                <v-form @submit.prevent="onSubmit" ref="form" v-model="valid">
                                    <v-text-field
                                            :rules="emailRules"
                                            label="Enter your e-mail address"
                                            required
                                            v-model="email"
                                    ></v-text-field>
                                    <v-layout justify-space-between>
                                        <v-btn :disabled="!valid" type="submit">Confirm</v-btn>
                                    </v-layout>
                                </v-form>
                            </div>
                        </v-card-text>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                valid: false,
                email: '',
                emailRules: [
                    (v) => !!v || 'E-mail is required',
                    (v) => /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail must be valid'
                ],
            }
        },
        computed: {
            error() {
                return this.$store.getters.error
            },
        },
        methods: {
            onSubmit() {
                if (this.$refs.form.validate()) {
                    let email = {email: this.email};
                    this.$store.dispatch('clearError');
                    this.$http.post('user/resetpassword', {}, {params: email})
                        .then(() => this.$router.push("/passwordreset"))
                        .catch(error => this.$store.dispatch('setError', error.response.data));
                }
            },
            clear() {
                this.$refs.form.reset()
            },
            onDismissed() {
                this.$store.dispatch('clearError')
            }
        },
    }
</script>

<style scoped>

</style>