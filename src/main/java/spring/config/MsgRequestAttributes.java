package spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.ServletRequestAttributes;

public class MsgRequestAttributes extends ServletRequestAttributes {
    private HttpServletResponse response;
    
    public MsgRequestAttributes(HttpServletRequest request, HttpServletResponse response) {
        super(request);
        this.response = response;
    }
    
    public MsgRequestAttributes(HttpServletRequest request) {
        super(request);
    }
    
    public HttpServletResponse getResponse() {
        return response;
    }
}