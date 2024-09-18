package sparadrap.views.pages;
import sparadrap.composants.CustomLabel;
import sparadrap.models.ModeleApplication;
import sparadrap.models.submodels.Client;
import sparadrap.views.VueApplication;
import sparadrap.views.subviews.HistoriqueView;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

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
    Dimension dimensionBandeauHaut = new Dimension(0, ModeleApplication.BANDEAU_HAUT_TAILLE * 2);
    Dimension dimensionBandeauBas = new Dimension(0, ModeleApplication.BANDEAU_BAS_TAILLE);
    static HistoriqueView historiqueView;
    static Date selectedDate;
    static CustomLabel label;
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
        this.setLayout(new BorderLayout());
        this.setVisible(false);
        creerBandeauHaut();
        afficherHistoriquesView();
        creerBandeauBas();
    }
    private void creerBandeauHaut() {
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(dimensionBandeauHaut);
        panel.setPreferredSize(dimensionBandeauHaut);
        panel.setMaximumSize(dimensionBandeauHaut);
        this.add(panel, BorderLayout.NORTH);
        JButton but = new JButton("Bouton");
        but.addActionListener(e -> {
            showDatePickerDialog();
        });
        panel.add(but);
    }
    private static void showDatePickerDialog() {
        JComboBox<Date> dayComboBox = new JComboBox<>();

        for (Date date : historiqueView.getUniquePurchaseDates()) {
            dayComboBox.addItem(date);
        }


        // Créer un panneau pour contenir les combo boxes
        JPanel panel = new JPanel(new GridLayout(2, 3));
        panel.add(dayComboBox);
        // Afficher le panneau dans un JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Sélectionnez une date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            selectedDate = (Date) dayComboBox.getSelectedItem();
            historiqueView.setDate(selectedDate);
            historiqueView.filterDate();
            historiqueView.refresh();
            label.setText("TOTAL: " + historiqueView.getTotal() + "€");
        }
    }
    /**
     * Ajoute la vue.
     */
    private void afficherHistoriquesView() {
        historiqueView =  new HistoriqueView();
        this.add(historiqueView, BorderLayout.CENTER);
    }
    /**
     * Creer le bandeau du bas avec le bouton accueil et le total.
     */
    private void creerBandeauBas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(VueApplication.ajouterPanneauAccueil());
        panel.add(ajouterPanneauTotal());
        panel.add(ajouterPanneauVide() );
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(dimensionBandeauBas);
        panel.setPreferredSize(dimensionBandeauBas);
        panel.setMaximumSize(dimensionBandeauBas);
        this.add(panel, BorderLayout.SOUTH);
    }
    /**
     * Ajoute le panneau du total.
     * @return (JPanel)
     */
    private JPanel ajouterPanneauTotal() {
        JPanel panneauTotal = new JPanel();
        label = new CustomLabel();
        Font font = new Font(ModeleApplication.APP_FONT, Font.PLAIN, 30);
        VueApplication.definirUneMiseEnPageSpring(panneauTotal, label, new int[] {4});
        panneauTotal.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        label.setBackground(ModeleApplication.APP_COULEUR_TEXTE);
        label.setOpaque(true);
        label.setForeground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        label.setText("TOTAL: " + historiqueView.getTotal() + "€");
        label.setHorizontalAlignment(-20);
        label.setFont(font);
        panneauTotal.add(label);
        return panneauTotal;
    }
    /**
     * Ajoute un panneau vide de taille fixe.
     * @return (JPanel)
     */
    private JPanel ajouterPanneauVide() {
        JPanel panneau = new JPanel();
        Dimension dimensionColonne = new Dimension(90, ModeleApplication.BANDEAU_BAS_TAILLE);
        panneau.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panneau.setMinimumSize(dimensionColonne);
        panneau.setPreferredSize(dimensionColonne);
        panneau.setMaximumSize(dimensionColonne);
        return panneau;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}