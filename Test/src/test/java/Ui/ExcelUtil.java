package Ui;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtil(String excelpath,String sheetname)
	{
	try{
			
		workbook = new XSSFWorkbook(excelpath);
		sheet = workbook.getSheet(sheetname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public static void main(String[] args)
	{
		getCelldataString(0,0);
		getCelldataNumber(1,1);
		
	}
	public static void getRowCount()
	{
		try{
			
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}
		catch(Exception exp){
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
		}
	}
	public static String getCelldataString(int rownum,int colnum)
	{
		try{
		
		String cellData=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		//System.out.println(cellData);
		return cellData;
	}
		catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			return null;
			}
		}

	public static void getCelldataNumber(int rownum,int colnum)
	{
		try{
	
		double cellData=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		System.out.println(cellData);
	}
		catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			}
		}
}

