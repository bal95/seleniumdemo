import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocators {
  static WebDriver wd;
  @BeforeEach 
  public void driverSetup(){
    wd=new ChromeDriver();
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
