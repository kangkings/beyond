
<template>

    <div class="frame-left">
        <div class="aside-menu-wrap">
            <nav class="aside-menu">
                <ul class="menu-list">
                    <li>
                        <a href="#" class="menu" @click.prevent="changeComponent('UserMypageInfoDetailComponent')">회원정보관리</a>
                        <ul class="depth2">
                            <li><a href="#" @click.prevent="changeComponent('UserMypageInfoDetailComponent')">내 정보</a>
                            </li><!-- 활성화될 경우 li에 addClass current  -->
                            <li><a href="#" @click.prevent="changeComponent('UserMypageInfoEditComponent')">정보 수정</a>
                            </li><!-- 활성화될 경우 li에 addClass current  -->
                            <li class=""><a href="#"
                                    @click.prevent="changeComponent('UserMypageManageAddressComponent')">배송지 관리</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="menu">주문관리</a>
                        <ul class="depth2">
                            <li><a class="left-sidebar" href="#" @click="showAlert">주문내역</a></li>
                            <li>
                                <a class="left-sidebar" href="#" @click="showAlert">취소/반품 내역</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="menu">혜택관리</a>
                        <ul class="depth2">
                            <li class=""><a class="sub-menu" href="#" @click.prevent="changeComponent('UserMypageCouponListComponent')" >나의 쿠폰</a></li>
                            <li class=""><a href="#" @click="showAlert">포인트</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="menu">활동관리</a>
                        <ul class="depth2">
                            <li class=""><a href="#" @click="showAlert">최근 본 상품</a></li>
                            <li class=""><a href="#">관심 공구</a></li>
                            <li><a href="#" @click="showAlert">1:1문의</a></li><!-- 활성화될 경우 li에 addClass current  -->
                            <li><a href="#" @click="showAlert">상품후기</a></li><!-- 활성화될 경우 li에 addClass current  -->
                            <li><a href="#" @click="showAlert">상품문의내역</a></li><!-- 활성화될 경우 li에 addClass current  -->
                        </ul>
                    </li>


                </ul>
            </nav><!--// menu-mypage -->

        </div><!--// aside-menu-wrap -->
    </div>
</template>

<script>
export default {
    name: "UserMypageAsideComponent",
    data() {
        return {
        }
    },
    methods: {
        changeComponent(componentName) {
            this.$emit('change-component', componentName);
        },
        showAlert() {
            alert("준비중인 기능입니다.");
        },
    },
}

</script>
<style scoped>
a{
    background: transparent;
    text-decoration: none;
    color: inherit;
}
.frame-left {
    float: left;
}

div {
    display: block;
    unicode-bidi: isolate;
}
tml, body {
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

.aside-menu-wrap {
    width: 220px;
}
.aside-menu {
    padding: 10px 25px;
    border: 1px solid #E6E6E6;
}

article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section {
    display: block;
}

nav {
    display: block;
    unicode-bidi: isolate;
}

l, ul {
    list-style: none;
}
ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
    unicode-bidi: isolate;
}

.aside-menu .menu-list > li:first-child {
    border-top: 0;
}

.aside-menu .menu-list > li {
    padding: 15px 0;
    border-top: 1px solid #eee;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
    unicode-bidi: isolate;
}

.aside-menu .menu-list > li .menu {
    font-size: 15px;
    color: #000;
    font-weight: 500;
}
a {
    background: transparent;
    text-decoration: none;
    color: inherit;
}a:-webkit-any-link {
    color: -webkit-link;
    cursor: pointer;
    text-decoration: underline;
}
li {
    text-align: -webkit-match-parent;
}
tml, body {
    height: 100%;
    color: #333;
    font-size: 14px;
    font-weight: 400;
    /* line-height: 1.4; */
    font-family: 'Pretendard', sans-serif;
    word-break: break-all;
}
.aside-menu .menu-list > li .depth2 {
    margin-top: 8px;
}

ul ul {
    list-style-type: circle;
    margin-block-start: 0px;
    margin-block-end: 0px;
}
ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
    unicode-bidi: isolate;
}

.aside-menu .menu-list > li .depth2 > li {
    font-size: 14px;
    color: #666;
}

li {
    display: list-item;
    text-align: -webkit-match-parent;
    unicode-bidi: isolate;
}

li:nth-child(3) {
    background: transparent;
    text-decoration: none;
    color: inherit;
}
.depth2 {
    padding-left: 10px;
}

ul{
    list-style: none;
}

li{
    list-style: none;
}

li .menu{
    text-decoration: none;
}

.depth2 li a {
    text-decoration: none;
    color: #666;
}

ul.menu-list {
    padding-left: 20px;
}

</style>