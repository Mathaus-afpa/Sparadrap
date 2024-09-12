package sparadrap.views.pages;
import sparadrap.models.ModeleApplication;
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
    Dimension dimensionBandeauBas = new Dimension(0, ModeleApplication.BANDEAU_BAS_TAILLE);
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
        this.setLayout(new BorderLayout());
        this.setVisible(false);
        afficherAchatView();
        creerBandeauBas();
    }
    /**
     * Ajoute la vue.
     */
    private void afficherAchatView() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        this.add(panel, BorderLayout.CENTER);
    }
    /**
     * Creer le bandeau du bas avec ses boutons.
     */
    private void creerBandeauBas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(VueApplication.ajouterPanneauAccueil());
        panel.add(ajouterPanneauValiderCommande());
        panel.add(ajouterPanneauVide() );
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(dimensionBandeauBas);
        panel.setPreferredSize(dimensionBandeauBas);
        panel.setMaximumSize(dimensionBandeauBas);
        this.add(panel, BorderLayout.SOUTH);
    }
    /**
     * Ajoute le panneau du bouton valider la commande.
     * @return (JPanel)
     */
    private JPanel ajouterPanneauValiderCommande() {
        JPanel panneauBoutonValiderCommande = new JPanel();
        JButton bouton = VueApplication.creerBoutonTexte("valider la commande");
        Dimension imageDimension = new Dimension(300, 52);
        bouton.setMinimumSize(imageDimension);
        bouton.setPreferredSize(imageDimension);
        bouton.setMaximumSize(imageDimension);
        panneauBoutonValiderCommande.add(bouton);
        panneauBoutonValiderCommande.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        return panneauBoutonValiderCommande;
    }
    /**
     * Ajoute un panneau vide de taille fixe.
     * @return (JPanel)
     */
    private JPanel ajouterPanneauVide() {
        JPanel panneau = new JPanel();
        Dimension dimensionColonne = new Dimension(ModeleApplication.BTN_ACCUEIL_WIDTH, ModeleApplication.BANDEAU_BAS_TAILLE);
        panneau.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panneau.setMinimumSize(dimensionColonne);
        panneau.setPreferredSize(dimensionColonne);
        panneau.setMaximumSize(dimensionColonne);
        return panneau;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}