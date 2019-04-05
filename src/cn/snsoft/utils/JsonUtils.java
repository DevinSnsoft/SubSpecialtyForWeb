package cn.snsoft.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import cn.snsoft.bean.ClassSpecialtyBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2016
 * 
 * @author 14信息慎伟康
 * 
 * @version 1.0
 * 
 * @date 2016年10月20日 下午1:59:44
 * 
 * @Description TODO
 *    json工具类
 */
public class JsonUtils {

	public static String jsonResponse(Object data,int code,String msg){

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("code", code);
		jsonObject.element("msg", msg);
		if(data != null){
			if(data instanceof Collection<?>){
				JSONArray array = new JSONArray();
				array.addAll((Collection<?>) data);
				jsonObject.element("data", array);
			} else if(data instanceof  Map<?, ?>){
				//Map闆嗗悎瀵硅薄
				jsonObject.element("data", data);
			} else {
				jsonObject.element("data", data);
			}
		}
		return jsonObject.toString();
	}
	
	/**
	 * 返回json字符串
	 * @param data
	 * @param code
	 * @param msg
	 * @return
	 * @Description TODO
	 */

	public static String jsonResponse1(Object data,int code,String msg){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();//存放结果集【包括数据，结果码，结果信息】
		resultMap.put("code",code);
		resultMap.put("msg",msg);
		resultMap.put("data",data);
		
		JSONObject jsonObject = JSONObject.fromObject(resultMap);//将结果集转为json
		return jsonObject.toString();	//返回json字符串	
	}
	
	public static List<ClassSpecialtyBean> jsonResponseList(
			List<ClassSpecialtyBean> list, int codeSuccess, String msgSuccess) {
		
		return null;
	}
	/**
	 * 将请求中的json数据转为HashMap对象
	 * @param request
	 * @return
	 * @throws IOException
	 * @Description TODO
	 */
	public static HashMap<String,String> getRequestParams(HttpServletRequest request)
			throws IOException{
		if(request == null)
			return null;
		HashMap<String,String> reqParams = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		BufferedReader reader = request.getReader();
		StringBuffer buffer = new StringBuffer("");
		String temp;
		while((temp = reader.readLine()) != null){
			buffer.append(temp);
		}
		reader.close();
		String acceptjson = buffer.toString();
		if(!StringUtils.isBlank(acceptjson)){
			//json字符串转化为JSONObject对象
			JSONObject jo = JSONObject.fromObject(acceptjson);
			//该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默
			@SuppressWarnings("unchecked")  
			Iterator<Object> it = jo.keys();
			while(it.hasNext()){
				String key = (String) it.next();
				String value = jo.getString(key);
				reqParams.put(key, value);
			}
		}     
		return reqParams;
	}
}
