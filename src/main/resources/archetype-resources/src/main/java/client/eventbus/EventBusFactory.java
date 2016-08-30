#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.eventbus;

import com.google.gwt.event.shared.SimpleEventBus;

/**
 * The type <code>EventBusFactory</code>
 */
public class EventBusFactory {

    /**
     * The constant eventBus.
     */
    private static SimpleEventBus eventBus = new SimpleEventBus();

    /**
     * Gets event bus.
     *
     * @return the event bus
     */
    public static SimpleEventBus getEventBus() {
        return eventBus;
    }
}
