
<template>
    <UserMypageAddAddressComponent v-show="addAddrIsVisible" @close-modal="handleCloseModal" @save-modal="handleSaveModal"></UserMypageAddAddressComponent>
        <div class="frame-right">
                    <div class="frame-cnt-inner">
                        <div class="menu-title-area">
                            <h3 class="title-menu">배송지 관리</h3>
                            <p class="sub-desc">* 배송지는 최대 10개까지 등록됩니다.</p>
                            <div class="right">
                                <a href="javascript:void(0);"
                                    class="btn-link-txt1 btn-modal-delivery" @click="addAddr"><i class="ico-plus"></i><span>새 배송지
                                        추가</span></a>
                            </div>
                        </div><!--// menu-title-area -->

                        <div class="board-list" id="tbl-my-delivery">
                            <table>
                                <caption>배송지 관리</caption>
                                <colgroup>
                                    <col style="width:50px">
                                    <col style="width:100px">
                                    <col style="width:auto">
                                    <col style="width:100px">
                                    <col style="width:140px">
                                    <col style="width:100px">
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th scope="col">선택</th>
                                        <th scope="col">배송지명</th>
                                        <th scope="col">배송주소</th>
                                        <th scope="col">배송유형</th>
                                        <th scope="col">연락처</th>
                                        <th scope="col">관리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="(deliveryAddress, index) in userBasicStore.userInfoDetail.deliveryAddressList" :key="index">
                                        <td class="text-center">
                                            <!-- [Dev] 20210909 체크박스 > 라디오 버튼으로 수정 -->
        
                                            <div class="custom-radio single">
                                                <input type="radio" class="radio"
                                                    id="radio-delivery-20220424000000577778" name="vDeliveryid"
                                                    value="20220424000000577778" data-v-postcd="01198"
                                                    data-v-addr="서울특별시 강북구 삼양로19길 113(미아동, 삼각산아이원아파트)"
                                                    data-v-addr-dtl="106동 304호" data-v-delivery-tel="01047541175"
                                                    data-v-delivery-cell="01047541175" data-v-delivery-cell1="010"
                                                    data-v-delivery-cell2="47541175" data-v-delivery-nm="강태성"
                                                    data-v-door-access-method-cd="01"
                                                    data-v-door-access-method-memo="#*3176#"
                                                    data-v-dawn-dlv-message-send-time="Y" data-v-exdlv-area="10001"
                                                    checked="">
                                                <label for="radio-delivery-20220424000000577778" class="blind"></label>
                                            </div>
                                        </td>
                                        <td class="text-center">{{ deliveryAddress.addressName }}</td>
                                        <td class="text-left">
                                            <label for="" ><span class="text-mint" v-if="deliveryAddress.addressDefault">[기본배송지]<br></span>
                                                {{ deliveryAddress.addressInfo }}</label>
                                        </td>
                                        <td class="text-center">
                                        </td>
                                        <td class="text-center td-delivery-cell">{{ userBasicStore.userInfoDetail.phoneNumber }}</td>
                                        <td class="text-center">
                                            <ul class="sep-list type4">
                                                <li><a href="javascript:void(0);" class="btn-upd-delivery">수정</a></li>
                                                <li>
                                                    <a href="javascript:void(0);" class="btn-delt-delivery"
                                                        data-id="20220424000000577778" data-basic-yn="Y">삭제</a>
                                                </li>
                                            </ul>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div><!--// board-list -->
                        <!-- modal -->
                        <div class="layer-wrap" id="modal-my-delivery" style="display: none;">
                            <form id="userDeliveryForm" name="userDeliveryForm" action="/mypage/delivery/pop"
                                method="post" novalidate="novalidate"><input type="hidden" name="actionFlag" value="R">
                                <input type="hidden" name="vDeliveryid" value="">
                                <input type="hidden" name="vDeliveryCell" value="">
                                <input type="hidden" name="vOrderCd" value="">
                                <div class="layer-pop dlv-addr-pop">
                                    <div class="layer-inner">
                                        <div class="layer-head">
                                            <h4 class="layer-pop-title">배송지 추가</h4>
                                        </div>

                                        <div class="layer-content">
                                            <div class="delivery-notice">
                                                <ul>
                                                    <li>공동현관 출입이 불가한 경우, 1층 공동현관 또는 경비실에 배송될 수 있습니다.</li>
                                                    <li>6층 이상부터 엘리베이터 이용이 어려운 경우, 공동현관 또는 경비실로 배송될 수 있습니다.</li>
                                                    <li>관공서, 군부대, 학교, 기숙사 등 특급배송 불가 지역으로 일반배송으로 주문해 주세요.</li>
                                                    <li>배송 수령 시간 지정은 불가하며, 배송 방법과 배송 지역에 따라 시간은 상이합니다.</li>
                                                    <li>새벽에는 전화 또는 세대 호출이 불가하오니 제품 수령 위치를 상세하게 남겨주세요.</li>
                                                </ul>
                                            </div>
                                            <div class="inner">
                                                <div class="lineless-table type2">
                                                    <div class="custom-checkbox" style="margin-top:8px;">
                                                        <input type="checkbox" id="check-101" class="checkbox"
                                                            name="vBasicDlvYn" value="Y">
                                                        <label for="check-101"> 기본배송지로 등록</label>
                                                    </div>
                                                    <h3>주소 <em class="es"><span class="blind">필수입력</span></em></h3>
                                                    <div class="block">
                                                        <div class="input-group">
                                                            <input type="text" name="vPostcd" title="" id="postCd"
                                                                class="input-text" placeholder="우편번호"
                                                                readonly="readonly" value="">
                                                            <span class="input-group-btn">
                                                                <a href="#" class="btn-ex-white" onclick="searchAddr();"
                                                                    style="border-radius: 4px;height: 50px;min-width: 90px;line-height: 50px;"><span>우편번호
                                                                        찾기</span></a>
                                                            </span>
                                                        </div>
                                                        <div class="input-group w-full">
                                                            <input type="text" name="vAddr" title="" id="addr"
                                                                class="input-text" placeholder="기본주소"
                                                                readonly="readonly" value="">
                                                        </div>
                                                        <div class="input-group w-full">
                                                            <input type="text" name="vAddrDtl" title=""
                                                                class="input-text removeEmoji" placeholder="상세주소"
                                                                value="" maxlength="80">
                                                        </div>
                                                    </div>


                                                </div>
                                            </div>
                                        </div><!--// layer-content -->

                                        <div class="layer-bottom type-shadow">
                                            <div class="btn-area">
                                                <button type="button" class="btn-basic-lg2 btn-black btn-save-delivery"
                                                    onclick="closeModal()"><span>저장</span></button>
                                            </div>
                                        </div>

                                        <button type="button" class="btn-x-md2 ui-close-pop" title=""
                                            onclick="closeModal()"><i class="ico-x-black"></i><span
                                                class="blind">닫기</span></button>
                                    </div><!--// layer-inner -->
                                </div><!--// layer-pop  -->
                                <input type="hidden" id="express-yn">
                                <div>
                                    <input type="hidden" name="_csrf" value="c1907c4c-b83b-4331-be9f-f9ccd273c575">
                                </div>
                            </form>
                            <form id="postSearchForm" name="postSearchForm" action="/mypage/delivery/pop" method="post"
                                onsubmit="return false;"><input type="hidden" name="resultType" value="json">
                                <input type="hidden" name="pageSize" value="5">
                                <div id="jusoDiv" class="searchPop"></div>
                                <div>
                                    <input type="hidden" name="_csrf" value="c1907c4c-b83b-4331-be9f-f9ccd273c575">
                                </div>
                            </form>
                            
                        </div>

                        <div class="btn-bottom-area">
                            <button type="button" class="btn-basic-lg2 btn-navy btn-basic-delivery"><span>기본 배송지로
                                    설정</span></button>
                        </div>
                    </div><!--// frame-cnt-inner -->
                </div>
            
            <form id="command" name="deliveryPop" action="/mypage/main" method="post"><input type="hidden"
                    name="actionFlag" value="M">
                <input type="hidden" name="vDeliveryid">
                <input type="hidden" name="vOrderCd">
                <div>
                    <input type="hidden" name="_csrf" value="a91b0f57-cc25-49e7-a7da-d6918d115134">
                </div>
            </form>
            <div class="layer-wrap" id="modal-my-delivery" style="display: none"></div>
