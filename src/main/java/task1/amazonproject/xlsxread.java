package task1.amazonproject;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsxread {
	static String value;
	String sheet;
	public static String datafromexcel(String sheet,int row,int cell) throws IOException {
		File f = new File("C:\\Users\\Sathish\\OneDrive\\Desktop\\amazon datadriven.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet); 
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType ct = c.getCellType();
		if (ct.equals(CellType.STRING)) {
			value = c.getStringCellValue();
		} else if (ct.equals(CellType.NUMERIC)) {
			double dd = c.getNumericCellValue();// NOTE IN BOOK NARROW CASTTING
			int a = (int) dd;
			//Double.toString(dd)
			//value = Integer.toString(a);//integer string conversion
		}
		return value;
	}
}
 
