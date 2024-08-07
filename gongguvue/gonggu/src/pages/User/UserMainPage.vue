<template>
    <div id="wrapper">
    <HeaderComponent></HeaderComponent>
    <MainComponent></MainComponent>
    <FooterComponent></FooterComponent>
    </div>
</template>

<script>
import HeaderComponent from '@/components/User/HeaderComponent.vue';
import FooterComponent from '@/components/User/FooterComponent.vue';
import MainComponent from '@/components/User/MainComponent.vue';
import { mapStores } from 'pinia';
import { groupbuyStore } from '@/stores/groupbuyStore';

export default {
    name: "UserMainPage",
    data() {
        return { response:{}
        }
    },
    computed: {
        ...mapStores(groupbuyStore)
    },
    methods: {
        test() {
            let request = {
                categoryIdx: 0,
                minPrice: 0,
                maxPrice: 0,
                page: 0,
                size: 0
            }
            this.response = this.groupbuyStore.gpbuySearch(request);
        }
    },
    components: {
        HeaderComponent,
        FooterComponent,
        MainComponent,
    }
}

</script>

<style scoped>

</style>