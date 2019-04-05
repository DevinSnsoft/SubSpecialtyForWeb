package cn.snsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.snsoft.bean.ClassSpecialtyBean;
import cn.snsoft.bean.EnrollBean;
import cn.snsoft.bean.QueryResult;
import cn.snsoft.bean.StudentBean;
import cn.snsoft.exception.DaoException;
import cn.snsoft.utils.JdbcUtil;

public class ApplyDao2 {
	/*
	 * //根据大类名称查专业信息 public HashMap<String,Object>
	 * getAllSpecialty(HashMap<String, String> params) throws SQLException{
	 * //返回结果 HashMap<String, Object> result = new HashMap<String, Object>();
	 * Connection conn = null; PreparedStatement st = null; ResultSet rs = null;
	 * 
	 * try{ conn = JdbcUtils.getConnection(); String sql =
	 * "select * from tb_classSpecialty where className=?"; st =
	 * conn.prepareStatement(sql); st.setString(1,
	 * params.get("className"));//设置参数 rs = st.executeQuery();//结果集 result =
	 * JdbcUtils.getHashMap(rs);//获取处理后的结果集 }catch(SQLException e){
	 * e.printStackTrace(); }finally{ JdbcUtils.close(rs); JdbcUtils.close(st);
	 * JdbcUtils.close(conn); } return result; }
	 */
	public static List<ClassSpecialtyBean> getAllSpecialty(
			HashMap<String, String> params) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_classSpecialty where className=?";
			st = conn.prepareStatement(sql);
			st.setString(1, params.get("className"));
			rs = st.executeQuery();
			
