import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLocators {
  static WebDriver wd;
  @BeforeEach 
  public void driverSetup(){
    ChromeOptions options =new ChromeOptions();
    options.addArguments("--headless=new");
    options.addArguments("--window_size=1920,1080");
    wd=new ChromeDriver(options);
  }

  @AfterAll 
  public static void closeDriver(){
    wd.quit();
  }

  @Test 
  public void openSelenium(){
    wd.get("https://www.selenium.dev");
    String text=wd.findElement(By.xpath(
      "/html/body/div[2]/main/section[1]/div/div/div/p[1]")).getText();
    assertEquals(true, text.contains("Selenium"));
  }
}
