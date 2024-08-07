
<template>
   <div class="frame-right" id="myCoupon">
    <div class="frame-cnt-inner">
        <div class="menu-title-area">
            <h3 class="title-menu">나의 쿠폰</h3>
        </div><!--// menu-title-area -->

        

        <div class="board-top-tab-group">
            <button id="myCoupon" class="board-top-tab active" type="button" data-cp-status="10">보유쿠폰 <b id="myCouponCnt">{{ userBasicStore.userInfoDetail.couponList.length }}</b></button>
            
        </div>
        <div id="myConponCont" class="board-list"><div class="coupon-table" id="myCouponList">
    <input type="hidden" name="useableCnt" value="1">
    <input type="hidden" name="doneCnt" value="8">
    <table>
        <caption>쿠폰 목록</caption>
        <colgroup>
            <col style="width:190px">
            <col style="width:380px">
            <col style="width:auto">
        </colgroup>
        <thead>
        <tr>
            <th scope="col">금액</th>
            <th scope="col">쿠폰명</th>
            <th scope="col">최소주문금액</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(coupon, index) in userBasicStore.userInfoDetail.couponList" :key="index">
                    <td>
                        <div class="coupon-tbl-discount-group">
                            <b>{{ coupon.couponPrice }}원</b>
                                </div>
                        
                    </td>
                    <td>
                        <p class="coupon-tbl-subject">{{ coupon.couponName }}</p>
                        
                        </td>
                        
                    <td>
                        <div class="in-tb">
                            <!-- 사용조건 -->
                            <!--// 사용조건 -->

                            {{coupon.minOrderPrice}}원 이상</div>
                    </td>
                </tr>
            </tbody>
    </table>
</div>



</div>

        </div><!--// frame-cnt-inner -->
</div>
</template>

<script>
import { userBasicStore } from '@/stores/userBasicStore';
import { mapStores } from 'pinia';
export default {
    name: "UserMypageCouponListComponent",
    data() {
        return { 
        }
    },
    computed:{
        ...mapStores(userBasicStore)
    },
    methods: {
    },
        
    components:{
        
    }
}

</script>

