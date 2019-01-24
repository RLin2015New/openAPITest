package api.executorConfig;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import api.ApiExecutor;
import api.apiImpl.broadBandProdInst.BroadBandProdInstExecutor;
import api.executorConfig.bean.ApiExecutorConfig;
import api.util.ApiUtils;

/**
 * 
 * @author 91714
 *
 */
public class ApiExecutorManager {

	@Autowired
	private ApiExecutorService apiExecutorService;

	private static ApiExecutorManager manager = new ApiExecutorManager();

	private Object lock = new Object();

	/**
	 * ��������ǻ���ϵͳ���еĻ�����������û�Ҫ�Լ�ʵ��ˢ�»���
	 */
	private static Map<String, Class<? extends ApiExecutor>> classMap;

	private ApiExecutorManager() {
		// lock = new Object();
		// updateAllConfig();
	}

	static {
		classMap = new HashMap<>();
		classMap.put("broadBandProdInst", BroadBandProdInstExecutor.class);
	}

	/**
	 * ȫ�ӿ�ˢ��
	 */
	public void updateAllConfig() {
		synchronized (lock) {
			// classMap = apiExecutorService.getAllApiConfig();
			classMap.put("broadBandProdInst", BroadBandProdInstExecutor.class);
		}
	}

	/**
	 * ���ӿ�ˢ��
	 * 
	 * @param apiName
	 * @throws ClassNotFoundException
	 */
	public void updateConfigByName(String apiName) throws ClassNotFoundException {
		synchronized (lock) {
			// ��ܲ�����ͻ
			Map<String, Class<? extends ApiExecutor>> newClassMap = new HashMap<>();
			newClassMap.putAll(classMap);

			ApiExecutorConfig config = apiExecutorService.getOneApiConfigByName(apiName);
			if (config == null && newClassMap.containsKey(apiName)) {// �Ƴ�
				newClassMap.remove(apiName);
			}
			if (config != null && !newClassMap.containsKey(apiName) && config.isAble()) {// ����
				Class<? extends ApiExecutor> clz = (Class<? extends ApiExecutor>) Class
						.forName(config.getHandlerClass());
				newClassMap.put(apiName, clz);
			}
			if (config != null && newClassMap.containsKey(apiName)) {// �޸�ˢ��
				if (config.isAble()) {// ��Ч
					newClassMap.remove(apiName);
					Class<? extends ApiExecutor> clz = (Class<? extends ApiExecutor>) Class
							.forName(config.getHandlerClass());
					newClassMap.put(apiName, clz);
				} else {// ʧЧ
					newClassMap.remove(apiName);
				}
			}
			classMap = newClassMap;// �滻
		}
	}

	public static ApiExecutorManager getInstance() {
		if (manager == null) {
			manager = new ApiExecutorManager();
		}
		return manager;
	}

	public Class<? extends ApiExecutor> getApiExecutro(HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		String key = ApiUtils.getApiName(request);
		if (key == null || key.length() == 0) {
			return null;
		}
		return classMap.get(key);
	}

}
