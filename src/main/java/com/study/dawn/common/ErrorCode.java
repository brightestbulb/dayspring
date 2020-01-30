package com.study.dawn.common;


/*
 * Error Code Role
 * ********************
 * 코드 출력 : 000-000
 * 자리 번호 : 12 345
 * 구분 : [12][3]-[4][56]
 * ********************
 *  [12] | 메뉴 구분 |  01:[todoList]  02:[로그인]
 *  [3] | 작업 위치 |  0:[Front]   1:[Backend]   3:[Data]
 *  [4] | 코드 종류 |  9:[Error]
 *  [56]| 코드 번호 | 01~99
 *
 */
public enum  ErrorCode {

    INTERNAL_SERVER_ERROR("011-901"),  // Internal Server Error, 서버 에러
    INVALID_DATA("11");                // 요청한 데이터가 잘못 되었습니다.

    private String code;

    ErrorCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public String toString(){
        return String.format("CODE_ERROR[%s]", this.code);
    }
}
