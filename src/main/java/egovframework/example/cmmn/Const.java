package egovframework.example.cmmn;

public class Const {
	// 예외 처리 - HashMap key 값
	public static final String MSG_KEY = "MSG";
	public static final String ERRORS_KEY = "ERRORS";
	public static final String IBOARD_KEY = "IBOARD";
	// 예외 처리 - 'code <= 0'이 true 일 경우 예외 처리를 위한 에러 코드로 인식
	public static final int SUCCESS = 1;
	// 예외 처리 - default 실패 플래그 값(추후 에러 코드 변경하기)
	public static final int FAIL = 0;
	// 예외 처리 - 비동기 통신 요청 시 플래그 값으로 사용
	public static final int INTERNAL_SERVER_ERROR = -5;
	public static final int PASHED_PASSWORD_FAIL_ERROR = -1;
	public static final int VALIDATION_ERROR = -2;
	public static final int NULL_POINTER_EXCEPTION = -4;
	
	// 답변글 여부
	public static final String REPLY_FL = "Y";
	public static final String UN_REPLY_FL = "N";
	
	public static final int UN_REPLY_CODE = 0;
	
	// 확장명
//	public static final String[] EXT_EXCEPTION_ARR = {".exe", ".gif", ".zip"};
	
	// 유효성 검증 - 필드 멤버명
	public static final String FIELD_NAME = "name";
	public static final String FIELD_PWD = "pwd";
	public static final String FIELD_TITLE = "title";
	public static final String FIELD_CONTENTS = "contents";
	
	// 유효성 검증 - 필드 멤버명 컨버터용
	public static final String FIELD_NAME_CONVERT = "작성자";
	public static final String FIELD_PWD_CONVERT = "패스워드";
	public static final String FIELD_TITLE_CONVERT = "제목";
	public static final String FIELD_CONTENTS_CONVERT = "내용";
	
}