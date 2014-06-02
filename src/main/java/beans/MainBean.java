package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class MainBean implements ApplicationContextAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected ApplicationContext context;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
    @Autowired
    public void setRequestContext(HttpServletRequest req, HttpServletResponse resp){
        setRequest(req);
        setResponse(resp);
    }
	
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }
    
    public ApplicationContext getApplicationContext(){
        return context;
    }
    
	public String getStringFromParam(String paramName) {
		if (request.getParameter(paramName) == null) {
			return "";
		} else {
			return request.getParameter(paramName);
		}
	}
	
	public boolean isParamExists(String name) {		
		return request.getParameter(name) != null;
	}
	
	public String getTitle() {
		return "MsgHost";
	}
}