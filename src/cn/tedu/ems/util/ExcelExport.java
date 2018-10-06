package cn.tedu.ems.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelExport {
	
	public static void main(String[] args) throws IOException {
		export();
	}
	

	public static void export() throws IOException {
		
		

		HSSFWorkbook work = new HSSFWorkbook();

		HSSFSheet sheet = work.createSheet();

		Row row = sheet.createRow(0);

		Cell cell = row.createCell(0);

		cell.setCellValue("english");

		CellStyle style = work.createCellStyle();

		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		Font font = work.createFont();

		font.setColor(Font.COLOR_RED);

		font.setFontHeightInPoints((short) 20);

		font.setFontName("黑体");

		style.setFont(font);

		cell.setCellStyle(style);

		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 2));

		String fileName = "D:/workbook.xls";

		FileOutputStream out = new FileOutputStream(fileName);
		
		work.write(out);
		
		work.close();
		
		out.close();
	}
}
