package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous �tes d�j� un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("�tes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder gaulois = new StringBuilder();
					gaulois.append("Bienvenue villageois " + nomVisiteur + "\n");
					gaulois.append("Quelle est votre force ?\n");
					int force=-1;
					do{ 
						force = Clavier.entrerEntier(gaulois.toString());
					}while (force<1);
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder druide = new StringBuilder();
		druide.append("Bienvenue villageois " + nomVisiteur + "\n");
		druide.append("Quelle est votre force ?\n");
		int force=-1;
		do{ 
			force = Clavier.entrerEntier(druide.toString());
		}while (force<1);
		int effetPotionMax=-2,effetPotionMin=-1;
		do {
			druide = new StringBuilder();
			druide.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMin=Clavier.entrerEntier(druide.toString());
			druide = new StringBuilder();
			druide.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
			effetPotionMax=Clavier.entrerEntier(druide.toString());
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		}while(effetPotionMax<effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
