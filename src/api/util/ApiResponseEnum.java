package api.util;

public enum ApiResponseEnum {

	AuthError001("1001", "鉴权信息缺失"), //
	AuthError002("1002", "用户验证不通过"), //
	AuthError003("1003", "用户信息已过期"), //
	ErrorParams("1010", "请求参数不正确"), //
	ErrorConfig("1020", "没有找到对应的接口配置"),//
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
		return "接口错误编码：" + code + " _ " + msg;
	}
}
