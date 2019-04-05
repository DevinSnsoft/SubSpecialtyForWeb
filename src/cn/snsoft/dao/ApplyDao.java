package cn.snsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import cn.snsoft.utils.JdbcUtil;

public class ApplyDao {

	/**
	 * 获取学生个人信息
	 * @param params
	 * @return
	 * @throws SQLException 
	 * @Description TODO
	 */
	public HashMap<String, Object> getStudentInfo(HashMap<String, String> params) throws SQLException {
		//返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT studentId,studentName,sex,entryDate,faculty,className,classes,credit "
				+ "FROM tb_student "
				+ "WHERE studentId = ?";
		
		try {
			conn = JdbcUtil.getConnection();//取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("studentId"));//设置参数
			rs = pstat.executeQuery();//查询
			result = JdbcUtil.getHashMap(rs);//获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}
	
	/**
	 * 添加志愿预报名申请信息
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public void addApply(HashMap<String, String> params) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		String sql = "INSERT INTO tb_enroll(studentId,firstvoluntary,secondvoluntary,thirdvoluntary,telephone,academic,performance,time)"
				+ "VALUES(?,?,?,?,?,?,?,NOW());";		
		try {
			conn = JdbcUtil.getConnection();//取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("studentId"));//设置参数
			pstat.setString(2, params.get("firstvoluntary"));
			pstat.setString(3, params.get("secondvoluntary"));
			pstat.setString(4, params.get("thirdvoluntary"));
			pstat.setString(5, params.get("telephone"));
			pstat.setString(6, params.get("academic"));
			pstat.setString(7, params.get("performance"));
			pstat.executeUpdate();//插入数据		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, pstat, null);
		}
	}
	
	/**
	 * 获取报名信息
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public HashMap<String, Object> getApplyInfo(HashMap<String, String> params) throws SQLException {
		//返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT studentId,firstvoluntary,secondvoluntary,thirdvoluntary,telephone,academic,performance "
				+ "FROM tb_enroll "
				+ "WHERE studentId = ?";
		
		try {
			conn = JdbcUtil.getConnection();//取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("studentId"));//设置参数
			rs = pstat.executeQuery();//查询
			result = JdbcUtil.getHashMap(rs);//获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}
	
	/**
	 * 修改报名信息
	 * @param params
	 * @throws SQLException
	 * @Description TODO
	 */
	public void updateApply(HashMap<String, String> params) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		String sql = "UPDATE tb_enroll "
				+ "SET firstvoluntary = ?, secondvoluntary = ?, thirdvoluntary = ?,"
				+ "telephone = ?,academic = ?,performance = ? "
				+ "WHERE studentId = ?";
		
		try {
			conn = JdbcUtil.getConnection();//取得连接
			pstat = conn.prepareStatement(sql);
			//设置参数
			pstat.setString(1, params.get("firstvoluntary"));
			pstat.setString(2, params.get("secondvoluntary"));
			pstat.setString(3, params.get("thirdvoluntary"));
			//pstat.setObject(5, x);
			//pstat.setString(4, params.get("credit"));
			//pstat.setString(4, params.get("punished"));
			pstat.setString(4, params.get("telephone"));
			pstat.setString(5, params.get("academic"));
			pstat.setString(6, params.get("performance"));
			pstat.setString(7, params.get("studentId"));
			pstat.executeUpdate();//插入数据
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(conn, pstat, null);
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		ApplyDao ad = new ApplyDao();
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("studentId", "2016188053");
		HashMap<String, Object> res = null;
		res = ad.getStudentInfo(param);
		System.out.println(res);//打印结果
		
//		param.put("studentId", "2016125008");
//		param.put("firstvoluntary", "农业机械化及其自动化");
//		param.put("secondvoluntary", "农业工程");
//		param.put("thirdvoluntary", "交通运输");
//		param.put("credit", "4.12");
//		param.put("punished", "是");
//		param.put("telephone", "13800112233");
//		param.put("academic", "无");
//		param.put("performance", "表现优异");
//		ad.addApply(param);
//		System.out.println("ok...");
		
//		param.put("studentId", "2016125001");
//		HashMap<String, Object> res = null;
//		res = ad.getApplyInfo(param);
//		System.out.println(res);//打印结果
		
//		param.put("studentId", "2016125001");
//		param.put("firstvoluntary", "农业机械化及其自动化");
//		param.put("secondvoluntary", "农业工程");
//		param.put("thirdvoluntary", "交通运输");
//		param.put("credit", "4.12");
//		param.put("punished", "是");
//		param.put("telephone", "13800112233");
//		param.put("academic", "无");
//		param.put("performance", "表现优异");
//		ad.updateApply(param);
//		System.out.println("ok...");
	}

}
