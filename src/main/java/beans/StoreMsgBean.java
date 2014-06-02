package beans;

import logic.MsgManager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component(value = "storeBean")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class StoreMsgBean extends MainBean {
	private boolean isSended = false;
	
	public void init() {
		
		if (isParamExists("sendMsg")) {
			MsgManager manager = context.getBean("msgManager", MsgManager.class);
			
			manager.addNewMsg(
					getStringFromParam("nameField"), 
					getStringFromParam("msgField"));
			
			isSended = true;
		}
	}
	
	public boolean isSended() {
		return isSended;
	}
}