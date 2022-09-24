package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;

import com.itextpdf.layout.element.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.ObservableList;

public class Noeud {

	private Stagiaire stagiaire;
	private int filsGauche;
	private int doublon;
	private int filsDroit;

	public Noeud(Stagiaire stagiaire, int filsGauche, int doublon, int filsDroit) {
		this.stagiaire = stagiaire;
		this.filsGauche = filsGauche;
		this.doublon = doublon;
		this.filsDroit = filsDroit;
	}

	public Noeud() {
		stagiaire = null;
		filsGauche = -1;
		doublon = -1;
		filsDroit = -1;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public int getFilsGauche() {
		return filsGauche;
	}

	public void setFilsGauche(int filsGauche) {
		this.filsGauche = filsGauche;
	}

	public int getDoublon() {
		return doublon;
	}

	public void setDoublon(int doublon) {
		this.doublon = doublon;
	}

	public int getFilsDroit() {
		return filsDroit;
	}

	public void setFilsDroit(int filsDroit) {
		this.filsDroit = filsDroit;
	}

	public static void afficherListeStagiairesOrdre(RandomAccessFile raf) {

		try {

			Noeud noeud = lireNoeud(raf);

			if (noeud.filsGauche != -1) {
				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.filsGauche);
				afficherListeStagiairesOrdre(raf);
			}

			Main.annuaire.add(noeud.stagiaire);

			if (noeud.doublon != -1) {
				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.doublon);
				afficherListeStagiairesOrdre(raf);
			}

			if (noeud.filsDroit != -1) {
				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.filsDroit);
				afficherListeStagiairesOrdre(raf);
			}

		} catch (FileNotFoundException e) {
			System.out.println("le chemin n'est pas le bon");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("j'ai un pb avec un fichier");
			e.printStackTrace();
		}

	}

	public static String afficherStagiairesConsole(RandomAccessFile raf) {

		String resultat = "";

		try {

			Noeud noeud = lireNoeud(raf);

			if (noeud.filsGauche != -1) {
				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.filsGauche);
				resultat += afficherStagiairesConsole(raf);
			}

			resultat += noeud.stagiaire.toString() + "\n";

			if (noeud.doublon != -1) {
				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.doublon);
				resultat += afficherStagiairesConsole(raf);
			}

			if (noeud.filsDroit != -1) {
				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.filsDroit);
				resultat += afficherStagiairesConsole(raf);
			}

		} catch (FileNotFoundException e) {
			System.out.println("le chemin n'est pas le bon");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("j'ai un pb avec un fichier");
			e.printStackTrace();
		}

		return resultat;

	}

	public static void ajouterStagiaire(Stagiaire stagiaireAAjouter, RandomAccessFile raf) {

		try {

			if (raf.length() == 0) {
				raf.writeChars(stagiaireAAjouter.getStagiaireLong());
				raf.writeInt(-1);
				raf.writeInt(-1);
				raf.writeInt(-1);

			} else {
				raf.seek(0);
				remplirFichier(stagiaireAAjouter, raf);
			}

		} catch (FileNotFoundException e) {
			System.out.println("le chemin n'est pas le bon");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("j'ai un pb avec un fichier");
			e.printStackTrace();
		}

	}

	private static void remplirFichier(Stagiaire stagiaireAAjouter, RandomAccessFile raf) {
		try {
			Noeud noeud = lireNoeud(raf);
			if (noeud.stagiaire.toString().equals(stagiaireAAjouter.toString()) == false
					&& noeud.stagiaire.getNom().compareTo(stagiaireAAjouter.getNom()) > 0) { // je pars à gauche
				if (noeud.filsGauche == -1) {
					raf.seek(raf.getFilePointer() - 12);
					raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
					raf.seek(raf.length());
					raf.writeChars(stagiaireAAjouter.getStagiaireLong());
					raf.writeInt(-1);
					raf.writeInt(-1);
					raf.writeInt(-1);
				} else {
					raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.filsGauche);
					remplirFichier(stagiaireAAjouter, raf);
				}
			} else if (noeud.stagiaire.toString().equals(stagiaireAAjouter.toString()) == false
					&& noeud.stagiaire.getNom().compareTo(stagiaireAAjouter.getNom()) == 0) { // même nom (doublon)
				if (noeud.doublon == -1) {
					raf.seek(raf.getFilePointer() - 8);
					raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
					raf.seek(raf.length());
					raf.writeChars(stagiaireAAjouter.getStagiaireLong());
					raf.writeInt(-1);
					raf.writeInt(-1);
					raf.writeInt(-1);
				} else {
					raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.doublon);
					remplirFichier(stagiaireAAjouter, raf);
				}
			} else if (noeud.stagiaire.toString().equals(stagiaireAAjouter.toString()) == false
					&& noeud.stagiaire.getNom().compareTo(stagiaireAAjouter.getNom()) < 0) { // je pars à droite
				if (noeud.filsDroit == -1) {
					raf.seek(raf.getFilePointer() - 4);
					raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
					raf.seek(raf.length());
					raf.writeChars(stagiaireAAjouter.getStagiaireLong());
					raf.writeInt(-1);
					raf.writeInt(-1);
					raf.writeInt(-1);
				} else {
					raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * noeud.filsDroit);
					remplirFichier(stagiaireAAjouter, raf);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("le chemin n'est pas le bon");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("j'ai un pb avec un fichier");
			e.printStackTrace();
		}
	}

