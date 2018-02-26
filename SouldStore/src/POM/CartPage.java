package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Base_Page;

public class CartPage extends Base_Page {
	@FindBy(xpath="(//div[@class='cartcount'])[1]")
    private WebElement cart;
	@FindBy(xpath="//span[.='Remove']")
	private WebElement rm;
    
    public CartPage(WebDriver driver)
    {
   	 super(driver);
   	 PageFactory.initElements(driver,this);
    }
     
    public void clickcart()
    {
   	cart.click();
    }
    
    public void removeformcart()
    {
    	rm.click();
    	
    }
}
