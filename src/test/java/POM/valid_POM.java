package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Genericlibraries.ConfigfileHandler;


@Test
public class valid_POM {
	
	WebDriver driver = null;
	
	public void setbrowser() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ConfigfileHandler.Handle_configfile("ChromeDriverpath"));
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		}
	
	
	public void seturl() throws Exception{
		
		driver.get(ConfigfileHandler.Handle_configfile ("URL"));
	}
	
public void click_signinlink(){
	
	driver.findElement(By.linkText("Sign In")).click();
	
}
public void setusername(String Uname){
	
	driver.findElement(By.name("logid")).sendKeys(Uname);
	
}
public void EnterText_Pwd(String Pwd)
{
	driver.findElement(By.name("pswd")).sendKeys(Pwd);
}

public void Click_button_login() throws Exception
{
	driver.findElement(By.xpath(ConfigfileHandler.Handle_configfile("xpathforbutton"))).click();
}

//public void Click_button_login(String handle_configfile) throws Exception
//{
//	driver.findElement(By.xpath(handle_configfile)).click();
//}



public String gettext_myprofile()
{
	return driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
}

public void Click_link_SignOut()
{
	driver.findElement(By.linkText("Sign Out")).click();
}


public String gettext_Invalid_loginmessage()
{
	return driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table[1]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/font/b")).getText();
}
public void Close_browser()
{		
	driver.close();
}}
