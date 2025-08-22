package Fireflink_ninza_CRM.GenericUitility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to file operations like properties , excel
 * @author Tushar Jadhav
 * 
 */
public class FileUtility {

	/**
	 * This method will read data from properties file
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	/**
	 * This methods read data from excel file and returns value to the caller
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromFile(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString();
		
	}
	
	
	
	public Object[][] readDataFromExcelForMultipleValues(String filepath, String sheetName) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		int rownum = sheet.getLastRowNum();
		int colnum = sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rownum-1][colnum];
		
		for(int i=1;i<rownum;i++) {
			Row row = sheet.getRow(i);
			
			for(int j=0;j<colnum;j++) {
				data[i-1][j]=row.getCell(j).toString();
			}
		}
		
		return data;
//		sheet.getRow(rows)
		
	}
}
