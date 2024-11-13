package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			chaine.append("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui!\n");
		}
		else {
			String[] donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.TRUE.equals(Boolean.valueOf(donneesEtal[0]))) {
				chaine.append("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".\n");
				chaine.append("Au revoir " + nomVendeur + ", passez une bonne journ�e\n");
			}
		}
		System.out.println(chaine);
	}

}
