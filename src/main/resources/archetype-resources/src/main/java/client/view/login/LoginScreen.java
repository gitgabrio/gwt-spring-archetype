#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * The type <code>LoginScreen</code>
 */
public class LoginScreen extends Composite {
    /**
     * The interface Login screen ui binder.
     */
    interface LoginScreenUiBinder extends UiBinder<HTMLPanel, LoginScreen> {
    }

    /**
     * The constant ourUiBinder.
     */
    private static LoginScreenUiBinder ourUiBinder = GWT.create(LoginScreenUiBinder.class);

    /**
     * Instantiates a new Login screen.
     */
    public LoginScreen() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


}