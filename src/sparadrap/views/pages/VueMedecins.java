package sparadrap.views.pages;

import sparadrap.composants.CustomComboBox;
import sparadrap.mocks.DataSource;
import sparadrap.models.ModeleApplication;
import sparadrap.models.submodels.Medecin;
import sparadrap.views.VueApplication;
import sparadrap.views.subviews.MedecinView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueMedecins extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private VueMedecins() {
        if (SingletonVueMedecins.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        configurerVueMedecins();
        VueApplication.ajouterAuPanneauParent(this);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    Dimension dimensionBandeauHaut = new Dimension(0, ModeleApplication.BANDEAU_HAUT_TAILLE);
    Dimension dimensionBandeauBas = new Dimension(0, ModeleApplication.BANDEAU_BAS_TAILLE);
    MedecinView medecinView = new MedecinView();
    CustomComboBox selectionMedecin = new CustomComboBox(DataSource.MEDECINS);
    JButton boutonSupprimerClient;
    JButton boutonModifierClient;
    boolean edition = false;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Classes interne">
    /**
     * Classe porteuse du Singleton.
     */
    private static class SingletonVueMedecins {
        private static final VueMedecins INSTANCE = new VueMedecins();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (JPanel)
     */
    public static VueMedecins getInstance() {
        return VueMedecins.SingletonVueMedecins.INSTANCE;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le JPanel.
     */
    private void configurerVueMedecins() {
        this.setLayout(new BorderLayout());
        this.setVisible(false);
        creerBandeauHaut();
        afficherClientView();
        creerBandeauBas();
        selectionMedecin.addPropertyChangeListener(evt -> {
            if ("selectedItem".equals(evt.getPropertyName())) {
                Medecin client = (Medecin) selectionMedecin.getSelectedItem();
                medecinView.setMedecin(client);
            }
        });
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
        VueApplication.definirUneMiseEnPageSpring(panel, selectionMedecin, new int[] { 4, 500, 0, 40});
        panel.add(selectionMedecin);
        medecinView.setMedecin((Medecin) selectionMedecin.getSelectedItem());
    }
    /**
     * Ajoute la vue.
     */
    private void afficherClientView() {
        JPanel panel = new JPanel();
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.add(medecinView);
        VueApplication.definirUneMiseEnPageSpring(panel, medecinView, new int[]{5 , 120, 5 ,40});
        this.add(panel, BorderLayout.CENTER);
    }
    /**
     * Creer le bandeau du bas avec ses boutons.
     */
    private void creerBandeauBas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(VueApplication.ajouterPanneauAccueil());
        panel.add(ajouterPanneauSupprimer());
        panel.add(ajouterPanneauModifierEtAjouter());
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(dimensionBandeauBas);
        panel.setPreferredSize(dimensionBandeauBas);
        panel.setMaximumSize(dimensionBandeauBas);
        this.add(panel, BorderLayout.SOUTH);
    }
    /**
     * Ajoute le panneau du bouton supprimer.
     * @return (JPanel)
     */
    private JPanel ajouterPanneauSupprimer() {
        JPanel colonneBoutonSupprimer = new JPanel();
        boutonSupprimerClient = VueApplication.creerBoutonSupprimer();
        boutonSupprimerClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medecin client = medecinView.getMedecin();
                if (client != null) {
                    DataSource.CLIENTS.remove(client);
                    selectionMedecin.updateItems(client);
                }
            }
        });
        colonneBoutonSupprimer.add(boutonSupprimerClient);
        colonneBoutonSupprimer.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        return colonneBoutonSupprimer;
    }
    /**
     * Ajoute le panneau des boutons modifier et ajouter.
     * @return (JPanel)
     */
    private JPanel ajouterPanneauModifierEtAjouter() {
        JPanel colonne = new JPanel();
        boutonModifierClient = VueApplication.creerBoutonTexte("modifer");
        Dimension dimensionColonne = new Dimension(280, ModeleApplication.BANDEAU_BAS_TAILLE);
        colonne.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        colonne.setMinimumSize(dimensionColonne);
        colonne.setPreferredSize(dimensionColonne);
        colonne.setMaximumSize(dimensionColonne);
        Dimension imageDimension = new Dimension(200, 52);
        boutonModifierClient.setMinimumSize(imageDimension);
        boutonModifierClient.setPreferredSize(imageDimension);
        boutonModifierClient.setMaximumSize(imageDimension);
        colonne.add(boutonModifierClient);
        JButton ajout = VueApplication.creerBoutonAjouter();
        colonne.add(ajout);
        boutonModifierClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edition = (medecinView.isEditable()) ? true : false;
                if (edition) medecinView.setEdition();
                else medecinView.saveEidtion();
            }
        });
        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo: implementer pages
                JOptionPane.showMessageDialog(null, "Unimplemented yet", "TODO:", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return colonne;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}