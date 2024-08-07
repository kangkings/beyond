<template>

    <!--상품 영역-->

    <div class="frame-full head-mypage">
        <div class="user-info-box">
            <div class="inner">
                <div class="column user-info ">
                    <div class="txt">
                        <span class="img">
                            <i class="ico-cou-level03"></i>
                        </span>
                        <div class="" style="display:inline-block;width:calc(100% - 60xp);">
                            <p class="greeting">
                                <strong class="name">{{ userBasicStore.userInfoDetail.name }}</strong>님 반갑습니다
                            </p>

                        </div>


                    </div>
                </div><!--// user-info -->


                <div class="column order">
                    <dt>주문/배송</dt>
                    <dd><a href="#"><strong class="num" id="orderCountText">0</strong>건</a></dd>
                </div><!--// order -->
                <div class="column coupon">
                    <dt>나의 쿠폰</dt>
                    <dd><a href="#"><strong class="num" id="couponCountText">{{
                        userBasicStore.userInfoDetail.couponList.length }}</strong>개</a></dd>
                </div><!--// coupon -->
                <div class="column point">
                    <dt>포인트</dt>
                    <dd class="text-primary"><a href="/mypage/myPoint"><strong class="num"
                                id="totalUnusedPointText">{{ userBasicStore.userInfoDetail.userPoint }}</strong>P</a></dd>
                </div><!--// point -->
            </div><!--// inner -->
        </div><!--// user-info-box -->

        <div class="layer-wrap layer-usertag" id="usertag-popup">
            <div class="layer-pop">
                <div class="layer-inner">

                </div>
            </div><!--// layer-pop  -->
        </div><!--// layer-pop-wrap #popupSample-02 -->

    </div>
</template>

<script>
import { mapStores } from 'pinia';
import { userBasicStore } from '@/stores/userBasicStore';

export default {
    name: "UserMypageInfoComponent",
    data() {
        return {
        }
    },
    computed: {
        ...mapStores(userBasicStore)
    },
    methods: {

    },
}

</script>

<style scoped>
.frame-full{
    display: flex;
    align-content: flex-end;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: stretch;
}

.frame-full > div:nth-of-type(1){
    padding: 30px 30px;
}


.wrap {
    position: relative;
    min-width: 1300px;
    /* max-width: 1920px; */
}

html,
body,
div,
span,
applet,
object,
iframe,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
abbr,
acronym,
address,
big,
cite,
code,
del,
dfn,
em,
img,
ins,
kbd,
q,
s,
samp,
small,
strike,
strong,
sub,
sup,
tt,
var,
b,
u,
i,
center,
dl,
dt,
dd,
ol,
ul,
li,
fieldset,
form,
label,
legend,
table,
caption,
tbody,
tfoot,
thead,
tr,
th,
td,
article,
aside,
canvas,
details,
embed,
figure,
figcaption,
footer,
header,
hgroup,
menu,
nav,
output,
ruby,
section,
summary,
time,
mark,
audio,
video {
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

html,
body {
    height: 100%;
    color: #333;
    font-size: 14px;
    font-weight: 400;
    /* line-height: 1.4; */
    font-family: 'Pretendard', sans-serif;
    word-break: break-all;
}

html {
    -webkit-text-size-adjust: 100%;
    -ms-text-size-adjust: 100%;
    /* -ms-touch-action: none; */
}

.container {
    position: relative;
    min-height: 700px;
    padding-bottom: 100px;
}

article,
aside,
details,
figcaption,
figure,
footer,
header,
hgroup,
main,
menu,
nav,
section {
    display: block;
}

section {
    display: block;
    unicode-bidi: isolate;
}

.content-wrap {
    min-height: 700px;
}

.head-mypage {
    background: #F7F7F7;
}

.frame-full {
    position: relative;
    width: 100%;
}

.frame-wrap,
.clear:after,
[class*="frame-"]:after {
    display: block;
    clear: both;
    content: '';
}

.user-info-box {
    width: 1100px;
    margin: 0 auto;
    background: #F8F8F8;
    text-align: center;
    padding: 30px 0;
}

.user-info-box .user-info .txt {
    display: inline-block;
    vertical-align: middle;
}

.txt,
.txt span {
    word-break: break-all;
}

.user-info-box .inner>.column {
    display: flex;
    vertical-align: middle;
    background: #fff;
    padding: 0 25px;
    text-align: left;
    box-shadow: 0px 0px 8px 0px rgba(0, 0, 0, 0.10);
    border-radius: 6px;
    flex-direction: column;
    justify-content: center;
}

.txt,
.txt span {
    word-break: break-all;
}

.user-info-box .inner>.column {
    display: flex;
    vertical-align: middle;
    background: #fff;
    padding: 0 25px;
    text-align: left;
    box-shadow: 0px 0px 8px 0px rgba(0, 0, 0, 0.10);
    border-radius: 6px;
    flex-direction: column;
    justify-content: center;
}

.user-info-box .user-info .txt .greeting {
    font-size: 18px;
    font-weight: 400;
    position: relative;
}

p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    unicode-bidi: isolate;
}

