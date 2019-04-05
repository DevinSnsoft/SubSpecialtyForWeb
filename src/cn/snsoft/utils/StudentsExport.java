package cn.snsoft.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.snsoft.dao.ApplyDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StudentsExport {
	/**
	 * 写excel文件
	 * @throws SQLException 
	 *
	 */
	@SuppressWarnings("null")
	public void writeExc(File filename) throws SQLException {
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		//根据学号：导入报名信息
		ApplyDao apply = new ApplyDao();
		HashMap<String, String> params = new HashMap<String, String>();	
		HttpServletRequest request = null;
		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("studentId");
		params.put("studentId", studentId);
		HashMap<String, Object> applyInfo = apply.getApplyInfo(params);
	    studentId = (String) applyInfo.get("studentId");
		String firstvoluntary = (String) applyInfo.get("firstvoluntary");
		String secondvoluntary = (String) applyInfo.get("secondvoluntary");
		String thirdvoluntary = (String) applyInfo.get("thirdvoluntary");
		String credit = (String) applyInfo.get("credit");
		String punished = (String) applyInfo.get("punished");
		String telephone = (String) applyInfo.get("telephone");
		String academic = (String) applyInfo.get("academic");
		String performance = (String) applyInfo.get("performance");
		HashMap<String, Object> studentInfo = apply.getStudentInfo(params);
		String studentName = (String) studentInfo.get("studentName");
		String sex = (String) studentInfo.get("sex");
		String faculty = (String) studentInfo.get("faculty");
		String className = (String) studentInfo.get("className");
		String classes = (String) studentInfo.get("classes");
		// 创建Excel工作表 
		WritableSheet ws = wwb.createSheet("沈阳农业大学本科生大类招生确定专业申请表", 0);// 创建sheet
		try {
			ws.mergeCells(0, 0, 5, 1);//合并单元格(左列，左行，右列，右行)从第1行第1列到第2行第6列
			ws.mergeCells(1, 3, 5, 3);//合并单元格(左列，左行，右列，右行)从第4行第2列到第4行第6列
			ws.mergeCells(1, 4, 3, 4);//合并单元格(左列，左行，右列，右行)从第5行第2列到第5行第4列
			ws.mergeCells(1, 5, 5, 5);//合并单元格(左列，左行，右列，右行)从第6行第2列到第6行第6列
			ws.mergeCells(1, 6, 5, 6);//合并单元格(左列，左行，右列，右行)从第7行第2列到第7行第6列
			ws.mergeCells(1, 7, 5, 7);//合并单元格(左列，左行，右列，右行)从第8行第2列到第8行第6列
			ws.mergeCells(1, 8, 2, 8);//合并单元格(左列，左行，右列，右行)从第9行第2列到第9行第3列
			ws.mergeCells(4, 8, 5, 8);//合并单元格(左列，左行，右列，右行)从第9行第5列到第9行第6列
			ws.mergeCells(1, 9, 5, 9);//合并单元格(左列，左行，右列，右行)从第10行第2列到第10行第6列
			ws.mergeCells(0, 10, 5, 10);//合并单元格(左列，左行，右列，右行)从第11行第1列到第11行第6列
			ws.mergeCells(0, 11, 5, 11);//合并单元格(左列，左行，右列，右行)从第12行第1列到第12行第6列
			ws.mergeCells(1, 12, 5, 12);//合并单元格(左列，左行，右列，右行)从第13行第2列到第13行第6列
			ws.mergeCells(1, 13, 5, 13);//合并单元格(左列，左行，右列，右行)从第14行第2列到第14行第6列
			ws.mergeCells(1, 14, 5, 14);//合并单元格(左列，左行，右列，右行)从第14行第2列到第14行第6列
			ws.mergeCells(0, 15, 5, 15);//合并单元格(左列，左行，右列，右行)从第16行第1列到第16行第6列
			Label header = new Label(0, 0, "沈阳农业大学本科生大类招生确定专业申请表", getHeader());
			ws.addCell(header);//写入头
			Label l = new Label(0, 2, "姓名",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 2, studentName,getNormolCell());
		    ws.addCell(l);
		    l = new Label(2, 2, "学号",getNormolCell());
		    ws.addCell(l);
		    l = new Label(3, 2, studentId,getNormolCell());
		    ws.addCell(l);
			l = new Label(4, 2, "性别",getNormolCell());
			ws.addCell(l);
			l = new Label(5, 2, sex,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 3, "大类专业所在学院",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 3, faculty,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 4, "大类专业名称",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 4, className,getNormolCell());
			ws.addCell(l);
			l = new Label(4, 4, "大类班级名称",getNormolCell());
			ws.addCell(l);
			l = new Label(5, 4, classes,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 5, "拟报第一志愿",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 5, firstvoluntary,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 6, "拟报第二志愿",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 6, secondvoluntary,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 7, "拟报第三志愿",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 7, thirdvoluntary,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 8, "平均学分绩点",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 8, credit,getNormolCell());
			ws.addCell(l);
			l = new Label(3, 8, "是否有违纪",getNormolCell());
			ws.addCell(l);
			l = new Label(4, 8, punished,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 9, "联系电话",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 9, telephone,getNormolCell());
			ws.addCell(l);
			l = new Label(0, 10, "本人表现及特长:	"+performance,getNormolCell1());
			ws.addCell(l);
			l = new Label(0, 11, "是否拥有某学科专业方面的学术特长:	"+academic,getNormolCell1());
			ws.addCell(l);
			l = new Label(0, 12, "辅导员意见",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 12, "签名：          年   月   日",getNormolCell2());
			ws.addCell(l);
			l = new Label(0, 13, "教务员员意见",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 13, "签名：          年   月   日",getNormolCell2());
			ws.addCell(l);
			l = new Label(0, 14, "学院领导意见",getNormolCell());
			ws.addCell(l);
			l = new Label(1, 14, "分管教学副院长签名：          年   月   日",getNormolCell2());
			ws.addCell(l);
			l = new Label(0, 15, "备注：如拥有某学科专业方面的学术特长，请出示相关证明。",getNormolCell4());
			ws.addCell(l);
			l = new Label(4, 16, "学生本人签字确认:",getNormolCell3());
			ws.addCell(l);
			l = new Label(5, 16, "",getNormolCell3());
			ws.addCell(l);
			ws.setColumnView(0,20);//设置列宽
			ws.setColumnView(1,19);
			ws.setColumnView(2,19);
			ws.setColumnView(3,19);//设置列宽
			ws.setColumnView(4,19);
			ws.setColumnView(5,19);
			ws.setRowView(0,400);//设置行高
			ws.setRowView(1,400);//设置行高
			ws.setRowView(2,600);//设置行高
			ws.setRowView(3,600);//设置行高
			ws.setRowView(4,600);//设置行高
			ws.setRowView(5,600);//设置行高
			ws.setRowView(6,600);//设置行高
			ws.setRowView(7,600);//设置行高
			ws.setRowView(8,600);//设置行高
			ws.setRowView(9,600);//设置行高
			ws.setRowView(10,1400);//设置行高
			ws.setRowView(11,1400);//设置行高
			ws.setRowView(12,1400);//设置行高
			ws.setRowView(13,1400);//设置行高
			ws.setRowView(14,1400);//设置行高
			ws.setRowView(16,400);//设置行高
		} catch (RowsExceededException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}

		// 输出流
		try {
			wwb.write();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// 关闭流
		try {
			wwb.close();
		} catch (WriteException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// outStream.close();
		System.out.println("写入成功！\n");
	}

	public void readExc(File filename) throws BiffException, IOException {
		Workbook wb = Workbook.getWorkbook(filename);
		Sheet s = wb.getSheet(0);// 第1个sheet
		Cell c = null;
		int row = s.getRows();// 总行数
		int col = s.getColumns();// 总列数
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				c = s.getCell(j, i);
				System.out.print(c.getContents() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 设置头的样式
	 * 
	 * @return 
	 */
	public static WritableCellFormat getHeader() {
		WritableFont font = new WritableFont(WritableFont.TIMES, 14,
				WritableFont.BOLD);// 定义字体
		try {
			font.setColour(Colour.BLACK);// 黑色字体
		} catch (WriteException e1) {
			// TODO 自动生成 catch 块
			e1.printStackTrace();
		}
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);// 黑色边框
//			format.setBackground(Colour.YELLOW);// 黄色背景
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}

	/**
	 * 设置标题样式
	 * 
	 * @return
	 */
	public static WritableCellFormat getTitle() {
		WritableFont font = new WritableFont(WritableFont.TIMES, 14);
		try {
			font.setColour(Colour.BLUE);// 蓝色字体
		} catch (WriteException e1) {
			// TODO 自动生成 catch 块
			e1.printStackTrace();
		}
		WritableCellFormat format = new WritableCellFormat(font);

		try {
			format.setAlignment(jxl.format.Alignment.CENTRE);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}

	/**
	 * 设置第一种单元格样式
	 * 
	 * @return
	 */
	public static WritableCellFormat getNormolCell() {// 12号字体,上下左右居中,带黑色边框
		WritableFont font = new WritableFont(WritableFont.TIMES, 12,WritableFont.BOLD);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.CENTRE);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
//			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}

	
	/**
	 * 设置第二种单元格样式
	 * 
	 * @return
	 */
	public static WritableCellFormat getNormolCell1() {// 12号字体,上下左右居中,带黑色边框
		WritableFont font = new WritableFont(WritableFont.TIMES, 12,WritableFont.BOLD);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.LEFT);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}
	
	/**
	 * 设置第三种单元格样式
	 * 
	 * @return
	 */
	public static WritableCellFormat getNormolCell2() {// 12号字体,上下左右居中,带黑色边框
		WritableFont font = new WritableFont(WritableFont.TIMES, 12,WritableFont.BOLD);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.RIGHT);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
//			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}
	
	/**
	 * 设置第四种单元格样式
	 * 
	 * @return
	 */
	public static WritableCellFormat getNormolCell3() {// 11号字体,上下左右居中,带黑色边框
		WritableFont font = new WritableFont(WritableFont.TIMES, 11);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.LEFT);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}
	
	/**
	 * 设置第四种单元格样式
	 * 
	 * @return
	 */
	public static WritableCellFormat getNormolCell4() {// 11号字体,上下左右居中,带黑色边框
		WritableFont font = new WritableFont(WritableFont.TIMES, 11);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.LEFT);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}
	public static void main(String[] args) throws IOException, BiffException, SQLException {
		StudentsExport js = new StudentsExport();
//		HashMap<String, String> params = new HashMap<String, String>();
		File f = new File("D:\\沈阳农业大学本科生大类招生确定专业申请表.xls");
		f.createNewFile();
		js.writeExc(f);
		js.readExc(f);
	}
}
