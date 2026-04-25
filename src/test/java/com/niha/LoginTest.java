package com.niha;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
  @Test
  public void test_login_with_incorrect_credentials(){

    ChromeOptions options = new ChromeOptions();
    // options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

    WebDriver driver = new ChromeDriver(options);
        
    try{
      driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
      driver.get("http://103.139.122.250:4000/");

      driver.findElement(By.id("email")).sendKeys("qasim@malik.com");
            driver.findElement(By.id("password")).sendKeys("abcdefg");
            driver.findElement(By.id("m_login_signin_submit")).click();
            WebElement error = driver.findElement(By.xpath("//form//div[1]"));

            String errorText = error.getText();

            assertTrue(errorText.contains("Incorrect email or password"));

        } finally {
            driver.quit();
    }
  }

}