#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/**
 * The interface <code>InstanceTestClassListener</code>
 */
public interface InstanceTestClassListener {

    void beforeClassSetup();

    void afterClassSetup();

}