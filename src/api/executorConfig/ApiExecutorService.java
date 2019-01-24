package api.executorConfig;

import java.util.Map;

import api.ApiExecutor;
import api.executorConfig.bean.ApiExecutorConfig;

public interface ApiExecutorService {

	public Map<String, Class<? extends ApiExecutor>> getAllApiConfig();

	public ApiExecutorConfig getOneApiConfigByName(String apiName);
}
