<template>
    <!-- modal -->
    <div class="layer-wrap" ref="modal" id="modal-my-delivery" style="display: block;">
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
                                                        <input type="checkbox" v-model="request.addressDefault" id="check-101" class="checkbox"
                                                            name="vBasicDlvYn"  value="Y">
                                                        <label for="check-101"> 기본배송지로 등록</label>
                                                    </div>
                                                    <h3>주소 <em class="es"><span class="blind">필수입력</span></em></h3>
                                                    <div class="block">
                                                        <div class="input-group">
                                                            <input type="text" v-model="request.postCode" name="vPostcd" title="" id="postCd"
                                                                class="input-text" placeholder="우편번호"
                                                                readonly="readonly" value="{{ request.postCode }}">
                                                            <span class="input-group-btn">
                                                                <a href="#" class="btn-ex-white" @click="openPostcode"
                                                                    style="border-radius: 4px;height: 50px;min-width: 90px;line-height: 50px;"><span>우편번호
                                                                        찾기</span></a>
                                                            </span>
                                                        </div>
                                                        <div class="input-group w-full">
                                                            <input type="text" v-model="basicAddr" name="vAddr" title="" id="addr"
                                                                class="input-text" placeholder="기본주소"
                                                                readonly="readonly" value="">
                                                        </div>
                                                        <div class="input-group w-full">
                                                            <input type="text" v-model="detailAddr" name="vAddrDtl" title=""
                                                                class="input-text removeEmoji" placeholder="상세주소"
                                                                value="" maxlength="80">
                                                        </div>
                                                        <div class="input-group w-full">
                                                            <input type="text" v-model="request.addressName" name="vAddrDtl" title=""
                                                                class="input-text removeEmoji" placeholder="배송지명"
                                                                value="" maxlength="80">
                                                        </div>
                                                    </div>


                                                </div>
                                            </div>
                                        </div><!--// layer-content -->

                                        <div class="layer-bottom type-shadow">
                                            <div class="btn-area">
                                                <button type="button" class="btn-basic-lg2 btn-black btn-save-delivery"
                                                    @click="saveModal"><span>저장</span></button>
                                            </div>
                                        </div>

                                        <button id="closeBtn" type="button" class="btn-x-md2 ui-close-pop" title=""
                                            @click="closeModal"><i class="ico-x-black"></i><span
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
</template>

<script>
export default {
    name: "UserMypageAddAddressComponent",
    data() {
        return { basicAddr: "", detailAddr:"",request:{
            addressName: "",
            addressInfo: "",
            postCode: "",
            addressDefault: false,
        }
        }
    },
    methods: {
        openPostcode(){
            let width = 500;
            let height = 600;
            
            // eslint-disable-next-line no-undef
            new daum.Postcode({
                width: width,
                height: height,
                oncomplete: (data) => {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                    // 예제를 참고하여 다양한 활용법을 확인해 보세요.
                    
                    this.basicAddr = data.address;
                    this.request.postCode = data.zonecode;
                }
            }).open({
                left: (window.screen.width / 2) - (width / 2),
                top: (window.screen.height / 2) - (height / 2)
            });
                
        },
        
        closeModal(){
            this.$emit("close-modal", "close-modal");
        },
        saveModal(){
            this.request.addressInfo = this.basicAddr +","+this.detailAddr;
            this.$emit("save-modal", this.request);
            this.basicAddr = "";
            this.detailAddr = "";
            this.request.addressInfo = "";
            this.request.addressInfo = "";
            this.request.addressName = "";
            this.request.postCode = "";
        }
    },
}

</script>

