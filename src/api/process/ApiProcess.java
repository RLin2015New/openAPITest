package api.process;

import javax.servlet.http.HttpServletRequest;

import api.ApiResponse;

public interface ApiProcess {

	/**
	 * µ÷¶Èapi
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse process(HttpServletRequest request);
}
