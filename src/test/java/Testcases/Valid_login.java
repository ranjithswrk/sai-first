package Testcases;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import Genericlibraries.ConfigfileHandler;
import POM.valid_POM;





public class Valid_login {
  @Test(dataProvider = "Valid_DP" , dataProviderClass = Dataproviders.DP_Valid.class)
  
	  public void validtest(String TC_ID, String Uname, String Pwd, String exp_result) throws Exception{
	  
	  System.out.println(TC_ID +"   "+Uname+"  "+Pwd+ "   "+exp_result);
	  
	  Valid_login cpmvar = new Valid_login ();
	  
			  
	  valid_POM cpm = cpmvar.CPM();
	  
	  cpm.setusername(Uname);
	  cpm.EnterText_Pwd(Pwd);
	  cpm.Click_button_login();
	  
	   //cpm.Click_button_login(ConfigfileHandler.Handle_configfile("xpathforbutton"));
	 // cpm.Click_button_login(ConfigfileHandler.Handle_configfile("xpathforbutton1"));
	  
	  
	  String actual = cpm.gettext_myprofile();
 Assert.assertEquals(actual, exp_result);
  cpm.Click_link_SignOut();
	  
  }
	  
 // @Test(dataProvider = "invalidlogin" , dataProviderClass)
  
  
  
  
  public valid_POM CPM() throws Exception{
	  
	  valid_POM test = new valid_POM();
	   
	  test.setbrowser();
	  test.seturl();
	  test.click_signinlink();
	  
	  return test;
	  
  }
  
  
	  
  }

