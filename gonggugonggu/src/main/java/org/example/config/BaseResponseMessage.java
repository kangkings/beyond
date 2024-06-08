package org.example.config;

public enum BaseResponseMessage {

    //연결 관련(HTTP, 서버 등) 1000
    HTTP_SUCCESS(true,1000,"good"),
    HTTP_FAIL(false,1001,"no good");


    //일반 회원 관련 2000



    //업체 회원 관련 3000



    //공구 관련 4000



    //입찰 관련 5000



    //결제 관련 6000



    //게시판 관련 7000





    private Boolean isSuccess;
    private Integer code;
    private String message;

    BaseResponseMessage(Boolean isSuccess, Integer code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    BaseResponseMessage() {
    }
}