</template>

<script>
import { userBasicStore } from '@/stores/userBasicStore';
import { mapStores } from 'pinia';
import UserMypageAddAddressComponent from './UserMypageAddAddressComponent.vue';
export default {
    name: "UserMypageManageAddressComponent",
    data() {
        return { addAddrIsVisible:false,
        }
    },
    computed:{
        ...mapStores(userBasicStore)
    },
    methods: {
        addAddr(){
            this.addAddrIsVisible = true;
        },
        handleCloseModal(){
            this.addAddrIsVisible = false;
        },
        handleSaveModal(payload){
            console.log(payload.detailAddr);
            this.userBasicStore.saveAddr(payload);
            this.userBasicStore.userDetail();
            this.addAddrIsVisible = false;
        }
    },
    components:{
        UserMypageAddAddressComponent,
    }
}

</script>

<style scoped>
.frame-right {
    width: 100%;
    padding: 0 4rem;
    float: right;
}
html, body, div, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, address, big, cite, code, del, dfn, em, font, img, ins, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, ul, ol, li, dl, dt, dd, table, caption, tbody, tfoot, thead, tr, th, td, fieldset, form, label, legend, input, button, textarea, select {
    margin: 0;
    padding: 0;
}
div {
    display: block;
    unicode-bidi: isolate;
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
.frame-cnt-inner {
    width: 820px;
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
.menu-title-area .sub-desc {
    display: inline-block;
    color: #666;
    font-size: 12px;
    margin-left: 5px;
}
p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    unicode-bidi: isolate;
}
.menu-title-area .right {
    position: absolute;
    right: 0;
    top: 50%;
    transform: translateY(-50%);
    -webkit-transform: translateY(-50%);
    z-index: 1;
}
a:link {
    color: #4f4f4f;
    text-decoration: none;
}
.btn-link-txt1 {
    display: inline-block;
    color: #333;
    font-size: 15px;
}
a {
    text-decoration: none;
    cursor: pointer;
}
.btn-link-txt1 i {
    vertical-align: middle;
    margin-top: -3px;
    margin-right: 5px;
}
.ico-plus {
    position: relative;
    width: 11px;
    height: 11px;
    display: inline-block;
}
.ico-plus:before {
    display: block;
    content: '';
    position: absolute;
    top: 5px;
    left: 0;
    width: 100%;
    height: 1px;
    background: #333;
}
*, ::after, ::before {
    box-sizing: border-box;
}
.ico-plus:after {
    display: block;
    content: '';
    position: absolute;
    top: 0px;
    left: 5px;
    width: 1px;
    height: 100%;
    background: #333;
    }
    a:link {
    color: #4f4f4f;
    text-decoration: none;
}
.search-box ~ .board-list, .menu-title-area ~ .board-form, .menu-title-area ~ .board-list, .menu-title-area ~ .coupon-box, .menu-title-area ~ .top-search-box, .menu-title-area ~ .grid-list-wrap {
    margin-top: 10px;
}
.board-list {
    width: 100%;
    border-top: 1px solid #666;
}
.board-list table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
}
fieldset, img, table, caption, tbody, tfoot, thead, tr, th, td, button, hr {
    border: 0 none;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
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
    padding-top: .5rem;
    padding-bottom: .5rem;
    color: #6c757d;
    text-align: left;
}
.board-list table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
}
.board-list table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
}
*, ::after, ::before {
    box-sizing: border-box;
}
col {
    display: table-column;
    unicode-bidi: isolate;
}
.board-list table thead th {
    text-align: center;
    color: #000;
    border-bottom: 1px solid #ddd;
    font-weight: 500;
}
.board-list table th, .board-list table td {
    padding: 16px 10px;
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
fieldset, img, table, caption, tbody, tfoot, thead, tr, th, td, button, hr {
    border: 0 none;
}
address, caption, cite, code, dfn, em, strong, th, var {
    font-style: normal;
}
.board-list table {
    width: 100%;
    table-layout: fixed;
    border-collapse: collapse;
}
tbody {
    display: table-row-group;
    vertical-align: middle;
    unicode-bidi: isolate;
    border-color: inherit;
}
#tbl-my-delivery table td {
    font-size: 13px;
    line-height: 20px;
    letter-spacing: 0.002em;
}
.board-list table th, .board-list table td {
    padding: 16px 10px;
}
.board-list table th, .board-list table td {
    border-bottom: 1px solid #ddd;
    vertical-align: middle;
    word-break: break-all;
    line-height: 20px;
}
.text-center {
    text-align: center !important;
}
.custom-radio input[type="radio"] {
    position: absolute;
    width: 1px;
    height: 1px;
    padding: 0;
    margin: -1px;
    overflow: hidden;
    clip: rect(0, 0, 0, 0);
    border: 0;
}
label, select, input, textarea {
    vertical-align: middle;
}
.custom-radio {
    position: relative;
    display: inline-block;
}
input[type="radio" i] {
    background-color: initial;
    cursor: default;
    appearance: auto;
    box-sizing: border-box;
    margin: 3px 3px 0px 5px;
    padding: initial;
    border: initial;
}
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
#tbl-my-delivery table td {
    font-size: 13px;
    line-height: 20px;
    letter-spacing: 0.002em;
}
.custom-radio.single .radio + label {
    padding-left: 20px;
}
.custom-radio .radio + label {
    display: inline-block;
    color: #333;
    position: relative;
    padding-left: 28px;
    height: 20px;
    cursor: pointer;
    font-size: 16px;
    line-height: 1.4;
    vertical-align: top;
}
.blind {
    overflow: hidden;
    position: absolute;
    width: 1px;
    height: 1px;
    margin: -1px;
    padding: 0;
    border: 0;
    line-height: 0;
    white-space: normal;
    word-wrap: break-word;
    word-break: break-all;
    clip: rect(0, 0, 0, 0);
}
.custom-radio .radio:checked + label:before {
    background: #fff;
    border: 1px solid #ddd;
}
.custom-radio .radio + label:before {
    display: block;
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    width: 20px;
    height: 20px;
    text-align: center;
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 100%;
    box-sizing: border-box;
}
.custom-radio .radio + label {
    display: inline-block;
    color: #333;
    position: relative;
    padding-left: 28px;
    height: 20px;
    cursor: pointer;
    font-size: 16px;
    line-height: 1.4;
    vertical-align: top;
}
.blind {
    overflow: hidden;
    position: absolute;
    width: 1px;
    height: 1px;
    margin: -1px;
    padding: 0;
    border: 0;
    line-height: 0;
    white-space: normal;
    word-wrap: break-word;
    word-break: break-all;
    clip: rect(0, 0, 0, 0);
}
.custom-radio .radio:checked + label:after {
    content: '';
    position: absolute;
    top: 5px;
    left: 5px;
    width: 10px;
    height: 10px;
    background: #FF6001;
    border-radius: 100%;
}
*, ::after, ::before {
    box-sizing: border-box;
}
.custom-radio .radio + label {
    display: inline-block;
    color: #333;
    position: relative;
    padding-left: 28px;
    height: 20px;
    cursor: pointer;
    font-size: 16px;
    line-height: 1.4;
    vertical-align: top;
}
.text-center {
    text-align: center !important;
}
#tbl-my-delivery table td {
    font-size: 13px;
    line-height: 20px;
    letter-spacing: 0.002em;
}
.text-left {
    text-align: left !important;
}
.text-mint {
    color: #13A7B8;
}
.type4 {
    padding-inline-start: 0px;
}
.sep-list {
    overflow: inherit;
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
ol, ul {
    list-style: none;
}
.sep-list.type4 li {
    display: inline-block;
    float: none;
    vertical-align: top;
    padding: 0 10px 0 0;
    font-size: 12px;
    color: #666;
}
.sep-list li {
    float: left;
    position: relative;
    padding: 0 13px 0 0;
    color: #555;
    font-size: 13px;
    letter-spacing: -0.5px;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
    unicode-bidi: isolate;
}
a:link {
    color: #4f4f4f;
    text-decoration: none;
}
a {
    background: transparent;
    text-decoration: none;
    color: inherit;
}
.sep-list li:last-child {
    padding-right: 0;
}
.sep-list.type4 li {
    display: inline-block;
    float: none;
    vertical-align: top;
    padding: 0 10px 0 0;
    font-size: 12px;
    color: #666;
}
.sep-list li {
    float: left;
    position: relative;
    padding: 0 13px 0 0;
    color: #555;
    font-size: 13px;
    letter-spacing: -0.5px;
}
.sep-list.type4 li:before {
    height: 12px;
    background: #b2b2b2;
    margin: -2px 10px 0 0;
}
.sep-list li:before {
    display: inline-block;
    content: '';
    width: 1px;
    height: 10px;
    vertical-align: middle;
    background: #C4C4C4;
    margin: -1px 11px 0 0;
}
.sep-list.type4 li {
    display: inline-block;
    float: none;
    vertical-align: top;
    padding: 0 10px 0 0;
    font-size: 12px;
    color: #666;
}
.sep-list li:last-child {
    padding-right: 0;
}
.sep-list.type4 li {
    display: inline-block;
    float: none;
    vertical-align: top;
    padding: 0 10px 0 0;
    font-size: 12px;
    color: #666;
}
.sep-list:after {
    content: '';
    display: block;
    clear: both;
}
#radio-delivery-20220424000000577778{
    display: none;
}
.custom-radio .radio:checked + label:before {
    background: #fff;
    border: 1px solid #ddd;
}
.custom-radio .radio + label:before {
    display: block;
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    width: 20px;
    height: 20px;
    text-align: center;
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 100%;
    box-sizing: border-box;
}
.reply-area ~ .pagination, .banner-list-wrap ~ .pagination, .board-list ~ .pagination, .board-list ~ .btn-bottom-area, .board-form ~ .btn-bottom-area, .list-lately-wrap ~ .btn-bottom-area, .order-list-area ~ .pagination {
    margin-top: 20px;
}
.btn-bottom-area {
    margin-bottom: 35px;
    position: relative;
    text-align: center;
}
.btn-bottom-area > [class*="btn-"]:only-child {
    margin: 0;
}
.btn-bottom-area > [class*="btn-"]:not(.w-full) {
    margin: 0 3px;
    vertical-align: top;
}
[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
    cursor: pointer;
}
.btn-navy {
    color: #fff;
    background: #3a4c67;
    border: 1px solid #3a4c67;
}
.btn-basic-lg2 {
    min-width: 180px;
    height: 48px;
    padding: 10px 25px 11px;
}
[class*="btn-basic-"], [class*="btn-option"] {
    border-radius: 6px;
}
[class*="btn-basic-"], [class*="btn-option"], [class*="btn-rud-"] {
    display: inline-block;
    text-align: center;
    border: 1px solid transparent;
    box-sizing: border-box;
    vertical-align: top;
}
.btn-basic-lg2 > span {
    font-size: 15px;
    line-height: 1.8;
}
[class*="btn-basic-"] > span, [class*="btn-option"] > span, [class*="btn-rud-"] > span {
    display: inline-block;
    vertical-align: top;
}
button span {
    position: relative;
}
.btn-bottom-area:after {
    display: block;
    content: '';
    clear: both;
}
*, ::after, ::before {
    box-sizing: border-box;
}
</style>