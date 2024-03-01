package smallproject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class methods {
	WebDriver driver;
	 
	//initiate the driver
	@BeforeClass
	public void getDriver() {
		driver = driverSetup.driverSetup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	//get the url
	public void getUrl() {
		driver.get("https://www.snapdeal.com/");
		System.out.println("Enter successfully.......!!!!!");
		try {
			driver.findElement(By.xpath("//button[@id='pushDenied']")).click();
		}catch(Exception e) {
			System.out.println("Popup not found.....!!!! ");
		}
	}
	
	@Test(dependsOnMethods = {"getUrl"})
	//search for item
	public void setSearch() throws InterruptedException, IOException {
		WebElement getitem = driver.findElement(By.xpath("//div[@class='col-xs-14 search-box-wrapper']/input"));
		getitem.sendKeys(excelData.Input());
		}
	
 //get the auto-dropdown List
	 @Test(dependsOnMethods = {"setSearch"})
	public void searchItem() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> dropdownList =driver.findElements(By.xpath("//div[@class='suggestionBox topSearch-container']//li"));
		System.out.println("search recommendation.......!!!");
		for(int i=0;i<dropdownList.size();i++) {
			System.out.println(dropdownList.get(i).getText());
			if(dropdownList.get(i).getText().equalsIgnoreCase("Iphone 13 Cover")) {
				dropdownList.get(i).click();
				System.out.println("clicked......!!!!");
				break;
			}
			
		}
	
	}
	
	@Test(dependsOnMethods = {"searchItem"})
	//get product details
		public void getDetails() {
			List<WebElement> name=driver.findElements(By.xpath("//div[@id='products']//p[@class='product-title']"));
			List<WebElement> price=driver.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
			
			System.out.println("Search Items are: ");
			for(int i=0;i<10;i++) {
				System.out.println(name.get(i).getText()+" "+price.get(i).getText());
			}
		}
	
		public List<WebElement> getName(){
			List<WebElement> name=driver.findElements(By.xpath("//div[@id='products']//p[@class='product-title']"));
			return name;
		}
		public List<WebElement> getPrice(){
			List<WebElement> price=driver.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
			return price;
		}
	
	@Test(dependsOnMethods = {"getDetails"})
	//scroll down till 10 th element is shown
	public void scrollDown() throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement Element = driver.findElement(By.xpath("(//div[@id='products']//p[@class='product-title'])["+(excelData.Input1())+"]"));
		js.executeScript("arguments[0]. scrollIntoView();", Element);
		Thread.sleep(5000);
		System.out.println("Scroll down successfully......!!!!!");
	}
	
	@Test(dependsOnMethods = {"scrollDown"})
	//take screenshot
	public void takeSnapShot() throws Exception{
		try{
			TakesScreenshot scrShot =(TakesScreenshot)driver;
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("C:\\Users\\Asus\\eclipse-workspace\\smallProject\\screenshot\\hbk.png");
			FileUtils.copyFile(SrcFile, DestFile);
			System.out.println("ScreenShot take successfully.........!!!!");
		}catch(Exception e) {
			System.out.println("cannot take ss.....!!!!!");
		}
	}
	
	@AfterClass
	//close the driver
	public void close() {
		System.out.println("project run successfully.........!!!!!");
		driver.quit();
	}

}
