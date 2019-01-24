package api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Map<String, Object> params = new HashMap<>();
		// // 鉴权信息
		// params.put("X-APP-ID", "FFnN2hso42Wego3pWq4X5qlu");
		// params.put("X-APP-KEY", "UtOCzqb67d3sN12Kts4URwy8");
		//
		// // api信息
		// params.put("APIKEY", "broadBandProdInst");
		//
		// // api参数信息
		// params.put("certType", "123");
		// params.put("certNum", "345");
		// params.put("commonRegionId", "asd");
		//
		// ApiResponse ap =
		// ApiProcessFactory.getInstance().getApiProcessImpl().process(params);
		// if (ap.isSuccess()) {
		// System.out.println("success:" + ap);
		// } else {
		// System.out.println("error:" + ap);
		// }

//		Resource resource = new ClassPathResource("config/SimpleScan.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
		
		Server server = new Server(8080);
		ServletContextHandler handler = new ServletContextHandler();
		
		// 服务器根目录，类似于tomcat部署的项目。 完整的访问路径为ip:port/contextPath/realRequestMapping
		//ip:port/项目路径/api请求路径
		handler.setContextPath("/*");
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		//加载spring配置文件
		context.setConfigLocation("classpath:config/SimpleScan.xml");
		
		//相当于web.xml中配置的ContextLoaderListener
		handler.addEventListener(new ContextLoaderListener(context));
		
		//springmvc拦截规则 相当于web.xml中配置的DispatcherServlet
		handler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/*");
		server.setHandler(handler);
		server.start();
		server.join();

	}

}
