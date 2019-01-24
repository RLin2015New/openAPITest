package api;

import javax.servlet.http.HttpServletRequest;

public interface ApiExecutor {

	/**
	 * api���õ����̶��庯��
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse execute(HttpServletRequest request);

	/**
	 * api���õļ�����
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse checkParams(HttpServletRequest request);

	/**
	 * api���õ�ҵ��ִ��
	 * 
	 * @param params
	 * @return
	 */
	public ApiResponse run(HttpServletRequest request);
}
