package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;

import cn.snsoft.bean.ClassSpecialtyBean;
import cn.snsoft.dao.ApplyDao2;
import cn.snsoft.utils.AllConstant;
import cn.snsoft.utils.JsonUtils;

/**
 * Servlet implementation class GetAllSpecialtyServlet
 */
@WebServlet("/GetAllSpecialty")
public class GetAllSpecialty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(
				JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "请求异常！"));
		// response.setContentType("application/json");
		// response.setCharacterEncoding("utf-8");
		// JSONArray json = new JSONArray();
		// for(ClassSpecialtyBean bean1 : result){
		// JSONObject jo = new JSONObject();
		// jo.put("id", bean1.getId());
		// jo.put("classCode", bean1.getClassCode());
		// jo.put("className", bean1.getClassName());
		// jo.put("subSpecialtyCode", bean1.getSubSpecialtyCode());
		// jo.put("subSpecialtyName", bean1.getSubSpecialtyName());
		// json.add(jo);
		// }
		// try{
		// response.setCharacterEncoding("UTF-8");
		// response.getWriter().write(json.toString());
		// }catch(IOException e){
		// e.printStackTrace();
		// }
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 0:结果集
		String result = "";
		//
//		String temp = "";
		// 1:得到className
		HashMap<String, String> param = JsonUtils.getRequestParams(request);
		// 2:参数合法性校验
		if (StringUtils.isEmpty(param.get("className"))) {
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR,
					"大类名不能为空！");
		} else {
			try {
				// 调用dao
				ApplyDao2 apply = new ApplyDao2();
				List<ClassSpecialtyBean> list = apply.getAllSpecialty(param);
				// 把list转成json字符串
				// Gson JSON = new Gson();
				// temp = JSON.toJson(list); //转json
				// JSONObject jo = JSONObject.fromObject(temp);
				// Collection collection = jo.values();
				if (list != null) {
					result = JsonUtils.jsonResponse(list,
							AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
				} else {
					result = JsonUtils.jsonResponse(null,
							AllConstant.CODE_ERROR, "该大类不存在！");
				}
			} catch (SQLException e) {
				result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR,
						"操作失败！");
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
		}
	}

}
