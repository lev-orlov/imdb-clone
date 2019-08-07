<template>
    <div>
        <v-container fill-height fluid>
            <v-layout align-center flex justify-center>
                <v-flex lg4 sm6 xs12>
                    <v-card>
                        <v-toolbar color="blue">
                            <v-toolbar-title><h4>Password reset</h4></v-toolbar-title>
                        </v-toolbar>
                        <v-card-text>
                            <div v-if="error">
                                <app-alert :text="error.message" @dismissed="onDismissed"></app-alert>
                            </div>
                            <div>
                                <v-form @submit.prevent="onSubmit" ref="form" v-model="valid">
                                    <v-text-field
                                            label="Enter your token from email"
                                            required
                                            v-model="token"
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
                token: '',
                password: '',
                passwordConf: '',
                passwordRules: [
                    (v) => !!v || 'Password is required',
                    (v) => v.length >= 4 || 'Password length must be at least 4 characters'
                ],
            }
        },
        computed: {
            error() {
                return this.$store.getters.error
            },
            comparePassword() {
                return this.password !== this.passwordConf ? 'Passwords doesn\'t match' : true
            },
        },
        methods: {
            onSubmit() {
                if (this.$refs.form.validate()) {
                    let reset = {
                        password: this.password,
                        token: this.token
                    };
                    this.$store.dispatch('clearError');
                    this.$http.put('user/resetpassword', {}, {params: reset})
                        .then(() => {
                            this.clear();
                            this.$router.push('/signin')
                        })
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