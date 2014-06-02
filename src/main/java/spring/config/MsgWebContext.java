package spring.config;

import javax.servlet.ServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MsgWebContext extends AnnotationConfigWebApplicationContext {
	
    private static class ResponseFactory implements ObjectFactory<ServletResponse> {
    	
        public ServletResponse getObject() throws BeansException {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if(!(requestAttributes instanceof MsgRequestAttributes)){
                throw new IllegalStateException("Current request is not a MsgHost servlet request");
            }
            
            return ((MsgRequestAttributes)requestAttributes).getResponse();
        }
    }
    
    public MsgWebContext() {
        scan(
        		"spring.config", 
        		"spring.controller", 
        		"beans"
        	);
    }
    
    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        super.postProcessBeanFactory(beanFactory);
        
        beanFactory.registerResolvableDependency(ServletResponse.class, new ResponseFactory());
    }
}