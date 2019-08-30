package NewPackage;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExampleTest {
    static WebDriver driver;
    @BeforeClass
    public static void beforeMethod() {
        driver = new ChromeDriver();
    }
    @Test
    public void testMethod() throws InterruptedException {
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        driver.findElement(By.cssSelector("input#login-form-username.text.medium-field")).sendKeys("myusername");
        driver.findElement(By.cssSelector("input#login-form-password.text.medium-field")).sendKeys("mypasswd");
        driver.findElement(By.cssSelector("input#login.aui-button.aui-button-primary")).click();
        Thread.sleep(500);
        List<WebElement> elements = driver.findElements(By.cssSelector("td.summary p"));
        for (WebElement el: elements) {
            System.out.println(el.findElement(By.cssSelector("a.issue-link")).getText());
        }
    }

    @AfterClass
    public static void afterMethod() {
        driver.quit();
    }

}

