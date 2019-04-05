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
import cn.snsoft.dao.ApplyDao;
import cn.snsoft.dao.ApplyDao2;
import cn.snsoft.utils.AllConstant;
import cn.snsoft.utils.ConnectToJWC;
import cn.snsoft.utils.JsonUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 返回结果
		String res = "";
		try {
			String studentId = request.getParameter("account");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();

			session.setAttribute("studentId", studentId);
			session.setAttribute("password", password);
//			System.out.println("登录时学号:"+studentId);
			ConnectToJWC connect = new ConnectToJWC();
			ApplyDao ad = new ApplyDao();
			ApplyDao2 apply = new ApplyDao2();
			HashMap<String, String> param = new HashMap<String, String>();
			HashMap<String, String> paramadmin = new HashMap<String, String>();
			param.put("studentId", studentId);
			paramadmin.put("account", studentId);
			HashMap<String, Object> result = ad.getStudentInfo(param);
			HashMap<String, Object> resultAdmin = apply
					.getAdminInfo(paramadmin);
			if (result!=null && !result.isEmpty()) { // 判断是否为数据库中的学生
				// 判断账号和密码是否与vpn一致
				boolean resb=connect.checkVPNAccount(studentId, password);
				if (resb) {
					// 让用户登录成功后，跳转到首页
						response.sendRedirect(request.getContextPath()
								+ "/choose.jsp");
					} else {	
						response.sendRedirect(request.getContextPath()
								+ "/login.jsp");
					}
				} else {
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write("不是合法用户，不能申报专业！");
				}
		} catch (SQLException e) {
			res = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "操作失败！");
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
