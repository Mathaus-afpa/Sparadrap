package sparadrap.views.subviews;
import sparadrap.composants.CustomViewLabel;
import sparadrap.mocks.DataSource;
import sparadrap.models.ModeleApplication;
import sparadrap.models.enums.AFFICHAGES;
import sparadrap.models.enums.medecine.SPECIALITES;
import sparadrap.models.submodels.Client;
import sparadrap.models.submodels.Medecin;
import sparadrap.models.submodels.Mutuelle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import static sparadrap.models.ModeleApplication.APP_FONT;
import static sparadrap.views.VueApplication.creerBoutonAfficher;
public class ClientView extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public ClientView() {
        this.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        this.setBorder(BorderFactory.createLineBorder(ModeleApplication.APP_COULEUR_TEXTE, ModeleApplication.BTN_TAILLE_BORDURE_FINE));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 15, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        int row = 0;
        for (Map.Entry<String, JComponent> entry : ClientView.getMap().entrySet()) {
            gbc.gridx = 0;  // Colonne 1
            gbc.gridy = row;  // Ligne correspondante
            JLabel label = new JLabel(entry.getKey());
            Font font = new Font(APP_FONT, Font.PLAIN, 20);
            label.setFont(font);
            this.add(label, gbc);
            gbc.gridx = 1;  // Colonne 2
            this.add(entry.getValue(), gbc);
            row++;
        }
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private static Map<String, JComponent> map = new HashMap<>();
    private static Client client;
    private JButton boutonAfficherReferent, boutonAfficherMutuelle, boutonAfficherSpecialistes;
    static {
        map.put("Nom", new CustomViewLabel("^[A-Z][a-zA-Z-'À-ÿ]+(?: [A-Z][a-zA-Z-'À-ÿ]+)*$"));
        map.put("Prenom", new CustomViewLabel("^[A-Z][a-zA-Z-'À-ÿ]+(?: [A-Z][a-zA-Z-'À-ÿ]+)*$"));
        map.put("Adresse", new CustomViewLabel("^(\\d{1,5}\\s[A-Za-zÀ-ÿ0-9\\s\\-\\'\\.\\,]+[A-Za-zÀ-ÿ0-9])(\\s[0-9]{5}\\s[A-Za-zÀ-ÿ\\s\\-]+)?$"));
        map.put("CodePostal", new CustomViewLabel("^\\d{5}$"));
        map.put("Téléphone", new CustomViewLabel("^(?:0[1-9]|\\+33[1-9])(?:[\\s.-]?\\d{2}){4}$"));
        map.put("Email", new CustomViewLabel("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        map.put("Numéro de Sécurité Sociale", new CustomViewLabel("^\\d{9}$"));
        map.put("Mutuelle", creerPanelAffichagePartiel(AFFICHAGES.MUTUELLE));
        map.put("Médecin référent", creerPanelAffichagePartiel(AFFICHAGES.MEDECIN));
        map.put("Spécialistes", creerPanelAffichagePartiel(AFFICHAGES.SPECIALISTE));
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Creer un panneau pour afficher partiellement un modèle.
     * @return (JPanel)
     */
    private static JPanel creerPanelAffichagePartiel(AFFICHAGES affichage) {
        JPanel label = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label.setBackground(Color.WHITE);
        JButton o = creerBoutonAfficher();
        label.add(o);
        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (affichage) {
                    case MUTUELLE -> afficherMutuelleSelection(client);
                    case MEDECIN -> afficherMedecinSelection(client);
                    case SPECIALISTE -> afficherSpecialisteSelection(client);

                }

            }
        });
        return label;
    }
    private static void afficherMutuelleSelection(Client medecin) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JComboBox<Mutuelle> comboBox = new JComboBox<>();
        for (Mutuelle mutuelle : DataSource.MUTUELLES) {
            comboBox.addItem(mutuelle);
        }
        panel.add(comboBox);
        JButton validateButton = new JButton("Changer");
        panel.add(validateButton);

        Mutuelle mutuelle = medecin.getMutuelle();
        String name = (mutuelle == null) ? "Aucune mutuelle" : mutuelle.toString();
        JLabel selectedSpecialitesLabel = new JLabel("Mutuelle du client : " + name);
        panel.add(selectedSpecialitesLabel);

        // Ajouter un action listener au bouton
        validateButton.addActionListener(e -> {
            // Récupérer la spécialité sélectionnée
            Mutuelle mutuel = (Mutuelle) comboBox.getSelectedItem();
            client.setMutuelle(mutuel);
            selectedSpecialitesLabel.setText("Mutuelle du client : " + mutuel.toString());
        });

        // Afficher le JOptionPane avec la combo box, le bouton et le label
        JOptionPane.showConfirmDialog(
                null,
                panel,
                "Sélectionnez les spécialités",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
    }
    private static void afficherMedecinSelection(Client medecin) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JComboBox<Medecin> comboBox = new JComboBox<>();
        for (Medecin mutuelle : DataSource.filtrerMedecinsGeneralistes()) {
            comboBox.addItem(mutuelle);
        }
        panel.add(comboBox);
        JButton validateButton = new JButton("Changer");
        panel.add(validateButton);

