package com.polaris.teamd.reports;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import com.polaris.teamd.bean.CPNRCancellation;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.common.utils.HTMLUtil;

public class CCancellationReport extends CReport{
String fileName;
CPNRCancellation pnrCancellation;
CTrip trip;
public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

@Override
void generateReport(Object... param) {
	try {
		OutputStream out=new FileOutputStream(fileName);
		Writer obj= new FileWriter(fileName);
		BufferedWriter writer=new BufferedWriter(obj);
		writer.write(HTMLUtil.startHTML());
		writer.write(HTMLUtil.createHeading(1, "CANCELLATION REPORT"));
		writer.write(HTMLUtil.startBODY());
		writer.write(HTMLUtil.startTable(70, 70));
		writer.write(HTMLUtil.startRow("white", "Black"));
		writer.write(HTMLUtil.createCell("TRIP ID"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell(trip. getTripId()+""));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell("TRIP DATE"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell(trip.getTripDate()+""));
		writer.write(HTMLUtil.endCell());
		
		writer.write(HTMLUtil.endRow());
		
		writer.write(HTMLUtil.startRow("WHITE","BLACK"));
		writer.write(HTMLUtil.createCell("START LOCATION"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell(trip.getBusService().getStartLocation().getCityName()));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell("DESTINATION"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell(trip.getBusService().getEndLocation()));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.endRow());
		writer.write(HTMLUtil.endTable());
		writer.write(HTMLUtil.startTable(70, 1));
		writer.write(HTMLUtil.startRow("WHITE","BLACK"));
		writer.write(HTMLUtil.createCell("PNR NO"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell("PASSENGER NAME"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell("SEAT NUMBER"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.createCell("CANCELLATION STATUS"));
		writer.write(HTMLUtil.endCell());
		writer.write(HTMLUtil.endRow());
		
		//for loop should be created 
		
		
		writer.write(HTMLUtil.endTable());
		writer.write(HTMLUtil.endBODY());
		
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	
	
	catch (IOException e) {
		e.printStackTrace();
	}	
	
}
}
