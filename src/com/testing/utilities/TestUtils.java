package com.testing.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtils {
	
	public static void main(String args[]) throws BiffException, IOException
	{
		TestUtils.xls_Reader();
	}
	public static void xls_Reader() throws BiffException, IOException
	{
		
		File f=new File("C:\\Users\\bhawa\\OneDrive\\Desktop\\test.xls");
		
		Workbook wb=Workbook.getWorkbook(f);
		Sheet s=wb.getSheet(0);
		int rows=s.getRows();
		
		int columns=s.getColumns();
		
		for (int i=1;i<rows;i++) {
			for(int j=0;j<columns;j++)
			{
				Cell cell=s.getCell(j,i);
				System.out.print(cell.getContents());
			}	
			System.out.println();
		}
	
	}

}