//	public static void supprimerStagiaire(Stagiaire stagiaireASupprimer, RandomAccessFile raf) {
//		
//		try {
//			
//			raf.seek(0);
//			
//			Noeud noeud = lireNoeud(raf);
//			
//			if (noeud.stagiaire.toString().equals(stagiaireASupprimer.toString()) && noeud.filsGauche == -1 && noeud.doublon == -1 && noeud.filsDroit == -1) { // supprime les feuilles
//				raf.seek(0);
//				
//				raf.seek(raf.length());
//				raf.writeChars(stagiaireAAjouter.getStagiaireLong());
//				raf.writeInt(0);
//				raf.writeInt(0);
//				raf.writeInt(0);
//				
//				

//				if (filsGauche == -1) {
//					raf.seek(raf.getFilePointer() - 12);
//					raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
//					raf.seek(raf.length());
//					raf.writeChars(stagiaireAAjouter.getStagiaireLong());
//					raf.writeInt(-1);
//					raf.writeInt(-1);
//					raf.writeInt(-1);
//				} else {
//					raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * filsGauche);
//					remplirFichier(stagiaireAAjouter, raf);
//				}
//
//			} else if ((new Stagiaire(nom.trim(), prenom.trim(), dpt.trim(), promo.trim(), annee.trim()).toString().equals(stagiaireAAjouter.toString()) == false) && nom.trim().compareTo(stagiaireAAjouter.getNom()) == 0
//					&& new Stagiaire(nom, prenom.trim(), dpt.trim(), promo.trim(), annee.trim()).toString()
//							.equals(stagiaireAAjouter.toString()) == false) { // même nom (doublon)
//				if (doublon == -1) {
//					raf.seek(raf.getFilePointer() - 8);
//					raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
//					raf.seek(raf.length());
//					raf.writeChars(stagiaireAAjouter.getStagiaireLong());
//					raf.writeInt(-1);
//					raf.writeInt(-1);
//					raf.writeInt(-1);
//				} else {
//					raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * doublon);
//					remplirFichier(stagiaireAAjouter, raf);
//				}
//
//			} else if ((new Stagiaire(nom.trim(), prenom.trim(), dpt.trim(), promo.trim(), annee.trim()).toString().equals(stagiaireAAjouter.toString()) == false) && nom.trim().compareTo(stagiaireAAjouter.getNom()) < 0) { // je pars à droite
//				if (filsDroit == -1) {
//					raf.seek(raf.getFilePointer() - 4);
//					raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
//					raf.seek(raf.length());
//					raf.writeChars(stagiaireAAjouter.getStagiaireLong());
//					raf.writeInt(-1);
//					raf.writeInt(-1);
//					raf.writeInt(-1);
//				} else {
//					raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * filsDroit);
//					remplirFichier(stagiaireAAjouter, raf);
//				}
//			}
//
//		} catch (FileNotFoundException e) {
//			System.out.println("le chemin n'est pas le bon");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("j'ai un pb avec un fichier");
//			e.printStackTrace();
//		}
//		
//	}

