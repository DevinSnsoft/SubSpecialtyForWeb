package cn.snsoft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.snsoft.utils.ConnectToJWC;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String passwordAdmin = request.getParameter("passwordAdmin");
		HttpSession session = request.getSession();
		session.setAttribute("account", account);
		session.setAttribute("passwordAdmin", passwordAdmin);
		ConnectToJWC connect = new ConnectToJWC();
		if(connect.checkVPNAccount(account,passwordAdmin)){
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("账号或密码错误，请重新输入！！！");
		}else if(!connect.checkVPNAccount(account,passwordAdmin)&&account.substring(4, 5).startsWith("5")){
			response.sendRedirect(request.getContextPath()+"/adminload.jsp");
		}else{
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("只有老师可以下载，同学别闹！！！");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
