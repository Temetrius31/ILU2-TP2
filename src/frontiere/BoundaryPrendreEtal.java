package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			chaine.append("Je suis désolé " + nomVendeur + " mais il faut etre habitant de notre village pour commercer ici.\n");
			System.out.println(chaine);
		}
		else {
			chaine.append("Bonjour " + nomVendeur + " je vais voir si je peux vous trouver une place.\n");
			if(!controlPrendreEtal.resteEtals()) {
				chaine.append("Désolé " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé\n");
			}
			else {
				System.out.println(chaine);
				installerVendeur(nomVendeur);
				
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un étal pour vous!\n");
		chaine.append("Il me faudrait quelques renseignements :\n");
		chaine.append("Quels produits souhaitez vous vendre\n");
		System.out.println(chaine);
		String produit=scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + numEtal + ".\n");
		}
	}
}
