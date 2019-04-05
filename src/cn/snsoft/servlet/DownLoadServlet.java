package cn.snsoft.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import cn.snsoft.bean.Upfile;
import cn.snsoft.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BusinessServiceImpl service = new BusinessServiceImpl();
		Upfile upfile = service.findUpfile(id);
		File file = new File(upfile.getSavepath()+ "\\" + upfile.getUuidname());
		if(!file.exists()){
			request.setAttribute("message", "下载资源已被删除！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
//		upfile.getFilename()=8b7cb3ec2462be2bcd591ffef630df18.jpeg;
//		834f76ee-879e-470c-8456-c76b3f35f293
		System.out.println(upfile.getFilename());
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(upfile.getFilename(),"UTF-8"));
		
		FileInputStream in = new FileInputStream(file);
		int len = 0;
		byte buffer[] = new byte[1024];
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
