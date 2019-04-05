package cn.snsoft.exception;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 (c) 2016
 * 
 * @author Mr. Soldier
 * 
 * @version 1.0
 * 
 * @date 2016年7月9日 下午2:29:17
 * 
 * @Description TODO
 *	连接超时异常
 */
public class ConnectTimeOutException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConnectTimeOutException() {

	}

	public ConnectTimeOutException(String detailMessage) {
		super(detailMessage);
	}
	
}