        Medecin mutuelle = medecin.getReferent();
        String name = (mutuelle == null) ? "Aucune référent" : mutuelle.toString();
        JLabel selectedSpecialitesLabel = new JLabel("Médecin du client : " + name);
        panel.add(selectedSpecialitesLabel);

        // Ajouter un action listener au bouton
        validateButton.addActionListener(e -> {
            // Récupérer la spécialité sélectionnée
            Medecin mutuel = (Medecin) comboBox.getSelectedItem();
            client.setReferent(mutuel);
            selectedSpecialitesLabel.setText("Médecin du client : " + mutuel.toString());
        });

        // Afficher le JOptionPane avec la combo box, le bouton et le label
        JOptionPane.showConfirmDialog(
                null,
                panel,
                "Sélectionnez les spécialités",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
    }

    private static void afficherSpecialisteSelection(Client client) {
        // Création du panneau principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Création de la combo box pour sélectionner les médecins
        JComboBox<Medecin> comboBox = new JComboBox<>();
        for (Medecin medecin : DataSource.MEDECINS) {
            comboBox.addItem(medecin);
        }
        panel.add(comboBox);

        // Création du modèle de données pour la JTable
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Spécialistes", "Spécialités"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Boutons pour ajouter et retirer des spécialistes
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Retirer");
        panel.add(addButton);
        panel.add(removeButton);


        // Initialiser la JTable avec les spécialistes actuels du client
        tableModel.setRowCount(0); // Effacer les lignes existantes
        for (Medecin spec : client.getSpecialiste()) {
            tableModel.addRow(new Object[]{spec, spec.getSpecialites().toString()});
        }

        // Ajouter un action listener au bouton d'ajout
        addButton.addActionListener(e -> {
            // Récupérer le spécialiste sélectionné
            Medecin selectedMedecin = (Medecin) comboBox.getSelectedItem();
            if (selectedMedecin != null && !client.getSpecialiste().contains(selectedMedecin)) {
                client.addSpecialiste(selectedMedecin);
                tableModel.setRowCount(0); // Effacer les lignes existantes
                for (Medecin spec : client.getSpecialiste()) {
                    tableModel.addRow(new Object[]{spec, spec.getSpecialites().toString()});
                }
            }
        });

        // Ajouter un action listener au bouton de retrait
        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                Medecin selectedMedecin = (Medecin) tableModel.getValueAt(selectedRow, 0);
                client.removeSpecialiste(selectedMedecin);
                tableModel.setRowCount(0); // Effacer les lignes existantes
                for (Medecin spec : client.getSpecialiste()) {
                    tableModel.addRow(new Object[]{spec, spec.getSpecialites().toString()});
                }
            }
        });

        // Afficher le JOptionPane avec la combo box, les boutons, et la JTable
        JOptionPane.showConfirmDialog(
                null,
                panel,
                "Sélectionnez et gérez les spécialistes",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (Map<String, JComponent> )
     */
    public static Map<String, JComponent> getMap() {
        return map;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Setter
     * @param client
     */
    public void setClient(Client client) {
        if (client != null) {
            this.client = client;
            ((CustomViewLabel)ClientView.map.get("Nom")).setText(client.getNom());
            ((CustomViewLabel)ClientView.map.get("Prenom")).setText(client.getPrenom());
            ((CustomViewLabel)ClientView.map.get("Adresse")).setText(client.getAdresse());
            ((CustomViewLabel)ClientView.map.get("CodePostal")).setText(client.getCodePostal());
            ((CustomViewLabel)ClientView.map.get("Téléphone")).setText(client.getTelephone());
            ((CustomViewLabel)ClientView.map.get("Email")).setText(client.getEmail());
            ((CustomViewLabel)ClientView.map.get("Numéro de Sécurité Sociale")).setText(Integer.toString(client.getNumeroSecuriteSociale()));
        }
        else {
            this.client = null;
            ((CustomViewLabel)ClientView.map.get("Nom")).setText("");
            ((CustomViewLabel)ClientView.map.get("Prenom")).setText("");
            ((CustomViewLabel)ClientView.map.get("Adresse")).setText("");
            ((CustomViewLabel)ClientView.map.get("CodePostal")).setText("");
            ((CustomViewLabel)ClientView.map.get("Téléphone")).setText("");
            ((CustomViewLabel)ClientView.map.get("Email")).setText("");
            ((CustomViewLabel)ClientView.map.get("Numéro de Sécurité Sociale")).setText("");
        }
    }

    public Client getClient() {
        return client;
    }

    public void reverseClient() {
        client.setNom(((CustomViewLabel)ClientView.map.get("Nom")).getText());
        client.setPrenom(((CustomViewLabel)ClientView.map.get("Prenom")).getText());
    }
    private boolean editable = true;
    public boolean isEditable() {
        return editable;
    }
    public void setEdition() {
        editable = false;
        for (Map.Entry<String, JComponent> entry : map.entrySet()) {
            if (entry.getValue() instanceof CustomViewLabel) {
                CustomViewLabel value = (CustomViewLabel) entry.getValue();
                value.setModifiable(true);
            }
        }
    }

    public void saveEdition() {
    }
    // </editor-fold>
    //****************************************************************************************************************//
    
}