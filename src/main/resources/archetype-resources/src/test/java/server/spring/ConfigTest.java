#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The type <code>ConfigTest</code>
 */
@EnableWebMvc
@Configuration
@ComponentScan({"${package}"})
@PropertySource("classpath:application_test.properties")
@Profile("test")
public class ConfigTest  extends WebMvcConfigurerAdapter {

    /**
     * This is needed for @Value configuration to work properly
     *
     * @return property sources placeholder configurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}