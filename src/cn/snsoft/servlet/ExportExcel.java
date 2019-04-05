package cn.snsoft.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
//import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.read.biff.BiffException;
import cn.snsoft.utils.ConnectToJWC;
import cn.snsoft.utils.StudentsExport;
//import cn.snsoft.utils.AdministratorsExport;

/**
 * Servlet implementation class ExportExcelServlet
 */
@WebServlet(description = "根据账号导出对应的Excel表", urlPatterns = { "/ExportExcel" })
public class ExportExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("studentId");
		String password = (String) session.getAttribute("password");
		ConnectToJWC connect = new ConnectToJWC();
		/*
		 * 验证是否是学生账号
		 * */
		if(connect.checkVPNAccount(studentId,password)){
			StudentsExport js = new StudentsExport();
			File f = new File("D:\\沈阳农业大学本科生大类招生确定专业申请表.xls");
			f.createNewFile();
			try{
//				HashMap<String, String> params = new HashMap<String, String>();
				js.writeExc(f);
				js.readExc(f);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
//			AdministratorsExport js = new AdministratorsExport();
//			File f = new File("D:\\Administrators.xls");
//			f.createNewFile();
//			try {
//				js.writeExc(f);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			js.readExc(f);
		}
		/*
		 * 验证是否是老师账号
		 * */
//		else if(){
//			
//		}
		/*
		else if(){
			StudentsExport js = new StudentsExport();
			File f = new File("D:\\沈阳农业大学本科生大类招生确定专业申请表.xls");
			f.createNewFile();
			try{
				js.writeExc(f);
				js.readExc(f);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
