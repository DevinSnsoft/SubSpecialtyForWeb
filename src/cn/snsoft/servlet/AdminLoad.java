package cn.snsoft.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;
//
//import jxl.Cell;
//import jxl.Sheet;
import jxl.Workbook;
//import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import cn.snsoft.bean.EnrollBean;
//import cn.snsoft.bean.StudentBean;
import cn.snsoft.dao.ApplyDao;
import cn.snsoft.dao.ApplyDao2;

/**
 * Servlet implementation class AdminLoad
 */
@WebServlet("/AdminLoad")
public class AdminLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("account");//老师账号

		String filename ="Administrators.xls";
		String saveFileName = generateFileName(filename);
		String savepath = generateSavePath(this.getServletContext().getRealPath("/WEB-INF/temp_admin"),saveFileName);
			
		File f = new File(savepath+"\\"+saveFileName);	
		f.createNewFile();
		try {
		//1:写文件
		WritableWorkbook wwb = null;
		try
		{
			wwb = Workbook.createWorkbook(f);
		}catch (Exception e){
			e.printStackTrace();
		}
		//创建Excel工作表 
		WritableSheet ws = wwb.createSheet("大类分流预报名信息表", 0);//创建sheet
			try{
			Label l = new Label(0, 0, "学号",getNormolCell());
			ws.addCell(l);
		    l = new Label(1, 0, "姓名",getNormolCell());
		    ws.addCell(l);
			l = new Label(2, 0, "性别",getNormolCell());
			ws.addCell(l);
			l = new Label(3, 0, "入学日期",getNormolCell());
			ws.addCell(l);
			l = new Label(4, 0, "院系",getNormolCell());
			ws.addCell(l);
			l = new Label(5, 0, "专业",getNormolCell());
			ws.addCell(l);
			l = new Label(6, 0, "班级",getNormolCell());
			ws.addCell(l);
			l = new Label(7, 0, "拟报第一志愿",getNormolCell());
			ws.addCell(l);
			l = new Label(8, 0, "拟报第二志愿",getNormolCell());
			ws.addCell(l);
			l = new Label(9, 0, "拟报第三志愿",getNormolCell());
			ws.addCell(l);
			l = new Label(10, 0, "联系电话",getNormolCell());
			ws.addCell(l);
			ws.setColumnView(0,14);//设置列宽
			ws.setColumnView(1,10);
			ws.setColumnView(2,10);
			ws.setColumnView(3,10);//设置列宽
			ws.setColumnView(4,10);
			ws.setColumnView(5,10);
			ws.setColumnView(6,10);//设置列宽
			ws.setColumnView(7,20);
			ws.setColumnView(8,20);
			ws.setColumnView(9,20);//设置列宽
			ws.setColumnView(10,20);
			ws.setRowView(0,400);//设置行高
			}catch (RowsExceededException e1) {
				e1.printStackTrace();
			} catch (WriteException e1) {
			e1.printStackTrace();
			}
	//往模板表中导入全部数据
	ApplyDao  apply = new ApplyDao();
	HashMap<String, String> params = new HashMap<String, String>();	
	
	ApplyDao2 apply2 = new ApplyDao2();
	int i =0;
	
	//只遍历报名表中的学生信息?【如果这个学生报名了，再遍历】
	List<EnrollBean> Beans = apply2.getAllApplyInfo();//list中只存了studentId
	for(EnrollBean bean: Beans){
		params.put("studentId", bean.getStudentId());
		HashMap<String, Object> res = apply.getStudentInfo(params);
		HashMap<String, Object> res2 = apply.getApplyInfo(params);
		
		studentId = (String) res.get("studentId");
		String studentName = (String) res.get("studentName");
		String sex = (String) res.get("sex");
		String entryDate = (String) res.get("entryDate");
		String faculty = (String) res.get("faculty");
		String className = (String) res.get("className");
		String classes = (String) res.get("classes");
		String firstvoluntary = (String) res2.get("firstvoluntary");
		String secondvoluntary = (String) res2.get("secondvoluntary");
		String thirdvoluntary = (String) res2.get("thirdvoluntary");
		String telephone =(String) res2.get("telephone");
		
		Label l = new Label(0, i+1, studentId,getNormolCell());
	    try {
			ws.addCell(l);
		l = new Label(1, i+1, studentName,getNormolCell());
		ws.addCell(l);
		l = new Label(2, i+1, sex,getNormolCell());
		ws.addCell(l);
		l = new Label(3, i+1, entryDate,getNormolCell());
		ws.addCell(l);
		l = new Label(4, i+1, faculty,getNormolCell());
		ws.addCell(l);
		l = new Label(5, i+1, className,getNormolCell());
		ws.addCell(l);
		l = new Label(6, i+1, classes,getNormolCell());
		ws.addCell(l);
		l = new Label(7, i+1, firstvoluntary,getNormolCell());
		ws.addCell(l);
		l = new Label(8, i+1, secondvoluntary,getNormolCell());
		ws.addCell(l);
		l = new Label(9, i+1, thirdvoluntary,getNormolCell());
		ws.addCell(l);
		l = new Label(10, i+1, telephone,getNormolCell());
		ws.addCell(l);
		i++;
	    } catch (RowsExceededException e) {
	    	e.printStackTrace();
	    } catch (WriteException e) {
	    	e.printStackTrace();
	    }
		
	}
			//输出流
			try {
			wwb.write();
			} catch (IOException ex) {
			// TODO 自动生成 catch 块
			ex.printStackTrace();
			}
			//关闭流
			try {
			wwb.close();
			} catch (WriteException ex) {
			// TODO 自动生成 catch 块
			ex.printStackTrace();
			} catch (IOException ex) {
			// TODO 自动生成 catch 块
			ex.printStackTrace();
			}
			//System.out.println("写入成功！\n");
	} catch (SQLException e) {
		e.printStackTrace();
	}

		/*
		 * 以流的形式下载文件
		 * */
		File file = new File(savepath+"\\"+saveFileName);
		if(!file.exists()){
			request.setAttribute("message", "下载资源已被删除！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
		FileInputStream in = new FileInputStream(savepath+"\\"+saveFileName);
		int len = 0;
		byte buffer[] = new byte[1024];
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		in.close();
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	* 设置单元格样式
	* @return
	*/
	public static WritableCellFormat getNormolCell(){//12号字体,上下左右居中,带黑色边框
		WritableFont font = new WritableFont(WritableFont.TIMES, 12);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.CENTRE);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
//			format.setBorder(Border.ALL,BorderLineStyle.THIN,Colour.BLACK);
			} catch (WriteException e) {
				e.printStackTrace();
			}
				return format;
		}
	public String generateFileName(String filename){
		return UUID.randomUUID().toString() + "_" + filename;
	}
	public String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&15;
		int dir2 = (hashcode>>4)&0xf;
		
		String savepath = path + File.separator +dir1 + File.separator + dir2;
		File file = new File(savepath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savepath;
	}
}
