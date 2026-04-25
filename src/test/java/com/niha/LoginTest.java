package com.niha;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
  @Test
  public void test_login_with_incorrect_credentials() {

    System.setProperty("webdriver.chrome.verboseLogging", "true");
System.setProperty("webdriver.chrome.logfile", "/tmp/chromedriver.log");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

    options.addArguments("--disable-gpu");  
    options.addArguments("--window-size=1920,1080");


    WebDriver driver = new ChromeDriver(options);

    try {
      driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
      driver.get("http://103.139.122.250:4000/");

      driver.findElement(By.id("email")).sendKeys("qasim@malik.com");
<<<<<<< HEAD
      driver.findElement(By.id("password")).sendKeys("abcdefg");
      driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/button")).click();
=======
            driver.findElement(By.id("password")).sendKeys("abcdefg");
           driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/button")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
>>>>>>> d98f08071b9aac25b7b27d5b16eb1ea3daf24226
      WebElement error = driver.findElement(By.xpath("//form//div[1]"));

      String errorText = error.getText();

<<<<<<< HEAD
      assertTrue(errorText.contains("Incorrect email or password"));
=======
            assertTrue(errorText.contains("Failed to fetch"));
>>>>>>> d98f08071b9aac25b7b27d5b16eb1ea3daf24226

    } finally {
      driver.quit();
    }
  }

}
