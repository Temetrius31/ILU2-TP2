package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez vous achetez ?\n");
		String[] marchands = controlAcheterProduit.obtenirMarchand(produit);
		if (marchands == null) {
			return;
		}
		int indiceVendeur = Clavier.entrerEntier(null);
		indiceVendeur--;
		if (controlAcheterProduit.verifierIdentite(marchands[indiceVendeur])) {
			
			int quantite = Clavier.entrerEntier(nomAcheteur + " se déplace jusqu'à l'étal du vendeur" + marchands[indiceVendeur]
					+ "\nBonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?\n");
			int quantiteAchete = controlAcheterProduit.acheterProduit(marchands[indiceVendeur], quantite);
			if (quantiteAchete == 0) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
						+ " malheureusement il n'y en a plus.\n");
			} else if (quantite > quantiteAchete) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + " malheureusement "
						+ marchands[indiceVendeur] + " n'en a plus que " + quantiteAchete + "." + nomAcheteur
						+ " achète tout le stock de " + marchands[indiceVendeur] + ".");
			} else {
				System.out.println(
						nomAcheteur + " achète " + quantiteAchete + " " + produit + " à " + marchands[indiceVendeur]);
			}
		}
	}
	
}
