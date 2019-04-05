package cn.snsoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import cn.snsoft.dao.DaoDemo;
import cn.snsoft.utils.AllConstant;
import cn.snsoft.utils.JsonUtils;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2017
 * 
 * @author 14信息慎伟康
 * 
 * @version 1.0
 * 
 * @date 2017年1月26日 下午6:44:46
 * 
 * @Description TODO
 *		获取学生信息接口
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "请求异常！"));
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//返回结果
		String result = "";
		
		//解析请求中的参数
		HashMap<String, String> param = JsonUtils.getRequestParams(request);
		
		//参数校验
		if(StringUtils.isEmpty(param.get("studentId"))){
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "学号不能为空！");
		}else{
			try {
				//调用dao
				DaoDemo dd = new DaoDemo();
				HashMap<String, Object> res = dd.getStudentInfo(param);
				if(res != null){
					result = JsonUtils.jsonResponse(res, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
				}else{
					result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
				}
				
			} catch (SQLException e) {
				result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
			}
		}
		
		System.out.println("post...");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);				
	}

}
