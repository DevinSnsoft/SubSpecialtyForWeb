package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import cn.snsoft.dao.ApplyDao2;
//import cn.snsoft.utils.AllConstant;
//import cn.snsoft.utils.JsonUtils;

/**
 * Servlet implementation class AddFeedback
 */
@WebServlet("/AddFeedback")
public class AddFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/json");
//		response.setCharacterEncoding("utf-8");
//		response.getWriter().write(JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "请求异常！"));	
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		//得到学号
		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("studentId");
		
		//解析请求中的参数
//		HashMap<String, String> param = JsonUtils.getRequestParams(request);
//		String message = param.get("feedback");
		//得到反馈信息
		request.setCharacterEncoding("utf-8");
		
		String message = request.getParameter("feedback");
//		String message = (String) request.getAttribute("feedback");
//		String message = (String) request.getSession().getAttribute("feedback");
//		System.out.println(message);
		
//		String message = (String) request.getSession().getAttribute("feedback");

		HashMap<String, String> params = new HashMap();		
		//参数校验
		if(StringUtils.isEmpty(studentId)){
			response.getWriter().write("学号不能为空");
		}
		if(message==null){
			response.getWriter().write("反馈信息不能为空");
		}
		ApplyDao2 apply = new ApplyDao2();
		try {
			params.put("studentId", studentId);
			params.put("message", message);
			apply.addFeedback(params);
			request.setAttribute("message", "谢谢您的反馈,我们会尽快处理您的问题!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
