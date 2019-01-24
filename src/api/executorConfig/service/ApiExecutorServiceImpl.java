package api.executorConfig.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ApiExecutor;
import api.executorConfig.ApiExecutorDao;
import api.executorConfig.ApiExecutorService;
import api.executorConfig.bean.ApiExecutorConfig;

@Service
public class ApiExecutorServiceImpl implements ApiExecutorService {

	@Autowired
	private ApiExecutorDao apiExecutorDao;

	public Map<String, Class<? extends ApiExecutor>> getAllApiConfig() {
		Map<String, Class<? extends ApiExecutor>> map = new HashMap<>();
		List<ApiExecutorConfig> allConfigs = apiExecutorDao.getAllApiConfigs();
		if (allConfigs != null) {
			for (ApiExecutorConfig config : allConfigs) {
				try {
					if (config.isAble()) {// ÓÐÐ§
						Class<? extends ApiExecutor> clz = (Class<? extends ApiExecutor>) Class
								.forName(config.getHandlerClass());
						map.put(config.getApiName(), clz);
					} else {
						// log
					}

				} catch (Exception e) {
					e.printStackTrace();
					// log
				}
			}
		}
		return map;
	}

	public ApiExecutorConfig getOneApiConfigByName(String apiName) {
		return null;
	}

}
