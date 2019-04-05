package cn.snsoft.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import cn.snsoft.bean.ClassSpecialtyBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2016
 * 
 * @author 14信息慎伟康
 * 
 * @version 1.0
 * 
 * @date 2016年10月20日 下午1:55:38
 * 
 * @Description TODO
 *    jdbc工具类
 */
public class JdbcUtils2 {
	
    private static ComboPooledDataSource dataSource;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * 取得数据源
	 * @return
	 */
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 取得连接
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 取得连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getMySQlConnection() throws SQLException{
		//返回当前线程绑定的连接
		Connection conn = tl.get();
		
		//如果线程未绑定连接对象
		if(conn == null){
			//取得连接池的一个空闲连接对象
			conn = dataSource.getConnection();
			//绑定到当前线程
			tl.set(conn);
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(Connection conn) throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	public static void close(Statement stat) throws SQLException{
		if(stat != null){
			stat.close();
		}
	}
	public static void close(ResultSet rs) throws SQLException{
		if(rs != null){
			rs.close();
		}
	}
	
	/**
	 * 开启事务
	 * @throws SQLException 
	 */
	public static void startTransaction() throws SQLException{
		Connection conn = getMySQlConnection();
		if(conn != null){
			conn.setAutoCommit(false);
		}
	}
	
	/**
	 * 事务回滚
	 * @throws SQLException 
	 */
	public static void rollback() throws SQLException{
		Connection conn = getMySQlConnection();
        if(conn != null){
        	conn.rollback();
		}
	}
	
	/**
	 * 事务提交
	 * @throws SQLException 
	 */
	public static void commit() throws SQLException{
		Connection conn = getMySQlConnection();
		if(conn != null){
			conn.commit();
		}
	}
	
	/**
	 * 解除当前线程的绑定，关闭连接
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException{
		Connection conn = getMySQlConnection();
		if(conn != null){
			conn.close();
			tl.remove();
		}
	}
	
	public static HashMap<String, Object> getHashMap(ResultSet rs) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		result = getList(rs);
		if(result == null || result.size() == 0){
			return null;
		}else{
			return result.get(0);
		}
	}
	
	
	/**
	 * 处理结果集
	 * @param rs
	 * @return
	 * @Description TODO
	 */
	public static List<HashMap<String, Object>> getList(ResultSet rs) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> temp = null;
		ResultSetMetaData rsmd = null;
		try {
			rsmd = rs.getMetaData();
			while(rs.next()){
				temp = new HashMap<String, Object>();
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					temp.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				result.add(temp);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result == null || result.size() == 0){
			return null;
		}else{
			return result;
		}
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(st!=null){
					try{
						st.close();
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try{
								conn.close();
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}

