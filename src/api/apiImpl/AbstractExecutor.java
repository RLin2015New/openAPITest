package api.apiImpl;

import javax.servlet.http.HttpServletRequest;

import api.ApiExecutor;
import api.ApiResponse;

public abstract class AbstractExecutor implements ApiExecutor {
	/**
	 * ����Ĭ�����̣��ȼ���������ִ�д���
	 */
	@Override
	public ApiResponse execute(HttpServletRequest request) {
		ApiResponse checkResult = checkParams(request);
		if (checkResult != null && checkResult.notSuccess()) {// �ȼ�����
			return checkResult;
		}
		return run(request);// ��ִ�����̴���
	}

	@Override
	public ApiResponse checkParams(HttpServletRequest request) {
		return ApiResponse.success();
	}

}
