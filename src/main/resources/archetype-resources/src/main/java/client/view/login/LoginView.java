#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * The type <code>LoginView</code>
 */
public class LoginView extends Composite {
    /**
     * The interface Login screen ui binder.
     */
    interface LoginViewUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    /**
     * The constant ourUiBinder.
     */
    private static LoginViewUiBinder ourUiBinder = GWT.create(LoginViewUiBinder.class);

    /**
     * Instantiates a new Login screen.
     */
    public LoginView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


}