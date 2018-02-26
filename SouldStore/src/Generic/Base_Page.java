package Generic;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.internal.Utils;
//first commit
//second commit
//third commit//changes
public abstract class Base_Page  
{
	public WebDriver driver;
	
	 public Base_Page(WebDriver driver)
	 {
		 this.driver=driver;
		 
	 }
	public void verifyTitle(String atitle)
	{  
		  System.out.println("hi"+atitle);
		WebDriverWait wait =new WebDriverWait(driver,10);
		try
		{
			 wait.until(ExpectedConditions.titleContains(atitle));
		}
		catch(Exception e)
		{
			Reporter.log("title is not matched",true);
			TakeScreenShootDisplay();
			Assert.fail();
		}
		
	}
	
	public void TakeScreenShootDisplay()
	{  
		try
	   {
		String ScreenPath="D:/selenium/"+System.currentTimeMillis()+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(ScreenPath);
	//	Reporter.log(ScreenPath,true);
		Utils.copyFile(scr, dst);
	   }
	  catch(Exception e)
	 {
	 
		Reporter.log("error in path",true);
	}
	}
	
	 public void MousehoverFuction(WebElement Passelem)
     {
    	 Actions ac=new Actions(driver);
    	 ac.moveToElement(Passelem).perform();
      }
	 
	
	public void verifyElementPresent(WebElement Elem)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(Elem));
		}
		catch(Exception e)
		{
			Reporter.log("the element is not present",true);
			Assert.fail();
		}
	}

}
