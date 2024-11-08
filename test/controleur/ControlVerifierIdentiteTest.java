package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void init() {
		System.out.println("Initialisation...");
		
		village=new Village("le village des irréductibles", 10, 5);
		controlEmmenager=new ControlEmmenager(village);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlEmmenager.ajouterGaulois("Asterix", 10);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Obelix"));
	}

}
