package smallproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;


public class excelData {
	
	public static String Input() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\Users\\2303787\\eclipse-workspace\\smallproject\\Excel\\ExcelInput.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(0);
		String input = cell.getStringCellValue();
		return input;
	}
	
	public static double Input1() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\Users\\2303787\\eclipse-workspace\\smallproject\\Excel\\ExcelInput.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		double input1 = cell.getNumericCellValue();
		return input1;
	}
	
	
	public static void output(List<WebElement>nameList, List<WebElement>priceList) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Output");
		XSSFRow headerrow = sh.createRow(0);
		//headerrow.createCell(0).setCellValue("search recommendation");
		headerrow.createCell(0).setCellValue("Name");
		headerrow.createCell(1).setCellValue("Price");
	
		for(int i=0;i<nameList.size();i++) {
				XSSFRow row =sh.createRow(i+1);
				//row.createCell(0).setCellValue(searchRec.get(i).getText());
				row.createCell(0).setCellValue(nameList.get(i).getText());
				row.createCell(1).setCellValue(priceList.get(i).getText());
			}
			System.out.println("Print successfully.......!!!!");
		

		FileOutputStream fileout = new FileOutputStream("C:\\Users\\2303787\\eclipse-workspace\\smallproject\\Excel\\ExcelOuput.xlsx");
			
		wb.write(fileout);
		
		wb.close();
		
	}               
	
}
	

