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
		// // ��Ȩ��Ϣ
		// params.put("X-APP-ID", "FFnN2hso42Wego3pWq4X5qlu");
		// params.put("X-APP-KEY", "UtOCzqb67d3sN12Kts4URwy8");
		//
		// // api��Ϣ
		// params.put("APIKEY", "broadBandProdInst");
		//
		// // api������Ϣ
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
		
		// ��������Ŀ¼��������tomcat�������Ŀ�� �����ķ���·��Ϊip:port/contextPath/realRequestMapping
		//ip:port/��Ŀ·��/api����·��
		handler.setContextPath("/*");
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		//����spring�����ļ�
		context.setConfigLocation("classpath:config/SimpleScan.xml");
		
		//�൱��web.xml�����õ�ContextLoaderListener
		handler.addEventListener(new ContextLoaderListener(context));
		
		//springmvc���ع��� �൱��web.xml�����õ�DispatcherServlet
		handler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/*");
		server.setHandler(handler);
		server.start();
		server.join();

	}

}
