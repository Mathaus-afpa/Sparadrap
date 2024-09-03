package sparadrap.models.submodels;
import java.util.Date;
/**
 * [Achat] - class
 * @author Mathaus
 */
public class Achat {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private Date dateAchat;
    private boolean prescription;
    private int numeroFacture;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (Date)
     */
    public final Date getDateAchat() {
        return this.dateAchat;
    }
    /**
     * Getter
     * @return (boolean)
     */
    public final boolean isPrescription() {
        return this.prescription;
    }
    /**
     * Getter
     * @return (int)
     */
    public final int getNumeroFacture() {
        return this.numeroFacture;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param dateAchat
     */
    public final void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }
    /**
     * Setter
     * @param prescription
     */
    public final void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }
    /**
     * Setter
     * @param numeroFacture
     */
    public final void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}