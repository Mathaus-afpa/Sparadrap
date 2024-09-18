package sparadrap.models.submodels;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public Mutuelle getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Mutuelle mutuelle) {
        this.mutuelle = mutuelle;
    }

    private Mutuelle mutuelle = null;

    public Medecin getReferent() {
        return referent;
    }

    public void setReferent(Medecin referent) {
        this.referent = referent;
    }

    private Medecin referent = null;

    public List<Medecin> getSpecialiste() {
        return specialiste;
    }

    public void addSpecialiste(Medecin specialiste) {
        this.specialiste.add(specialiste);
    }

    public void removeSpecialiste(Medecin specialiste) {
        this.specialiste.remove(specialiste);
    }

    public int lengthSpecialiste() {
        return this.specialiste.size();
    }

    private List<Medecin> specialiste = new ArrayList<>();
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