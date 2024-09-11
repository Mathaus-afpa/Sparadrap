package sparadrap.views.pages;
import sparadrap.composants.CustomComboBox;
import sparadrap.mocks.DataSource;
import sparadrap.models.ModeleApplication;
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
    Dimension dimensionBandeauHaut = new Dimension(0, ModeleApplication.BANDEAU_HAUT_TAILLE);
    Dimension dimensionBandeauBas = new Dimension(0, ModeleApplication.BANDEAU_BAS_TAILLE);
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
        this.setLayout(new BorderLayout());
        this.setVisible(false);
        creerBandeauHaut();
        afficherClientView();
        creerBandeauBas();
    }
    /**
     * Creer le bandeau du haut avec sa combobox.
     */
    private void creerBandeauHaut() {
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(dimensionBandeauHaut);
        panel.setPreferredSize(dimensionBandeauHaut);
        panel.setMaximumSize(dimensionBandeauHaut);
        this.add(panel, BorderLayout.NORTH);
        CustomComboBox menu = new CustomComboBox(DataSource.CLIENTS.toArray());
        VueApplication.definirUneMiseEnPageSpring(panel, menu, new int[] { 4, 500, 0, 40});
        panel.add(menu);
    }
    /**
     * Ajoute la vue.
     */
    private void afficherClientView() {
        JPanel panel = new JPanel();
        JPanel clientView = new JPanel();
        VueApplication.definirUneMiseEnPageSpring(panel, clientView, new int[]{5 , 120, 5 ,40});
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        clientView.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        clientView.setBorder(BorderFactory.createLineBorder(ModeleApplication.APP_COULEUR_TEXTE, ModeleApplication.BTN_TAILLE_BORDURE_FINE));
        panel.add(clientView);
        this.add(panel, BorderLayout.CENTER);
    }
    /**
     * Creer le bandeau du bas avec ses boutons.
     */
    private void creerBandeauBas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(ajouterColonneAccueil());
        panel.add(ajouterColonneSupprimer());
        panel.add(ajouterColonneModifierEtAjouter() );
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(dimensionBandeauBas);
        panel.setPreferredSize(dimensionBandeauBas);
        panel.setMaximumSize(dimensionBandeauBas);
        this.add(panel, BorderLayout.SOUTH);
    }
    /**
     * Ajoute le panneau du bouton d'accueil.
     * @return (JPanel)
     */
    private JPanel ajouterColonneAccueil() {
        JPanel colonneBoutonAccueil = new JPanel();
        JButton boutonAccueil = VueApplication.creerBoutonAccueil();
        Dimension homedim = new Dimension(174, ModeleApplication.BANDEAU_BAS_TAILLE);
        colonneBoutonAccueil.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        colonneBoutonAccueil.setMinimumSize(homedim);
        colonneBoutonAccueil.setPreferredSize(homedim);
        colonneBoutonAccueil.setMaximumSize(homedim);
        colonneBoutonAccueil.add(boutonAccueil);
        VueApplication.definirUneMiseEnPageSpring(colonneBoutonAccueil, boutonAccueil, new int[] {3});
        return colonneBoutonAccueil;
    }
    /**
     * Ajoute le panneau du bouton supprimer.
     * @return (JPanel)
     */
    private JPanel ajouterColonneSupprimer() {
        JPanel colonneBoutonSupprimer = new JPanel();
        colonneBoutonSupprimer.add(VueApplication.creerBoutonSupprimer());
        colonneBoutonSupprimer.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        return colonneBoutonSupprimer;
    }
    /**
     * Ajoute le panneau des boutons modifier et ajouter.
     * @return (JPanel)
     */
    private JPanel ajouterColonneModifierEtAjouter() {
        JPanel colonne = new JPanel();
        Dimension dimensionColonne = new Dimension(280, ModeleApplication.BANDEAU_BAS_TAILLE);
        colonne.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        colonne.setMinimumSize(dimensionColonne);
        colonne.setPreferredSize(dimensionColonne);
        colonne.setMaximumSize(dimensionColonne);
        colonne.add(VueApplication.creerBoutonModifier());
        colonne.add( VueApplication.creerBoutonAjouter());
        return colonne;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}