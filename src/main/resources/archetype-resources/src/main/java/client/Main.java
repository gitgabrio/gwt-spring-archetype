#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import ${package}.client.event.CustomerLoginEvent;
import ${package}.client.event.CustomerLogoutEvent;
import ${package}.client.eventbus.EventBusFactory;
import ${package}.client.model.CustomerProxy;
import ${package}.client.requestfactory.AuthenticationFactory;
import ${package}.client.requestfactory.FactoryFactory;
import ${package}.client.view.customer.CustomerView;
import ${package}.client.view.login.LoginScreen;


/**
 * The type <code>Main</code>
 */
public class Main implements EntryPoint, CustomerLoginEvent.CustomerLoginHandler, CustomerLogoutEvent.CustomerLogoutHandler {


    /**
     * The Authentication factory authenticationFactory <code>AuthenticationFactory</code>.
     */
    private AuthenticationFactory authenticationFactory;

    /**
     * The <code>Event bus</code> SimpleEventBus <code>SimpleEventBus</code>.
     */
    private SimpleEventBus eventBus;


    /**
     * On module load.
     */
    @Override
    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
            @Override
            public void onUncaughtException(Throwable e) {
                ensureNotUmbrella(e);
            }
        });
        eventBus = EventBusFactory.getEventBus();
        eventBus.addHandler(CustomerLoginEvent.TYPE, this);
        eventBus.addHandler(CustomerLogoutEvent.TYPE, this);
        authenticationFactory = FactoryFactory.getAuthenticationFactory();
        showLoginScreen();
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(CustomerLoginEvent event) {
        showCustomerView(event.getCustomer());
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(CustomerLogoutEvent event) {
        logout();
    }

    /**
     * Logout.
     */
    private void logout() {
        String path = Window.Location.getPath();
        GWT.log("Opening " + path);
        Window.open(path, "_self", "enabled");
    }

    /**
     * Show login screen.
     */
    private void showLoginScreen() {
        RootPanel content = RootPanel.get("content");
        content.clear();
        LoginScreen loginScreen = new LoginScreen();
        content.add(loginScreen);
    }

    /**
     * Show customer view.
     *
     * @param customer the customer
     */
    private void showCustomerView(CustomerProxy customer) {
        CustomerView customerView = new CustomerView(customer);
        RootPanel content = RootPanel.get("content");
        content.clear();
        content.add(customerView);
    }

    /**
     * Ensure not umbrella.
     *
     * @param e the e
     */
    private void ensureNotUmbrella(Throwable e) {
        if (e == null) {
            return;
        }
        if (e instanceof UmbrellaException) {
            for (Throwable th : ((UmbrellaException) e).getCauses()) {
                ensureNotUmbrella(th);
            }
        } else {
            GWT.log(e.toString(), e);
        }
    }


}