			List<ClassSpecialtyBean> list = new ArrayList<ClassSpecialtyBean>();
			while (rs.next()) {
				ClassSpecialtyBean c = new ClassSpecialtyBean();
				c.setId(rs.getString("id"));
				c.setClassCode(rs.getString("classCode"));
				c.setClassName(rs.getString("className"));
				c.setSubSpecialtyCode(rs.getString("subSpecialtyCode"));
				c.setSubSpecialtyName(rs.getString("subSpecialtyName"));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	// 得到所有学生信息
	public static List<StudentBean> getAllstudent() throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_student";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<StudentBean> list = new ArrayList<StudentBean>();
			while (rs.next()) {
				StudentBean sb = new StudentBean();
				sb.setStudentId(rs.getString("studentId"));
				sb.setStudentName(rs.getString("studentName"));
				sb.setSex(rs.getString("sex"));
				sb.setClasses(rs.getString("classes"));
				sb.setCredit(rs.getString("credit"));
				sb.setEntryDate(rs.getDate("entryDate"));
				sb.setFaculty(rs.getString("faculty"));
				sb.setClassName(rs.getString("className"));
				list.add(sb);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	// 得到所有报名学生的信息
	public static List<EnrollBean> getAllApplyInfo() throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_enroll";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<EnrollBean> list = new ArrayList<EnrollBean>();
			while (rs.next()) {
				EnrollBean sb = new EnrollBean();
				sb.setStudentId(rs.getString("studentId"));
				// sb.setFirstVoluntary(rs.getString("studentName"));
				// sb.setSex(rs.getString("sex"));
				// sb.setClasses(rs.getString("classes"));
				// sb.setCredit(rs.getString("credit"));
				// sb.setEntryDate(rs.getDate("entryDate"));
				// sb.setFaculty(rs.getString("faculty"));
				// sb.setClassName(rs.getString("className"));
				list.add(sb);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	// 根据第一志愿得到所有报名学生的学号
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getAllStuIDFromFirst(HashMap<String, String> params)
			throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select studentId from tb_enroll where firstvoluntary=?";
			st = conn.prepareStatement(sql);
			st.setString(1, params.get("firstvoluntary"));// 设置参数
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				@SuppressWarnings("unused")
				EnrollBean sb = new EnrollBean();
				// sb.setStudentId(rs.getString("studentId"));
				String studentId = rs.getString("studentId");
				list.add(studentId);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	// 根据第二志愿得到所有报名学生的学号
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getAllStuIDFromSecond(HashMap<String, String> params)
			throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select studentId from tb_enroll where secondvoluntary=?";
			st = conn.prepareStatement(sql);
			st.setString(1, params.get("secondvoluntary"));// 设置参数
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				@SuppressWarnings("unused")
				EnrollBean sb = new EnrollBean();
				// sb.setStudentId(rs.getString("studentId"));
				String studentId = rs.getString("studentId");
				list.add(studentId);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	// 根据第三志愿得到所有报名学生的学号
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getAllStuIDFromThird(HashMap<String, String> params)
			throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select studentId from tb_enroll where thirdvoluntary=?";
			st = conn.prepareStatement(sql);
			st.setString(1, params.get("thirdvoluntary"));// 设置参数
			rs = st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				@SuppressWarnings("unused")
				EnrollBean sb = new EnrollBean();
				// sb.setStudentId(rs.getString("studentId"));
				String studentId = rs.getString("studentId");
				list.add(studentId);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	// 根据学号查学分绩点
	public HashMap<String, Object> getCreditFromStuId(
			HashMap<String, String> params) throws SQLException {
		// 返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select credit from tb_enroll where studentId=?";
			st = conn.prepareStatement(sql);
			st.setString(1, params.get("studentId"));// 设置参数
			rs = st.executeQuery();
			result = JdbcUtil.getHashMap(rs);// 获取处理后的结果集
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
		return result;
	}

	/**
	 * 获取管理员信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public HashMap<String, Object> getAdminInfo(HashMap<String, String> params)
			throws SQLException {
		// 返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT account,password,name " + "FROM tb_admin "
				+ "WHERE account = ?";

		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("account"));// 设置参数
			rs = pstat.executeQuery();// 查询
			result = JdbcUtil.getHashMap(rs);// 获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}

	// 获取到页面数据和页面大小
	@SuppressWarnings("resource")
	public QueryResult pageQuery(int startindex, int pagesize) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		QueryResult qr = new QueryResult();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_enroll limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, startindex);
			st.setInt(2, pagesize);
			rs = st.executeQuery();
			List<EnrollBean> list = new ArrayList<EnrollBean>();
			while (rs.next()) {
				EnrollBean e = new EnrollBean();
				e.setStudentId(rs.getString("studentId"));
				e.setEntryDate(rs.getTimestamp("time"));
				e.setFirstVoluntary(rs.getString("firstvoluntary"));
				e.setSecondVoluntary(rs.getString("secondvoluntary"));
				e.setThirdVoluntary(rs.getString("thirdvoluntary"));
				e.setPunished(rs.getString("punished"));
				e.setTelephone(rs.getString("telephone"));
				e.setAcademic(rs.getString("academic"));
				e.setPerformance(rs.getString("performance"));
				list.add(e);
			}
			qr.setList(list);

			sql = "select count(*) from tb_enroll";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				qr.setTotalrecord(rs.getInt(1));
			}
			return qr;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(conn, st, rs);
		}
	}

	/**
	 * 添加用户反馈信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public void addFeedback(HashMap<String, String> params) throws SQLException {

		Connection conn = null;
		PreparedStatement pstat = null;
		String sql = "INSERT INTO tb_feedBack(studentId,time,message)"
				+ "VALUES(?,NOW(),?);";

		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			// pstat.setString(1, params.get("id"));//设置参数
			pstat.setString(1, params.get("studentId"));
			pstat.setString(2, params.get("message"));
			pstat.executeUpdate();// 插入数据

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, null);
		}
	}

	/**
	 * 获取控制信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public HashMap<String, Object> getControllInfo(
			HashMap<String, String> params) throws SQLException {
		// 返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT id,illustration,sign " + "FROM tb_controll "
				+ "WHERE id = ?";

		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("id"));// 设置参数
			rs = pstat.executeQuery();// 查询
			result = JdbcUtil.getHashMap(rs);// 获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}

	/**
	 * 获取志愿排名信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Description TODO
	 */
	public HashMap<String, Object> sort(HashMap<String, String> params)
			throws SQLException {
		// 返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT (*) FROM tb_enroll " + "WHERE firstvoluntary = ?";

		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("firstvoluntary"));// 设置参数
			rs = pstat.executeQuery();// 查询
			result = JdbcUtil.getHashMap(rs);// 获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}

	/*
	 * 根据大类名称查找大类下共有多少人
	 */
	public HashMap<String, Object> getSumFromClassName(
			HashMap<String, String> params) throws SQLException {
		// 返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM tb_student WHERE className = ?";

		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("className"));// 设置参数
			rs = pstat.executeQuery();// 查询
			result = JdbcUtil.getHashMap(rs);// 获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}

	/*
	 * 根据大类名称查找已经报名的共有多少人
	 */
	public HashMap<String, Object> getEnrollSumFromClassName(
			HashMap<String, String> params) throws SQLException {
		// 返回结果
		HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM tb_enroll WHERE className = ?";

		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("className"));// 设置参数
			rs = pstat.executeQuery();// 查询
			result = JdbcUtil.getHashMap(rs);// 获取处理后的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return result;
	}

	/*
	 * 根据大类名称查找对应大类下的所有学生学号
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getStuIdFromClassName(HashMap<String, String> params)
			throws SQLException {
		// 返回结果
		//HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT studentId FROM tb_student WHERE className = ?";
		List list = new ArrayList();
		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, params.get("className"));// 设置参数
			rs = pstat.executeQuery();// 查询
			while (rs.next()) {
//				EnrollBean sb = new EnrollBean();
				String studentId = rs.getString("studentId");
				list.add(studentId);
			}
//			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return list;
	}
	
	/*
	 * 在报名表中得到所有学生学号
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getStuIdFromEnroll() throws SQLException {
		// 返回结果
		//HashMap<String, Object> result = new HashMap<String, Object>();

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = "SELECT studentId FROM tb_enroll";
		List list = new ArrayList();
		try {
			conn = JdbcUtil.getConnection();// 取得连接
			pstat = conn.prepareStatement(sql);
//			pstat.setString(1, params.get("className"));// 设置参数
			rs = pstat.executeQuery();// 查询
			while (rs.next()) {
//				EnrollBean sb = new EnrollBean();
				String studentId = rs.getString("studentId");
				list.add(studentId);
			}
//			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(conn, pstat, rs);
		}
		return list;
	}
	/*
	// 根据第一志愿得到所有报名学生的学号
		public static List getAllStuIDFromFirst2(HashMap<String, String> params)
				throws SQLException {
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				conn = JdbcUtils.getConnection();
				String sql = "select studentId from tb_enroll where firstvoluntary=?";
				st = conn.prepareStatement(sql);
				st.setString(1, params.get("firstvoluntary"));// 设置参数
				rs = st.executeQuery();
				List list = new ArrayList();
				while (rs.next()) {
					EnrollBean sb = new EnrollBean();
					// sb.setStudentId(rs.getString("studentId"));
					String studentId = rs.getString("studentId");
					list.add(studentId);
				}
				return list;
			} catch (Exception e) {
				throw new DaoException(e);
			} finally {
				JdbcUtils.close(rs);
				JdbcUtils.close(st);
				JdbcUtils.close(conn);
			}
		}*/
	
	/*
	 * 测试dao
	 */

	public static void main(String[] args) throws SQLException {
		ApplyDao2 ad = new ApplyDao2();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("studentId", "2016188053");
		param.put("message", "第三次测试！！");
		ad.addFeedback(param);
		/*
		 * String param = "植物生产类"; List<ClassSpecialtyBean> bean = null; try {
		 * bean = ad.getAll(param);//调用方法 for() } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		// param.put("className", "植物生产类");
		// List<ClassSpecialtyBean> list = getAllSpecialty(param);
		// Gson JSON = new Gson();
		// String jsonString = JSON.toJson(list); //转json
		// System.out.println(jsonString);
		// List<ClassSpecialtyBean> Beans = getAllSpecialty(param);
		// String str = Beans.toString();
		// System.out.println(str);
		// for(ClassSpecialtyBean bean : Beans){
		// System.out.println(bean.getId());
		// System.out.println(bean.getClassCode());
		// System.out.println(bean.getClassName());
		// System.out.println(bean.getSubSpecialtyCode());
		// System.out.println(bean.getSubSpecialtyName());
		// System.out.println("========================");
		// }
		/*
		 * List<StudentBean> Beans = getAllstudent(); for(StudentBean bean :
		 * Beans){ System.out.println(bean.getStudentId());
		 * System.out.println(bean.getStudentName());
		 * System.out.println(bean.getClassName());
		 * System.out.println(bean.getClasses());
		 * System.out.println(bean.getCredit());
		 * System.out.println(bean.getFaculty());
		 * System.out.println(bean.getSex());
		 * System.out.println(bean.getEntryDate());
		 * System.out.println("========================"); }
		 */
	}
}