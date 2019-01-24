package api.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ApiUtils {

	public static final String APPID = "X-APP-ID";
	public static final String APPKEY = "X-APP-KEY";
	// private static final String REQUESTID = "X-CTG-Request-Id";
	// private static final String REGIONID = "X-CTG-Region-ID";

	/**
	 * 
	 * @param all
	 * @param canBeNull
	 *            是否允许参数为null或","
	 * @param params
	 * @return
	 */
	public static String checkParamNotNull(HttpServletRequest request, boolean canBeNull, String... params) {
		if (params == null || params.length == 0) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		for (String param : params) {
			Enumeration<String> names = request.getParameterNames();
			String value = null;
			boolean has = false;
			while (names.hasMoreElements()) {
				String next = names.nextElement();
				if (param.equals(next)) {// 有key
					value = request.getParameter(param);
					if (!canBeNull && StringUtils.isEmpty(value)) {// 不能为空时值为空
						continue;
					}
					has = true;
					break;
				}
			}
			if (!has) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append("key:").append(param).append(" value:").append(value);
			}
		}

		return sb.toString();
	}

	/**
	 * 获取请求的api，这里要求是/api/?这种格式
	 * 
	 * @param request
	 * @return
	 */
	public static String getApiName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String[] uris = uri.split("/");
		return uris[2];
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getAppId(HttpServletRequest request) {
		return request.getHeader(APPID);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getAppKey(HttpServletRequest request) {
		return request.getHeader(APPKEY);
	}

}
