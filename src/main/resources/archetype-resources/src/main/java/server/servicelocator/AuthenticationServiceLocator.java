#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.servicelocator;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import ${package}.server.service.AuthenticationService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


/**
 * The type <code>AuthenticationServiceLocator</code>
 */
public class AuthenticationServiceLocator implements ServiceLocator {
    /**
     * The constant serviceInstance.
     */
    private static AuthenticationService serviceInstance;

    /**
     * Gets instance.
     *
     * @param clazz the clazz
     * @return the instance
     */
    @Override
    public Object getInstance(Class<?> clazz) {
        return getServiceInstance();
    }

    /**
     * Gets service instance.
     *
     * @return the service instance
     */
    private static AuthenticationService getServiceInstance() {
        if (serviceInstance == null) {
            HttpServletRequest request = RequestFactoryServlet
                    .getThreadLocalRequest();
            ServletContext servletCtx = request.getSession()
                    .getServletContext();
            ApplicationContext springCtx = WebApplicationContextUtils
                    .getWebApplicationContext(servletCtx);
            serviceInstance = springCtx.getBean(AuthenticationService.class);
        }
        return serviceInstance;
    }
}
