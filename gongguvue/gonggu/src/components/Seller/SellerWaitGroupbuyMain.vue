<template>
    <main class="css-mkkf9p">
        <div class="css-1jzj7i2">
            <SellerNavComponent/>
            <SellerWaitGroupbuyListComponent />
        </div>
    </main>
</template>

<script>
import SellerNavComponent from '@/components/Seller/SellerNavComponent.vue';
import SellerWaitGroupbuyListComponent from './SellerWaitGroupbuyListComponent.vue';
export default {
    name: "SellerBidListMain",
    data() {
        return {
        }
    },
    methods: {

    },
    components: {
        SellerNavComponent,
        SellerWaitGroupbuyListComponent

    }
}

</script>

<style scoped>
.css-mkkf9p {
    flex: 1 1 auto;
}
.css-1jzj7i2 {
    position: relative;
    display: flex;
    width: 100%;
    max-width: 100%;
    height: 100%;
    flex-direction: column;
}

.css-1jzj7i2 {
    flex-direction: row;
}

</style>