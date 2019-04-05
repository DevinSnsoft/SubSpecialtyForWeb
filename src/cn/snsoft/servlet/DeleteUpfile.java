package cn.snsoft.servlet;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cn.snsoft.bean.Upfile;
import cn.snsoft.dao.UpfileDao;

/**
 * Servlet implementation class DeleteUpfile
 */
@WebServlet("/DeleteUpfile")
public class DeleteUpfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		UpfileDao upfile = new UpfileDao();
//		List<Upfile> list = (List<Upfile>) request.getAttribute("list");
		upfile.delete(id);
		response.getWriter().write("删除成功!!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
