<template>
<div class="goods">
    <a href="goods_product_detail.html">
        <div class="goods_image">
            <img src="../../assets/images/goods_ex.jpg" width="245" height="245" alt="상품 이미지">
            <div class="styled__BadgeArea-sc-3zkh6z-0 dwFxLs"><div class="styled__Badge-sc-3zkh6z-1 kpHfXu">12/20</div></div>
        </div>
        <div class="goods_info">
            <p class="goods_title" v-text=product.name></p>
            <div class="goods_price_date">
                <span class="goods_price" v-text=product.price></span>
                <span class="goods_date_before" v-text=product.duration></span>
            </div>
        </div>
    </a>
</div>
</template>

<script>
export default {
    name: "CardComponent",
    data() {
        return { 
        }
    },
    methods: {

    },
    props:["product"]
}

</script>

<style scoped>
.dwFxLs {
    position: absolute;
    right: 10px;
    bottom: 10px;
    display: flex;
    gap: 5px;
}
.kpHfXu {
    padding: 2px 3px 3px;
    background: rgba(0, 0, 0, 1);
    border-radius: 2px;
    font-size: 11px;
    font-weight: 500;
    color: rgb(255, 255, 255);
}
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