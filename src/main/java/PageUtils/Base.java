package PageUtils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	static Properties prop= new Properties();
	static String Propfilepath="C:\\Users\\isha2\\eclipse-workspaceNew\\GitRepository\\properties";

	public static void initializedriver() throws IOException {
		FileInputStream fis= new FileInputStream(Propfilepath);
		prop.load(fis);
		String Browser= prop.getProperty("browser");
		
		if(Browser.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\isha2\\OneDrive\\Desktop\\Code Repository\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	
		
	}
	public static String switchtoWindow() {
		List<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return (driver.getTitle());
	}
}
