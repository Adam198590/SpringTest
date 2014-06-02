package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MsgManager {	
	private static List<UserMsg> messages = new ArrayList<UserMsg>();
	
	public static enum SortType {
		NAME,
		CREATE_TIME
	}
	
	public void addNewMsg(String userName, String msg) {
		synchronized (MsgManager.class) {
			messages.add(new UserMsg(userName, msg));
		}
	}
	
	class ByNameComparator implements Comparator<UserMsg> {

		public int compare(UserMsg o1, UserMsg o2) {
			return o1.getUserName().compareTo(o2.getUserName());
		}		
	}
	
	class ByCreateTimeComparator implements Comparator<UserMsg> {

		public int compare(UserMsg o1, UserMsg o2) {
			return o1.getCreateTime().compareTo(o2.getCreateTime());
		}		
	}
	
	public List<UserMsg> getUsualList() {
		return messages;
	}
	
	public List<UserMsg> getSortedList(SortType type) {		
		List<UserMsg> sortedList = null;
		
		synchronized (MsgManager.class) {
			sortedList = new ArrayList<UserMsg>(messages);
		}
		
		switch (type) {
			case NAME:
				Collections.sort(sortedList, new ByNameComparator());
				break;
	
			case CREATE_TIME:
				Collections.sort(sortedList, new ByCreateTimeComparator());
				break;
				
			default:
				break;
		}
		
		return sortedList;		
	}
}