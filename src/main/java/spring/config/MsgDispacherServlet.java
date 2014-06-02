package spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

public class MsgDispacherServlet extends DispatcherServlet {    
    @Override
    protected ServletRequestAttributes buildRequestAttributes(HttpServletRequest request, HttpServletResponse response, RequestAttributes previousAttributes) {
        if (previousAttributes == null || previousAttributes instanceof MsgRequestAttributes) {
            return new MsgRequestAttributes(request, response);
        } else {
            return null;  
        }
    }
}
