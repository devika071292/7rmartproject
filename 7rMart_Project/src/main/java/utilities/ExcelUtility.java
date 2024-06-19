package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtility {
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
		
	public static String getStringData(int i, int j, String sheet) throws IOException 
	{
		String file_path = Constants.TESTDATAFILE;
		f=new FileInputStream(file_path);
		wb= new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r= sh.getRow(i);
		Cell c= r.getCell(j);
		return c.getStringCellValue();
	}
public static String getIntegerData(int i, int j, String sheet) throws IOException
	{
		String file_path = Constants.TESTDATAFILE;
		f=new FileInputStream(file_path);
		wb= new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r= sh.getRow(i);
		Cell c= r.getCell(j);
		int x= (int) c.getNumericCellValue();
		return String.valueOf(x);
	}

}
