package smallproject;

import java.util.List;

import org.openqa.selenium.WebElement;

public class main {

	public static void main(String[] args) throws Exception{
		methods mn = new methods();
		mn.getDriver();
		mn.getUrl();
		mn.setSearch();		 
		mn.searchItem();
		mn.getDetails();
		
		List<WebElement>nameList = mn.getName();
		List<WebElement>priceList = mn.getPrice();
		
		excelData.output(nameList, priceList);
		
		mn.scrollDown();
		mn.takeSnapShot();
		mn.close();
	}
		
}

