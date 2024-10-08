package sparadrap.views.pages;
import sparadrap.composants.CustomComboBox;
import sparadrap.composants.CustomOptionPane;
import sparadrap.mocks.DataSource;
import sparadrap.models.ModeleApplication;
import sparadrap.models.submodels.Client;
import sparadrap.views.VueApplication;
import sparadrap.views.subviews.ClientView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    ClientView clientView = new ClientView();
    CustomComboBox selectionClient = new CustomComboBox(DataSource.CLIENTS);
    JButton boutonSupprimerClient;
    JButton boutonAjouterClient;
    JButton boutonModifierClient;
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
        selectionClient.addPropertyChangeListener(evt -> {
            if ("selectedItem".equals(evt.getPropertyName())) {
                Client client = (Client) selectionClient.getSelectedItem();
                clientView.setClient(client);
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
        VueApplication.definirUneMiseEnPageSpring(panel, selectionClient, new int[] { 4, 500, 0, 40});
        panel.add(selectionClient);
        clientView.setClient((Client) selectionClient.getSelectedItem());
    }
    /**
     * Ajoute la vue.
     */
    private void afficherClientView() {
        JPanel panel = new JPanel();
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.add(clientView);
        VueApplication.definirUneMiseEnPageSpring(panel, clientView, new int[]{5 , 120, 5 ,40});
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
                Client client = clientView.getClient();
                if (client != null) {
                    DataSource.CLIENTS.remove(client);
                    selectionClient.updateItems(client);
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
        boutonAjouterClient = VueApplication.creerBoutonAjouter();
        colonne.add(boutonAjouterClient);
        onClick();
        return colonne;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    boolean edition = false;
    private void onClick() {
        boutonModifierClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edition = (clientView.isEditable()) ? true : false;
                if (edition) clientView.setEdition();
                else clientView.saveEdition();
            }
        });
        boutonAjouterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView addclientView = new ClientView();
                addclientView.setClient(new Client());
                addclientView.setEdition();
                CustomOptionPane customOptionPane = new CustomOptionPane(addclientView);
                customOptionPane.setValidateListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Client client = clientView.getClient();
                        clientView.reverseClient();
                        DataSource.CLIENTS.add(addclientView.getClient());
                    }
                });
                //CustomOptionPane.showConfirmDialog(null, addclientView, "Ajouter Client", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                customOptionPane.showCustomDialog("Titre Personnalisé");
            }
        });
    }
}