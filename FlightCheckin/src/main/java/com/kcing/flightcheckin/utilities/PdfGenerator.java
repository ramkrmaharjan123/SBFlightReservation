package com.kcing.flightcheckin.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kcing.flightcheckin.integration.dto.Reservation;

@Component
public class PdfGenerator {
	
	public void generateItinerary(Reservation r, String filePath) {
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			
			document.add(generateTable(r));
			document.close();
		}catch(FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation r) {
		
		PdfPTable table = new PdfPTable(2);
		
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure city");
		table.addCell(r.getFlight().getDepartureCity());
		
		table.addCell("Arrival city");
		table.addCell(r.getFlight().getArrivalCity());
		
		table.addCell("Departure date");
		table.addCell(r.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure time");
		table.addCell(r.getFlight().getEstimatedDepartureTime().toString());
		
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(r.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(r.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(r.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(r.getPassenger().getPhone());
		
		
		
		
		
		return table;
	}

}
