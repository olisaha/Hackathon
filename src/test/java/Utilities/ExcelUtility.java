package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	public FileInputStream fi;

	public FileOutputStream fo;

	public XSSFWorkbook workbook;

	public XSSFSheet sheet;

	public XSSFRow row;

	public XSSFCell cell;

	//public CellStyle style;
	public void excelWrite(Map<String , String>insurancepaln) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TRAVELINSURANCE");
		int i=0;
		for(Map.Entry<String, String> map : insurancepaln.entrySet()) {
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(map.getKey());
			row.createCell(1).setCellValue(map.getValue());
			i++;
		}
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\2303442\\eclipse-workspace\\TravelInsurance\\TestData\\Excel1.xlsx");
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Data written in excel sheet!");	
	}
	 public void excelwrite2(List<WebElement>menulist) throws IOException {
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet = workbook.createSheet("HealthInsurance");
		 for(int i=0;i< menulist.size();i++) {
			 Row row1 = sheet.createRow(i);
			 row1.createCell(0).setCellValue(menulist.get(i).getText());
		 
		 }
		 
		 FileOutputStream file = new FileOutputStream("C:\\Users\\2303442\\eclipse-workspace\\TravelInsurance\\TestData\\Exce2.xlsx");
			workbook.write(file);
			workbook.close();
			file.close();
			System.out.println("Data written in excel sheet!!");	
		
	}
	
	

}
