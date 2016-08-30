#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.abstracts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import ${package}.client.event.CustomerLogoutEvent;
import ${package}.client.eventbus.EventBusFactory;
import ${package}.client.model.CustomerProxy;
import ${package}.client.requestfactory.AuthenticationFactory;
import ${package}.client.requestfactory.FactoryFactory;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.TextBox;

/**
 * The abstract class CommonView
 */
public abstract class CommonView extends Composite {


    /**
     * The interface Staff view ui binder.
     */
    interface CommonViewUiBinder extends UiBinder<HTMLPanel, CommonView> {
    }

    /**
     * The constant ourUiBinder.
     */
    private static CommonViewUiBinder ourUiBinder = GWT.create(CommonViewUiBinder.class);

    /**
     * The First name.
     */
    @UiField
    protected TextBox firstName;
    /**
     * The Last name.
     */
    @UiField
    protected TextBox lastName;

    /**
     * The Logout.
     */
    @UiField
    protected Button logout;


    /**
     * The Authentication factory.
     */
    protected AuthenticationFactory authenticationFactory = FactoryFactory.getAuthenticationFactory();


    /**
     * The CustomerProxy.
     */
    protected CustomerProxy customerProxy;

    public CommonView(CustomerProxy customerProxy) {
        this.customerProxy = customerProxy;
        initWidget(ourUiBinder.createAndBindUi(this));
        firstName.setText(customerProxy.getFirstName());
        lastName.setText(customerProxy.getLastName());
    }


    /**
     * Logout.
     *
     * @param
     */
    @UiHandler("logout")
    public void logout(ClickEvent event) {
        AuthenticationFactory.AuthenticationRequestCtx authenticationRequestCtx = authenticationFactory.createAuthenticationRequestCtx();
        Request<Void> request = authenticationRequestCtx.logoutCustomer(customerProxy);
        request.fire(getLogoutReceiver());
    }


    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    protected Receiver<Void> getLogoutReceiver() {
        Receiver<Void> toReturn = new Receiver<Void>() {
            @Override
            public void onSuccess(Void response) {
                fireLogout();
            }

            @Override
            public void onFailure(ServerFailure error) {
                fireLogout();
            }
        };
        return toReturn;
    }

    /**
     * Fire logout.
     */
    protected void fireLogout() {
        EventBusFactory.getEventBus().fireEvent(new CustomerLogoutEvent());
    }


}
