#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * The type <code>LoginScreenTest</code>
 */
public class LoginScreenTest extends AbstractGWTTest {

    /**
     * Test simple loading
     */
    @Ignore
    @Test
    public void testLoad() {
        System.out.println("LoginScreenTest.testLoad");
        chromeDriver.get("localhost:8080/${artifactId}");
        assertTrue(true);
    }

    /**
     * Test actual fake login
     */
    @Test
    public void testLogin() {
        System.out.println("LoginScreenTest.testLogin");
        chromeDriver.get("localhost:8080/${artifactId}");
        WebDriverWait wait = new WebDriverWait(chromeDriver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        chromeDriver.findElement(By.id("user")).sendKeys("TestLogin");
        chromeDriver.findElement(By.id("password")).sendKeys("TestPassword");
        chromeDriver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
        chromeDriver.findElement(By.id("logout")).click();
    }
}