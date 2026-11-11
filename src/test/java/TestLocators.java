import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
  public void switchTabTest(){
    for(int i=0;i<10;i++){
      wd.get("https://www.facebook.com");
      wd.switchTo().newWindow(WindowType.TAB);
    }
    Object[] tabs=wd.getWindowHandles().toArray();
    int k=tabs.length-1;
    while(k>0){
      wd.close();
      wd.switchTo().window((String)tabs[--k]);
    }
  }
}
