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
			System.out.println("Je suis d�sol�e" + nomVendeur + "mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour" + nomVendeur + " je vais regarder si je peux vous trouver un �tal.");
			etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("D�sol�e " + nomVendeur + "je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
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
		System.out.println("C'est parfait, il me reste un �tal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		produit = Clavier.entrerString("Quel produit souhaitez-vous vendre ?");
		nbProduit = Clavier.entrerEntier("Combien souhaitez-vous vendre ?");
		numeroEtal =controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal !=-1) {
			System.out.println("L vendeur "+nomVendeur + "s'est install� � l'�tal n�" +numeroEtal);
		}
	}
}
