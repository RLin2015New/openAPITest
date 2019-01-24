package api.log;

import api.log.bean.ApiLogBean;

public interface ApiLogService {

	public void saveApiLog(ApiLogBean bean);

	public void updateApiLog(String requestId, String responseData);
}
