package cn.snsoft.test;

import java.io.InputStream;
//import java.util.Collection;
import java.util.HashMap;

//import net.sf.json.JSONObject;
import org.junit.Test;

import cn.snsoft.utils.AllConstant;
import cn.snsoft.utils.HttpUtils;
import cn.snsoft.utils.JsonUtils;

public class ServletTest {
	
	@Test
	public void test1() {
		String str = "";
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("aaa", 12);
		param.put("bbb", "bbb---");
		str = JsonUtils.jsonResponse(param, AllConstant.CODE_SUCCESS, AllConstant.MSG_SUCCESS);
		System.out.println(str);
	}
	
	
	@Test
	public void servletPostTest(){
		String url = "http://localhost:8080/major/ServletDemo";
		InputStream is = HttpUtils.sendPost(url,"{studentId:'2016125001'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}

	@Test
	public void ApplyInfoTest(){
		String url = "http://localhost:8080/major/ApplyInfo";
		InputStream is = HttpUtils.sendPost(url,"{studentId:'2016125001'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	//2016101001
	@Test
	public void StudentInfoTest(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/StudentInfo";
		InputStream is = HttpUtils.sendPost(url,"{studentId:''}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	@Test
	public void UpdateApplyTest(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/UpdateApply";
		InputStream is = HttpUtils.sendPost(url,"{studentId:'2016125001',firstvoluntary:'农业工程',credit:'3.0'"
				+ "punished:'否',telephone:'13801234567'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	@Test
	public void checkVPNAccountTest(){
		
	}
	@Test
	public void addApplyPostTest(){
		String url = "http://localhost:8080/major/AddApply";
		InputStream is = HttpUtils.sendPost(url, "{studentId:'2016125010',firstvoluntary:'农业工程',credit:'3.0',"
				+ "telephone:'13801234567'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	
	
	@Test
	public void applyInfoPostTest(){
		String url = "http://localhost:8080/major/ApplyInfo";
		InputStream is = HttpUtils.sendPost(url, "{studentId:'2016125004'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}

	@Test
	public void GetAllSpecialty(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/GetAllSpecialty";
		InputStream is = HttpUtils.sendPost(url, "{className:'植物生产类'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
//		JSONObject jo = JSONObject.fromObject(result);
//		Collection collection = jo.values();
//		System.out.println(collection);
	}
	
	@Test
	public void AdminInfoTest(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/AdminInfo";
		InputStream is = HttpUtils.sendPost(url,"{account:'1999500023'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	
	@Test
	public void ControllInfoTest(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/ControllInfo";
		InputStream is = HttpUtils.sendPost(url,"{id:'0'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	
	@Test
	public void SortTest(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/Sort";
		InputStream is = HttpUtils.sendPost(url,"{firstvoluntary:'计算机科学与技术'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	
	@Test
	public void SortPostTest(){
		String url = "http://localhost:8080/SubSpecialtyForWeb/Sort";
		InputStream is = HttpUtils.sendPost(url, "{studentId:'2016188053'}");
		String result = HttpUtils.getString(is);
		System.out.println(result);
	}
	
	
	@SuppressWarnings("unused")
	public void test(){
		String a = null, b = null, c = null;
		//判空
		if(a == null){
			System.out.println("error");
		} else if(b == null && c != null) {
			System.out.println("error");
		}
		//判重复
		if((a == b && a != null) || (a == c && a != null) || (b == c && b != null)) {
			System.out.println("error");
		}
		
	}
}
