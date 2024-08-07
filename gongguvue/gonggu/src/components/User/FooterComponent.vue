<template>
<footer>
    <div id="top_footer_border_area">
        <div id="top_footer_area">
            <ul>
                <li>회사소개</li>
                <li>이용약관</li>
                <li>운영정책</li>
                <li>개인정보처리방침</li>
                <li>청소년보호정책</li>
            </ul>
        </div>
    </div>
    <div id="mid_footer_area" class="container text-center">
        <div class="row">
            <div class="col mid_footer_areas">
                <div class="mid_footer_left">
                    <p>공구공구(주) 사업자정보</p>
                    <p>
                        대표이사 : 강태성, 서재은 | 개인정보보호책임자 : 도지민, 김우혁<br>
                        사업자등록번호 : 111-11-11111 | 통신판매업신고 : 1111-서울동작-1111<br>
                        호스팅서비스 제공자 : Amazon Web Services (AWS)<br>
                        EMAIL : help@gonggu.co.kr | FAX : 02-111-1111<br>
                        주소 : 서울특별시 동작구 보라매로 1길 1, 1, 11층<br>
                        (신대방동, SFC빌딩)<br>
                        <span>사업자정보 확인</span>
                    </p>
                </div>
                <div class="mid_footer_left2">
                    <div>
                    </div>
                </div>
            </div>
            <div class="col mid_footer_right_area">
                <div class="mid_footer_right">
                    <p>고객센터 ></p>
                    <p>1111-1111</p>
                    <p>운영시간 9시 - 18시 (주말/공휴일 휴무, 점심시간 12시 - 13시)</p>
                    <span>공지사항</span> <span>문의하기</span><span>자주 묻는 질문</span>
                </div>
                <div id="mid_footer_right2">
                </div>
            </div>
            <!-- <div id="bot_footer_area">
                <div class="bot_footer_left">
                </div>
                <div class="bot_footer_right">
                    <p></p>
                </div>
            </div> -->
        </div>
    </div>
</footer>
</template>

<script>
export default {
    name: "FooterComponent",
    data() {
        return { 
        }
    },
    methods: {

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

/* footer 영역 */
/* 상단 footer */
footer {
    font-size: 14px;
    border-top: 1px solid rgb(229, 229, 229);
    letter-spacing: -1px;
}
#top_footer_border_area {
    border-bottom: 1px solid rgb(229, 229, 229);
}
#top_footer_area:hover {
    cursor: pointer;
}
#top_footer_area > ul {
    width: 1024px;
    height: 64px;
}
#top_footer_area > ul > li {
    display: inline-block;
    padding: 15px;
    height: 64px;
    line-height: 32px;
}
#top_footer_area > ul > li::after {
    content: "|";
    float: right;
    color: rgb(204, 204, 204);
    margin-right: -17px;
}
#top_footer_area > ul > li:nth-child(4) {
    font-weight: bold;
}
/* // 상단 footer */
/* 중단 footer */
#mid_footer_area {
    margin-top: 40px;
    margin-bottom: 40px;
}
.mid_footer_areas {
    text-align: left;
}
.mid_footer_left {
    color: #666;
}
.mid_footer_left > p:first-child {
    color: #666;
    font-weight: bold;
}
.mid_footer_left > p:last-child {
    margin-top: 8px;
    font-size: 12px;
    line-height: 23px;
}
.mid_footer_left span {
    text-decoration: underline;
}

.mid_footer_left2 {
    margin-top: 24px;
    font-size: 12px;
    line-height: 23px;
    color: #666;
}
.mid_footer_left2 > div > p {
    margin-top: 6px;
}

.mid_footer_right_area {
    text-align: left;
    color: #666;
}
.mid_footer_right p {
    margin-bottom: 3px;
}
.mid_footer_right > p:first-child, #mid_footer_right2 > p:nth-child(1) {
    font-weight: bold;
}
.mid_footer_right > p:nth-child(2) {
    font-size: 24px;
    font-weight: bold;
}
.mid_footer_right > p:nth-child(3), #mid_footer_right2 > p:nth-child(2), #mid_footer_right2 > p:nth-child(4) {
    font-size: 12px;
}
.mid_footer_right span {
    font-size: 12px;
    text-decoration: underline;
    margin-right: 13px;
}

#mid_footer_right2 p {
    margin-bottom: 10px;
}
#mid_footer_right2 {
    margin-top: 40px;
}
#mid_footer_right2 > p:nth-child(3) {
    font-size: 12px;
    text-decoration: underline;
}

#bot_footer_area {
    margin-top: 40px;
    border-top: 1px solid rgb(229, 229, 229);
    font-size: 11px;
    color: #999;
}
.bot_footer_left, .bot_footer_right {
    width: 512px;
}
.bot_footer_left {
    float: left;
}
.bot_footer_left > div {
    
    width: 31px;
}
.bot_footer_left > div > img {
    width: 31px;
    position: relative;
    top: 20px;
}
.bot_footer_left > p {
    width: 480px;
    text-align: left;
    margin-left: 40px;
    position: relative;
    top: -10px;
}

.bot_footer_right {
    float: right;
    position: relative;
    top: -43px;
}

</style>