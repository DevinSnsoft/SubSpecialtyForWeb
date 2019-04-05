package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.snsoft.dao.ApplyDao2;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");//通知浏览器以utf-8打开数据
		ApplyDao2 apply = new ApplyDao2();
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", "0");
		try {
			HashMap<String, Object> map = apply.getControllInfo(params);
			String illustration = (String) map.get("illustration");
			request.setAttribute("illustration", illustration);	
			String sign = (String) map.get("sign");
			if(sign.equals("0")){
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
				response.getWriter().write("截止时间已经到了，不能再报名!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
