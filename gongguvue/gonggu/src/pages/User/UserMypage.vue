<template>
    <div id="wrapper">
    <HeaderComponent @change-component="changeComponent"></HeaderComponent>
    <UserMypageInfoComponent></UserMypageInfoComponent>
    <div class="frame-sm">
        <UserMypageAsideComponent @change-component="changeComponent"></UserMypageAsideComponent>
        <component :is="currentComponent" @change-component="changeComponent"></component>

    </div>
    <div style="margin-bottom: 30px;"></div>
    <FooterComponent></FooterComponent>
    </div>
</template>

<script>
import HeaderComponent from '@/components/User/HeaderComponent.vue';
import FooterComponent from '@/components/User/FooterComponent.vue';
import UserMypageInfoComponent from '@/components/User/UserMypageInfoComponent.vue';
import { mapStores } from 'pinia';
import { groupbuyStore } from '@/stores/groupbuyStore';
import { userBasicStore } from '@/stores/userBasicStore';
import UserMypageAsideComponent from '@/components/User/UserMypageAsideComponent.vue';
import UserMypageInfoDetailComponent from '@/components/User/UserMypageInfoDetailComponent.vue';
import UserMypageInfoEditComponent from '@/components/User/UserMypageInfoEditComponent.vue';
import UserMypageManageAddressComponent from '@/components/User/UserMypageManageAddressComponent.vue';
import UserMypageCouponListComponent from '@/components/User/UserMypageCouponListComponent.vue';

export default {
    name: "UserMypage",
    data() {
        return { response:{}, currentComponent: UserMypageInfoDetailComponent
        }
    },
    computed: {
        ...mapStores(groupbuyStore, userBasicStore)
    },
    mounted(){
        this.setMypage();
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
            this.response = this.groupBuyStore.gpbuySearch(request);
        },
        changeComponent(componentName){
            this.currentComponent = componentName;
            console.log(this.currentComponent)
        },
        setMypage(){
            this.currentComponent = UserMypageInfoDetailComponent;
            this.userBasicStore.userDetail();
            console.log("설정");
        }
    },
    components: {
        HeaderComponent,
        FooterComponent,
        UserMypageInfoComponent,
        UserMypageAsideComponent,
        UserMypageInfoDetailComponent,
        UserMypageInfoEditComponent,
        UserMypageManageAddressComponent,
        UserMypageCouponListComponent,
    }
}

</script>

<style scoped>
.head-mypage ~ .frame-sm {
    margin-top: 45px;
}

.frame-sm {
    display: flex;
    position: relative;
    max-width: 1100px;
    margin: 0 auto;
}

div {
    display: block;
    unicode-bidi: isolate;
}
html, body {
    height: 100%;
    color: #333;
    font-size: 14px;
    font-weight: 400;
    /* line-height: 1.4; */
    font-family: 'Pretendard', sans-serif;
    word-break: break-all;
}
.frame-wrap, .clear:after, [class*="frame-"]:after {
    display: block;
    clear: both;
    content: '';
}
</style>