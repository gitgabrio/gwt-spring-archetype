#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.customer;

import ${package}.client.model.CustomerProxy;
import ${package}.client.view.abstracts.CommonView;

/**
 * The type <code>CustomerView</code>
 */
public class CustomerView extends CommonView {

    /**
     * Instantiates a new Customer view.
     *
     * @param customer the customer
     */
    public CustomerView(CustomerProxy customer) {
        super(customer);
    }


}