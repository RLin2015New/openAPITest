package api;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import api.log.ApiLogService;
import api.log.bean.ApiLogBean;
import api.process.ApiProcessFactory;
import api.util.ApiUtils;

@Controller
public class ApiController {
	@Autowired
	private ApiLogService apiLogService;

	public ApiController() {
		System.out.println("ApiController01");
	}

	/**
	 * common
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/order/api/*")
	@ResponseBody
	public void commonApi(HttpServletRequest request, HttpServletResponse respone) throws IOException {
		System.out.println("commonapi" + request.getAttributeNames());
//		respone.sendRedirect("/deliver/abs");
		try {
			request.getRequestDispatcher("/deliver/abs").forward(request, respone);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return;
//		String responseMsg = null;
//		try {
//			printHttpInfo(request);
//			// 1.记录日志
//			insertApiLog(request);
//			// 2.处理
//			ApiResponse result = ApiProcessFactory.getInstance().getApiProcessImpl().process(request);
//			completeResponseInfo(request, respone);
//
//			if (result != null) {
//				responseMsg = result.getResponseMsg();
//				System.out.println("responseMsg:" + responseMsg);
//				respone.getWriter().println(responseMsg);
//				return;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();// todo save日志
//			responseMsg = e.getMessage();
//			throw e;
//		} finally {
//			// 3.更新日志
//			updateApiLog(request, responseMsg);
//		}

	}
	
//	private void deliver(HttpServletRequest request){
//		
////		HttpHost host = new HttpHost("127.0.0.1", 8080);
////		request.get
////		HttpClients.custom().build().execute(host, request);
//		
//	}

	@RequestMapping(value = "/deliver/*")
	@ResponseBody
	public void deliverApi(HttpServletRequest request, HttpServletResponse respone) {

		System.out.println(" ================================== ");
		System.out.println(" ================================== ");
		printHttpInfo(request);
		System.out.println(" ================================== ");
		System.out.println(" ================================== ");
	}

	private void insertApiLog(HttpServletRequest request) {
		ApiLogBean bean = new ApiLogBean();
		bean.setApiName(ApiUtils.getApiName(request));
		apiLogService.saveApiLog(bean);
	}

	private void updateApiLog(HttpServletRequest request, String responseData) {
		apiLogService.updateApiLog(getRequestId(request), responseData);
	}

	private String getRequestId(HttpServletRequest request) {
		return request.getHeader("X-CTG-Request-Id");
	}

	/**
	 * 补全回复信息
	 * 
	 * @param request
	 * @param respone
	 */
	private void completeResponseInfo(HttpServletRequest request, HttpServletResponse respone) {
		respone.setHeader("X-CTG-Request-Id", getRequestId(request));
		respone.setHeader("X-RateLimit-Limit", "60");
		respone.setHeader("X-RateLimit-Remaining", "48");
		respone.setHeader("X-RateLimit-Reset", "14");
		respone.setCharacterEncoding("GBK");

	}

	private void printHttpInfo(HttpServletRequest request) {
		System.out.println("request.getRequestURI():" + request.getRequestURI());
		System.out.println("request.getContentType():" + request.getContentType());
		System.out.println("request.getContextPath():" + request.getContextPath());
		System.out.println("request.getMethod()" + request.getMethod());
		System.out.println(" parameters:");
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			System.out.println("" + name + " value:" + request.getParameter(name));
		}

		System.out.println(" attributes:");
		Enumeration<String> req = request.getAttributeNames();
		while (req.hasMoreElements()) {
			String name = req.nextElement();
			System.out.println("" + name + " value:" + request.getAttribute(name));
		}
		System.out.println(" headers:");
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			System.out.println("" + name + " value:" + request.getHeader(name));
		}

		String uri = request.getRequestURI();
		String[] uris = uri.split("/");
		System.out.println(uris[2]);

	}

}
