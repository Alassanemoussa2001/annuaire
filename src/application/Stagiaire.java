package application;

import javafx.collections.ObservableList;
import javafx.scene.control.TextInputControl;

public class Stagiaire {
	public static final int TAILLE_NOM = 30;
	public static final int TAILLE_PRENOM = 30;
	public static final int TAILLE_DEPARTEMENT = 3;
	public static final int TAILLE_PROMOTION = 20;
	public static final int TAILLE_ANNEE = 4;
	public static final int TAILLE_STAGIAIRE = TAILLE_NOM + TAILLE_PRENOM + TAILLE_DEPARTEMENT + TAILLE_PROMOTION + TAILLE_ANNEE; // 87 caractères
	public static final int TAILLE_STAGIAIRE_OCTETS = 2 * TAILLE_STAGIAIRE; // 174 octets
	// calcul de la taille en octets d'un noeud dans le fichier binaire (= stagiaire + 4 * 3 pour les trois indices (indiceFilsGauche, indiceFilsDroit et indiceDoublon))
	public static final int TAILLE_NOEUD_OCTETS = TAILLE_STAGIAIRE_OCTETS + 4 * 3; // 186 octets (174 octets pour le stagiaire seul + 12 octets pour les trois indices)
	
	private String nom;
	private String prenom;
	private String dpt;
	private String promo;
	private String annee;
	
	public Stagiaire(String nom, String prenom, String dpt, String promo, String annee) {
		this.nom = nom;
		this.prenom = prenom;
		this.dpt = dpt;
		this.promo = promo;
		this.annee = annee;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getDpt() {
		return dpt;
	}
	
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	
	public String getPromo() {
		return promo;
	}
	
	public void setPromo(String promo) {
		this.promo = promo;
	}
	
	public String getAnnee() {
		return annee;
	}
	
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	private String getAttributLong(String attribut, int TAILLE_ATTRIBUT) {
		String attributLong = attribut;
		for(int i = attribut.length(); i < TAILLE_ATTRIBUT; i++) {
			attributLong += " ";
		}
		return attributLong;
	}
	
	public String getStagiaireLong() {
		return getAttributLong(nom, TAILLE_NOM) + getAttributLong(prenom, TAILLE_PRENOM) + getAttributLong(dpt, TAILLE_DEPARTEMENT) + getAttributLong(promo, TAILLE_PROMOTION) + annee;
	}
	
	@Override
	public String toString() {
		return "Stagiaire [nom=" + nom + ", prénom=" + prenom + ", dpt=" + dpt + ", promo=" + promo + ", année=" + annee
				+ "]";
	}
}











