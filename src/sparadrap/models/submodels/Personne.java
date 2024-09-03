package sparadrap.models.submodels;
/**
 * [Personne] - class
 * @author Mathaus
 */
public class Personne extends Entite {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private String prenom;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (String)
     */
    public final String getPrenom() {
        return this.prenom;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param prenom
     */
    public final void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Override">
    /**
     * Setter
     * @param nom
     */
    @Override
    public final void setNom(String nom) {
        this.nom = nom;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}