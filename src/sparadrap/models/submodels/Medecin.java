package sparadrap.models.submodels;
/**
 * [Medecin] - class
 * @author Mathaus
 */
public class Medecin extends Personne {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private int agreement;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (int)
     */
    public final int getAgreement() {
        return this.agreement;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param agreement
     */
    public final void setAgreement(int agreement) {
        this.agreement = agreement;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}