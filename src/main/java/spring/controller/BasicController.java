package spring.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.apache.log4j.Logger;

import beans.MainBean;

public class BasicController implements ApplicationContextAware {
	protected ApplicationContext context = null;	
	
    public <T extends MainBean> T createBean(Class<T> type) {
    	MainBean bean = null;
    	
    	try {
    		bean = context.getBean(type);
		} catch (BeansException e) {
			Logger.getLogger(BasicController.class).error(e);
		}
    	
        return (T) bean;
    }
	
	public void setApplicationContext(ApplicationContext context) {
		try {
			this.context = context;
		} catch (BeansException e) {
			Logger.getLogger(BasicController.class).error(e);
		}
	}
}