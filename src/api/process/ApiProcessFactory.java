package api.process;

public class ApiProcessFactory {

	private static ApiProcessFactory factory = new ApiProcessFactory();

	private ApiProcessFactory() {
	}

	public static ApiProcessFactory getInstance() {
		return factory;
	}

	private ApiProcess apiProcess;

	public ApiProcess getApiProcessImpl() {
		if (apiProcess == null) {// 共用一个实例在这里合理么？
			apiProcess = new ApiProcessRentImpl();
		}
		return apiProcess;
	}

}
