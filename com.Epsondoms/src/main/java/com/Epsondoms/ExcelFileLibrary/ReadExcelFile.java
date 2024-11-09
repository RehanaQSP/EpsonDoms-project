package com.Epsondoms.ExcelFileLibrary;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	

	import org.apache.poi.EncryptedDocumentException;
	
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Epsondoms.GenericLibrary.FrameworkConstant;

/**
 * This Class Provides the Reusuable Method To Read The Data To  Property File
 * 
 * 
 * @author rehana23
 */
	public class ReadExcelFile implements FrameworkConstant{
		public FileInputStream fis;
		public FileOutputStream fos;
		public Workbook wb;

		public String readSingleData(String sheetname, int row, int cell) {
			// 1. Convert the physical file into java readable file
			try {
				 fis = new FileInputStream(excelpath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			// 2. Create the workbook using workbook factory
			try {
				wb=WorkbookFactory.create(fis);
				
			} catch (EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}

			// 3. using Workbook get the sheet control
			// 4. Using sheet get the row control
			// 5. Using Row get the Column control
			// 6. using Column Get The Cell-Data
			return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		
			
		}

		public void readMultipleData(String sheetname) {
			// 1. Convert the physical file into java readable file
					try {
						 fis = new FileInputStream(excelpath);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					// 2. Create the workbook using workbook factory
					try {
						WorkbookFactory.create(fis);
					} catch (EncryptedDocumentException | IOException e) {
						e.printStackTrace();
					}

					// 3. using Workbook get the sheet control
					// 4. Using sheet get the row control
					// 5. Using Row get the Column control
					// 6. using Column Get The Cell-Data
					
					int rowcount = wb.getSheet(sheetname).getLastRowNum();
					for(int i = 0; i<rowcount; i++) {
					wb.getSheet(sheetname).getRow(1).getCell(1).getStringCellValue();
					}
								

		}

		public void writeData(String sheetname, int row, int cell, String data) {
			// 1. Convert the physical file into java readable file
			try {
				fis = new FileInputStream(excelpath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			// 2. Create the workbook using workbook factory
			try {
				WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}

			// 3. using Workbook get the sheet control
			// 4. Using sheet get the row control
			// 5. Using Row create the Column
			// 6. using the column set the cell-data
			wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue("Data we will pass");
			
			
			// 7. Convert java readable file into physical file
			 try {
				fos = new FileOutputStream(excelpath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 8. Write the data
			try {
				wb.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 9. close the workbook
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	

}
