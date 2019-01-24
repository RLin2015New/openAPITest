package api.auth;

import javax.servlet.http.HttpServletRequest;

import api.ApiResponse;

public interface ApiAuth {
	/**	
	 * ·ÃÎÊ¼øÈ¨
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse auth(HttpServletRequest request);
}
