package sparadrap.models.submodels;
/**
 * [Mutuelle] - class
 * @author Mathaus
 */
public class Mutuelle extends Entite {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private float tauxDeRemboursement;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (float)
     */
    public final float getTauxDeRemboursement() {
        return this.tauxDeRemboursement;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param tauxDeRemboursement
     */
    public final void setTauxDeRemboursement(float tauxDeRemboursement) {
        this.tauxDeRemboursement = tauxDeRemboursement;
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

    }
    // </editor-fold>
    //****************************************************************************************************************//
}