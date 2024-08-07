<template>

    <div class="frame-right">
        <form id="submitForm" name="submitForm" method="post">
            <h2 class="stit"><span class="sub-title">내 정보</span></h2>
            <div class="form_section">
                <div class="content_intro">
                    <h3>회원정보조회</h3>
                </div>
                <fieldset class="fieldset medium">
                    <div class="field">
                        <span class="label">이메일</span>
                        <div class="insert">
                            <span id="userEmail">{{userBasicStore.userInfoDetail.email}}</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">이름</span>
                        <div class="insert">
                            <span id="userName">{{userBasicStore.userInfoDetail.name}}</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">생년월일</span>
                        <div class="insert">
                            <span id="userBirth">{{userBasicStore.userInfoDetail.birth}}</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">성별</span>
                        <div class="insert">
                            <span id="userSex">{{userBasicStore.userInfoDetail.sex}}</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">주소</span>
                        <div class="insert">
                            <span id="userAddress">{{userBasicStore.userInfoDetail.address}}</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">우편번호</span>
                        <div class="insert">
                            <span id="userPostCode">{{userBasicStore.userInfoDetail.postCode}}</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">휴대폰 번호</span>
                        <div class="insert">
                            <span id="userPhoneNumber">{{userBasicStore.userInfoDetail.phoneNumber}}</span>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="form_btn_area">
                <p id="alertArea" class="desc"></p>
                <button type="button" id="submitBtn" class="cs_btn large black" @click.prevent="changeComponent('UserMypageInfoEditComponent')">수정하기</button>
            </div>
            <div class="cs_info_box">
                <h3 class="cs_info_subtit">회원정보변경 안내</h3>
                <ul class="cs_info_lst">
                    <li>배송지 정보는 '나의 정보관리 &gt; 배송지 관리' 메뉴에서 추가/수정/삭제하실 수 있습니다.</li>
                    <li>주문 정보는 회원 정보에 등록된 휴대폰번호 및 이메일주소로 안내됩니다.</li>
                </ul>
            </div>
        </form>
        <!-- frame-cnt-inner 닫는 div 제거 -->
    </div><!--// content-wrap -->

</template>

<script>
import { mapStores } from 'pinia';
import { userBasicStore } from '@/stores/userBasicStore';

export default {
    name: "UserMypageInfoDetailComponent",
    data() {
        return {
            // 필요한 데이터 추가
        };
    },
    computed: {
        ...mapStores(userBasicStore)
    },
    methods: {
        // 필요한 메소드 추가
        changeComponent(componentName) {
            this.$emit('change-component', componentName);
            console.log(componentName);
        },
    
    },
};
</script>

