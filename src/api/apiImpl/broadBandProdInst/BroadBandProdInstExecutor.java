package api.apiImpl.broadBandProdInst;

import javax.servlet.http.HttpServletRequest;

import api.ApiResponse;
import api.apiImpl.AbstractExecutor;
import api.apiImpl.broadBandProdInst.bean.RESBroadBandProdInst;
import api.util.ApiResponseEnum;
import api.util.ApiUtils;
import api.util.StringUtils;

public class BroadBandProdInstExecutor extends AbstractExecutor {

	@Override
	public ApiResponse checkParams(HttpServletRequest request) {
		String lackParams = ApiUtils.checkParamNotNull(request, false, "certType", "certNum", "commonRegionId");
		if (!StringUtils.isEmpty(lackParams)) {
			return ApiResponse.error(ApiResponseEnum.ErrorParams, lackParams);
		}
		return ApiResponse.success();
	}

	@Override
	public ApiResponse run(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("execute BroadBandProdInstExecutor");
//		return ApiResponse.success(RESBroadBandProdInst.testInst());
		return null;
	}

}
