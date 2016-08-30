#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.server.spring.ConfigTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * The abstract class <code>AbstractContextTest</code>
 */
@RunWith(SpringInstanceTestClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ConfigTest.class)
@ActiveProfiles("test")
public abstract class AbstractContextTest implements InstanceTestClassListener {

    /**
     * The <code>Environment</code> env.
     */
    @Autowired
    protected Environment env;

    /**
     * Before class setup.
     */
    @Override
    public void beforeClassSetup() {
        assertNotNull(env);
    }

    /**
     * After class setup.
     */
    @Override
    public void afterClassSetup() {

    }


}
