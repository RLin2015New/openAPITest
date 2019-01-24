package api.apiImpl.broadBandmktCamItem;

import javax.servlet.http.HttpServletRequest;

import api.ApiResponse;
import api.apiImpl.AbstractExecutor;
import api.util.ApiResponseEnum;
import api.util.ApiUtils;
import api.util.StringUtils;

public class BroadBandmktCamItemExecutor extends AbstractExecutor {

	@Override
	public ApiResponse checkParams(HttpServletRequest request) {
		String lackParams = ApiUtils.checkParamNotNull(request, false, "prodInstId", "commonRegionId");
		if (!StringUtils.isEmpty(lackParams)) {
			return ApiResponse.error(ApiResponseEnum.ErrorParams, lackParams);
		}
		return ApiResponse.success();
	}

	@Override
	public ApiResponse run(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("execute BroadBandmktCamItemExecutor");
		return null;
	}

}
