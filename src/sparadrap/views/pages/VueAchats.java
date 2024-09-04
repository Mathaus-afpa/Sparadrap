package sparadrap.views.pages;
import sparadrap.views.VueApplication;
import javax.swing.*;
import java.awt.*;
/**
 * [VueAchats] - class
 * @author Mathaus
 */
public class VueAchats extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private VueAchats() {
        if (VueAchats.SingletonVueAchats.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        configurerVueAchats();
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
    private static class SingletonVueAchats {
        private static final VueAchats INSTANCE = new VueAchats();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (JPanel)
     */
    public static VueAchats getInstance() {
        return VueAchats.SingletonVueAchats.INSTANCE;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le JPanel.
     */
    private void configurerVueAchats() {
        this.setVisible(false);
        this.setBackground(Color.ORANGE);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}