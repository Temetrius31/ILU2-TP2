package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void init() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles", 10, 5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois asterix=new Gaulois("asterix", 10);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
		Etal etalAttendu=new Etal();
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur("asterix");
		assertNotEquals(etal, etalAttendu);
		
		assertEquals(etal.getVendeur(),asterix); 
	}

}
