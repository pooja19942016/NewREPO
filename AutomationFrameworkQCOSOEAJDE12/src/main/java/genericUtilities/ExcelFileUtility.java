package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException{
		//Step 1:Create fis object n initialize the path
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Step 2: create workbook object and use fis object
		Workbook wb = WorkbookFactory.create(fis);
		//Step 3:Create object for sheet class and add name of the sheet 
		Sheet sh = wb.getSheet(sheetName);
		//step 4: object for Row and pass value
		Row rw = sh.getRow(rowNo);
		//Step 5: object for Cell and pass value
		Cell c1 = rw.getCell(cellNo);
		//Step 6: use getStringCellValue for String as value for cell 
		String value = c1.getStringCellValue();
		
		return value;
	}
}
