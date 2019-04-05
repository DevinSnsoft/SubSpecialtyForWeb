package cn.snsoft.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.snsoft.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class CheckUpfile
 */
@WebServlet("/CheckUpfile")
public class CheckUpfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl service = new BusinessServiceImpl();
		List list = service.getAllUpfile();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/listfile.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
