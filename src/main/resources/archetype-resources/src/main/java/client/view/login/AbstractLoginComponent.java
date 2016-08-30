#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import com.google.gwt.user.client.ui.Composite;
import ${package}.client.requestfactory.AuthenticationFactory;
import ${package}.client.requestfactory.FactoryFactory;

/**
 * The abstract class AbstractLoginView
 */
public abstract class AbstractLoginComponent extends Composite {

    /**
     * The Authentication factory.
     */
    protected AuthenticationFactory authenticationFactory = FactoryFactory.getAuthenticationFactory();

}
