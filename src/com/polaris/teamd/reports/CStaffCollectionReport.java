package com.polaris.teamd.reports;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Date;

import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.common.utils.HTMLUtil;

public class CStaffCollectionReport extends CReport{
	String fileName;
	CReservation reservation=new CReservation();
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public void generateReportTo(String fileName) {
		super.generateReportTo(fileName);
	}
	@Override
	void generateReport(Object... param) {
		try {
			OutputStream out=new FileOutputStream(fileName);
			Writer obj= new FileWriter(fileName);
			BufferedWriter writer=new BufferedWriter(obj);
			writer.write(HTMLUtil.startHTML());
			writer.write(HTMLUtil.createHeading(1, "STAFF COLLECTION REPORT"));
			writer.write(HTMLUtil.startTable(70, 1));
			writer.write(HTMLUtil.startRow("white", "Black"));
			writer.write(HTMLUtil.createCell("STAFF NAME"));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell(reservation.getBookedBy()));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell(" "));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell("DATE"));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell(new Date()+""));
			
			writer.write(HTMLUtil.endRow());
			writer.write(HTMLUtil.endTable());
			writer.write(HTMLUtil.startTable(70, 70));
			writer.write(HTMLUtil.createCell("OPERATOR NAME"));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell("PNR NO"));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell("TOTAL AMOUNT"));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell("REFUND AMOUNT"));
			writer.write(HTMLUtil.endCell());
			writer.write(HTMLUtil.createCell("STATUS"));
			writer.write(HTMLUtil.endCell());
			//for loop should be created 
			
			
			writer.write(HTMLUtil.endTable());
			writer.write(HTMLUtil.createCell("TOTAL AMOUNT COLLECTED"));
			writer.write(HTMLUtil.endCell());
			//writer.write(HTMLUtil.createCell(+""));
			writer.write(HTMLUtil.newLine());
			writer.write(HTMLUtil.createCell("TOTAL AMOUNT REFUNDED"));
			writer.write(HTMLUtil.endCell());
			//writer.write(HTMLUtil.createCell(+""));
			writer.write(HTMLUtil.newLine());
			writer.write(HTMLUtil.createCell("TOTAL AMOUNT"));
			writer.write(HTMLUtil.endCell());
			//writer.write(HTMLUtil.createCell(+""));
			//writer.write()
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		catch (IOException e) {
			e.printStackTrace();
		}	
		
	}	
}
		
	


