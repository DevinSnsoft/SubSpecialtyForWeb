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

import cn.snsoft.dao.ApplyDao;
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
 * @date 2017年2月3日 下午10:00:16
 * 
 * @Description TODO
 *		修改报名信息
 */
@WebServlet("/UpdateApply")
public class UpdateApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateApply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "请求异常！"));	
	}

	/**
	 * 修改报名信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//返回结果
		String result = "";
		
		//解析请求中的参数
		HashMap<String, String> param = JsonUtils.getRequestParams(request);
		
		//参数校验
		if(StringUtils.isEmpty(param.get("performance"))){
			param.put("performance", "无");
		}
		if(StringUtils.isEmpty(param.get("academic"))){
			param.put("academic", "无");
		}
		if(StringUtils.isEmpty(param.get("secondvoluntary"))){
			param.put("secondvoluntary", "无");
		}
		if(StringUtils.isEmpty(param.get("thirdvoluntary"))){
			param.put("thirdvoluntary", "无");
		}
		
		if(StringUtils.isEmpty(param.get("studentId"))){
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "学号不能为空！");
		}else if(StringUtils.isEmpty(param.get("firstvoluntary"))){
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "第一志愿不能为空！");
		}/*else if(StringUtils.isEmpty(param.get("credit"))){
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "学分绩点不能为空！");
		}else if(StringUtils.isEmpty(param.get("punished"))){
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "违纪不能为空！");
		}*/else if(StringUtils.isEmpty(param.get("telephone"))){
			result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "联系电话不能为空！");
		}else{
			try {
				//调用dao
				ApplyDao ad = new ApplyDao();
				ad.updateApply(param);
				result = JsonUtils.jsonResponse(null, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
			} catch (SQLException e) {
				result = JsonUtils.jsonResponse(null, AllConstant.CODE_ERROR, "操作失败！");
				e.printStackTrace();
			}
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);	
	}

}
