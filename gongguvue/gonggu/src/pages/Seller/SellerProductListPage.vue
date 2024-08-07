<template>
    <div id="root">
        <div class="css-ey8mg8" style="">
            <SellerHeaderComponent />
            <SellerProductListMain />
        </div>
    </div>
</template>

<script>
import SellerProductListMain from '@/components/Seller/SellerProductListMain.vue';
import SellerHeaderComponent from '@/components/Seller/SellerHeaderComponent.vue';
export default {
    name: "SellerProductListPage",
    data() {
        return {
        }
    },
    methods: {

    },
    components: {
        SellerProductListMain,
        SellerHeaderComponent
    }
}

</script>

<style scoped>

.css-ey8mg8 {
    height: 10vh;
    display: flex;
    flex-direction: column;
}

</style>