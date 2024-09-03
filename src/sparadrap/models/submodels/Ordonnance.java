package sparadrap.models.submodels;
import java.util.Date;
/**
 * [Ordonnance] - class
 * @author Mathaus
 */
public class Ordonnance {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private Date datePrescripton;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (Date)
     */
    public final Date getDatePrescripton() {
        return this.datePrescripton;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param datePrescripton
     */
    public final void setDatePrescripton(Date datePrescripton) {
        this.datePrescripton = datePrescripton;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}