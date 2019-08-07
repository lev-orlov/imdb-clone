<template>
    <v-app dark>
        <v-navigation-drawer app
                             class="hidden-sm-and-up"
                             clipped
                             v-model="sideNav">
            <v-list>
                <v-list-tile
                        :key="item.title"
                        :to="item.link"
                        v-for="item in menuItems">
                    <v-list-tile-action>
                        <v-icon>{{ item.icon }}</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>{{ item.title }}</v-list-tile-content>
                </v-list-tile>
                <v-list-tile
                        @click="logout"
                        v-if="isAuthenticated">
                    <v-list-tile-action>
                        <v-icon>exit_to_app</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>Logout</v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar>
            <v-toolbar-side-icon
                    @click.stop="sideNav = !sideNav"
                    class="hidden-sm-and-up"></v-toolbar-side-icon>
            <v-toolbar-title>
                <router-link style="cursor: pointer" tag="span" to="/">
                    <v-icon large>home</v-icon>
                </router-link>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-items class="hidden-xs-only">
                <v-btn
                        :key="item.title"
                        :to="item.link"
                        flat
                        v-for="item in menuItems">
                    <v-icon dark left>{{ item.icon }}</v-icon>
                    {{ item.title }}
                </v-btn>
                <v-btn flat
                       @click="logout"
                       v-if="isAuthenticated"
                >
                    <v-icon class="pr-3">exit_to_app</v-icon>
                    Logout
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <main>
            <router-view></router-view>
        </main>
    </v-app>
</template>

<script>
    export default {
        data() {
            return {
                sideNav: false
            }
        },
        computed: {
            menuItems() {
                let menuItems = [
                    {icon: 'search', title: 'Search', link: '/search'},
                    {icon: 'person_add', title: 'Sign Up', link: '/signup'},
                    {icon: 'how_to_reg', title: 'Sign In', link: '/signin'},
                ];
                if (this.isAuthenticated) {
                    menuItems = [
                        {icon: 'search', title: 'Search', link: '/search'},
                        {icon: 'bookmarks', title: 'Bookmarks', link: '/bookmarks'},
                    ]
                }
                return menuItems
            },
            isAuthenticated() {
                return this.$store.getters.isAuthenticated
            }
        },
        methods: {
            logout() {
                this.$http.post('/logout').then(()=> this.$store.dispatch("setUser", ""))
            }
        }
    }
</script>

<style scoped>

</style>