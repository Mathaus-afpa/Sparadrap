package sparadrap.views.pages;
import sparadrap.views.VueApplication;
import javax.swing.*;
import java.awt.*;
/**
 * [VueHistoriques] - class
 * @author Mathaus
 */
public class VueHistoriques extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private VueHistoriques() {
        if (SingletonVueHistoriques.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        configurerVueHistoriques();
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
    private static class SingletonVueHistoriques {
        private static final VueHistoriques INSTANCE = new VueHistoriques();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (JPanel)
     */
    public static VueHistoriques getInstance() {
        return SingletonVueHistoriques.INSTANCE;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le JPanel.
     */
    private void configurerVueHistoriques() {
        this.setVisible(false);
        this.setBackground(Color.RED);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}