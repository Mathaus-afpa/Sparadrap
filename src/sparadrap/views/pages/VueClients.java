package sparadrap.views.pages;
import sparadrap.views.VueApplication;
import javax.swing.*;
import java.awt.*;
/**
 * [VueClients] - class
 * @author Mathaus
 */
public class VueClients extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private VueClients() {
        if (VueClients.SingletonVueClients.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        configurerVueClients();
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
    private static class SingletonVueClients {
        private static final VueClients INSTANCE = new VueClients();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (JPanel)
     */
    public static VueClients getInstance() {
        return VueClients.SingletonVueClients.INSTANCE;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le JPanel.
     */
    private void configurerVueClients() {
        this.setVisible(false);
        this.setBackground(Color.MAGENTA);
        this.add(VueApplication.creerBoutonAccueil());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}