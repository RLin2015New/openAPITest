package api.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.log.ApiLogDao;
import api.log.ApiLogService;
import api.log.bean.ApiLogBean;

@Service
public class ApiLogServiceImpl implements ApiLogService {
	@Autowired
	private ApiLogDao apiLogDao;

	/**
	 * 
	 * @param bean
	 */
	@Override
	public void saveApiLog(ApiLogBean bean) {

	}

	/**
	 * 
	 * @param requestId
	 * @param responseData
	 */
	@Override
	public void updateApiLog(String requestId, String responseData) {
		System.out.println("update:" + requestId + " data:" + responseData);
	}
}
