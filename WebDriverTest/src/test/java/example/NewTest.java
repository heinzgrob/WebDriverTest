package example;

import org.testng.annotations.Test;
import org.testng.Assert;	
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class NewTest {
  @Test
  public void f() {
	  
	  File file = new File("/Users/hgrob/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs");				
      System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
      WebDriver driver = new PhantomJSDriver();
      
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      
      long start = System.currentTimeMillis();
      driver.get("http://www.firmtec.ch"); 
      long finish = System.currentTimeMillis();
      long totalTime = finish - start;
      
      System.out.println("Page title is: " + driver.getTitle());	
      System.out.println("Total time for page load: " + totalTime);
        
      
      By css = By.cssSelector(".item[href*='testmanagement']");
      WebElement element = driver.findElement(css);
      start = System.currentTimeMillis();
      ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
      
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      //driver.findElement(By.linkText("/dienstleistungen"));

      
      driver.findElement(By.partialLinkText("Sie zum Download"));
      finish = System.currentTimeMillis();
      totalTime = finish - start;
      
      //driver.findElement(By.xpath("//a[@href='/dienstleistungen']")).click();
      
      System.out.println("Page title is: " + driver.getTitle());	
      System.out.println("Total time for page load: " + totalTime);
      
      css = By.cssSelector(".item[href*='performance-testing']");
      element = driver.findElement(css);
      start = System.currentTimeMillis();
      ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
      
      driver.findElement(By.partialLinkText("performance@firmtec.ch"));
      finish = System.currentTimeMillis();
      totalTime = finish - start;
      
      System.out.println("Page title is: " + driver.getTitle());	
      System.out.println("Total time for page load: " + totalTime);
      
      driver.quit();			
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
