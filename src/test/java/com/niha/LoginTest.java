import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginTest {

  @Test
  public void test_login_with_incorrect_credentials() {

    // // Tell Selenium where ChromeDriver is located on your computer
    // System.setProperty("webdriver.chrome.driver",
    // "C:\\ChromeDriver\\chromedriver.exe");

    // Set options for Chrome browser
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless"); // no visible window
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

    // Launch Chrome browser
    WebDriver driver = new ChromeDriver(options);

    // Open the login page
    driver.navigate().to("http://103.139.122.250:4000/");

    // Enter wrong email and password
    driver.findElement(By.name("email")).sendKeys("qasim@malik.com");
    driver.findElement(By.name("password")).sendKeys("abcdefg");

    // Click the login button
    driver.findElement(By.id("m_login_signin_submit")).click();

    // Wait 5 seconds for the page to respond
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    // Find the error message on the page
    String errorText = driver.findElement(By.xpath(
        "/html/body/div/div/div[1]/div/div/div/div[2]/form/div[1]")).getText();

    // Check that the error message contains the expected text
    assertTrue("Error message not found", errorText.contains("Incorrect email or password"));

    // Close the browser
    driver.quit();
  }
}
