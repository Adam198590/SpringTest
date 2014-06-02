package beans;

import java.util.List;

import logic.MsgManager;
import logic.UserMsg;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component(value = "viewBean")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ViewMsgBean extends MainBean {
	private MsgManager manager 		= null;
	private List<UserMsg> messages 	= null;
	
	public void init() {
		manager = context.getBean("msgManager", MsgManager.class);
		initListMsg();
		
		if (isParamExists("sortByName")) {
			messages = manager.getSortedList(MsgManager.SortType.NAME);
		}
		
		if (isParamExists("sortByTime")) {
			messages = manager.getSortedList(MsgManager.SortType.CREATE_TIME);
		}
	}
	
	private void initListMsg() {
		messages = manager.getUsualList();
	}
	
	public List<UserMsg> getMessages() {
		return messages;
	}
}