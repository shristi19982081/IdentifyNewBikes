package UtilityFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static String readFromExcel(int sheetNo, int cellNo) throws EncryptedDocumentException, IOException{
		File file = new File(System.getProperty("user.dir")+"/ExcelFiles/InputFromExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheetAt(sheetNo);
		
		//Select 1st row of excel sheet
		Row row0 = sheet.getRow(0);
		//Select 1st cell of 1st row
		Cell cell = row0.getCell(cellNo);
		/*//Select 2nd cell of 1st row
		Cell cell1 = row0.getCell(1);*/
		
		//Store the value of 1st cell in "username" variable
		String cellValue = cell.getStringCellValue();
		/*//Store the value of 2nd cell in "password" variable
		password = cell1.getStringCellValue();*/

		fis.close();
		return cellValue;
		
	}
	
}
