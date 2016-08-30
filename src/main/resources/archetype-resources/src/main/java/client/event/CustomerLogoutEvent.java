#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event;

/**
 * The type <code>CustomerLogoutEvent</code>
 */
public class CustomerLogoutEvent extends Event<CustomerLogoutEvent.CustomerLogoutHandler> {

    /**
     * The interface Customer logout handler.
     */
    public interface CustomerLogoutHandler {
        /**
         * Manage event.
         *
         * @param event the event
         */
        void manageEvent(CustomerLogoutEvent event);
    }

    /**
     * The constant TYPE.
     */
    public static final GwtEvent.Type<CustomerLogoutHandler> TYPE = new GwtEvent.Type<>();


    /**
     * Instantiates a new Customer logout event.
     */
    public CustomerLogoutEvent() {

    }


    /**
     * Gets associated type.
     *
     * @return the associated type
     */
    @Override
    public Type<CustomerLogoutHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * Dispatch.
     *
     * @param handler the handler
     */
    @Override
    protected void dispatch(CustomerLogoutHandler handler) {
        handler.manageEvent(this);
    }
}