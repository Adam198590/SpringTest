package logic;

import java.text.SimpleDateFormat;
import java.util.Date;


public class UserMsg {
	private String userName;
	private String userMessage;
	private String createTime;
		
	public UserMsg(String userName, String userMessage) {
		this.userName 		= userName;
		this.userMessage 	= userMessage;		
		this.createTime 	= new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
	}	
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	public String getCreateTime() {
		return createTime;
	}
}