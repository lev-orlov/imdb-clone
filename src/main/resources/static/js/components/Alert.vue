<template>
    <v-alert
            :value="true"
            @input="onClose"
            dismissible
            error
            icon="warning"
            outline
    >
        {{ text }}
    </v-alert>
</template>

<script>
    export default {
        props: ['text'],
        methods: {
            onClose() {
                this.$emit('dismissed')
            }
        }
    }
</script>