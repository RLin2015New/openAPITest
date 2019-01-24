package api;

import api.util.ApiResponseEnum;

public class ApiResponse {
	private String code;
	private String msg;
	private String data;
	private static final String successCode = "0000";
	private static final String successMsg = "成功!";
	/**
	 * 非定义类型错误编码
	 */
	private static final String otherErrorCode = "9999";
	/**
	 * 成功
	 */
	private final static ApiResponse success = new ApiResponse(successCode, successMsg);

	public ApiResponse() {

	}

	public ApiResponse(String code, String msg, String data) {
		this.code = code;
		this.msg = msg;
		this.setData(data);
	}

	public ApiResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ApiResponse(ApiResponseEnum info) {
		this.code = info.getCode();
		this.msg = info.getMsg();
	}

	public static ApiResponse error(ApiResponseEnum info) {
		return new ApiResponse(info);
	}

	public static ApiResponse error(ApiResponseEnum info, String... strings) {
		StringBuilder sb = new StringBuilder(info.getMsg());
		for (String string : strings) {
			sb.append(string);
		}
		return new ApiResponse(info.getCode(), sb.toString());
	}

	public static ApiResponse otherError(String msg) {
		return new ApiResponse(otherErrorCode, msg);
	}

	public static ApiResponse success() {
		return success;
	}

	public static ApiResponse success(String data) {
		return new ApiResponse(successCode, successMsg, data);
	}

	public boolean isSuccess() {
		if (success.getCode().equals(code)) {
			return true;
		}
		return false;
	}

	public boolean notSuccess() {
		return !isSuccess();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ApiResponse:" + code + "_" + msg;
	}

	public String getResponseMsg() {
		if (isSuccess()) {
			return getData();
		}
		return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\"}";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
