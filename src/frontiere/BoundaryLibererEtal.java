package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String[] donneesEtal = null;
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donneesEtal[0];
			if (Boolean.valueOf(donneesEtal[0])) {
				System.out.println("Vous avez vendu " + donneesEtal[4] +" sur "+ donneesEtal[3] + " " + donneesEtal[2] + ".");
				System.out.println("Au revoir" + nomVendeur + ", passez une bonne journée.");
			}

		}
	}

}
