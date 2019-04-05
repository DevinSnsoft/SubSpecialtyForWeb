package cn.snsoft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class JdbcUtil {
	private static Properties config = new Properties();
	static{
		try {
			config.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(config.getProperty("driver"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
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