//	public static void afficherStagiairesListeOrdre(RandomAccessFile raf) {
//		
//		String resultat = "";
//		
//		try {
//									
//			String nom = "";
//			String prenom = "";
//			String dpt = "";
//			String promo = "";
//			String annee = "";
//			
//			for (int i = 0; i < Stagiaire.TAILLE_NOM; i++) {
//				nom += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_PRENOM; i++) {
//				prenom += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_DEPARTEMENT; i++) {
//				dpt += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_PROMOTION; i++) {
//				promo += raf.readChar();
//			}
//			for (int i = 0; i < Stagiaire.TAILLE_ANNEE; i++) {
//				annee += raf.readChar();
//			}
//			
//			int filsGauche = raf.readInt();
//			int doublon = raf.readInt();
//			int filsDroit = raf.readInt();
//			
//			if (filsGauche != -1) {
//				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * filsGauche);
//				afficherStagiairesListeOrdre(raf);
//			}
//			
//			Main.list.add(new Stagiaire(nom.trim(), prenom.trim(), dpt.trim(), promo.trim(), annee.trim()));
//				
//			if (doublon != -1) {
//				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * doublon);
//				afficherStagiairesListeOrdre(raf);
//			}
//				
//			if (filsDroit != -1) {
//				raf.seek(Stagiaire.TAILLE_NOEUD_OCTETS * filsDroit);
//				afficherStagiairesListeOrdre(raf);		
//			}
//				
//		} catch (FileNotFoundException e) {
//			System.out.println("le chemin n'est pas le bon");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("j'ai un pb avec un fichier");
//			e.printStackTrace();
//		}
//				
//	}

	public static Noeud lireNoeud(RandomAccessFile raf) {

		Noeud noeud = new Noeud();

		try {

			String nom = "";
			String prenom = "";
			String dpt = "";
			String promo = "";
			String annee = "";

			for (int i = 0; i < Stagiaire.TAILLE_NOM; i++) {
				nom += raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_PRENOM; i++) {
				prenom += raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_DEPARTEMENT; i++) {
				dpt += raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_PROMOTION; i++) {
				promo += raf.readChar();
			}
			for (int i = 0; i < Stagiaire.TAILLE_ANNEE; i++) {
				annee += raf.readChar();
			}

			int filsGauche = raf.readInt();
			int doublon = raf.readInt();
			int filsDroit = raf.readInt();

			noeud = new Noeud(new Stagiaire(nom.trim(), prenom.trim(), dpt.trim(), promo.trim(), annee.trim()),
					filsGauche, doublon, filsDroit);

		} catch (FileNotFoundException e) {
			System.out.println("le chemin n'est pas le bon");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("j'ai un pb avec un fichier");
			e.printStackTrace();
		}

		return noeud;
	}

	public static void modifierStagiaire(Stagiaire stagiaireAModifier, Stagiaire nouveauStagiaire, RandomAccessFile raf)
			throws IOException {

//		
		raf.seek(0);

		Stagiaire stagiaire;
		int filsGauche;
		int doublon;
		int filsDroit;
//	
		Noeud noeud = lireNoeud(raf);
		if (noeud.stagiaire.toString().equals(stagiaireAModifier.toString()) == false
				&& noeud.stagiaire.getNom().compareTo(stagiaireAModifier.getNom()) > 0) {
			if (noeud.filsGauche == -1) {

				raf.writeInt((int) raf.length() / Stagiaire.TAILLE_NOEUD_OCTETS);
				raf.seek(raf.length());
				raf.writeChars(nouveauStagiaire.getStagiaireLong());
				raf.writeInt(-1);
				raf.writeInt(-1);
			}

		}
	}

	public static void genererPdf(ObservableList<Stagiaire> annuaire) throws FileNotFoundException, DocumentException {
			
		
		
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
	  
	    for (Stagiaire stagiaire : Main.annuaire) {
	    	table.addCell(new Phrase(stagiaire.getNom()));
	    	table.addCell(new Phrase(stagiaire.getPrenom()));
	    	table.addCell(new Phrase(stagiaire.getDpt()));
	    	table.addCell(new Phrase(stagiaire.getPromo()));
	    	table.addCell(new Phrase(stagiaire.getAnnee()));
	    	
		}
	   
		document.add(table);
		document.close();
	}
	
	
	}
