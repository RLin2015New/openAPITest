package api.auth;

import javax.servlet.http.HttpServletRequest;

import api.ApiResponse;
import api.util.ApiResponseEnum;
import api.util.ApiUtils;
import api.util.StringUtils;

public class ApiAuthRentImpl implements ApiAuth {

	@Override
	public ApiResponse auth(HttpServletRequest request) {
		if (request == null || StringUtils.isEmpty(ApiUtils.getAppId(request))
				|| StringUtils.isEmpty(ApiUtils.getAppKey(request))) {
			return ApiResponse.error(ApiResponseEnum.AuthError001);
		}
		// TODO ÊµÏÖ¼øÈ¨
		return ApiResponse.success();
	}

}
