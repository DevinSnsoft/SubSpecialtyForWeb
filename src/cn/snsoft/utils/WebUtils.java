package cn.snsoft.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.snsoft.bean.Upfile;

public class WebUtils {

	@SuppressWarnings("unchecked")
	public static Upfile doUpload(HttpServletRequest request, String uppath) throws FileSizeLimitExceededException {
		Upfile bean = new Upfile();
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			upload.setFileSizeMax(1000*1000*500);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(bean, name, value);	
				}else{
					//得到上传文件名
					String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);
					//得到文件的保存名称
					String uuidname = genearteFilename(filename);
					//得到文件的保存路径
					String savepath = generateSavePath(uppath, uuidname);
				
					InputStream in = item.getInputStream();
					int len =0;
					byte buffer[] = new byte[1024];
					FileOutputStream out = new FileOutputStream(savepath+"\\"+uuidname);
					while((len=in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
					
					bean.setFilename(filename);
					bean.setId(UUID.randomUUID().toString());
					bean.setSavepath(savepath);
					bean.setUptime(new Date());
					bean.setUuidname(uuidname);
				}
			}
			return bean;
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			throw e;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	public static String genearteFilename(String filename){
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		return UUID.randomUUID().toString();
	}
	
	private static String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&15;
		int dir2 = (hashcode>>4)&0xf;
		
		String savepath = path + File.separator +dir1 + File.separator + dir2;
		File file = new File(savepath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savepath;
	}
}
