package UtilityFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void bikesOutputoToExcel(String sheetName, ArrayList<String> arr) throws IOException {

		// Create a new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a sheet in that workbook
		XSSFSheet sheet = workbook.createSheet(sheetName);

		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Upcoming Honda Bikes Under 4 Lac");
		int count = 0;
		for (int i = 1; i <= arr.size(); i++) {

			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(arr.get(count++));
		}
		try {
			FileOutputStream file = new FileOutputStream(
					System.getProperty("user.dir") + "/ExcelFiles/ExcelOutputs/UpcomingBikes.xlsx");
			workbook.write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
workbook.close();
	}

	public static void signInOutputoToExcel(String sheetName, String errorMessage) throws IOException {

		// Create a new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a sheet in that workbook
		XSSFSheet sheet = workbook.createSheet(sheetName);

		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Error message showing for wrong credentials");
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(0);
		cell.setCellValue(errorMessage);

		try {
			FileOutputStream file = new FileOutputStream(
					System.getProperty("user.dir") + "/ExcelFiles/ExcelOutputs/GoogleSignInOutputs.xlsx");
			workbook.write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();

	}
	
	public static void usedCarsOutputToExcel(String fileName, String sheetName, List<String> labelsList) throws EncryptedDocumentException, IOException{
		// Create a new workbook
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a sheet in that workbook
		XSSFSheet sheet = workbook.createSheet(sheetName);
		/*File f = new File(System.getProperty("user.dir") + "/ExcelFiles/ExcelOutputs/UsedCarsInChennai.xlsx");
		Workbook workbook = WorkbookFactory.create(f);
		Sheet sheet = workbook.createSheet(sheetName);*/

				Row row1 = sheet.createRow(0);
				Cell cell1 = row1.createCell(0);
				cell1.setCellValue("Used Cars in Chennai");
				int count = 0;
				for (int i = 1; i <= labelsList.size(); i++) {

					Row row = sheet.createRow(i);
					Cell cell = row.createCell(0);
					cell.setCellValue(labelsList.get(count++));
				}
				try {
					FileOutputStream file = new FileOutputStream(
							System.getProperty("user.dir") + "/ExcelFiles/ExcelOutputs/UsedCarsInChennai/"+fileName+".xlsx");
					workbook.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				workbook.close();
	}
}
