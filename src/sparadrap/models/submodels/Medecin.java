package sparadrap.models.submodels;
import sparadrap.models.enums.medecine.SPECIALITES;
import java.util.ArrayList;
import java.util.List;

/**
 * [Medecin] - class
 * @author Mathaus
 */
public class Medecin extends Personne {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainView.
     */
    public Medecin(){}
    public Medecin(String prenom){
        this.setPrenom(prenom);
    }
    // </editor-fold>
    //****************************************************************************************************************//
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
    List<SPECIALITES> specilites = new ArrayList<>();
    private boolean isGeneraliste = false;
    @Override
    public String toString() {
        return "Dr " + this.getPrenom() + " " + this.getNom();
    }
    public void addSpecialite(SPECIALITES specialite){
        if (!this.specilites.contains(specialite)){
            this.specilites.add(specialite);
            if (specialite == SPECIALITES.GENERALE) isGeneraliste = true;
        }
    }
    public List<SPECIALITES> getSpecialites() {
        return specilites;
    }

    public void removeSpecialite(SPECIALITES spe) {
        this.specilites.remove(spe);
    }
}