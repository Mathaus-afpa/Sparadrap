package sparadrap.views.pages;
import sparadrap.views.VueApplication;
import javax.swing.*;
import java.awt.*;
/**
 * [VueAccueil] - class
 * @author Mathaus
 */
public class VueAccueil extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private VueAccueil() {
        if (VueAccueil.SingletonVueAccueil.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        configurerVueAccueil();
        VueApplication.ajouterAuPanneauParent(this);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Classes interne">
    /**
     * Classe porteuse du Singleton.
     */
    private static class SingletonVueAccueil {
        private static final VueAccueil INSTANCE = new VueAccueil();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (JPanel)
     */
    public static JPanel getInstance() {
        return VueAccueil.SingletonVueAccueil.INSTANCE;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le JPanel.
     */
    private void configurerVueAccueil() {
        this.setBackground(Color.YELLOW);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}