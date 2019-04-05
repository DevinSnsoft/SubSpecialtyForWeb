package cn.snsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import cn.snsoft.bean.Upfile;
import cn.snsoft.service.impl.BusinessServiceImpl;
import cn.snsoft.utils.WebUtils;

@WebServlet("/UpfileServlet")
public class UpfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//跳转到jsp,显示上传页面
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/addfile.jsp").forward(request, response);
	}
	//处理上传
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("message", "不支持的操作");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		try{
			String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
			Upfile upfile = WebUtils.doUpload(request,savepath);
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addUpfile(upfile);
			request.setAttribute("message", "上传成功!!");
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			request.setAttribute("message", "文件不能超过500M");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "上传失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
