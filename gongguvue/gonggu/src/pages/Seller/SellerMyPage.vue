<template>
    <div id="root">
        <div class="css-ey8mg8" style="">
            <SellerHeaderComponent />
            <SellerMyPageMain />
        </div>
    </div>
</template>

<script>
import SellerHeaderComponent from '@/components/Seller/SellerHeaderComponent.vue';
import SellerMyPageMain from '@/components/Seller/SellerMyPageMain.vue';
export default {
    name: "SellerMyPage",
    data() {
        return {
        }
    },
    methods: {

    },
    components: {
        SellerHeaderComponent,
        SellerMyPageMain
    }
}

</script>

<style scoped>
div {
    display: block;
    unicode-bidi: isolate;
}

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, em, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time,mark,audio,video {
    margin: 0px;
    padding: 0px;
    border: 0px;
    font-size: 100%;
    font-style: normal;
    vertical-align: baseline;
}

* {
    font-family: "Pretendard Variable", -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
    scroll-behavior: smooth;
}
.css-ey8mg8 {
    height: 10vh;
    display: flex;
    flex-direction: column;
}
.css-1geb722 {
    max-width: 1045px;
    padding-top: 32px;
    margin: 0px auto;
}

</style>