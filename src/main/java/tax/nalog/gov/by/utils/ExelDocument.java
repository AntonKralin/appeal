package tax.nalog.gov.by.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import tax.nalog.gov.by.entity.Appeals;
import tax.nalog.gov.by.entity.Imns;

public class ExelDocument {
	
	public String createReport7(List<Appeals> appealList, Imns imns) {
		Integer number = imns.getNumber();
		String pathToExcel = number.toString()+".xlsx";
		File file = new File(pathToExcel);
		pathToExcel = file.getAbsolutePath();
		
		if (file.exists() == true) {
			file.delete();
		}
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet= wb.createSheet("report");
			
			createHeaderReport7(sheet);
			
			int count = 1;
			for (Appeals appeal:appealList ) {
				HSSFRow row = sheet.createRow(count);
				HSSFCell cell = null;
				
				cell = row.createCell(0); 
		    	cell.setCellValue(new HSSFRichTextString( Integer.toString(appeal.getId())) );
		    	
		    	cell = row.createCell(1); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getDateMessage()));
		    	
		    	cell = row.createCell(2); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getType()));
		    	
		    	cell = row.createCell(3); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getWho()));
		    	
		    	cell = row.createCell(4); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getWhat()));
		    	
		    	cell = row.createCell(5); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getResult()));
		    	
		    	cell = row.createCell(6); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getDone()));
		    	
		    	cell = row.createCell(7); 
		    	cell.setCellValue(new HSSFRichTextString(appeal.getUnit()));
		    	
		    	cell = row.createCell(8); 
		    	cell.setCellValue(new HSSFRichTextString(Integer.toString(appeal.getId_imns().getNumber())));
		    	
		    	count++;
			}
			
			FileOutputStream fos = new FileOutputStream(pathToExcel);
			wb.write(fos);
	        wb.close();
	        fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pathToExcel;
	} 

	public String createReport74(List<Appeals> appealList, Imns imns) {
		Integer number = imns.getNumber();
		String pathToExcel = number.toString()+".xlsx";
		File file = new File(pathToExcel);
		pathToExcel = file.getAbsolutePath();
		
		if (file.exists() == true) {
			file.delete();
		}
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet= wb.createSheet("report");
			
			createHeaderReport74(sheet);
			
			int count = 1;
			for (Appeals appeal:appealList ) {
				HSSFRow row = sheet.createRow(count);
				HSSFCell cell = null;
				
				cell = row.createCell(0); 
		    	cell.setCellValue(new HSSFRichTextString( appeal.getDateMessage() ));
		    	
		    	cell = row.createCell(1); 
		    	cell.setCellValue(new HSSFRichTextString( appeal.getWhat() ));
		    	
		    	cell = row.createCell(2); 
		    	cell.setCellValue(new HSSFRichTextString(Integer.toString(appeal.getId_imns().getNumber()) ));
		    	
		    	cell = row.createCell(3); 
		    	cell.setCellValue(new HSSFRichTextString( appeal.getDone() ));
		    	
		    	cell = row.createCell(8); 
		    	cell.setCellValue(new HSSFRichTextString( appeal.getUnit() ));
		    	
		    	count++;
			}
			
			FileOutputStream fos = new FileOutputStream(pathToExcel);
			wb.write(fos);
	        wb.close();
	        fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pathToExcel;
	} 
	
	public void createHeaderReport7(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		
		cell = row.createCell(0); 
    	cell.setCellValue(new HSSFRichTextString("№ п/п"));
    	
    	cell = row.createCell(1); 
    	cell.setCellValue(new HSSFRichTextString("Дата рассмотрения"));
    	
    	cell = row.createCell(2); 
    	cell.setCellValue(new HSSFRichTextString("Вид документа"));
    	
    	cell = row.createCell(3); 
    	cell.setCellValue(new HSSFRichTextString("Наименование плательщика"));
    	
    	cell = row.createCell(4); 
    	cell.setCellValue(new HSSFRichTextString("Суть жалобы"));
    	
    	cell = row.createCell(5); 
    	cell.setCellValue(new HSSFRichTextString("Результат рассмотрения (удовлетворена или нет)"));
    	
    	cell = row.createCell(6); 
    	cell.setCellValue(new HSSFRichTextString("Что сделано (в случае удовлетворения)"));
    	
    	cell = row.createCell(7); 
    	cell.setCellValue(new HSSFRichTextString("Управление, самостоятельный отдел, к компетенции которого относится рассматриваемый вопрос"));
    	
    	cell = row.createCell(8); 
    	cell.setCellValue(new HSSFRichTextString("ИМНС"));
	}
	
	public void createHeaderReport74(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		
		cell = row.createCell(0); 
    	cell.setCellValue(new HSSFRichTextString("Дата и номер письма МНС"));
    	
    	cell = row.createCell(1); 
    	cell.setCellValue(new HSSFRichTextString("Суть нарушений"));
    	
    	cell = row.createCell(2); 
    	cell.setCellValue(new HSSFRichTextString("ИМНС, в которых установлены нарушения"));
    	
    	cell = row.createCell(3); 
    	cell.setCellValue(new HSSFRichTextString("Результат проделанной работы, направленной на устранение нарушений"));
    	
    	cell = row.createCell(4); 
    	cell.setCellValue(new HSSFRichTextString("Управление, самостоятельный отдел, к компетенции которого относится рассматриваемый вопрос"));

	}
	
}