.user-info-box .user-info .txt .greeting .name {
    font-weight: 700;
}

address,
caption,
cite,
code,
dfn,
em,
strong,
th,
var {
    font-style: normal;
}

.user-info-box .user-info .txt .greeting {
    font-size: 18px;
    font-weight: 400;
    position: relative;
}

.user-info-box .user-info .txt .greeting~.sep-list.type3 {
    margin-top: 6px;
    display: flex;
    align-items: center;
}

.user-info-box .user-info .user-info-list.type3 {
    overflow: visible;
}

ol,
ul {
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

.user-info-box .user-info .user-info-list.type3:after {
    display: block;
    clear: both;
    content: '';
}

.user-info-box .user-info .next-rank-text {
    margin-top: 6px;
    color: #ff6001;
}

.user-info-box .inner>.column.orange-mem-coupon-box {
    border-radius: 6px;
    background: linear-gradient(90deg, #FF7D54 0%, #FF6331 88.54%, #FF6535 100%);
    max-width: 146px;
    padding: 0 15px;
    width: 146px;
}

.user-info-box .inner>.column {
    display: flex;
    vertical-align: middle;
    background: #fff;
    padding: 0 25px;
    text-align: left;
    box-shadow: 0px 0px 8px 0px rgba(0, 0, 0, 0.10);
    border-radius: 6px;
    flex-direction: column;
    justify-content: center;
}

.user-info-box .inner>.column.order,
.user-info-box .inner>.column.coupon,
.user-info-box .inner>.column.point {
    width: 146px;
}

.user-info-box .column>dt {
    color: #666;
    font-size: 13px;
    margin-bottom: 10px;
}

.user-info-box .column>dd {
    color: #333;
    font-size: 20px;
    font-weight: 700;
    word-break: keep-all;
    max-width: 200px;
    display: block;
}

dd {
    display: block;
    margin-inline-start: 40px;
    unicode-bidi: isolate;
}

a {
    background: transparent;
    text-decoration: none;
    color: inherit;
}

.user-info-box .column>dd {
    color: #333;
    font-size: 20px;
    font-weight: 700;
    word-break: keep-all;
    max-width: 200px;
    display: block;
}

.user-info-box .column>dd .num {
    font-size: 20px;
}

address,
caption,
cite,
code,
dfn,
em,
strong,
th,
var {
    font-style: normal;
}

trong {
    font-weight: bold;
}

a:-webkit-any-link {
    color: -webkit-link;
    cursor: pointer;
}

.user-info-box .column>dd {
    color: #333;
    font-size: 20px;
    font-weight: 700;
    word-break: keep-all;
    max-width: 200px;
}

.user-info-box .inner>.column.order,
.user-info-box .inner>.column.coupon,
.user-info-box .inner>.column.point {
    width: 146px;
}

.user-info-box .inner>.column.order,
.user-info-box .inner>.column.coupon,
.user-info-box .inner>.column.point {
    width: 146px;
}

.text-primary {
    color: #FF6001 !important;
}

.user-info-box .column>dd .num {
    font-size: 20px;
}

address,
caption,
cite,
code,
dfn,
em,
strong,
th,
var {
    font-style: normal;
}

html[data-v-fdaaaa16],
body[data-v-fdaaaa16],
div[data-v-fdaaaa16],
span[data-v-fdaaaa16],
applet[data-v-fdaaaa16],
object[data-v-fdaaaa16],
iframe[data-v-fdaaaa16],
h1[data-v-fdaaaa16],
h2[data-v-fdaaaa16],
h3[data-v-fdaaaa16],
h4[data-v-fdaaaa16],
h5[data-v-fdaaaa16],
h6[data-v-fdaaaa16],
p[data-v-fdaaaa16],
blockquote[data-v-fdaaaa16],
pre[data-v-fdaaaa16],
a[data-v-fdaaaa16],
abbr[data-v-fdaaaa16],
acronym[data-v-fdaaaa16],
address[data-v-fdaaaa16],
big[data-v-fdaaaa16],
cite[data-v-fdaaaa16],
code[data-v-fdaaaa16],
del[data-v-fdaaaa16],
dfn[data-v-fdaaaa16],
em[data-v-fdaaaa16],
img[data-v-fdaaaa16],
ins[data-v-fdaaaa16],
kbd[data-v-fdaaaa16],
q[data-v-fdaaaa16],
s[data-v-fdaaaa16],
samp[data-v-fdaaaa16],
small[data-v-fdaaaa16],
strike[data-v-fdaaaa16],
strong[data-v-fdaaaa16],
sub[data-v-fdaaaa16],
sup[data-v-fdaaaa16],
tt[data-v-fdaaaa16],
var[data-v-fdaaaa16],
b[data-v-fdaaaa16],
u[data-v-fdaaaa16],
i[data-v-fdaaaa16],
center[data-v-fdaaaa16],
dl[data-v-fdaaaa16],
dt[data-v-fdaaaa16],
dd[data-v-fdaaaa16],
ol[data-v-fdaaaa16],
ul[data-v-fdaaaa16],
li[data-v-fdaaaa16],
fieldset[data-v-fdaaaa16],
form[data-v-fdaaaa16],
label[data-v-fdaaaa16],
legend[data-v-fdaaaa16],
table[data-v-fdaaaa16],
caption[data-v-fdaaaa16],
tbody[data-v-fdaaaa16],
tfoot[data-v-fdaaaa16],
thead[data-v-fdaaaa16],
tr[data-v-fdaaaa16],
th[data-v-fdaaaa16],
td[data-v-fdaaaa16],
article[data-v-fdaaaa16],
aside[data-v-fdaaaa16],
canvas[data-v-fdaaaa16],
details[data-v-fdaaaa16],
embed[data-v-fdaaaa16],
figure[data-v-fdaaaa16],
figcaption[data-v-fdaaaa16],
footer[data-v-fdaaaa16],
header[data-v-fdaaaa16],
hgroup[data-v-fdaaaa16],
menu[data-v-fdaaaa16],
nav[data-v-fdaaaa16],
output[data-v-fdaaaa16],
ruby[data-v-fdaaaa16],
section[data-v-fdaaaa16],
summary[data-v-fdaaaa16],
time[data-v-fdaaaa16],
mark[data-v-fdaaaa16],
audio[data-v-fdaaaa16],
video[data-v-fdaaaa16] {
    margin: 0;
    padding: 0;
    border: 0;
    vertical-align: baseline;
    -webkit-font-smoothing: antialiased;
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
}

.head-mypage {
    background: #F7F7F7;
}

.frame-wrap,
.clear:after,
[class*="frame-"]:after {
    display: block;
    clear: both;
    content: '';
}

.user-info-box {
    width: 1100px;
    margin: 0 auto;
    background: #F8F8F8;
    text-align: center;
    padding: 30px 0;
}

.user-info-box .inner {
    display: flex;
    width: 100%;
    gap: 4px;
}

.user-info-box .inner>.column.user-info {
    position: relative;
    padding: 24px 25px;
    flex: 1;
    max-width: 500px;
}

.user-info-box .inner>.column {
    display: flex;
    vertical-align: middle;
    background: #fff;
    padding: 0 25px;
    text-align: left;
    box-shadow: 0px 0px 8px 0px rgba(0, 0, 0, 0.10);
    border-radius: 6px;
    flex-direction: column;
    justify-content: center;
}

.user-info-box .inner>.column.orange-mem-coupon-box {
    border-radius: 6px;
    background: linear-gradient(90deg, #FF7D54 0%, #FF6331 88.54%, #FF6535 100%);
    max-width: 146px;
    padding: 0 15px;
    width: 146px;
}

.user-info-box .inner>.column {
    display: flex;
    vertical-align: middle;
    background: #fff;
    padding: 0 25px;
    text-align: left;
    box-shadow: 0px 0px 8px 0px rgba(0, 0, 0, 0.10);
    border-radius: 6px;
    flex-direction: column;
    justify-content: center;
}

.user-info-box .user-info .txt {
    display: inline-block;
    vertical-align: middle;
}

.user-info-box .user-info .txt .greeting {
    font-size: 18px;
    font-weight: 400;
    position: relative;
}

.user-info-box .user-info .txt .greeting .name {
    font-weight: 700;
}

address,
caption,
cite,
code,
dfn,
em,
strong,
th,
var {
    font-style: normal;
}

.user-info-box .user-info .txt .greeting {
    font-size: 18px;
    font-weight: 400;
    position: relative;
}

.user-info-box .inner>.column {
    display: flex;
    vertical-align: middle;
    background: #fff;
    padding: 0 25px;
    text-align: left;
    box-shadow: 0px 0px 8px 0px rgba(0, 0, 0, 0.10);
    border-radius: 6px;
    flex-direction: column;
    justify-content: center;
}

.user-info-box .user-info .txt .greeting~.sep-list.type3 {
    margin-top: 6px;
    display: flex;
    align-items: center;
}

.head-mypage {
    background: #F7F7F7;
}
</style>