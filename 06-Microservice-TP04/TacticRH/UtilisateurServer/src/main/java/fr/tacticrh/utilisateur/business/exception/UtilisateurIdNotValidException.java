package fr.tacticrh.utilisateur.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>EXCEPTION DU TYPE CI-DESSOUS :</b><br/>
 * TYPE : 'UTILISATEUR-ID NON VALIDE'
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UtilisateurIdNotValidException extends RuntimeException {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * <b>CONSTRUCTEUR AVEC UN ARGUMENT</b><br/>
     * @param pMessage Le message de l'exception
     */
	public UtilisateurIdNotValidException(String pMessage) {
        super(pMessage);
    }
}
