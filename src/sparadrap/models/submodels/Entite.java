package sparadrap.models.submodels;
/**
 * [Entite] - abstract class
 * @author Mathaus
 */
public abstract class Entite {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    protected String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String codePostal;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (String)
     */
    public final String getNom() {
        return this.nom;
    }
    /**
     * Getter
     * @return (String)
     */
    public final String getAdresse() {
        return this.adresse;
    }
    /**
     * Getter
     * @return (String)
     */
    public final String getTelephone() {
        return this.telephone;
    }
    /**
     * Getter
     * @return (String)
     */
    public final String getEmail() {
        return this.email;
    }
    /**
     * Getter
     * @return (String)
     */
    public final String getCodePostal() {
        return this.codePostal;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param adresse
     */
    public final void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    /**
     * Setter
     * @param telephone
     */
    public final void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    /**
     * Setter
     * @param email
     */
    public final void setEmail(String email) {
        this.email = email;
    }
    /**
     * Setter
     * @param codePostal
     */
    public final void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Abstract">
    /**
     * Setter
     * @param nom
     */
    public abstract void setNom(String nom);
    // </editor-fold>
    //****************************************************************************************************************//
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Permet de definir les informations d'une Entite.
     * @param nom
     * @param adresse
     * @param telephone
     * @param email
     * @param codePostal
     */
    public void completerIdentite(String nom, String adresse, String telephone, String email, String codePostal) {
        this.setNom(nom);
        this.setAdresse(adresse);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setCodePostal(codePostal);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}