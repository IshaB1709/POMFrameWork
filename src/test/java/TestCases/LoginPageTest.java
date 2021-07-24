package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageUtils.Base;
import PageUtils.Utils;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;

public class LoginPageTest extends Base{
	static LoginPage loginpage;
	static HomePage homepage;
	static SignUpPage signup;
	
	public  LoginPageTest() {
		super();
	}
	@BeforeMethod
	public static void LoginPage() throws IOException {
		initializedriver();
		loginpage=new LoginPage();
		}
	
	@Test(priority=3)
	public static void validatepagetitle() {
		Assert.assertTrue(loginpage.pageheader());
	}
	
	@Test(priority=1,dataProvider="getdata")
	public static void login(String Username, String PwD) {
		homepage=loginpage.login(Username,PwD);
	
	}
	@Test(priority=1)
	public static void signup() {
		signup=loginpage.signupPage();
		String title=switchtoWindow();
		Assert.assertTrue(title.equals("Cogmento CRM"));
	
	
	}

	@DataProvider
	public static Object[][] getdata() throws EncryptedDocumentException, IOException {
		Object[][] logindata=Utils.ReadData("Sheet1");
		return logindata;
	}
	@AfterMethod
	public static void teardown() {
		driver.close();
	}


	
	
}