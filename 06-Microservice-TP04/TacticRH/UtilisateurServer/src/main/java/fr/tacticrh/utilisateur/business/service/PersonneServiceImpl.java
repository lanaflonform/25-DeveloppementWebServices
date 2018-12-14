package fr.tacticrh.utilisateur.business.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.tacticrh.utilisateur.business.exception.PersonneIdNotValidException;
import fr.tacticrh.utilisateur.business.exception.PersonneNotFoundException;
import fr.tacticrh.utilisateur.business.exception.PersonneNotValidException;
import fr.tacticrh.utilisateur.persistence.dao.PersonneDao;
import fr.tacticrh.utilisateur.persistence.model.Personne;

/**
 * <b>CLASSE IMPLEMENTANT LES FONCTIONNALITES SUIVANTES :</b><br/>
 *    -->LES FONCTIONNALITES METIER.<br/>
 *    -->TYPE D'ENTITE CONCERNEE : 'Personne'
 *    <br/>
 */
@Service
public class PersonneServiceImpl implements PersonneService {

	
	private static final String ERROR__PERSONNE_CREATE__NOT_VALID = "Création d'une personne -- Personne non valide";
	private static final String ERROR__PERSONNE_FIND_ALL__NOT_AVAILABLE = "Recherche de toutes les personnes -- Personnes indisponibles";
	private static final String ERROR__PERSONNE_FIND_BY_ID__NOT_FOUND = "Recherche d'une personne par id -- Personne introuvable";
	private static final String ERROR__PERSONNE_UPDATE_BY_ID__NOT_VALID = "Modification d'une personne -- Personne non valide";
	private static final String ERROR__PERSONNE_DELETE_BY_ID__NOT_VALID = "Suppression d'une personne -- Personne-id non valide";

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonneServiceImpl.class);
	
	/**
	 * <b>COMPOSANT DE PERSISTANCE RELATIF A L'ENTITE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->ENTITE : 'Account'.<br/> 
	 */    
    @Autowired
    private PersonneDao personneDao;

	
	@Override
	public Personne enregistrer(@RequestBody Personne pPersonne) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : enregistrer -- BEGIN");
		
		if((pPersonne == null) || (pPersonne.getId() != null)) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : enregistrer -- END");
			throw new PersonneNotValidException(ERROR__PERSONNE_CREATE__NOT_VALID);
		}
		Personne personneCreated = personneDao.save(pPersonne);
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : enregistrer -- END");
		return personneCreated;
	}

	@Override
	public List<Personne> rechercherTous() {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherTous -- BEGIN");
		
		List<Personne> personnes = personneDao.findAll();
		
		if((personnes == null) || (personnes.isEmpty())) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherTous -- END");
			throw new PersonneNotFoundException(ERROR__PERSONNE_FIND_ALL__NOT_AVAILABLE);
		}
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherTous -- END");
		return personnes;
	}

	@Override
	public Personne rechercherParId(@PathVariable("id") Long pId) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherParId -- BEGIN");
		
		Optional<Personne> personneOptional = personneDao.findById(pId);
		
		if (!personneOptional.isPresent()) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherParId -- END");
			throw new PersonneNotFoundException(ERROR__PERSONNE_FIND_BY_ID__NOT_FOUND);
		}
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherParId -- END");
		return personneOptional.get();
	}

	@Override
	public Personne modifierParId(@RequestBody Personne pPersonne) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : modifierParId -- BEGIN");
		
		if((pPersonne == null) || (pPersonne.getId() == null)) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : modifierParId -- END");
			throw new PersonneNotValidException(ERROR__PERSONNE_UPDATE_BY_ID__NOT_VALID);
		}
		Personne personneUpdated = personneDao.save(pPersonne);
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : modifierParId -- END");
		return personneUpdated;
	}

	@Override
	public Long supprimerParId(@PathVariable("id") Long pId) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : supprimerParId -- BEGIN");
		try {
			personneDao.deleteById(pId);
			
		} catch (IllegalArgumentException e) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : supprimerParId -- END");
			throw new PersonneIdNotValidException(ERROR__PERSONNE_DELETE_BY_ID__NOT_VALID);
		}
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : supprimerParId -- END");
		return pId;
	}
}
