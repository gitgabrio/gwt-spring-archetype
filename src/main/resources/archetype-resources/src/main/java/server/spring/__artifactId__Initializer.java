#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.spring;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Properties;

import ${package}.server.utils.PropertiesLoader;

/**
 * The type <code>${artifactId}Initializer</code>.
 */
public class ${artifactId}Initializer implements WebApplicationInitializer {


    /**
     * The constant <code>Logger</code> logger.
     */
    private static Logger logger = LoggerFactory.getLogger(WebApplicationInitializer.class);

    /**
     * The constant <code>PropertiesLoader</code> propertiesLoader.
     */
    private static final PropertiesLoader propertiesLoader = new PropertiesLoader();

    /**
     * On startup.
     *
     * @param container the container
     * @throws <code>ServletException</code> the servlet exception
     */
    public void onStartup(ServletContext container) throws ServletException {
        logger.debug("${artifactId}");
        AnnotationConfigWebApplicationContext ctx = getContext();
        ctx.register(Config.class);
        ctx.setServletContext(container);
        // Mapping Spring dispatcher
        ServletRegistration.Dynamic springDispatcher = container.addServlet("spring-dispatcher", new DispatcherServlet(ctx));
        springDispatcher.setLoadOnStartup(0);
        springDispatcher.addMapping("*.rpc", "/downloader/*");
        // Mapping GWT requestFactory servlet
        ServletRegistration.Dynamic requestFactoryServlet = container.addServlet("requestFactoryServlet", new RequestFactoryServlet());
        requestFactoryServlet.setLoadOnStartup(1);
        requestFactoryServlet.addMapping("/gwtRequest");
        requestFactoryServlet.setInitParameter("symbolMapsDirectory", "WEB-INF/deploy/${artifactId}/symbolMaps");
        container.addListener(new ContextLoaderListener(ctx));
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext toReturn = new AnnotationConfigWebApplicationContext();
        toReturn.setConfigLocation("${package}.server.spring");
        Properties prop = propertiesLoader.load("application.properties");
        toReturn.getEnvironment().setActiveProfiles(prop.getProperty("spring.profiles", "dev"));
        return toReturn;
    }

}