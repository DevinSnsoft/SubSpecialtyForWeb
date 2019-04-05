package cn.snsoft.test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import cn.snsoft.bean.Upfile;
import cn.snsoft.dao.ApplyDao;
import cn.snsoft.dao.ApplyDao2;
import cn.snsoft.dao.UpfileDao;

public class DaoTest {
	
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	@Test
	public void test() throws SQLException{
		HashMap params = new HashMap();
		ApplyDao2 applyDao2 = new ApplyDao2();
		params.put("firstvoluntary", "计算机科学与技术");
		List stuID = applyDao2.getAllStuIDFromFirst(params);
		System.out.println(stuID);
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testStudentInfo() throws SQLException{
		HashMap params = new HashMap();
		ApplyDao apply = new ApplyDao();
		params.put("studentId", "2016188053");
		HashMap<String, Object> map = apply.getStudentInfo(params);
		System.out.println(map);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testUpfile(){
		UpfileDao upfile = new UpfileDao();
		List<Upfile> list = upfile.getAll();
		for(Upfile i : list){
			System.out.println(list.get(0).getId());
			System.out.println(list.get(0).getUuidname());
			System.out.println(list.get(0).getFilename());
			System.out.println(list.get(0).getSavepath());
			System.out.println(list.get(0).getUptime());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testControllInfo() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		params.put("id", "0");
		HashMap<String, Object> map = apply.getControllInfo(params);
		String sign = (String) map.get("sign");
		System.out.println(sign);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSumFromClassName() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		params.put("className", "电子信息类");
		HashMap<String, Object> map = apply.getSumFromClassName(params);
		//int i = map.hashCode();	
		//String i = (String) map.get("count(*)");
//		System.out.println(map);
		String sum = map.toString();
		String[] result= sum.split("=");
		String[] res = result[1].split("}");
		System.out.println(res[0]);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testEnrollSumFromClassName() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		params.put("className", "电子信息类");
		HashMap<String, Object> map = apply.getEnrollSumFromClassName(params);
		//int i = map.hashCode();	
		//String i = (String) map.get("count(*)");
//		System.out.println(map);
		String Enrollsum = map.toString();
		String[] result= Enrollsum.split("=");
		String[] res = result[1].split("}");
		System.out.println(res[0]);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testaddFeedback() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		String message = "吃奶奶";
		String studentId = "2016188053";
		params.put("studentId", studentId);
		params.put("message", message);
		apply.addFeedback(params);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testApplyInfo() throws SQLException{
		HashMap params = new HashMap();
		ApplyDao apply = new ApplyDao();
		params.put("studentId", "2016108010");
		HashMap<String, Object> map = apply.getApplyInfo(params);
		System.out.println(map);
	}
	
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	@Test
	public void testgetAllStuIDFromFirst() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		params.put("firstvoluntary", "林学");
		List list = apply.getAllStuIDFromFirst(params);
	
		System.out.println(list);
	}
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	
	@Test
	public void testgetAllStuIDFromSecond() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		params.put("firstvoluntary", "林学");
		List list = apply.getAllStuIDFromFirst(params);
	
		System.out.println(list);
	}
	
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	@Test
	public void testgetAllStuIDFromThird() throws SQLException{
		ApplyDao2 apply = new ApplyDao2();
		HashMap params = new HashMap();
		params.put("thirdvoluntary", "水土保持与荒漠化防治");
		List list = apply.getAllStuIDFromThird(params);
		System.out.println(list);
	}
}