<style scoped>
.frame-right {
    width: 100%;
    padding: 0 4rem;
    float: right;
}
.frame-cnt-inner {
    width: 820px;
}
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    vertical-align: baseline;
    -webkit-font-smoothing: antialiased;
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
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
.menu-title-area {
    position: relative;
    min-height: 30px;
}
.menu-title-area .title-menu {
    display: inline-block;
    font-size: 24px;
    font-weight: 500;
}
h3 {
    display: block;
    font-size: 1.17em;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    unicode-bidi: isolate;
}
.board-top-tab-group {
    display: flex;
    justify-content: flex-end;
    margin-top: 40px;
    gap: 30px;
    align-items: center;
}
.board-top-tab-group .board-top-tab.active {
    color: #333;
    font-weight: 700;
}
.board-top-tab-group .board-top-tab {
    display: flex;
    align-items: center;
    color: #666;
    font-size: 17px;
    line-height: 26px;
    font-weight: 400;
    gap: 4px;
}
button, [type="button"], [type="reset"], [type="submit"] {
    -webkit-appearance: none;
    appearance: none;
    cursor: pointer;
    /* border: 0; */
    padding: 0;
    background-image: none;
}
button {
    background: none;
    font-family: 'Pretendard', sans-serif;
    cursor: pointer;
    outline: none;
    border: 0;
    margin: 0;
    padding: 0;
}
button, select {
    text-transform: none;
}
button, input {
    overflow: visible;
}
button, input, optgroup, select, textarea {
    font: inherit;
    color: inherit;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    -webkit-appearance: none;
    appearance: none;
}
button {
    
    text-rendering: auto;
    letter-spacing: normal;
    word-spacing: normal;
    line-height: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    display: inline-block;
    text-align: center;
    align-items: flex-start;
    cursor: default;
    box-sizing: border-box;
    margin: 0em;
    padding-block: 1px;
    padding-inline: 6px;
    border-width: 2px;
    border-style: outset;
    border-color: buttonborder;
    border-image: initial;
}
.board-top-tab-group .board-top-tab.active b {
    color: #ff6001;
}
.board-top-tab-group .board-top-tab b {
    font-size: 18px;
    font-weight: 700;
}address, caption, strong[lang=en], em, cite, b {
    font-weight: normal;
    font-style: normal;
}
.board-top-tab-group .board-top-tab {
    display: flex;
    align-items: center;
    color: #666;
    font-size: 17px;
    line-height: 26px;
    font-weight: 400;
    gap: 4px;
}
button, [type="button"], [type="reset"], [type="submit"] {
    -webkit-appearance: none;
    appearance: none;
    cursor: pointer;
    /* border: 0; */
    padding: 0;
    background-image: none;
}
.search-box ~ .board-list, .menu-title-area ~ .board-form, .menu-title-area ~ .board-list, .menu-title-area ~ .coupon-box, .menu-title-area ~ .top-search-box, .menu-title-area ~ .grid-list-wrap {
    margin-top: 10px;
}
.board-list {
    width: 100%;
    border-top: 1px solid #666;
}
.board-list .coupon-table {
    border-bottom: 1px solid #f4f4f4;
}
button, input, optgroup, select, textarea {
    font: inherit;
    color: inherit;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    -webkit-appearance: none;
    appearance: none;
}
label, select, input, textarea {
    vertical-align: middle;
}
input[type="hidden" i] {
    display: none !important;
}
input:not([type="image" i], [type="range" i], [type="checkbox" i], [type="radio" i]) {
    overflow-clip-margin: 0px !important;
    overflow: clip !important;
}
input[type="hidden" i] {
    appearance: none;
    background-color: initial;
    cursor: default;
    padding: initial;
    border: initial;
}
input[type="hidden" i] {
    appearance: none;
    background-color: initial;
    cursor: default;
    padding: initial;
    border: initial;
}
user agent stylesheet
input:not([type="file" i], [type="image" i], [type="checkbox" i], [type="radio" i]) {
}
user agent stylesheet
input {
  
    text-rendering: auto;
    color: fieldtext;
    letter-spacing: normal;
    word-spacing: normal;
    line-height: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    display: inline-block;
    text-align: start;
    appearance: auto;
    -webkit-rtl-ordering: logical;
    cursor: text;
    background-color: field;
    margin: 0em;
    padding: 1px 0px;
    border-width: 2px;
    border-style: inset;
    border-color: light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
    border-image: initial;
    padding-block: 1px;
    padding-inline: 2px;
}
.board-list table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
}
table {
    display: table;
    border-collapse: separate;
    box-sizing: border-box;
    text-indent: initial;
    unicode-bidi: isolate;
    border-spacing: 2px;
    border-color: gray;
}
legend, caption {
    position: absolute;
    left: -99999px;
    display: block;
    width: 1px;
    height: 1px;
    overflow: hidden;
    text-indent: -99999px;
    clip: rect(0, 0, 0, 0);
}
address, caption, strong[lang=en], em, cite, b {
    font-weight: normal;
    font-style: normal;
}
caption {
    display: table-caption;
    text-align: -webkit-center;
    unicode-bidi: isolate;
}
.board-list table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
}
colgroup {
    display: table-column-group;
    unicode-bidi: isolate;
}
col {
    display: table-column;
    unicode-bidi: isolate;
}
thead {
    display: table-header-group;
    vertical-align: middle;
    unicode-bidi: isolate;
    border-color: inherit;
}
.board-list .coupon-table table thead th:first-child {
    padding-left: 30px;
    
}
.board-list .coupon-table table thead th {
    padding: 19px 15px;
    text-align: left;
    font-size: 14px;
    line-height: 16.8px;
    font-weight: 500;
    border-bottom: 1px solid #e9e9e9;
}
.board-list table thead th {
    text-align: center;
    color: #000;
    border-bottom: 1px solid #ddd;
    font-weight: 500;
}
.board-list table th, .board-list table td {
    border-bottom: 1px solid #ddd;
    vertical-align: middle;
    word-break: break-all;
    line-height: 20px;
}
table td, table th {
    word-break: keep-all;
    word-wrap: break-word;
}
th {
    display: table-cell;
    vertical-align: inherit;
    font-weight: bold;
    text-align: -internal-center;
    unicode-bidi: isolate;
}
tbody {
    display: table-row-group;
    vertical-align: middle;
    unicode-bidi: isolate;
    border-color: inherit;
}
.board-list .coupon-table table tbody tr:last-child td {
    border-bottom: 0;
}
.board-list .coupon-table table tbody td:first-child {
    padding-left: 30px;
}
.board-list .coupon-table table tbody td {
    padding: 25px 15px;
    text-align: left;
    border-bottom: 1px solid #f4f4f4;
}
.board-list table th, .board-list table td {
    border-bottom: 1px solid #ddd;
    vertical-align: middle;
    word-break: break-all;
    line-height: 20px;
}
.board-list .coupon-table .coupon-tbl-discount-group {
    display: flex;
    align-items: center;
}
.board-list .coupon-table .coupon-tbl-discount-group b {
    font-size: 20px;
    line-height: 20px;
    letter-spacing: -0.02em;
    font-weight: 700;
    margin-right: 4px;
}
.board-list .coupon-table .coupon-tbl-discount-group span {
    font-size: 14px;
    line-height: 20px;
    letter-spacing: -0.02em;
}
.board-list .coupon-table .coupon-tbl-subject:last-child {
    margin-bottom: 0;
}
.board-list .coupon-table .coupon-tbl-subject {
    font-size: 14px;
    line-height: 20px;
    letter-spacing: -0.02em;
    margin-bottom: 6px;
}
p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    unicode-bidi: isolate;
}

.board-list .coupon-table .in-tb {
    font-size: 14px;
    line-height: 20px;
    letter-spacing: -0.02em;
    color: #999;
}
.board-list table .in-tb {
    position: relative;
    word-break: keep-all;
}
.frame-wrap, .clear:after, [class*="frame-"]:after {
    display: block;
    clear: both;
    content: '';
}
.frame-wrap, .clear:after, [class*="frame-"]:after {
    display: block;
    clear: both;
    content: '';
}
#myCoupon{
    border: none;
}
</style>