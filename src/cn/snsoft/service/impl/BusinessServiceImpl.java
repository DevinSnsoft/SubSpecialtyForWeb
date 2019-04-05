package cn.snsoft.service.impl;

import java.util.List;

import cn.snsoft.bean.Upfile;
import cn.snsoft.dao.UpfileDao;
import cn.snsoft.factory.DaoFactory;
//import cn.snsoft.service.BusinessService;

public class BusinessServiceImpl{
	private UpfileDao dao = DaoFactory.getInstance().createDao(UpfileDao.class);
	
	public void addUpfile(Upfile upfile){
		dao.add(upfile);
	}
	
	public List<?> getAllUpfile(){
		return dao.getAll();
	}

	public Upfile findUpfile(String id){
		return dao.find(id);
	}
	
	public void delete(String id){
		//放在事务中，先删数据库记录，再删文件
		dao.delete(id);
	}
}
