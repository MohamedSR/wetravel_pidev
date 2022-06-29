/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Entities.Restaurant;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author m.rhouma
 */
public class PdfGenerator {

    public static void generateRestaurantPDF( ArrayList<Restaurant> list) throws FileNotFoundException {
        String dest = "D:/pdfs/restaurants_"+System.currentTimeMillis()+".pdf";
        PdfWriter pdfWriter = new PdfWriter(dest);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        String[] tableHeader = {"Nom","Capacité","Adresse","Ville","Pays"};
        float[] columnsWidth = {100f,100f,100f,100f,100f};
        Table table = new Table(columnsWidth);
        table.addCell(new Cell().add(new Paragraph(tableHeader[0])));
        table.addCell(new Cell().add(new Paragraph(tableHeader[1])));
        table.addCell(new Cell().add(new Paragraph(tableHeader[2])));
        table.addCell(new Cell().add(new Paragraph(tableHeader[3])));
        table.addCell(new Cell().add(new Paragraph(tableHeader[4])));
        for (Restaurant restaurant : list) {
            table.addCell(new Cell().add(new Paragraph(restaurant.getName())));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(restaurant.getCapacity()))));
            table.addCell(new Cell().add(new Paragraph(restaurant.getAdresse())));
            table.addCell(new Cell().add(new Paragraph(restaurant.getVille())));
            table.addCell(new Cell().add(new Paragraph(restaurant.getPays())));
        }
        document.add(table);
        document.close();
    }
}
