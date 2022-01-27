package base_utilitypackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility_Class {
	public  String GetExceldata(String Sheetname,int rowindex,int cellindex) throws EncryptedDocumentException, IOException{
		String value="";
		FileInputStream File= new FileInputStream("C:\\Users\\Shubh\\Desktop\\Exceldata\\Data.xlsx");
		Sheet Mysheet = WorkbookFactory.create(File).getSheet(Sheetname);
		try
		{
		value = Mysheet.getRow(rowindex).getCell(cellindex).getStringCellValue();
		}catch(Exception e)
		{
			double Num = Mysheet.getRow(rowindex).getCell(cellindex).getNumericCellValue();
		int num2 = (int)Num;
		value=num2+"";
		}
		return value;
	}


}
