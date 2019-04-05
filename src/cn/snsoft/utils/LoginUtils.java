package cn.snsoft.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 (c) 2016
 * 
 * @author Mr. 李竹林 
 * 
 * @version 1.0
 * 
 * @date 2016年7月9日 下午12:47:27
 * 
 * @Description TODO
 *  	教务处验证账号密码工具类
 */
public class LoginUtils {
    
	/**
	 * @Title: 自己定义的加密方法
	 * @Package me
	 * @Description: 通过3次MD5加密，且期中后2次有参数引入
	 * @author 李竹林
	 * @date 2016-2-23
	 * @version V1.0
	 */
	public String doEncryptURP(String inputStr) {
		String outputStr = "";
		outputStr = myMD5(myMD5(myMD5(inputStr) + "lzl") + "19760317");
		return outputStr;
	}
	
	/**
	 * @Title: MD5加密方法
	 * @Package me
	 * @Description:
	 * @author 李竹林
	 * @date 2016-2-20
	 * @version V1.0
	 */
	private String myMD5(String inputStr) {
		String outputStr = "";
		try {
			// 1.初始化MessageDigest信息摘要对象,并指定为MD5不分大小写都可以
			MessageDigest md = MessageDigest.getInstance("md5");
			// 2.传入需要计算的字符串更新摘要信息，传入的为字节数组byte[],
			// 将字符串转换为字节数组使用getBytes()方法完成
			// 指定时其字符编码 为utf-8
			md.update(inputStr.getBytes("utf-8"));
			// 3.计算信息摘要digest()方法
			// 返回值为字节数组
			byte[] hashCode = md.digest();
			// 4.将byte[] 转换为找度为32位的16进制字符串
			// 声明StringBuffer对象来存放最后的值
			StringBuffer sb = new StringBuffer();
			// 遍历字节数组
			for (byte b : hashCode) {
				// 对数组内容转化为16进制，
				sb.append(Character.forDigit(b >> 4 & 0xf, 16));
				// 换2次为32位的16进制
				sb.append(Character.forDigit(b & 0xf, 16));
			}
			outputStr = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputStr;
	}

}
