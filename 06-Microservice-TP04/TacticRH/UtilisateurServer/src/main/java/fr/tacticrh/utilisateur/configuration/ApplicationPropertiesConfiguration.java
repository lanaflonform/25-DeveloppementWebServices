package fr.tacticrh.utilisateur.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@RefreshScope
@Component
@ConfigurationProperties("ma-config")
public class ApplicationPropertiesConfiguration {

	
	private int produitNombreMax;
	

	public int getProduitNombreMax() { return this.produitNombreMax; }

	public void setProduitNombreMax(int pProduitNombreMax) { this.produitNombreMax = pProduitNombreMax; }
}
