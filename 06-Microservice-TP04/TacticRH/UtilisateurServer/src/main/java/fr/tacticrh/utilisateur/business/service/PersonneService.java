package fr.tacticrh.utilisateur.business.service;

import java.util.List;

import fr.tacticrh.utilisateur.persistence.model.Personne;

/**
 * <b>CLASSE EXPOSANT LES FONCTIONNALITES SUIVANTES :</b><br/>
 *    -->LES FONCTIONNALITES METIER.<br/>
 *    -->TYPE D'ENTITE CONCERNEE : 'Personne'
 *    <br/>
 */
public interface PersonneService {

	
	/**
	 * <b>EFFECTUER L'OPERATION DE CREATION CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE A CREER : 'Personne'.<br/> 
	 *    
	 * @param pPersonne L'entité a créer.
	 * @return Personne L'entité créée.
	 */
    public Personne enregistrer(Personne pPersonne);
	
    /**
	 * <b>EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE RECHERCHEE : 'Personne'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : AUCUN.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : AUCUNE.<br/>
	 *    
	 * @return List<Personne> La liste d'entités trouvées.
	 */
    public List<Personne> rechercherTous();

	/**
	 * <b>EFFECTUER L'OPERATION DE RECHERCHE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE RECHERCHEE : 'Personne'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : L'ATTRIBUT 'id'.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : L'ATTRIBUT 'id' EST EGAL A LA VALEUR FOURNIE.<br/>
	 *    
	 * @param pId L'attribut 'id' de l'entité à rechercher.
	 * @return Personne L'entité trouvée.
	 */
    public Personne rechercherParId(Long pId);
    
	/**
	 * <b>EFFECTUER L'OPERATION DE MODIFICATION CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE A MODIFIER : 'Personne'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : L'ATTRIBUT 'id'.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : L'ATTRIBUT 'id' EST EGAL A LA VALEUR FOURNIE.<br/>
	 *    
	 * @param pPersonne L'entité a modifier.
	 * @return Personne L'entité modifiée.
	 */
    public Personne modifierParId(Personne pPersonne);
    
	/**
	 * <b>EFFECTUER L'OPERATION DE SUPPRESSION CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->(01.)ENTITE A SUPPRIMER : 'Personne'.<br/> 
	 * ->(02.)CRITERE DE RECHERCHE : L'ATTRIBUT 'id'.<br/> 
	 * ->(03.)CONDITION A SATISFAIRE : L'ATTRIBUT 'id' EST EGAL A LA VALEUR FOURNIE.<br/>
	 *    
	 * @param pId L'attribut 'id' de l'entité à supprimer.
	 * @return void
	 */
    public Long supprimerParId(Long pId);
}
