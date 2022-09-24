package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CVS {
	
	

	    public static void main(String args[]){
	        try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\test.csv"))) {

	            StringBuilder sb = new StringBuilder();
	            
	            
	            sb.append("Liste de Stagiaires");
	            
	            sb.append('\n');
	            
	            sb.append("Nom");
	            sb.append(";	");
	            sb.append("Prénom");
	            sb.append(";	");
	            sb.append("Département");
	            sb.append(";	");
	            sb.append("Promotion");
	            sb.append(";	");
	            sb.append("Année");
	            sb.append('\n');
	            
	            Noeud.afficherListeStagiairesOrdre(new RandomAccessFile("C:\\Users\\PC\\Desktop\\CV_Builder\\AnnuaireInterface\\src\\application\\STAGIAIRES2.bin", "rw"));
	        	for(Stagiaire stagiaire : Main.annuaire) {
	        		sb.append(stagiaire.getNom());
	        		sb.append(";	");
	        		sb.append(stagiaire.getPrenom());
	        		sb.append(";	");
	        		sb.append(stagiaire.getDpt());
	        		sb.append(";	");
	        		sb.append(stagiaire.getPromo());
	        		sb.append(";	");
	        		sb.append(stagiaire.getAnnee());
	        		sb.append('\n');
	        		
	        	}
	            	

	            writer.write(sb.toString());
	            writer.close();
	            System.out.println("done!");
	            

	        } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }}
