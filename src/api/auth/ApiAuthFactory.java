package api.auth;

public class ApiAuthFactory {
	private static ApiAuthFactory factory = new ApiAuthFactory();

	private ApiAuthFactory() {
	}

	public static ApiAuthFactory getInstance() {
		return factory;
	}

	private ApiAuth apiAuth;

	public ApiAuth getApiAuthImpl() {
		if (apiAuth == null) {
			apiAuth = new ApiAuthRentImpl();
		}
		return apiAuth;
	}

}
