package cn.snsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import cn.snsoft.utils.JdbcUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2017
 * 
 * @author 14信息慎伟康
 * 
 * @version 1.0
 * 
 * @date 2017年1月26日 下午4:21:38
 * 
 * @Description TODO
 *		操作数据库，获取学生个人信息
 */
public class DaoDemo {
	
	/**
	 * 根据学号获取学生信息
	 * @param param
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
		String sql = "SELECT * FROM tb_student WHERE studentId = ?";
		
		try {
			conn = JdbcUtil.getConnection();//取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("studentId"));//设置参数
			rs = pstat.executeQuery();//查询
			result = JdbcUtil.getHashMap(rs);//获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//关闭资源
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}
	
	/*
	 * 测试dao
	 */
	public static void main(String[] args) {
		DaoDemo dd = new DaoDemo();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("studentId", "2016125001");
		HashMap<String, Object> res = null;
		try {
			res = dd.getStudentInfo(param);//调用方法
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(res);//打印结果
		
	}
	
}
