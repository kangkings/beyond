<template>
        <div class="frame-right">
        <form id="submitForm" name="submitForm" method="post">
            <h2 class="stit"><span>회원정보수정</span></h2>
            <div class="form_section">
                <div class="content_intro">
                    <h3>필수정보입력</h3>
                    <p class="join_txt">
                        <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"> 표시는 필수입력 항목 이오니 반드시 입력해 주세요.
                    </p>
                </div>
                <fieldset class="fieldset medium">
                    <legend>항목입력</legend>
                    <div class="field">
                        <span class="label">아이디 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
                        <div class="insert" id="idCheckDiv">
                            
                                <span>{{userBasicStore.userInfoDetail.email}}</span>
                            
                            
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">이름 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
                        <div class="insert">
                            <span id="mbrNm">강태성</span>
                        </div>
                    </div>
                    
                    <div class="field">
                        <span class="label">생년월일
                        </span>
                        <div class="insert">
                            <span id="userBirth">1997-05-13</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">성별</span>
                        <div class="insert">
                            <span id="userSex">남</span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">주소 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
                        <div class="insert">
                            <input type="text" id="email" name="email"  value="" class="input_text small translated" style="width:250px" maxlength="50"><span class="trans_placeholder blind" ></span>
                            <button class="searchAddrBtn" style="border: 0.5px solid #666; width: 80px;" onclick="searchAddr()">우편번호검색</button>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">상세주소 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
                        <div class="insert">
                            <input type="text" id="email" name="email"  value="" class="input_text small translated" style="width:250px" maxlength="50"><span class="trans_placeholder blind" ></span>
                        </div>
                    </div>
                    <div class="field">
                        <span class="label">우편번호 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
                        <div class="insert">
                            <input type="text" id="email" name="email"  value="" class="input_text small translated" style="width:100px" maxlength="50"><span class="trans_placeholder blind" ></span>
                        </div>
                    </div>
                    <div class="field">
                        <label for="mbrCntsELno" class="label">휴대폰번호 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
                        <input type="hidden" name="cntsTypeCd" value="20">
                        <input type="hidden" name="mbrCntsno" id="mbrCntsno">
                        <div class="insert">
                            <div>
                                <select id="mbrCntsano" name="mbrCntsano" title="식별번호 선택" class="select small" style="width: 102px;">
                                    <option value="010" addtoptnval1="" addtoptnval2="" selected="selected">010</option><option value="011" addtoptnval1="" addtoptnval2="">011</option><option value="016" addtoptnval1="" addtoptnval2="">016</option><option value="017" addtoptnval1="" addtoptnval2="">017</option><option value="018" addtoptnval1="" addtoptnval2="">018</option><option value="019" addtoptnval1="" addtoptnval2="">019</option>
                                </select>
                                <span>-</span>
                                <input type="tel" id="mbrCntsELno" title="휴대폰 번호 뒷자리" placeholder="- 없이 뒷자리를 입력해주세요." value="47541175" class="input_text small translated" style="width:136px;ime-mode:disabled;" maxlength="8" numberonly=""><span class="trans_placeholder blind" data-default-txt="- 없이 뒷자리를 입력해주세요.">- 없이 뒷자리를 입력해주세요.</span>
                            </div>
                        </div>
                    </div>


                    
                    <div class="field" id="emailChg01">
                        <label for="email" class="label">이메일주소 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
                        <div class="insert">
                            <input type="text" id="email" name="email" placeholder="자주 사용하시는 이메일 주소를 입력해주세요." value="dlflq11@gmail.com" class="input_text small translated" style="width:250px" maxlength="50"><span class="trans_placeholder blind" data-default-txt="자주 사용하시는 이메일 주소를 입력해주세요.">자주 사용하시는 이메일 주소를 입력해주세요.</span>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="form_btn_area">
                <p id="alertArea" class="desc"></p>
                <a href="javascript:void(0);" onclick="modify.update();" id="submitBtn" class="cs_btn large black">변경하기</a>
            </div>
            <div class="cs_info_box">
                <h3 class="cs_info_subtit">회원정보변경 안내</h3>
                <ul class="cs_info_lst">
                    <li>배송지 정보는 '나의 정보관리 &gt; 배송지 관리' 메뉴에서 추가/수정/삭제하실 수 있습니다.</li>
                    <li>주문 정보는 회원 정보에 등록된 휴대폰번호 및 이메일주소로 안내됩니다.</li>
                </ul>
            </div>
        </form>
    <div class="frame-cnt-inner">
    
    </div>
    </div><!--// content-wrap -->
</template>

<script>
import { mapStores } from 'pinia';
import { userBasicStore } from '@/stores/userBasicStore';
export default {
    name: "UserMypageInfoEditComponent",
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

.frame-right{
    width: 100%;
    padding: 0 4rem;
}

</style>