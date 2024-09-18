package sparadrap.views.subviews;

import sparadrap.models.ModeleApplication;
import sparadrap.models.submodels.Medicament;
import sparadrap.views.VueApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static sparadrap.mocks.DataSource.MEDICAMENTS;

public class AchatView extends JPanel {

    private List<Medicament> listeMedicaments = new ArrayList<>();
    JButton button;
    DefaultTableModel tableModel;

    public AchatView() {
        this.setLayout(new BorderLayout());
        creerBandeauHaut();
        afficherListeMedicaments();
        creerBandeauBas();
    }

    private void afficherListeMedicaments() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        this.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.PINK);

        String[] columnNames = {"OPERATIONS", "MEDICAMENT", "PRIX", "QUANTITE", "TOTAL"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);

    }

    private void creerBandeauBas() {
        JPanel panel = new JPanel(new SpringLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(new Dimension(100, ModeleApplication.BANDEAU_BAS_TAILLE));
        panel.setPreferredSize(new Dimension(100, ModeleApplication.BANDEAU_BAS_TAILLE));
        panel.setMaximumSize(new Dimension(100, ModeleApplication.BANDEAU_BAS_TAILLE));
        panel.add(ajouterPanneauVide());
        panel.add(new Panel());
        panel.add(ajouterPanneauAjouter());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMedicamentDialog();
            }
        });
        this.add(panel, BorderLayout.SOUTH);
        panel.setBackground(Color.GREEN);
    }
    private void showMedicamentDialog() {
        // Créer une boîte de dialogue personnalisée
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        // ComboBox pour les médicaments
        JComboBox<Medicament> medicamentComboBox = new JComboBox<>(MEDICAMENTS.toArray(new Medicament[0]));
        JLabel prixLabel = new JLabel("Prix: ");
        JLabel stockLabel = new JLabel("Stock: ");

        // Étiquette et zone de texte pour la quantité
        JLabel quantityLabel = new JLabel("Quantité à ajouter:");
        JTextField quantityField = new JTextField(5);

        // Mettre à jour les informations de prix et de stock lors de la sélection
        medicamentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicament selectedMedicament = (Medicament) medicamentComboBox.getSelectedItem();
                if (selectedMedicament != null) {
                    prixLabel.setText("Prix: " + selectedMedicament.getPrix());
                    stockLabel.setText("Stock: " + selectedMedicament.getStock());
                }
            }
        });

        // Afficher les informations du médicament sélectionné par défaut
        if (medicamentComboBox.getItemCount() > 0) {
            Medicament selectedMedicament = (Medicament) medicamentComboBox.getSelectedItem();
            prixLabel.setText("Prix: " + selectedMedicament.getPrix());
            stockLabel.setText("Stock: " + selectedMedicament.getStock());
        }

        // Bouton pour ajouter à la liste
        JButton addButton = new JButton("Ajouter");

        // Action du bouton pour ajouter le médicament et la quantité à une liste
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    Medicament selectedMedicament = (Medicament) medicamentComboBox.getSelectedItem();
                    if (selectedMedicament != null) {
                        float prix = selectedMedicament.getPrix();
                        float total = prix * quantity;

                        // Ajouter à la table
                        tableModel.addRow(new Object[]{"modifier", selectedMedicament.getNom(), prix, quantity, total});
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer une quantité valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ajouter les composants au panneau
        panel.add(new JLabel("Médicament:"));
        panel.add(medicamentComboBox);
        panel.add(prixLabel);
        panel.add(stockLabel);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(addButton);

        // Afficher la boîte de dialogue
        JOptionPane.showConfirmDialog(null, panel, "Ajouter Médicament", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
    public static float getColumnData(DefaultTableModel tableModel) {
        float somme = 0;

        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            float value = (float) tableModel.getValueAt(i, 4);
            somme += value;
        }

        return somme;
    }
    private JPanel ajouterPanneauVide() {
        JPanel panneau = new JPanel();
        Dimension dimensionColonne = new Dimension(ModeleApplication.BTN_ACCUEIL_WIDTH, ModeleApplication.BANDEAU_BAS_TAILLE);
        panneau.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panneau.setMinimumSize(dimensionColonne);
        panneau.setPreferredSize(dimensionColonne);
        panneau.setMaximumSize(dimensionColonne);
        return panneau;
    }
    private JPanel ajouterPanneauAjouter() {
        JPanel colonne = new JPanel();
        Dimension dimensionColonne = new Dimension(80, ModeleApplication.BANDEAU_BAS_TAILLE);
        colonne.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        colonne.setMinimumSize(dimensionColonne);
        colonne.setPreferredSize(dimensionColonne);
        colonne.setMaximumSize(dimensionColonne);
        button = VueApplication.creerBoutonAjouter();
        colonne.add(button);
        return colonne;
    }

    private void creerBandeauHaut() {
        JPanel panel = new JPanel();
        panel.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        panel.setMinimumSize(new Dimension(100, 150));
        panel.setPreferredSize(new Dimension(100, 150));
        panel.setMaximumSize(new Dimension(100, 150));
        this.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("SPARADRAP");
        JLabel addressLabel = new JLabel("128212 rue de la blessure, 54000 NANCY");
        JLabel invoiceLabel = new JLabel("Facture N° 1256 du 02/08/2024");

        JPanel prescriptionPanel = new JPanel();
        JButton withPrescriptionButton = new JButton("AVEC ORDONNANCE");
        JButton withoutPrescriptionButton = new JButton("SANS ORDONNANCE");
        withPrescriptionButton.setBackground(Color.WHITE);
        withoutPrescriptionButton.setBackground(Color.BLUE);// Assuming it's selected

        withPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withPrescriptionButton.setBackground(Color.BLUE);
                withoutPrescriptionButton.setBackground(Color.WHITE);
            }
        });
        withoutPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withPrescriptionButton.setBackground(Color.WHITE);
                withoutPrescriptionButton.setBackground(Color.BLUE);
            }
        });
        prescriptionPanel.add(withPrescriptionButton);
        prescriptionPanel.add(withoutPrescriptionButton);
        panel.add(titleLabel);
        panel.add(addressLabel);
        panel.add(invoiceLabel);
        panel.add(prescriptionPanel);
    }
}