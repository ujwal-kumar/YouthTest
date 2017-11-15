package YouthInc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestFramework.Page;

public class LoginPage extends Page {
  private String Url="http://10.244.99.196/admin/";

	public LoginPage() {
		
        PageFactory.initElements(Page.driver, this);
    }
	
		@FindBy(id = "loginform-email")
	    private WebElement email;
		
		@FindBy(xpath=".//*[@id='login-form']/div[2]/div/p")
		private WebElement emailErrormsg;
		
	    @FindBy(id = "loginform-password")
	    private WebElement password;

	    @FindBy(name = "login-button")
	    private WebElement loginButton;
	
@BeforeMethod
public void BeforeMethod()
{
	Page.InitBrowser("Chrome",Url);
	PageFactory.initElements(Page.driver, this);
}
@org.testng.annotations.AfterMethod

public void AfterMethod()
{
	CloseDriver();
}

  @Test(priority = 0)
  public void LoginWithValidCredential() throws InterruptedException  {
	  
	  
	  email.sendKeys("admin@youthinc.com");
	  password.sendKeys("admi");
	  Thread.sleep(3000);
	  loginButton.click();
	  Thread.sleep(3000);
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Dashboard YouthInc";
	  assertEquals(expectedTitle,actualTitle);
  }
  
  @Test(priority =1)
  public void LoginWithInValidCredential() throws InterruptedException {
	  email.sendKeys("adm@youthinc.com");
	  password.sendKeys("admin");
	  loginButton.click();
	  Thread.sleep(6000);
	  WebElement msg=driver.findElement(By.xpath(".//*[@id='login-form']/div[0]/div/p"));
		
		String text=msg.getText();
		System.out.println(text);
		if (msg.isEnabled() && text.contains("Email does not exist"))
		{ 
		    System.out.println("Script pass");
		}else{
		    System.out.println("Script fail");
		}
	  //String errorMsg=emailErrormsg.getText();
	 //loginButton.click();
  }
  
  @Test(priority =2)
  public void LoginWithEmptyemail() throws InterruptedException {
	  email.sendKeys("");
	  password.click();
	  Thread.sleep(6000);
	  WebElement msg=driver.findElement(By.xpath(".//*[@id='login-form']/div[1]/div/p"));
		
		String text=msg.getText();
		System.out.println(text);
		if (msg.isEnabled() && text.contains("Email cannot be blank."))
		{ 
		    System.out.println("Script pass");
		}else{
		    System.out.println("Script fail");
		}
	  password.sendKeys("admin");
	  loginButton.click();
	 
	  
	  //String errorMsg=emailErrormsg.getText();
	 //loginButton.click();
  }
  @Test(priority =3)
  public void LoginWithEmptypassword() throws InterruptedException {
	  email.sendKeys("admin@youthinc.com");
	  password.sendKeys("");
	  Thread.sleep(6000);
	  loginButton.click();
	  WebElement msg=driver.findElement(By.xpath(".//*[@id='login-form']/div[2]/div/p"));
		
		String text=msg.getText();
		System.out.println(text);
		if (msg.isEnabled() && text.contains("Password cannot be blank."))
		{ 
		    System.out.println("Script pass");
		}else{
		    System.out.println("Script fail");
		}
	  password.sendKeys("admin");
	  loginButton.click();
	 
	  
	  //String errorMsg=emailErrormsg.getText();
	 //loginButton.click();
  
}
}
