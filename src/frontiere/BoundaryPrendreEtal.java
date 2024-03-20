package frontiere;

import java.util.Scanner;
import frontiere.Clavier;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu;
		boolean etalDisponible;
		nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu){
			System.out.println("Je suis désolée" + nomVendeur + "mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour" + nomVendeur + " je vais regarder si je peux vous trouver un étal.");
			etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + "je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}
			else {
				installerVendeur(nomVendeur);
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int nbProduit;
		int numeroEtal;
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		produit = Clavier.entrerString("Quel produit souhaitez-vous vendre ?");
		nbProduit = Clavier.entrerEntier("Combien souhaitez-vous vendre ?");
		numeroEtal =controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal !=-1) {
			System.out.println("L vendeur "+nomVendeur + "s'est installé à l'étal n°" +numeroEtal);
		}
	}
}
