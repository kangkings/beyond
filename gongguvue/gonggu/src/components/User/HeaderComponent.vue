<template>
        <header>
            <div id="top_header_bot_border">
                <div id="top_header">
                    <div class="container text-center">
                        <div id="top_header_menu" class="row justify-content-between">
                            <div class="col-4 top_header_icon">
                            </div>
                            <div class="col-4">
                                <div class="row justify-content-end top_header_login">
                                    <div class="col-4">
                                        <a href="#" class="btn_map_close">
                                            로그인/회원가입
                                        </a>
                                    </div>
                                    <div class="col-4">
                                        <a href="#">
                                            <router-link to="/user/mypage" @click.prevent="changeComponent('UserMypageInfoDetailComponent')">
                                            마이페이지
                                            </router-link>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <div id="bot_header_border">
            <div id="bot_header">
                <div class="container text-center">
                    <div class="row justify-content-start">
                        <div class="col-3 header_logo">
                            <h1 class="hidden">로고</h1>
                            <a href="">
                                <img src="../../assets/images/market/logo.svg" alt="번개장터 로고">
                            </a>
                        </div>
                        <div class="col-6 top_searh_area">
                            <div id="top_searh">
                                <input type="text" placeholder="상품명, 지역명, @상점명 입력">
                                <img src="../../assets/images/market/search.png" alt="검색">
                            </div>
                        </div>
                        <div class="col-1 b_h_left_menu">
                            <a href="공구등록페이지.html">
                                <img src="../../assets/images/market/sell.png" alt="판매하기">
                                공구등록
                            </a>
                        </div>
                        <div class="col-1 b_h_left_menu store">
                            <a href="#" @click.prevent="changeComponent('UserMypageInfoDetailComponent')">
                                <img src="../../assets/images/market/my_store.png" alt="내상점">
                                내 정보
                            </a>
                        </div>
                    </div>
                </div>
                <div class="container text-center hamburger_area">
                    <div class="row">
                        <div class="col-md-1 hamburger">
                            <img id="menu" src="../../assets/images/market/hamburger.png" alt="메뉴">
                        </div>
                        <div class="col-md-4 sell_center">
                    
                        </div>
                        <!-- 메뉴 호버 -->
                        <div id="test_area">
                            <ul id="test_cates">
                                <h2>전체 카테고리<span> ></span></h2>
                                <li id="clothes"><a href="market_category_list.html">의류</a></li>
                                <li id="acc"><a href="market_category_list.html">악세서리</a></li>
                            </ul>
                            <ul id="test_clos">
                                <h3>의류</h3>
                                <li><a href="market_category_list.html">남성의류</a></li>
                                <li><a href="market_category_list.html">여성의류</a></li>
                            </ul>
                            <ul id="test_accs">
                                <h3>악세서리</h3>
                                <li><a href="market_category_list.html">시계/쥬얼리</a></li>
                                <li><a href="market_category_list.html">패션 악세서리</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
export default {
    name: "HeaderComponent",
    data() {
        return { 
        }
    },
    methods: {
        changeComponent(componentName) {
            this.$emit('change-component', componentName);
            console.log(componentName);
        },
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

/* 건너뛰기 링크 */
#skipNav {
    position: absolute;
    left: -9999px;
}
#skipNav:focus {
    left: 50%;
    margin: 3px 0 0 -3em;
    padding: 5px 15px;
    background-color: #000;
    color: #fff;
    outline: 0;
    z-index: 10;
}

/* 전체적인 레이아웃 설계 */
#top_header, #bot_header, #main_content, #top_footer_area, #menu_hover, #mid_footer_area, #bot_footer_area {
    width: 1024px;
    margin: 0 auto;
    box-sizing: border-box;
}

/* header 영역 */
header, #bot_header_border {
    z-index: 9999;
}
#bot_header_border {
    position: sticky;
    height: 146px;
    top: 0;
    background-color: white;
}

/* side bar 영역 */
#side_bar {
    width: 90px;
    height: 410px;
    /*position: relative;
    right: -1039px;
    top: -44px;*/
    position: fixed;
    right: 143px;
    top: 142px;
    
}
#heart {
    height: 54px;
    background-color: white;
    border: 1px solid #777;
    text-align: center;
    color: #666;
    font-size: 12px;
    margin-bottom: 6px;
}
#heart > p {
    height: 27px;
    line-height: 32px;
    letter-spacing: -2px;
    font-weight: bold;
}
#heart > p:nth-child(2) {
    line-height: 12px;
    font-weight: normal;
}
#heart > p > img {
    width: 9px;
}

#goods {
    padding: 10px;
    height: 174px;
    border: 1px solid #ccc;
    font-size: 12px;
    text-align: center;
    color: #666;
    background-color: white;
    margin-bottom: 6px;
}
#goods > p:nth-child(1) {
    font-weight: bold;
    letter-spacing: -1px;
}
#goods > p:nth-child(2) {
    width: 38px;
    display: inline-block;
    text-align: center;
    border-top: 2px dotted #777;
    position: relative;
    top: -7px;
}
#goods > p:nth-child(3) img {
    width: 28px;
    margin-top: 20px;
}
#goods > p:nth-child(4) {
    margin-top: 8px;
    letter-spacing: -2px;
    line-height: 15px;
    color: #ccc;
    font-weight: bold;
}

