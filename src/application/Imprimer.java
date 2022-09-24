package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;

import com.itextpdf.layout.element.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.SysoLogger;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Imprimer {
	private String nom;
	private String prenom;
	private String dpt;
	private String promo;
	private String annee;
	

	public static void main(String[] args) throws DocumentException, FileNotFoundException {
		
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\Listeles.pdf"));
	   
		document.open();
	    PdfPTable table = new PdfPTable(5);
	    table.setWidthPercentage(100);
	    PdfPCell cell = new PdfPCell(new Phrase("Annuaire stagiaire"));
	   
	    document.add(new Phrase("Liste de stagiaires générée le " + LocalDate.now() + "\n"));

    	
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setColspan(5);
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    table.addCell(cell);
	    cell = new PdfPCell(new Phrase("Nom"));
	     table.addCell(cell);
	     cell = new PdfPCell(new Phrase("Prenom"));
	     table.addCell(cell);
	     table.addCell(new Phrase("Département"));
	    cell = new PdfPCell();
	    cell = new PdfPCell(new Phrase("Promotion"));
	    table.addCell(cell);
	    cell = new PdfPCell(new Phrase("Année"));
	    table.addCell(cell);
//	    cell = new PdfPCell(new Phrase("Année"));
//	    cell.setPadding(5);

	 
	    cell.setPadding(5);
	    Noeud.afficherListeStagiairesOrdre(new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
		
	    for (Stagiaire stagiaire : Main.annuaire) {
	    	table.addCell(stagiaire.getNom());
	    	table.addCell(stagiaire.getPrenom());
	    	table.addCell(stagiaire.getDpt());
	    	table.addCell(stagiaire.getPromo());
	    	table.addCell(stagiaire.getAnnee());
	    
	    	
	    	
	        	
		}
	    
	    
	    System.out.println("créer");
		document.add(table);
		document.close();
	}
	}
		
	
	


//		
//		Document document = new Document(PageSize.A4);
//	    try {
//	      PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.pdf"));
//	      document.open();
//
//	      File file = new File("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw");
// 	      document.add(Paragraph());
//
//	    } catch (DocumentException de) {
//	      de.printStackTrace();
//	    } catch (IOException ioe) {
//	      ioe.printStackTrace();
//	    }
//
//	    document.close();
//	  }
//	}
	
//		//created PDF document instance   
//		Document doc = new Document();  
//		try  
//		{  
//		//generate a PDF at the specified location  
//		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\Liste des stagiaires.pdf"));  
//		System.out.println("PDF created.");  
//		float[] pointColumnWidths = {150F,150F, 50F, 50F, 50F };
//		Table table = new Table(pointColumnWidths);
//		//opens the PDF  
//		doc.open();  
//		//adds paragraph to the PDF file  
//		doc.add(new Paragraph("Annuaire de Stagiaires.")); 
//		table.addCell( "Nom");
//		table.addCell( "Prenom");
////		tbt.addCell(new Cell().add((IBlockElement) prenom_col));
//		
//		//close the PDF file  
//		doc.close();  
//		//closes the writer  
//		writer.close();  
//		}   
//		catch (DocumentException e)  
//		{  
//		e.printStackTrace();  
//		}   
//		catch (FileNotFoundException e)  
//		{  
//		e.printStackTrace();  
//		}  
//		}  
//		}  