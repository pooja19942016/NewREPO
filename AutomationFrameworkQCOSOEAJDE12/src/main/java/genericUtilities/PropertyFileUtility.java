package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 *
 *This class consists of generic methods related to property file
 * @author pooja
 */
public class PropertyFileUtility {
  /**
   * 
   * This method is used to read the data from property file and return the value
   * @param input
   * @return
   * @throws IOException
   */
public String readDataFromPropertyFile(String input) throws IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(input);
	return value;
	
}
	

}
