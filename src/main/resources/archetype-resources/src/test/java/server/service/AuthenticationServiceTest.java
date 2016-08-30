#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.service;

import ${package}.AbstractContextTest;
import ${package}.server.dto.CustomerBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * The type <code>AuthenticationServiceTest</code>
 */
public class AuthenticationServiceTest extends AbstractContextTest {

    @Autowired
    AuthenticationService authenticationService;

    @Override
    public void beforeClassSetup() {
        assertNotNull(authenticationService);
    }

    @Test
    public void testGetCustomer() {
        CustomerBean retrieved = authenticationService.getCustomer("user", "pass");
        assertNotNull(retrieved.toString(), retrieved);
        retrieved = authenticationService.getCustomer(null, "pass");
        assertNull("Retrieved a customer while null was expected", retrieved);
        retrieved = authenticationService.getCustomer("user", "");
        assertNull("Retrieved a customer while null was expected", retrieved);
    }

}