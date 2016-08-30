#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import ${package}.AbstractContextTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertNotNull;

/**
 * The abstract class <code>AbstractGWTTest</code>
 */
public abstract class AbstractGWTTest extends AbstractContextTest {

    protected static WebDriver chromeDriver;


    /**
     * Before class setup.
     */
    @Override
    public void  beforeClassSetup() {
        super.beforeClassSetup();
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver();
        }
        assertNotNull(chromeDriver);
    }

    /**
     * After class setup.
     */
    @Override
    public void  afterClassSetup() {
        chromeDriver.quit();
    }


}