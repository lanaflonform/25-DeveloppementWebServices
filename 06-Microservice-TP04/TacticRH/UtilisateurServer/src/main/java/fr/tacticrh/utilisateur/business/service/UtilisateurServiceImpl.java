package fr.tacticrh.utilisateur.business.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.tacticrh.utilisateur.business.exception.UtilisateurIdNotValidException;
import fr.tacticrh.utilisateur.business.exception.UtilisateurNotFoundException;
import fr.tacticrh.utilisateur.business.exception.UtilisateurNotValidException;
import fr.tacticrh.utilisateur.persistence.dao.UtilisateurDao;
import fr.tacticrh.utilisateur.persistence.model.Utilisateur;

/**
 * <b>CLASSE IMPLEMENTANT LES FONCTIONNALITES SUIVANTES :</b><br/>
 *    -->LES FONCTIONNALITES METIER.<br/>
 *    -->TYPE D'ENTITE CONCERNEE : 'Utilisateur'
 *    <br/>
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	
	private static final String ERROR__UTILISATEUR_CREATE__NOT_VALID = "Création d'un utilisateur -- Utilisateur non valide";
	private static final String ERROR__UTILISATEUR_FIND_ALL__NOT_AVAILABLE = "Recherche de tous les utilisateurs -- Utilisateurs indisponibles";
	private static final String ERROR__UTILISATEUR_FIND_BY_ID__NOT_FOUND = "Recherche d'un utilisateur par id -- Utilisateur introuvable";
	private static final String ERROR__UTILISATEUR_UPDATE_BY_ID__NOT_VALID = "Modification d'un utilisateur -- Utilisateur non valide";
	private static final String ERROR__UTILISATEUR_DELETE_BY_ID__NOT_VALID = "Suppression d'un utilisateur -- Utilisateur-id non valide";

	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurServiceImpl.class);
	
	/**
	 * <b>COMPOSANT DE PERSISTANCE RELATIF A L'ENTITE CI-DESSOUS :</b><br/>
	 * <br/>
	 * ->ENTITE : 'Utilisateur'.<br/> 
	 */    
    @Autowired
    private UtilisateurDao utilisateurDao;

	
	@Override
	public Utilisateur enregistrer(@RequestBody Utilisateur pUtilisateur) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : enregistrer -- BEGIN");
		
		if((pUtilisateur == null) || (pUtilisateur.getId() != null)) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : enregistrer -- END");
			throw new UtilisateurNotValidException(ERROR__UTILISATEUR_CREATE__NOT_VALID);
		}
		Utilisateur utilisateurCreated = this.utilisateurDao.save(pUtilisateur);
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : enregistrer -- END");
		return utilisateurCreated;
	}

	@Override
	public List<Utilisateur> rechercherTous() {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherTous -- BEGIN");
		
		List<Utilisateur> utilisateurs = this.utilisateurDao.findAll();
		
		if((utilisateurs == null) || (utilisateurs.isEmpty())) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherTous -- END");
			throw new UtilisateurNotFoundException(ERROR__UTILISATEUR_FIND_ALL__NOT_AVAILABLE);
		}
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherTous -- END");
		return utilisateurs;
	}

	@Override
	public Utilisateur rechercherParId(@PathVariable("id") Long pId) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherParId -- BEGIN");
		
		Optional<Utilisateur> utilisateurOptional = this.utilisateurDao.findById(pId);
		
		if (!utilisateurOptional.isPresent()) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherParId -- END");
			throw new UtilisateurNotFoundException(ERROR__UTILISATEUR_FIND_BY_ID__NOT_FOUND);
		}
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : rechercherParId -- END");
		return utilisateurOptional.get();
	}

	@Override
	public Utilisateur modifierParId(@RequestBody Utilisateur pUtilisateur) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : modifierParId -- BEGIN");
		
		if((pUtilisateur == null) || (pUtilisateur.getId() == null)) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : modifierParId -- END");
			throw new UtilisateurNotValidException(ERROR__UTILISATEUR_UPDATE_BY_ID__NOT_VALID);
		}
		Utilisateur utilisateurUpdated = this.utilisateurDao.save(pUtilisateur);
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : modifierParId -- END");
		return utilisateurUpdated;
	}

	@Override
	public void supprimerParId(@PathVariable("id") Long pId) {
		
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : supprimerParId -- BEGIN");
		try {
			this.utilisateurDao.deleteById(pId);
			
		} catch (IllegalArgumentException e) {
			LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : supprimerParId -- END");
			throw new UtilisateurIdNotValidException(ERROR__UTILISATEUR_DELETE_BY_ID__NOT_VALID);
		}
		LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : supprimerParId -- END");
		return;
	}
}
