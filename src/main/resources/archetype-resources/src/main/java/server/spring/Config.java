#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.spring;


import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * The type <code>Config</code>
 */
@EnableWebMvc
@Configuration
@ComponentScan({"${package}"})
@PropertySource("classpath:application.properties")
@Profile({"dev", "prod"})
public class Config {


    /**
     * This is needed for @Value configuration to work properly
     *
     * @return property sources placeholder configurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Handler mapping handler mapping.
     *
     * @return the handler mapping
     */
    @Bean
    public HandlerMapping handlerMapping() {
        RequestMappingHandlerMapping toReturn = new RequestMappingHandlerMapping();
        toReturn.setAlwaysUseFullPath(true);
        toReturn.setUseRegisteredSuffixPatternMatch(true);
        return toReturn;
    }
}
