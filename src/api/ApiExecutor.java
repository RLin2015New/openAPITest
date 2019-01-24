package api;

import javax.servlet.http.HttpServletRequest;

public interface ApiExecutor {

	/**
	 * api调用的流程定义函数
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse execute(HttpServletRequest request);

	/**
	 * api调用的检查参数
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse checkParams(HttpServletRequest request);

	/**
	 * api调用的业务执行
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse run(HttpServletRequest request);
}
