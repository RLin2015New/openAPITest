package api.process;

import javax.servlet.http.HttpServletRequest;

import api.ApiExecutor;
import api.ApiResponse;
import api.auth.ApiAuthFactory;
import api.executorConfig.ApiExecutorManager;
import api.util.ApiResponseEnum;

/**
 * �ṩ 1.��֤��Ч��-2.��Ȩ-3.�������÷ַ����� ��ʵ��
 * 
 * @author 91714
 *
 */
public class ApiProcessRentImpl implements ApiProcess {

	@Override
	public ApiResponse process(HttpServletRequest request) {
		// 1.����֤��Ч��
		if (request == null) {
			return ApiResponse.error(ApiResponseEnum.ErrorParams);
		}
		// TODO ���ݿ���Ч��

		// 2.�ټ�Ȩ
		ApiResponse authRes = ApiAuthFactory.getInstance().getApiAuthImpl().auth(request);
		if (!authRes.isSuccess()) {// ��Ȩʧ��
			return authRes;
		}

		// 3.�ַ�ִ��
		try {
			Class<? extends ApiExecutor> clz = ApiExecutorManager.getInstance().getApiExecutro(request);
			if (clz == null) {
				return ApiResponse.error(ApiResponseEnum.ErrorConfig);
			}
			return clz.newInstance().execute(request); // Ҫ���ǹ���һ��ʵ������ÿ�ζ��½�ʵ��
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ApiResponse.otherError(e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ApiResponse.otherError(e.getMessage());
		}
	}

}
