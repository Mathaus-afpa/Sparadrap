package sparadrap.models.submodels;
import java.util.Date;
/**
 * [Client] - class
 * @author Mathaus
 */
public class Client extends Personne {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainView.
     */
    public Client(){}
    public Client(String prenom){
        this.setPrenom(prenom);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private Date dateDeNaissance;
    private int numeroSecuriteSociale;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (Date)
     */
    public final Date getDateDeNaissance() {
        return this.dateDeNaissance;
    }
    /**
     * Getter
     * @return (int)
     */
    public final int getNumeroSecuriteSociale() {
        return this.numeroSecuriteSociale;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param dateDeNaissance
     */
    public final void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    /**
     * Setter
     * @param numeroSecuriteSociale
     */
    public final void setNumeroSecuriteSociale(int numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Implements">
    @Override
    public String toString() {
        return this.getNom() + " " + this.getPrenom();
    }
    // </editor-fold>
    //****************************************************************************************************************//
}