<style scoped>
/* 필요한 스타일 추가 */
.field{
    font-size: 0.75em;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;

}

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
*, ::after, ::before {
    box-sizing: border-box;
}
body {
    position: relative;
    line-height: 1.5em;
    font-size: 0.75em;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
}
body {
    position: relative;
    line-height: 1.5em;
    font-size: 0.75em;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
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
body {
    color: black;
    font-size: 15px;
}
body {
    margin: 0;
    font-family: var(--bs-body-font-family);
    font-size: var(--bs-body-font-size);
    font-weight: var(--bs-body-font-weight);
    line-height: var(--bs-body-line-height);
    color: var(--bs-body-color);
    text-align: var(--bs-body-text-align);
    background-color: var(--bs-body-bg);
    -webkit-text-size-adjust: 100%;
    -webkit-tap-highlight-color: transparent;
}
:root {
    --swiper-theme-color: #007aff;
}
:root {
    --bs-blue: #0d6efd;
    --bs-indigo: #6610f2;
    --bs-purple: #6f42c1;
    --bs-pink: #d63384;
    --bs-red: #dc3545;
    --bs-orange: #fd7e14;
    --bs-yellow: #ffc107;
    --bs-green: #198754;
    --bs-teal: #20c997;
    --bs-cyan: #0dcaf0;
    --bs-black: #000;
    --bs-white: #fff;
    --bs-gray: #6c757d;
    --bs-gray-dark: #343a40;
    --bs-gray-100: #f8f9fa;
    --bs-gray-200: #e9ecef;
    --bs-gray-300: #dee2e6;
    --bs-gray-400: #ced4da;
    --bs-gray-500: #adb5bd;
    --bs-gray-600: #6c757d;
    --bs-gray-700: #495057;
    --bs-gray-800: #343a40;
    --bs-gray-900: #212529;
    --bs-primary: #0d6efd;
    --bs-secondary: #6c757d;
    --bs-success: #198754;
    --bs-info: #0dcaf0;
    --bs-warning: #ffc107;
    --bs-danger: #dc3545;
    --bs-light: #f8f9fa;
    --bs-dark: #212529;
    --bs-primary-rgb: 13, 110, 253;
    --bs-secondary-rgb: 108, 117, 125;
    --bs-success-rgb: 25, 135, 84;
    --bs-info-rgb: 13, 202, 240;
    --bs-warning-rgb: 255, 193, 7;
    --bs-danger-rgb: 220, 53, 69;
    --bs-light-rgb: 248, 249, 250;
    --bs-dark-rgb: 33, 37, 41;
    --bs-white-rgb: 255, 255, 255;
    --bs-black-rgb: 0, 0, 0;
    --bs-body-color-rgb: 33, 37, 41;
    --bs-body-bg-rgb: 255, 255, 255;
    --bs-font-sans-serif: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", "Noto Sans", "Liberation Sans", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
    --bs-font-monospace: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
    --bs-gradient: linear-gradient(180deg, rgba(255, 255, 255, 0.15), rgba(255, 255, 255, 0));
    --bs-body-font-family: var(--bs-font-sans-serif);
    --bs-body-font-size: 1rem;
    --bs-body-font-weight: 400;
    --bs-body-line-height: 1.5;
    --bs-body-color: #212529;
    --bs-body-bg: #fff;
    --bs-border-width: 1px;
    --bs-border-style: solid;
    --bs-border-color: #dee2e6;
    --bs-border-color-translucent: rgba(0, 0, 0, 0.175);
    --bs-border-radius: 0.375rem;
    --bs-border-radius-sm: 0.25rem;
    --bs-border-radius-lg: 0.5rem;
    --bs-border-radius-xl: 1rem;
    --bs-border-radius-2xl: 2rem;
    --bs-border-radius-pill: 50rem;
    --bs-link-color: #0d6efd;
    --bs-link-hover-color: #0a58ca;
    --bs-code-color: #d63384;
    --bs-highlight-bg: #fff3cd;
}
html {
    -webkit-text-size-adjust: 100%;
    -ms-text-size-adjust: 100%;
    /* -ms-touch-action: none; */
}
*, ::after, ::before {
    box-sizing: border-box;
}
.frame-wrap, .clear:after, [class*="frame-"]:after {
    display: block;
    clear: both;
    content: '';
}
*, ::after, ::before {
    box-sizing: border-box;
}
form {
    display: block;
    margin-top: 0em;
    unicode-bidi: isolate;
}
form {
    display: block;
    margin-top: 0em;
    unicode-bidi: isolate;
}
body {
    margin: 0;
    font-family: var(--bs-body-font-family);
    font-size: var(--bs-body-font-size);
    font-weight: var(--bs-body-font-weight);
    line-height: var(--bs-body-line-height);
    color: var(--bs-body-color);
    text-align: var(--bs-body-text-align);
    background-color: var(--bs-body-bg);
    -webkit-text-size-adjust: 100%;
    -webkit-tap-highlight-color: transparent;
}
h2.stit {
    padding-top: 15px;
    border-bottom: 1px solid #203a4d;
    padding-bottom: 13px;
    
    padding-left: 10px;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
    font-size: 26px;
    color: #203a4d;
    line-height: 30px;
}
.stit {
    padding-left: 0px;
}
h2 {
    display: block;
    font-size: 1.5em;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    unicode-bidi: isolate;
}
h2 {
    margin: 0;
    padding: 0;
    font-size: 1em;
}
h2.stit {
    padding-top: 15px;
    border-bottom: 1px solid #203a4d;
    padding-bottom: 13px;
    padding-left: 10px;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
    font-size: 26px;
    color: #203a4d;
    line-height: 30px;
}
.form_section {
    margin-bottom: 30px;
}

.stit + .form_section .content_intro {
    margin-top: 30px;
}
.form_section .content_intro {
    
    overflow: unset;
}
.content_intro {
    position: relative;
}
.form_section .content_intro h3 {
    margin-top: 20px;
    margin-bottom: 10px;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
    font-size: 20px;
    color: #203a4d;
    line-height: 22px;
    letter-spacing: -1px;
    text-align: left;
}
.form_section .content_intro h3 {
    margin-top: 20px;
    margin-bottom: 10px;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
    font-size: 20px;
    color: #203a4d;
    line-height: 22px;
    letter-spacing: -1px;
    text-align: left;
}
.form_section .fieldset.medium {
    padding: 0;
    background: none;
}
.form_section .fieldset.medium {
    position: relative;
    margin-top: 1px;
    border-top: 1px solid #666;
    border-bottom: 1px solid #666;
}
html, body, div, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, address, big, cite, code, del, dfn, em, font, img, ins, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, ul, ol, li, dl, dt, dd, table, caption, tbody, tfoot, thead, tr, th, td, fieldset, form, label, legend, input, button, textarea, select {
    margin: 0;
    padding: 0;
}
fieldset {
    display: block;
    margin-inline-start: 2px;
    margin-inline-end: 2px;
    padding-block-start: 0.35em;
    padding-inline-start: 0.75em;
    padding-inline-end: 0.75em;
    padding-block-end: 0.625em;
    min-inline-size: min-content;
    border-width: 2px;
    border-style: groove;
    border-color: rgb(192, 192, 192);
    border-image: initial;
}
body {
    position: relative;
    line-height: 1.5em;
    font-size: 0.75em;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
}
.form_section legend {
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
legend {
    display: block;
    padding-inline-start: 2px;
    padding-inline-end: 2px;
    unicode-bidi: isolate;
    border-width: initial;
    border-style: none;
    border-color: initial;
    border-image: initial;
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
legend {
    float: left;
    width: 100%;
    padding: 0;
    margin-bottom: .5rem;
    font-size: calc(1.275rem + .3vw);
    line-height: inherit;
}
.form_section legend:before {
    display: block;
    width: 0;
    height: 0;
    font-size: 0;
    content: " ";
}
*, ::after, ::before {
    box-sizing: border-box;
}
.form_section legend {
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
.form_section .fieldset.medium .field {
    padding: 12px 10px;
}
.fieldset.medium .field {
    padding: 12px 10px;
    vertical-align: middle;
    border-top: 1px solid #e5e5e5;
}
.fieldset .field {
    zoom: 1;
}
html, body, div, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, address, big, cite, code, del, dfn, em, font, img, ins, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, ul, ol, li, dl, dt, dd, table, caption, tbody, tfoot, thead, tr, th, td, fieldset, form, label, legend, input, button, textarea, select {
    margin: 0;
    padding: 0;
}
.form_section .fieldset.medium .field .label {
    width: 154px;
    padding: 0;
    color: #222;
}
.fieldset.medium .field .label {
    width: 154px;
    line-height: 28px;
    font-weight: bold;
    color: #222;
}
.fieldset .field .label {
    float: left;
    display: inline;
    font-size: 12px;
}
.form_section .fieldset.medium .field .insert {
    margin-left: 154px;
    color: #666;
}
.fieldset.medium .field .insert {
    position: relative;
    margin-left: 154px;
    line-height: 28px;
    vertical-align: middle;
    zoom: 1;
}
.form_section .fieldset.medium .field .insert {
    margin-left: 154px;
    color: #666;
}
.fieldset.medium .field .insert {
    position: relative;
    margin-left: 154px;
    line-height: 28px;
    vertical-align: middle;
    zoom: 1;
}
.fieldset.medium .field:after {
    display: block;
    visibility: hidden;
    clear: both;
    width: 0;
    height: 0;
    content: "";
}
.form_section .fieldset.medium .field .label {
    width: 154px;
    padding: 0;
    color: #222;
}
.fieldset.medium .field .insert {
    position: relative;
    margin-left: 154px;
    line-height: 28px;
    vertical-align: middle;
    zoom: 1;
}
body {
    position: relative;
    line-height: 1.5em;
    font-size: 0.75em;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
}
.form_section .fieldset.medium .field .label {
    width: 154px;
    padding: 0;
    color: #222;
}
.form_btn_area {
    margin-top: 20px;
    text-align: center;
}
.form_btn_area p.desc {
    margin: 10px 0 20px;
    color: #f96a62;
}
p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    unicode-bidi: isolate;
}
.form_btn_area {
    margin-top: 20px;
    text-align: center;
}
.cs_btn.large.black {
    background: #f14f4f;
    border: 1px solid #da3a3a;
    color: #fff;
}
.cs_btn.large {
    min-width: 96px;
    padding: 11px 16px;
    text-align: center;
    font-size: 16px;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
    text-decoration: none;
    letter-spacing: -1px;
    line-height: 18px;
    
}
.cs_btn {
    display: inline-block;
}
a {
    text-decoration: none;
    cursor: pointer;
}
.cs_info_box {
    margin-top: 30px;
    text-align: left;
}
.frame-cnt-inner {
    width: 820px;
}
.cs_info_box .cs_info_subtit {
    padding-bottom: 10px;
    border-bottom: 1px solid #e8e8e8;
    font-size: 14px;
    line-height: 16px;
    letter-spacing: -0.28px;
    color: #222;
    font-family: "Pretendard", -apple-system, BlinkMacSystemFont, sans-serif;
    font-weight: 400;
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
.cs_info_box .cs_info_lst {
    overflow: hidden;
    padding: 15px 0;
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
.cs_info_box .cs_info_lst li:before {
    position: absolute;
    top: 8px;
    left: 0;
    width: 2px;
    height: 2px;
    background: #888;
    border-radius: 50%;
    content: "";
}
 ::after, ::before {
    box-sizing: border-box;
}
.cs_info_box .cs_info_lst li {
    position: relative;
    margin-top: 5px;
    padding-left: 8px;
    font-size: 12px;
    color: #888;
    line-height: 16px;
    letter-spacing: -0.28px;
}
ul li {
    list-style: none;
}
.cs_info_box .cs_info_lst li {
    position: relative;
    margin-top: 5px;
    padding-left: 8px;
    font-size: 12px;
    color: #888;
    line-height: 16px;
    letter-spacing: -0.28px;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
    unicode-bidi: isolate;
}
</style>
