package smallproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class driverSetup {
	public static WebDriver driver;
	public static WebDriver driverSetup;

	public static WebDriver driverSetup() {
		try{
			driver = new ChromeDriver();
		}catch(Exception e){
			driver = new EdgeDriver();
		}
		return driver;
	}

}
