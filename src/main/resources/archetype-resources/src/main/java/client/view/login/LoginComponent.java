#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import ${package}.client.event.CustomerLoginEvent;
import ${package}.client.eventbus.EventBusFactory;
import ${package}.client.model.CustomerProxy;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;

/**
 * The type <code>LoginComponent</code>
 */
public class LoginComponent extends AbstractLoginComponent {
    /**
     * The interface Fake login ui binder.
     */
    interface LoginComponentUiBinder extends UiBinder<HTMLPanel, LoginComponent> {
    }

    /**
     * The constant ourUiBinder.
     */
    private static LoginComponentUiBinder ourUiBinder = GWT.create(LoginComponentUiBinder.class);

    /**
     * The User input.
     */
    @UiField
    Input userInput;
    /**
     * The Password box.
     */
    @UiField
    Input passwordInput;
    /**
     * The Submit button.
     */
    @UiField
    Button loginButton;

    /**
     * Instantiates a new Social login view.
     */
    public LoginComponent() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    /**
     * Login.
     *
     * @param event the event
     */
    @UiHandler("loginButton")
    public void login(ClickEvent event) {
        Request<CustomerProxy> request = authenticationFactory.createAuthenticationRequestCtx().getCustomer(userInput.getText(), passwordInput.getText());
        request.fire(getReceiver());
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    private Receiver<CustomerProxy> getReceiver() {
        Receiver<CustomerProxy> toReturn = new Receiver<CustomerProxy>() {
            @Override
            public void onSuccess(CustomerProxy response) {
                if (response == null) {
                    onFailure(new ServerFailure("Failed to login customer"));
                } else {
                    getLoginPopupPanel(response.getConnectionId()).center();
                    CustomerLoginEvent loginEvent = new CustomerLoginEvent(response);
                    EventBusFactory.getEventBus().fireEvent(loginEvent);
                }
            }
        };
        return toReturn;
    }

    /**
     * Gets login popup panel.
     *
     * @param connectionId the connection id
     * @return the login popup panel
     */
    private PopupPanel getLoginPopupPanel(String connectionId) {
        final PopupPanel toReturn = new PopupPanel();
        toReturn.setTitle("Successful Login");
        VerticalPanel verticalPanel = new VerticalPanel();
        Label label = new Label("Connection ID : " + connectionId);
        Button button = new Button("Close");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                toReturn.hide();
            }
        });
        verticalPanel.add(label);
        verticalPanel.add(button);
        toReturn.setWidget(verticalPanel);
        return toReturn;
    }


}