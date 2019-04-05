package cn.snsoft.dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.snsoft.bean.Upfile;
import cn.snsoft.utils.JdbcUtils2;

public class UpfileDao {
	public void add(Upfile upfile){	
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils2.getDataSource());
			String sql = "insert into tb_file(id,uuidname,filename,savepath,uptime) values(?,?,?,?,?)";
			Object params[] = {upfile.getId(),upfile.getUuidname(),upfile.getFilename(),upfile.getSavepath(),upfile.getUptime()};
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public List<Upfile> getAll(){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils2.getDataSource());
			String sql = "select * from tb_file order by uptime desc";
			return (List<Upfile>)runner.query(sql, new BeanListHandler(Upfile.class));	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public Upfile find(String id){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils2.getDataSource());
			String sql = "select * from tb_file where id = ?";
			return (Upfile) runner.query(sql, id, new BeanHandler(Upfile.class));	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public void delete(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils2.getDataSource());
			String sql = "delete from tb_file where id= ?";
			runner.update(sql, id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public void update(Upfile upfile){
	}
}
