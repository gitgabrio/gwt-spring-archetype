#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event;
import ${package}.client.model.CustomerProxy;

/**
 * The type <code>CustomerLoginEvent</code>
 */
public class CustomerLoginEvent extends Event<CustomerLoginEvent.CustomerLoginHandler> {

    /**
     * The interface Customer login handler.
     */
    public interface CustomerLoginHandler {
        /**
         * Manage event.
         *
         * @param event the event
         */
        void manageEvent(CustomerLoginEvent event);
    }

    /**
     * The constant TYPE.
     */
    public static final GwtEvent.Type<CustomerLoginHandler> TYPE = new GwtEvent.Type<>();


    /**
     * The Customer.
     */
    private CustomerProxy customer;

    /**
     * Instantiates a new Customer login event.
     *
     * @param customer the customer
     */
    public CustomerLoginEvent(CustomerProxy customer) {
        this.customer = customer;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public CustomerProxy getCustomer() {
        return customer;
    }

    /**
     * Gets associated type.
     *
     * @return the associated type
     */
    @Override
    public Type<CustomerLoginHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * Dispatch.
     *
     * @param handler the handler
     */
    @Override
    protected void dispatch(CustomerLoginHandler handler) {
        handler.manageEvent(this);
    }
}