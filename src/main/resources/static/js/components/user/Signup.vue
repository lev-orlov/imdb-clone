<template>
    <div>
        <v-container fill-height fluid>
            <v-layout align-center flex justify-center>
                <v-flex lg4 sm6 xs12>
                    <v-card class="elevation-12">
                        <v-toolbar color="blue">
                            <v-toolbar-title><h4>Sign up</h4></v-toolbar-title>
                        </v-toolbar>
                        <v-card-text>
                            <div v-if="error">
                                <app-alert :text="error.message" @dismissed="onDismissed"></app-alert>
                            </div>
                            <div>
                                <v-form @submit.prevent="onSignup" ref="form" v-model="valid">
                                    <v-text-field
                                            :rules="emailRules"
                                            label="Enter your e-mail address"
                                            required
                                            v-model="email"
                                    ></v-text-field>
                                    <v-text-field
                                            :append-icon="e1 ? 'visibility' : 'visibility_off'"
                                            :rules="passwordRules"
                                            :type="e1 ? 'password' : 'text'"
                                            @click:append="() => (e1 = !e1)"
                                            label="Enter your password"
                                            min="4"
                                            required
                                            v-model="password"
                                    ></v-text-field>
                                    <v-text-field
                                            :append-icon="e2 ? 'visibility' : 'visibility_off'"
                                            :rules="[comparePassword]"
                                            :type="e2 ? 'password' : 'text'"
                                            @click:append="() => (e2 = !e2)"
                                            label="Confirm your password"
                                            min="4"
                                            required
                                            v-model="passwordConf"
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
                e1: true,
                e2: true,
                password: '',
                passwordConf: '',
                passwordRules: [
                    (v) => !!v || 'Password is required',
                    (v) => v.length >= 4 || 'Password length must be at least 4 characters'
                ],
                email: '',
                emailRules: [
                    (v) => !!v || 'E-mail is required',
                    (v) => /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail must be valid'
                ],
            }
        },
        computed: {
            comparePassword() {
                return this.password !== this.passwordConf ? 'Passwords doesn\'t match' : true
            },
            isAuthenticated() {
                return this.$store.getters.isAuthenticated
            },
            error() {
                return this.$store.getters.error
            },
        },
        watch: {
            isAuthenticated(value) {
                if (value) {
                    this.$router.push('/')
                }
            }
        },
        methods: {
            onSignup() {
                if (this.$refs.form.validate()) {
                    let user = {login: this.email, password: this.password};
                    this.$store.dispatch('clearError');
                    this.$store.dispatch('signUp', user)
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