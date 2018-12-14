package fr.tacticrh.utilisateur.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.tacticrh.utilisateur.persistence.model.Role;


/**
 * <b>COMPOSANT POSSEDANT LES FONCTIONNALITES CI-DESSOUS:</b><br/>
 * ->LES FONCTIONNALITES DE PERSISTANCE SUR L'ENTITE CONCERNEE<br/>
 * ->ENTITE : 'Role'.<br/> 
 */    
@Repository
public interface RoleDao extends JpaRepository<Role, Long>{
	
	public Role findByLibelle(String pLibelle);
}
