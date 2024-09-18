package sparadrap.models.submodels;
import java.util.Date;
/**
 * [Medicament] - class
 * @author Mathaus
 */
public class Medicament {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private String nom;
    private Date dateMiseEnService;
    private float prix;
    private int stock;
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
     * @return (Date)
     */
    public final Date getDateMiseEnService() {
        return this.dateMiseEnService;
    }
    /**
     * Getter
     * @return (float)
     */
    public final float getPrix() {
        return this.prix;
    }
    /**
     * Getter
     * @return (int)
     */
    public final int getStock() {
        return this.stock;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param nom
     */
    public final void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Setter
     * @param dateMiseEnService
     */
    public final void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }
    /**
     * Setter
     * @param prix
     */
    public final void setPrix(float prix) {
        this.prix = prix;
    }
    /**
     * Setter
     * @param stock
     */
    public final void setStock(int stock) {
        this.stock = stock;
    }
    // </editor-fold>
    //****************************************************************************************************************//


    @Override
    public String toString() {
        return this.nom;
    }
}