package api.process;

import javax.servlet.http.HttpServletRequest;

import api.ApiExecutor;
import api.ApiResponse;
import api.auth.ApiAuthFactory;
import api.executorConfig.ApiExecutorManager;
import api.util.ApiResponseEnum;

/**
 * 提供 1.验证有效性-2.鉴权-3.根据配置分发调度 的实现
 * 
 * @author 91714
 *
 */
public class ApiProcessRentImpl implements ApiProcess {

	@Override
	public ApiResponse process(HttpServletRequest request) {
		// 1.先验证有效性
		if (request == null) {
			return ApiResponse.error(ApiResponseEnum.ErrorParams);
		}
		// TODO 数据库有效性

		// 2.再鉴权
		ApiResponse authRes = ApiAuthFactory.getInstance().getApiAuthImpl().auth(request);
		if (!authRes.isSuccess()) {// 鉴权失败
			return authRes;
		}

		// 3.分发执行
		try {
			Class<? extends ApiExecutor> clz = ApiExecutorManager.getInstance().getApiExecutro(request);
			if (clz == null) {
				return ApiResponse.error(ApiResponseEnum.ErrorConfig);
			}
			return clz.newInstance().execute(request); // 要考虑公用一个实例还是每次都新建实例
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
