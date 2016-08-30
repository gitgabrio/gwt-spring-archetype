#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;
import ${package}.client.model.CustomerProxy;
import ${package}.server.service.AuthenticationService;
import ${package}.server.servicelocator.AuthenticationServiceLocator;

/**
 * The interface Authentication factory.
 */
public interface AuthenticationFactory extends RequestFactory {

    /**
     * Create authentication request ctx authentication request ctx.
     *
     * @return the authentication request ctx
     */
    AuthenticationRequestCtx createAuthenticationRequestCtx();

    /**
     * The interface Authentication request ctx.
     */
    @Service(value = AuthenticationService.class, locator = AuthenticationServiceLocator.class)
    interface AuthenticationRequestCtx extends RequestContext {


        /**
         * Logout customer request.
         *
         * @param customer the customer
         * @return the request
         */
        public Request<Void> logoutCustomer(CustomerProxy customer);


        /**
         * Gets customer.
         *
         * @param userName the user name
         * @param password the password
         * @return the customer
         */
        public Request<CustomerProxy> getCustomer(String userName, String password);
    }
}