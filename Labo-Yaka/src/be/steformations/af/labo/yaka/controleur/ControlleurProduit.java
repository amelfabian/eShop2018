package be.steformations.af.labo.yaka.controleur;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.web.bind.annotation.RequestMapping;

import be.steformations.af.labo.yaka.model.GestionnaireYaka;
import be.steformations.af.labo.yaka.session.SessionCaracteristiques;

@ManagedBean
@RequestMapping
public class ControlleurProduit {
	@ManagedProperty(value="{gestionnaireYaka}")
	private GestionnaireYaka gestionnaire;
	@ManagedProperty(value="{sessionCaracteristiques}")
	private SessionCaracteristiques session;
	private String produits;

	
	
	public String actionBoutton(){
		int id = Integer.parseInt(produits);
		this.produits = this.gestionnaire.getCaracteristiquesByProduits(id);
		session.setVar(produits);
		return "articles";
	}
	
	public String getVignette(){
		int id = Integer.parseInt(produits);
		return this.gestionnaire.getVignetteByProduit(id);
	}

	public String getProduits() {
		return produits;
	}

	public void setProduits(String produits) {
		this.produits = produits;
	}
	
	

	
	
}