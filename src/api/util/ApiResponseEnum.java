package api.util;

public enum ApiResponseEnum {

	AuthError001("1001", "��Ȩ��Ϣȱʧ"), //
	AuthError002("1002", "�û���֤��ͨ��"), //
	AuthError003("1003", "�û���Ϣ�ѹ���"), //
	ErrorParams("1010", "�����������ȷ"), //
	ErrorConfig("1020", "û���ҵ���Ӧ�Ľӿ�����"),//
	;

	private String code;
	private String msg;

	private ApiResponseEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getDes() {
		return "�ӿڴ�����룺" + code + " _ " + msg;
	}
}
