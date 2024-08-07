<template>
<div id="main_content">
            <!--상품 영역-->
            <section class="main_goods">
                <h2>오늘의 공구 추천</h2>
                <div class="goods_wrap">
                    <CardComponent v-for="product in productList" :key="product.idx" :product="product"></CardComponent>
                </div>
            </section>
        </div>
</template>

<script>
import CardComponent from './CardComponent.vue';
export default {
    name: "MainComponent",
    data() {
        return { 
            menus: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16],
            productList: [
                {
                    idx:1,
                    price: 1000,
                    name: "상품01",
                    duration: "남은 시간: 13시간"
                },
                {
                    idx:2,
                    price: 1000,
                    name: "상품02",
                    duration: "남은 시간: 14시간"
                },
                {
                    idx:3,
                    price: 1000,
                    name: "상품03",
                    duration: "남은 시간: 11시간"
                },
                {
                    idx:4,
                    price: 1000,
                    name: "상품04",
                    duration: "남은 시간: 12시간"
                },
                {
                    idx:5,
                    price: 1000,
                    name: "상품05",
                    duration: "남은 시간: 13시간"
                },
                {
                    idx:6,
                    price: 1000,
                    name: "상품06",
                    duration: "남은 시간: 12시간"
                },
                {
                    idx:6,
                    price: 1000,
                    name: "상품06",
                    duration: "남은 시간: 12시간"
                },
                {
                    idx:6,
                    price: 1000,
                    name: "상품06",
                    duration: "남은 시간: 12시간"
                },
            ]
        }
    },
    components: {
        CardComponent
    }
}

</script>

<style scoped>

html, body, div, header, nav, section, aside, article, footer, ul, ol, li, dl, dt, dd, h1, h2, h3, p {
    margin: 0;
    padding: 0;
}

ul {
    list-style: none;
}
/* 숨김 콘텐츠 */
.hidden {
    position: absolute;
    left: -9999px;
}

/* 링크 스타일 */
a:link {
    color: #4f4f4f;
    text-decoration: none;
}
a:visited {
    color: #8a8e91;
    text-decoration: none;
}
a:hover, a:focus {
    /*color: red;*/
    text-decoration: none;
}

/* 기본 스타일 */
body {
    color: black;
    font-size: 15px;
}

/* 전체적인 레이아웃 설계 */
#top_header, #bot_header, #main_content, #top_footer_area, #menu_hover, #mid_footer_area, #bot_footer_area {
    width: 1024px;
    margin: 0 auto;
    box-sizing: border-box;
}

/*상품 영역*/
.main_goods {
    padding: 3.5rem 0px 1.5rem;
}
.main_goods > h2{
    font-size: 1.5rem;
    margin-bottom: 1.5rem;
}
.goods_wrap {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
.goods_wrap > .goods {
    display: inline-block;
    width: 245px;
    margin-right: 11px;
    margin-bottom: 11px;
    border: 1px solid #eee;
}
.goods_wrap > .goods:nth-child(4n) {
    margin-right: 0;
}
.goods_image {
    position: relative;
    z-index: 1;
    width: 245px;
    height: 245px;
}
.goods_image > img:nth-child(2) {
    position: absolute;
    z-index: 10;
    bottom: 10px;
    left: 10px;
}
.goods_info {
    padding: 15px 10px;
    height: 80px;
    font-size: 14px;
    box-sizing: border-box;
    line-height: 1;
}
.goods_info > .goods_title {
    padding-bottom: 20px;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    color: #121212;
}
.goods_price_date {
    display: flex;
    justify-content: space-between;
    box-sizing: border-box;
    height: 20px;
}
.goods_price {
    font-weight: 600;
    font-size: 16px;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    color: #121212;
}

</style>