package api.apiImpl;

import javax.servlet.http.HttpServletRequest;

import api.ApiExecutor;
import api.ApiResponse;

public abstract class AbstractExecutor implements ApiExecutor {
	/**
	 * 定制默认流程，先检查参数，再执行代码
	 */
	@Override
	public ApiResponse execute(HttpServletRequest request) {
		ApiResponse checkResult = checkParams(request);
		if (checkResult != null && checkResult.notSuccess()) {// 先检查参数
			return checkResult;
		}
		return run(request);// 再执行流程代码
	}

	@Override
	public ApiResponse checkParams(HttpServletRequest request) {
		return ApiResponse.success();
	}

}
