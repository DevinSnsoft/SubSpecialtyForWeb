package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


//import javax.naming.ldap.SortKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import cn.snsoft.bean.EnrollBean;
//import cn.snsoft.bean.StudentBean;
import cn.snsoft.dao.ApplyDao;
import cn.snsoft.dao.ApplyDao2;
//import cn.snsoft.utils.AllConstant;
//import cn.snsoft.utils.JsonUtils;

/**
 * Servlet implementation class Sort
 */
@WebServlet("/Sort")
public class Sort extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("application/json");
		// response.setCharacterEncoding("utf-8");
		// response.getWriter().write(JsonUtils.jsonResponse(null,
		// AllConstant.CODE_ERROR, "请求异常！"));
		response.setCharacterEncoding("UTF-8"); // 更改response的码表（服务器的编码）
		response.setHeader("content-type", "text/html;charset=UTF-8");// 通知浏览器以utf-8打开数据
		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("studentId");
//		System.out.println("session中学号:"+studentId);
		ApplyDao apply = new ApplyDao();
		ApplyDao2 apply2 = new ApplyDao2();
		HashMap params = new HashMap();
		HashMap params2 = new HashMap();
		HashMap params20 = new HashMap();
		HashMap params200 = new HashMap();
		HashMap params22 = new HashMap();
		HashMap params220 = new HashMap();
		HashMap params2200 = new HashMap();
		HashMap params23 = new HashMap();
		HashMap params230 = new HashMap();
		HashMap params2300 = new HashMap();
		HashMap params3 = new HashMap();
		HashMap params31 = new HashMap();
		HashMap params32 = new HashMap();
		HashMap params4 = new HashMap();
		HashMap params41 = new HashMap();
		HashMap params42 = new HashMap();
		List list = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();

		params41.put("studentId", studentId);
		HashMap<String, Object> student;
		try {
			student = apply.getStudentInfo(params41);
			if (student != null) {
				String className = (String) student.get("className");
				if (params42 != null) {
					params42.put("className", className);
					// 根据大类名称查找大类下共有多少人
					HashMap<String, Object> sum = apply2
							.getSumFromClassName(params42);
					String[] result = sum.toString().split("=");
					String[] res = result[1].split("}");
					// System.out.println(res[0]);
					request.setAttribute("sum", res[0]);

					//
					List StuId = apply2.getStuIdFromClassName(params42);
					List stuId = apply2.getStuIdFromEnroll();
					int Enrollsum = 0;
					for (int i = 0; i < stuId.size(); i++) {
						for (int j = 0; j < StuId.size(); j++) {
							if (stuId.get(i).toString()
									.contains(StuId.get(j).toString())) {
								Enrollsum++;
							}
						}
					}
					// 已报志愿的人数
					request.setAttribute("Enrollsum", Enrollsum);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		params.put("studentId", studentId);
		try {
			HashMap<String, Object> applyInfo = apply.getApplyInfo(params);
//			System.out.println("applyInfo:"+applyInfo);
			// if (applyInfo != null) {
			String firstvoluntary = (String) applyInfo.get("firstvoluntary");
			String secondvoluntary = (String) applyInfo.get("secondvoluntary");
			String thirdvoluntary = (String) applyInfo.get("thirdvoluntary");

			request.setAttribute("firstvoluntary", firstvoluntary);
			request.setAttribute("secondvoluntary", secondvoluntary);
			request.setAttribute("thirdvoluntary", thirdvoluntary);
			params2.put("firstvoluntary", firstvoluntary);
			params20.put("secondvoluntary", firstvoluntary);
			params200.put("thirdvoluntary", firstvoluntary);
			// 根据第一志愿得到所有报名学生的学号
			List stuIdList01 = apply2.getAllStuIDFromFirst(params2);
			// 根据第二志愿得到所有报名学生的学号
			if(params20!=null){	
				List stuIdList02 = apply2.getAllStuIDFromSecond(params20);
				for (int i = 0; i < stuIdList02.size(); i++) {
					stuIdList01.add(0, stuIdList02.get(i));
				}
			}
			// 根据第三志愿得到所有报名学生的学号
			if(params200!=null){		
				List stuIdList03 = apply2.getAllStuIDFromThird(params200);
				for (int j = 0; j < stuIdList03.size(); j++) {
					stuIdList01.add(0, stuIdList03.get(j));
				}
			}
			List stuIdList = stuIdList01;
			// 对第一志愿排序
			for (int i = 0; i < stuIdList.size(); i++) {
				params3.put("studentId", stuIdList.get(i).toString());
				HashMap<String, Object> map = apply.getStudentInfo(params3);
				if(map!=null){		
					String credit = (String) map.get("credit");
					list.add(credit);
				}
			}
			Collections.sort(list);
			request.setAttribute("listSize", list.size());
			// 根据一个数拿到它是第几位？
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).toString()
						.equals(apply.getStudentInfo(params).get("credit"))) {
					int sort1 = list.size() - j;
					request.setAttribute("sort1", sort1);
					break;
				}
			}
			if ((secondvoluntary != null) && !(secondvoluntary.equals(""))) {
				params22.put("firstvoluntary", secondvoluntary);
				params220.put("secondvoluntary", secondvoluntary);
				params2200.put("thirdvoluntary", secondvoluntary);
				// 根据第一志愿得到所有报名学生的学号
				List stuIdList201 = apply2.getAllStuIDFromFirst(params22);
				// 根据第二志愿得到所有报名学生的学号
				List stuIdList202 = apply2.getAllStuIDFromSecond(params220);
				// 根据第三志愿得到所有报名学生的学号
				List stuIdList203 = apply2.getAllStuIDFromThird(params2200);
				for (int i = 0; i < stuIdList202.size(); i++) {
					stuIdList201.add(0, stuIdList202.get(i));
				}
				for (int j = 0; j < stuIdList203.size(); j++) {
					stuIdList201.add(0, stuIdList203.get(j));
				}
				List stuIdList2 = stuIdList201;
				// 对第二志愿排序
				for (int i = 0; i < stuIdList2.size(); i++) {
					params31.put("studentId", stuIdList2.get(i).toString());

					HashMap<String, Object> map = apply
							.getStudentInfo(params31);
					if(map!=null){	
					String credit = (String) map.get("credit");
					list2.add(credit);
					}
				}
				Collections.sort(list2);
				request.setAttribute("listSize2", list2.size());
				if (secondvoluntary.equals("") || secondvoluntary.equals("无") ||secondvoluntary.equals("请选择")) {
					request.setAttribute("listSize2", "0");
				}
				
				for (int j = 0; j < list2.size(); j++) {
					if (list2.get(j).toString()
							.equals(apply.getStudentInfo(params).get("credit"))) {
						int sort2 = list2.size() - j;
						request.setAttribute("sort2", sort2);
						if (secondvoluntary.equals("null")||secondvoluntary.equals("") || secondvoluntary.equals("无") ||secondvoluntary.equals("请选择")) {
							request.setAttribute("sort2", "0");
						}
						break;
					}
				}
				/*
				 * 把学生填报的第三志愿作为一二三志愿去查学号
				 * */
				// && (thirdvoluntary.equals(""))
				if (!thirdvoluntary.isEmpty()) {
					params23.put("firstvoluntary", thirdvoluntary);
					params230.put("secondvoluntary", thirdvoluntary);
					params2300.put("thirdvoluntary", thirdvoluntary);

					List stuIdList301 = apply2.getAllStuIDFromFirst(params23);
					List stuIdList302 = apply2.getAllStuIDFromSecond(params230);
					List stuIdList303 = apply2.getAllStuIDFromThird(params2300);
					for (int i = 0; i < stuIdList302.size(); i++) {
						stuIdList301.add(0, stuIdList302.get(i));
					}
					for (int j = 0; j < stuIdList303.size(); j++) {
						stuIdList301.add(0, stuIdList303.get(j));
					}
					List stuIdList3 = stuIdList301;
					// 对第三志愿排序
					for (int i = 0; i < stuIdList3.size(); i++) {
						params32.put("studentId", stuIdList3.get(i).toString());

						HashMap<String, Object> map = apply
								.getStudentInfo(params32);
//						if(map!=null){	
						String credit = (String) map.get("credit");
						list3.add(credit);
//						}
					}
					Collections.sort(list3);
				}
				request.setAttribute("listSize3", list3.size());
				if (thirdvoluntary.equals("") ||thirdvoluntary.equals("无") ||thirdvoluntary.equals("请选择")) {
					request.setAttribute("listSize3", "0");
				}
				for (int j = 0; j < list3.size(); j++) {
					if (list3.get(j).toString()
							.equals(apply.getStudentInfo(params).get("credit"))) {
						int sort3 = list3.size() - j;
						request.setAttribute("sort3", sort3);
						if (request.getAttribute("sort3")==null||thirdvoluntary.equals("") ||thirdvoluntary.equals("无") ||thirdvoluntary.equals("请选择")) {
							request.setAttribute("sort3", "0");
						}			
						break;
					}
				}
			}
			request.getRequestDispatcher("WEB-INF/jsp/sort.jsp").forward(
					request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
