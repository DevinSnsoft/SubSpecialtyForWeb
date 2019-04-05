package cn.snsoft.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cn.snsoft.bean.StudentBean;
import cn.snsoft.dao.ApplyDao;
import cn.snsoft.dao.ApplyDao2;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class AdministratorsExport{
	/**
	* 写excel文件
	 * @throws SQLException 
	*
	*/
	public void writeExc(File filename) throws SQLException{
	//1:导出模板表
		WritableWorkbook wwb = null;
		try
		{
			wwb = Workbook.createWorkbook(filename);
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
			l = new Label(10, 0, "平均学分绩点",getNormolCell());
			ws.addCell(l);
			l = new Label(11, 0, "是否有违纪",getNormolCell());
			ws.addCell(l);
			l = new Label(12, 0, "联系电话",getNormolCell());
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
			ws.setColumnView(11,20);
			ws.setColumnView(12,20);
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
	@SuppressWarnings("static-access")
	List<StudentBean> Beans = apply2.getAllstudent();
	int i =0;
	for(StudentBean bean: Beans){
		params.put("studentId", bean.getStudentId());
		HashMap<String, Object> res = apply.getStudentInfo(params);
		HashMap<String, Object> res2 = apply.getApplyInfo(params);
		
		String studentId = (String) res.get("studentId");
		String studentName = (String) res.get("studentName");
		String sex = (String) res.get("sex");
		String entryDate = (String) res.get("entryDate");
		String faculty = (String) res.get("faculty");
		String specialty = (String) res.get("specialty");
		String classes = (String) res.get("classes");
		
		String firstVoluntary = (String) res2.get("firstvoluntary");
		String secondVoluntary = (String) res2.get("secondvoluntary");
		String thirdVoluntary = (String) res2.get("thirdvoluntary");
		String credit = (String) res2.get("credit");
		String punished = (String) res2.get("punished");
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
		l = new Label(5, i+1, specialty,getNormolCell());
		ws.addCell(l);
		l = new Label(6, i+1, classes,getNormolCell());
		ws.addCell(l);
		l = new Label(7, i+1, firstVoluntary,getNormolCell());
		ws.addCell(l);
		l = new Label(8, i+1, secondVoluntary,getNormolCell());
		ws.addCell(l);
		l = new Label(9, i+1, thirdVoluntary,getNormolCell());
		ws.addCell(l);
		l = new Label(10, i+1, credit,getNormolCell());
		ws.addCell(l);
		l = new Label(11, i+1, punished,getNormolCell());
		ws.addCell(l);
		l = new Label(12, i+1, telephone,getNormolCell());
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
			//outStream.close();
			System.out.println("写入成功！\n");
			}
		
	
	public void readExc(File filename){
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(filename);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet s = wb.getSheet(0);//第1个sheet
		Cell c = null;
		int row = s.getRows();//总行数
		int col = s.getColumns();//总列数
		for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
		c = s.getCell(j,i);
		System.out.print(c.getContents()+" ");
		}
		System.out.println();
		}
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
//	format.setBorder(Border.ALL,BorderLineStyle.THIN,Colour.BLACK);
	} catch (WriteException e) {
	e.printStackTrace();
	}
	return format;
	}
	
	public static void main(String[] args) throws IOException, SQLException{
		AdministratorsExport js = new AdministratorsExport();
		File f = new File("D:\\Administrators.xls");
		f.createNewFile();
		js.writeExc(f);
		js.readExc(f);
	}
}
