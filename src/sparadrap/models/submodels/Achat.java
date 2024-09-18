package sparadrap.models.submodels;
import java.util.*;
/**
 * [Achat] - class
 * @author Mathaus
 */
public class Achat {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private Date dateAchat;
    private boolean prescription;
    private Map<Medicament, Integer> medicaments = new HashMap<>();
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
    public final void setMedicaments(Map<Medicament, Integer> medicaments) {
        this.medicaments = medicaments;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Medicament, Integer> entry : medicaments.entrySet()) {
            Medicament medicament = entry.getKey();
            Integer quantity = entry.getValue();
            result.append(quantity).append(" x ").append(medicament.getNom()).append(" ");
        }
        return result.toString();
    }
    public float calcul() {
        float result = 0;
        for (Map.Entry<Medicament, Integer> entry : medicaments.entrySet()) {
            Medicament medicament = entry.getKey();
            Integer quantity = entry.getValue();
            result += medicament.getPrix() * quantity;
        }
        return Math.round(result * 100.0f) / 100.0f;
    }
    //****************************************************************************************************************//
}