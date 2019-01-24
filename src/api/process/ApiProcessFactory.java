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
		if (apiProcess == null) {// ����һ��ʵ�����������ô��
			apiProcess = new ApiProcessRentImpl();
		}
		return apiProcess;
	}

}