#QR_code {
    height: 122px;
    border: 1px solid rgb(204, 204, 204);
    padding: 10px;
    margin-bottom: 6px;
}
#QR_code > p {
    font-size: 12px;
    text-align: center;
    font-weight: bold;
    color: #666;
    letter-spacing: -2px;
}
#QR_code > p:nth-child(2) {
    height: 68px;
    margin-top: 10px;
    box-shadow: rgb(0 0 0 / 12%) 0px 0px 7px 0px;
}
#QR_code > p > img {
    width: 50px;
    margin-top: 9px;
}

#top_btn {
    text-align: center;
}
#top_btn > button {
    width: 88px;
    height: 44px;
    padding: 0;
    border: 1px solid rgb(204, 204, 204);
    font-size: 13px;
    font-weight: bold;
    color: #666;
    background-color: white;
}
#top_btn > button > a {
    display: inline-block;
    width: 100%;
    height: 100%;
    line-height: 44px;
}
/* // side bar 영역 */

/* 상단 헤더 부분 */
.top_header_icon {
    text-align: left;
}
.top_header_icon a:nth-child(2) {
    margin-left: 30px;
}
#bot_header_border {
    border-bottom: 1px solid rgb(238, 238, 238);
}
#top_header_bot_border {
    border-bottom: 1px solid rgb(238, 238, 238);
}
#top_header {
    line-height: 39px;
    height: 39px;
    font-size: 13px;
    color: #666;
}
#top_header img {
    position: relative;
    top: -2px;
}

.top_header_login {
    text-align: right;
}
.top_header_login > div:nth-child(1) {
    width: 130px;
}
.top_header_login > div:nth-child(2) {
    text-align: center;
}
/* //상단 헤더 부분 */

/* 하단 헤더 부분 */
#bot_header {
    height: 145px;
    padding-top: 35px;
}
.header_logo {
    width: 23%;
    text-align: left;
    padding: 0;
}

.top_searh_area {
    text-align: left;
    padding: 0;
    width: 49%;
}
#top_searh > input {
    width: 445px;
    height: 36px;
    padding: 18px 15px;
    border: 2px solid rgb(247, 47, 51);
}
#top_searh > img {
    position: relative;
    left: -40px;
    bottom: 2px;
}

.b_h_left_menu::after {
    position:relative;
    content:"|";
    color:#333;
}
.store::after {
    right: -8px;
}
.b_h_left_menu:last-child::after {
    content: "";
}
.b_h_left_menu {
    width: 9.333%;
    text-align: center;
    font-size: 14px;
    padding: 0;
    line-height: 40px;
}
.b_h_left_menu > a {
    color: black;
}
.b_h_left_menu > a > img {
    width: 23px;
    position: relative;
    top: -4px;
}

.hamburger_area {
    margin-top: 20px;
}
.hamburger {
    padding: 0;
    height: 51px;
    text-align: left;
}
.hamburger > img {
    width: 20px;
}

.sell_center {
    text-align: left;
    position: relative;
    left: -35px;
    font-weight: bold;
    padding: 0;
}
.sell_center > p {
    width: 220px;
    cursor: pointer;
}
.sell_center > p > img {
    width: 72px;
}
/* // 하단 헤더 부분 */
/* // header 영역 */


/* 햄버거 메뉴 호버 */
#test_area {
    padding-left: 0;
    display: inline-block;
}

#test_cates, #test_clos, #test_accs {
    width: 200px;
    height: 150px;
    float: left;
    border-left: 1px solid rgb(238, 238, 238);
    border-right: 1px solid rgb(238, 238, 238);
    border-bottom: 1px solid rgb(238, 238, 238);
    background-color: white;
}
#test_cates > h2, #test_clos > h3, #test_accs > h3 {
    font-size: 1.1em;
    font-weight: bold;
    text-align: left;
    padding: 10px 0 10px 20px;
    border-bottom: 1px solid rgb(238, 238, 238);
}
#test_cates > li, #test_clos > li, #test_accs > li {
    padding: 5px 0;
}
#test_cates > li:nth-child(2), #test_clos > li:nth-child(2), #test_accs > li:nth-child(2) {
    margin-top: 10px;
}
#test_cates > li > a, #test_clos > li > a, #test_accs > li > a {
    display: inline-block;
    width: 100%;
    padding-left: 20px;
    text-align: left;
}
#test_cates, #test_clos, #test_accs {
    display: none;
}
#test_cates > h2 > span {
    float: right;
    margin-right: 10px;
    color: rgb(246, 68, 72);
    display: none;
}

#test_area a:hover {
    background-color: rgb(246, 68, 72);
    color: white;
}
/* // 햄버거 메뉴 호버 */



</style>
