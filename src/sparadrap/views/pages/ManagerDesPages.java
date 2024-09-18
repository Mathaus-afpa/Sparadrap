package sparadrap.views.pages;
import sparadrap.models.enums.PAGES;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
/**
 * [ManagerDesPages] - class
 * @author Mathaus
 */
public class ManagerDesPages {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private ManagerDesPages() {
        if (ManagerDesPages.SingletonManagerDesPages.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private static final Map<PAGES, JPanel> pages = new HashMap<>();
    // definition de la Map
    static {
        pages.put(PAGES.ACCUEIL, VueAccueil.getInstance());
        pages.put(PAGES.ACHATS, VueAchats.getInstance());
        pages.put(PAGES.CLIENTS, VueClients.getInstance());
        pages.put(PAGES.HISTORIQUES, VueHistoriques.getInstance());
        pages.put(PAGES.MEDECINS, VueMedecins.getInstance());
    }
    JPanel currentPanel = pages.get(PAGES.ACCUEIL);
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Classes interne">
    /**
     * Classe porteuse du Singleton.
     */
    private static class SingletonManagerDesPages {
        private static final ManagerDesPages INSTANCE = new ManagerDesPages();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (ManagerDesPages)
     */
    public static ManagerDesPages getInstance() {
        return ManagerDesPages.SingletonManagerDesPages.INSTANCE;
    }
    /**
     * Affiche la page choisie en parametre.
     * @param page
     */
    public void afficherPage(PAGES page) {
        this.currentPanel.setVisible(false);
        this.currentPanel = this.pages.get(page);
        this.currentPanel.setVisible(true);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    // </editor-fold>
    //****************************************************************************************************************//
}