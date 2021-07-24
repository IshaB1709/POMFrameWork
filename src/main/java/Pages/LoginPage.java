package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageUtils.Base;




	public class LoginPage extends Base   {
		
		public static HomePage homepage;
		public static SignUpPage signUpPage;
		@FindBy(name="username")
			WebElement UserName;
		
		@FindBy(name="password")
			WebElement Password;
		
		@FindBy(xpath="//input[@type='submit']")
		 	WebElement LoginButton;
		
		@FindBy(xpath="//img[@class='img-responsive']")
		
			WebElement PageHeader;
		
		@FindBy(xpath="//a[@href='https://register.freecrm.com/register/']")
			WebElement Signup;
		
		public LoginPage() {
		
			PageFactory.initElements(driver, this);
		}
		
		public boolean pageheader() {
			return PageHeader.isDisplayed();
		}
		public HomePage login(String us, String pwd) {
			UserName.sendKeys(us);
			Password.sendKeys(pwd);
			LoginButton.click();
			return homepage;
		}
		public SignUpPage signupPage() {
			Signup.click();
			return signUpPage;
		}

	}