<style scoped>
html, body, div, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, address, big, cite, code, del, dfn, em, font, img, ins, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, ul, ol, li, dl, dt, dd, table, caption, tbody, tfoot, thead, tr, th, td, fieldset, form, label, legend, input, button, textarea, select {
    margin: 0;
    padding: 0;
}
.layer-wrap {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 10001;
}
*, ::after, ::before {
    box-sizing: border-box;
}
.layer-wrap:before {
    display: block;
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.6);
    z-index: 100;
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
.layer-pop.dlv-addr-pop {
    width: 510px;
    height: 720px;
}
.layer-wrap .layer-pop {
    position: absolute;
    top: 50%;
    left: 50%;
    z-index: 100;
    background-color: #fff;
    -webkit-transform: translate3d(0, 0, 0) translateZ(1);
    transform: translate3d(0, 0, 0) translateZ(1);
    transform: translateY(-50%) translateX(-50%);
    -webkit-transform: translateY(-50%) translateX(-50%);
    backface-visibility: hidden;
    -webkit-backface-visibility: hidden;
}
.layer-pop.dlv-addr-pop .layer-inner {
    height: 100%;
}
.layer-pop .layer-inner {
    position: relative;
}
.layer-pop.dlv-addr-pop .layer-head {
    border-bottom: 1px solid #ccc;
}
.layer-pop .layer-inner .layer-head {
    padding: 20px 30px;
}
.layer-head .layer-pop-title {
    font-size: 20px;
    font-weight: 500;
    line-height: 20px;
}
#userDeliveryForm .layer-pop.dlv-addr-pop .layer-content:has(> .delivery-notice) {
    overflow-y: scroll;
    /* height: 560px; */
    padding-top: 0;
    padding-bottom: 40px;
}
.layer-pop.dlv-addr-pop .layer-content {
    padding: 20px 0 0;
    /* height: calc(100% - 145px); */
}
.layer-pop.dlv-addr-pop .delivery-notice {
    background: #FFF8F4;
    padding: 20px 30px;
    margin-bottom: 20px;
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
.layer-pop.dlv-addr-pop .delivery-notice li {
    color: #333;
    font-size: 12px;
    font-weight: 400;
    line-height: 18px;
    margin-bottom: 4px;
}
ul li {
    list-style: none;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
    unicode-bidi: isolate;
}
.layer-pop.dlv-addr-pop .delivery-notice li::before {
    content: "";
    width: 3px;
    height: 3px;
    border-radius: 50%;
    background: #333;
    display: inline-block;
    margin-right: 6px;
    vertical-align: middle;
}
*, ::after, ::before {
    box-sizing: border-box;
}
.layer-pop.dlv-addr-pop .delivery-notice li {
    color: #333;
    font-size: 12px;
    font-weight: 400;
    line-height: 18px;
    margin-bottom: 4px;
}
#userDeliveryForm .layer-pop.dlv-addr-pop .layer-content .delivery-notice ~ .inner {
    overflow-y: hidden;
    max-height: initial !important;
}
.layer-pop.dlv-addr-pop .layer-content .inner {
    padding: 0 30px;
    max-height: 340px;
    overflow-y: scroll;
}
.custom-checkbox {
    margin-top: 8px;
    position: relative;
    display: inline-block;
    vertical-align: top;
}
custom-checkbox input[type="checkbox"] {
    position: absolute;
    width: 1px;
    height: 1px;
    padding: 0;
    margin: -1px;
    overflow: hidden;
    clip: rect(0, 0, 0, 0);
    border: 0;
    vertical-align: top;
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
.layer-pop.dlv-addr-pop .lineless-table .custom-checkbox input[type="checkbox"] + label {
    font-size: 13px;
}
.custom-checkbox input[type="checkbox"] + label {
    display: inline-block;
    position: relative;
    cursor: pointer;
    vertical-align: top;
}
.custom-checkbox .checkbox + label {
    padding-left: 26px;
    min-height: 18px;
}
.layer-pop.dlv-addr-pop .custom-checkbox .checkbox + label:before {
    border-radius: 4px;
}
.custom-checkbox .checkbox + label:before {
    display: block;
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    width: 18px;
    height: 18px;
    text-align: center;
    background: #fff;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
.layer-pop.dlv-addr-pop .lineless-table .custom-checkbox input[type="checkbox"] + label {
    font-size: 13px;
}
.custom-checkbox input[type="checkbox"] + label {
    display: inline-block;
    position: relative;
    cursor: pointer;
    vertical-align: top;
}
.layer-pop.dlv-addr-pop h3 {
    margin-top: 20px;
    font-size: 15px;
    font-weight: 700;
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
address, caption, strong[lang=en], em, cite, b {
    font-weight: normal;
    font-style: normal;
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
.es:after {
    display: inline-block;
    content: "";
    margin-top: 5px;
    margin-left: 2px;
    width: 5px;
    height: 5px;
    border-radius: 50%;
    vertical-align: top;
    background: #FF6001;
}
.layer-pop.dlv-addr-pop .block {
    margin-top: 8px;
}
.input-group {
    height: 40px;
}
.input-group {
    position: relative;
    display: table;
    border-collapse: collapse;
    /* width: 100%; */
}
.input-group {
    position: relative;
    display: flex;
    flex-wrap: wrap;
    align-items: stretch;
    width: 100%;
}
.input-group:not(.has-validation)>.dropdown-toggle:nth-last-child(n+3), .input-group:not(.has-validation)>.form-floating:not(:last-child)>.form-control, .input-group:not(.has-validation)>.form-floating:not(:last-child)>.form-select, .input-group:not(.has-validation)>:not(:last-child):not(.dropdown-toggle):not(.dropdown-menu):not(.form-floating) {
    border-top-right-radius: 0;
    border-bottom-right-radius: 0;
}
.layer-pop.dlv-addr-pop .input-text {
    border-radius: 4px;
    height: 50px;
}
.input-group .input-text {
    height: 100%;
    /* height: 40px; */
    padding: 3px 15px;
}
.input-group > .input-text {
    position: relative;
    display: table-cell;
    float: left;
    width: 100%;
    z-index: 2;
}
input[readonly] {
    background-color: #F3F8FF;
    border: 1px solid #ccc;
    opacity: 1;
    color: 
    #333;
}
.input-text {
    height: 40px;
    padding: 5px 15px;
    background: #fff;
    color: #333;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-size: 13px;
    border-radius: 0;
}
.input-group>.form-floating:not(:first-child)>.form-control, .input-group>.form-floating:not(:first-child)>.form-select, .input-group>:not(:first-child):not(.dropdown-menu):not(.form-floating):not(.valid-tooltip):not(.valid-feedback):not(.invalid-tooltip):not(.invalid-feedback) {
    margin-left: -1px;
    border-top-left-radius: 0;
    border-bottom-left-radius: 0;
}
.input-group > .input-text + .input-group-form:last-child, .input-group > .input-text + .input-group-btn:last-child {
    padding: 0 0 0 5px;
}
.input-group > .input-group-form, .input-group > .input-group-btn {
    display: table-cell;
    position: relative;
    white-space: nowrap;
    width: 1%;
    vertical-align: middle;
    border: 0;
    padding: 0 5px;
}
a:link {
    color: #4f4f4f;
    text-decoration: none;
}
.btn-ex-white {
    display: inline-block;
    background-color: #fff;
    font-size: 13px;
    min-width: 100px;
    height: 40px;
    line-height: 40px;
    text-align: center;
    color: #333;
    border: 1px solid #333;
}
a {
    text-decoration: none;
    cursor: pointer;
}
style attribute {
    border-radius: 4px;
    height: 50px;
    min-width: 90px;
    line-height: 50px;
}
.lineless-table .input-group-wrap + .input-text, .lineless-table .input-group + .input-group {
    margin-top: 6px;
}
.wp100, .w-full {
    width: 100% !important;
}
.input-group {
    height: 40px;
}
.input-group {
    position: relative;
    display: table;
    border-collapse: collapse;
    /* width: 100%; */
}
.input-group > .input-text {
    position: relative;
    display: table-cell;
    float: left;
    width: 100%;
    z-index: 2;
}
input:not([type="file" i], [type="image" i], [type="checkbox" i], [type="radio" i]) {
}
input:not([type="file" i], [type="image" i], [type="checkbox" i], [type="radio" i]) {
}
.layer-pop .layer-inner .layer-bottom.type-shadow {
    position: relative;
    z-index: 10;
    box-shadow: 0px -2px 8px rgba(0, 0, 0, 0.1);
}
.layer-pop .layer-inner .layer-bottom {
    padding: 20px 30px 30px;
}
.layer-pop.dlv-addr-pop .layer-bottom {
    position: absolute;
    bottom: 0;
    left: 0;
}
.layer-pop .layer-inner .layer-bottom {
    width: 100%;
    padding: 20px 30px 30px;
    background: #fff;
}
.layer-pop .layer-inner .layer-bottom .btn-area {
    position: relative;
    text-align: center;
    clear: both;
}
.layer-pop.dlv-addr-pop .layer-bottom .btn-area > [class*="btn-"] {
    max-width: none;
}
.layer-bottom .btn-area > [class*="btn-"]:only-child {
    margin: 0;
    width: 100%;
    max-width: none;
}
.btn-basic-lg2 > span {
    font-size: 15px;
    line-height: 1.8;
}
[class*="btn-basic-"] > span, [class*="btn-option"] > span, [class*="btn-rud-"] > span {
    display: inline-block;
    vertical-align: top;
}
[class*="btn-basic-"] > span, [class*="btn-option"] > span, [class*="btn-rud-"] > span {
    display: inline-block;
    vertical-align: top;
}
[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
    cursor: pointer;
}
.btn-black {
    color: #fff;
    background: #333;
    border: 1px solid #333;
}
[class*="btn-basic-"], [class*="btn-option"], [class*="btn-rud-"] {
    display: inline-block;
    text-align: center;
    border: 1px solid transparent;
    box-sizing: border-box;
    vertical-align: top;
}
button {
 
    text-rendering: auto;
    letter-spacing: normal;
    word-spacing: normal;
    line-height: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    text-align: center;
    cursor: default;
}
.layer-bottom .btn-area:after {
    display: block;
    content: '';
    clear: both;
}
.layer-pop .layer-inner .ui-close-pop.btn-x-md2 {
    height: 30px;
    padding: 0;
}
.layer-pop .layer-inner .ui-close-pop {
    position: absolute;
    top: 15px;
    right: 25px;
}
[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
    cursor: pointer;
}
button, [type="button"], [type="reset"], [type="submit"] {
    -webkit-appearance: none;
    appearance: none;
    cursor: pointer;
    /* border: 0; */
    padding: 0;
    background-image: none;
}
.btn-x-md2 [class^="ico-x-"] {
    width: 20px;
    height: 20px;
}
.ico-x-black {
    color: #333;
}
[class^="ico-x-"] {
    position: relative;
    display: block;
    width: 20px;
    height: 20px;
}
.btn-x-md2 [class^="ico-x-"]:before, .btn-x-md2 [class^="ico-x-"]:after {
    height: 1px;
}
[class^="ico-x-"]:before {
    transform: rotate(45deg);
}
[class^="ico-x-"]:before, [class^="ico-x-"]:after {
    position: absolute;
    top: 50%;
    left: -3px;
    display: block;
    content: '';
    width: 130%;
    height: 1px;
    /* background: #666; */
    box-shadow: inset 0 0 0 32px;
}
.ico-x-black {
    color: #333;
}
[class^="ico-x-"]:after {
    bottom: 0;
    transform: rotate(-45deg);
}
[class^="ico-x-"]:before, [class^="ico-x-"]:after {
    position: absolute;
    top: 50%;
    left: -3px;
    display: block;
    content: '';
    width: 130%;
    height: 1px;
    /* background: #666; */
    box-shadow: inset 0 0 0 32px;
}
i {
    font-style: italic;
}
button .blind {
    position: relative;
    font-size: 0;
    color: transparent;
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
.btn-black {
    color: #fff;
    background: #333;
    border: 1px solid #333;
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
[type=button][data-v-d42245a0]:not(:disabled), [type=reset][data-v-d42245a0]:not(:disabled), [type=submit][data-v-d42245a0]:not(:disabled), button[data-v-d42245a0]:not(:disabled) {
    cursor: pointer;
}
button[data-v-d42245a0], [type="button"][data-v-d42245a0], [type="reset"][data-v-d42245a0], [type="submit"][data-v-d42245a0] {
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    cursor: pointer;
    /* border: 0; */
    padding: 0;
    background-image: none;
}
button[data-v-d42245a0] {
    text-rendering: auto;
    letter-spacing: normal;
    word-spacing: normal;
    line-height: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    text-align: center;
    cursor: default;
}
[class^="ico-x-"][data-v-d42245a0]:before, [class^="ico-x-"][data-v-d42245a0]:after {
    position: absolute;
    top: 50%;
    left: -3px;
    display: block;
    content: '';
    width: 130%;
    height: 1px;
    /* background: #666; */
    box-shadow: inset 0 0 0 32px;
}
[class^="ico-x-"][data-v-d42245a0]:before {
    transform: rotate(45deg);
}
[data-v-d42245a0], [data-v-d42245a0]::after, [data-v-d42245a0]::before {
    box-sizing: border-box;
}
#closeBtn{
    border: none;
    background: none;
}
</style>