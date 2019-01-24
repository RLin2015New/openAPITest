package api.executorConfig;

import java.util.List;

import api.executorConfig.bean.ApiExecutorConfig;

public interface ApiExecutorDao {

	public List<ApiExecutorConfig> getAllApiConfigs();
}
