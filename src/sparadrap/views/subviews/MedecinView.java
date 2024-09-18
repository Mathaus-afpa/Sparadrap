package sparadrap.views.subviews;
import sparadrap.composants.CustomViewLabel;
import sparadrap.models.ModeleApplication;
import sparadrap.models.enums.MISEAJOUR;
import sparadrap.models.enums.medecine.SPECIALITES;
import sparadrap.models.submodels.Medecin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import static sparadrap.models.ModeleApplication.APP_FONT;
import static sparadrap.views.VueApplication.creerBoutonAfficher;
public class MedecinView extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public MedecinView() {
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
        for (Map.Entry<String, JComponent> entry : MedecinView.getMap().entrySet()) {
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
    private static Medecin medecin;
    static {
        map.put("Nom", new CustomViewLabel("^[A-Z][a-zA-Z-'À-ÿ]+(?: [A-Z][a-zA-Z-'À-ÿ]+)*$"));
        map.put("Prenom", new CustomViewLabel("^[A-Z][a-zA-Z-'À-ÿ]+(?: [A-Z][a-zA-Z-'À-ÿ]+)*$"));
        map.put("Adresse", new CustomViewLabel("^(\\d{1,5}\\s[A-Za-zÀ-ÿ0-9\\s\\-\\'\\.\\,]+[A-Za-zÀ-ÿ0-9])(\\s[0-9]{5}\\s[A-Za-zÀ-ÿ\\s\\-]+)?$"));
        map.put("CodePostal", new CustomViewLabel("^\\d{5}$"));
        map.put("Téléphone", new CustomViewLabel("^(?:0[1-9]|\\+33[1-9])(?:[\\s.-]?\\d{2}){4}$"));
        map.put("Email", new CustomViewLabel("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        map.put("Numéro d'Agrément", new CustomViewLabel("^\\d{9}$"));
        map.put("Spécialistés", creerPanelAffichagePartiel());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Creer un panneau pour afficher partiellement un modèle.
     * @return (JPanel)
     */
    private static JPanel creerPanelAffichagePartiel() {
        JPanel label = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label.setBackground(Color.WHITE);
        JButton o = creerBoutonAfficher();
        label.add(o);
        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherSpecialiteSelection(medecin);
            }
        });
        return label;
    }
    private static void afficherSpecialiteSelection(Medecin medecin) {
        // Créer un JPanel pour contenir les cases à cocher
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Créer les cases à cocher pour chaque spécialité
        JCheckBox[] checkBoxes = new JCheckBox[SPECIALITES.values().length];
        for (int i = 0; i < SPECIALITES.values().length; i++) {
            checkBoxes[i] = new JCheckBox(SPECIALITES.values()[i].name());
            if (medecin.getSpecialites().contains(SPECIALITES.values()[i])) {
                checkBoxes[i].setSelected(true);
            }
            panel.add(checkBoxes[i]);
        }

        // Afficher le JOptionPane avec les cases à cocher
        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Sélectionnez les spécialités",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        // Vérifier si l'utilisateur a appuyé sur OK
        if (result == JOptionPane.OK_OPTION) {
            // Parcourir les cases à cocher et afficher les spécialités sélectionnées
            StringBuilder selectedSpecialites = new StringBuilder("Spécialités sélectionnées : ");
            for (JCheckBox checkBox : checkBoxes) {
                SPECIALITES spe = SPECIALITES.valueOf(checkBox.getText());
                if (checkBox.isSelected()) {
                    selectedSpecialites.append(checkBox.getText()).append(", ");
                    medecin.addSpecialite(spe);
                } else {
                    medecin.removeSpecialite(spe);
                }
            }

            // Afficher les spécialités sélectionnées
            JOptionPane.showMessageDialog(null, selectedSpecialites.toString());
        }
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
     * @param medecin
     */
    public void setMedecin(Medecin medecin) {
        if (medecin != null) {
            this.medecin = medecin;
            ((CustomViewLabel)MedecinView.map.get("Nom")).setText(medecin.getNom());
            ((CustomViewLabel)MedecinView.map.get("Prenom")).setText(medecin.getPrenom());
            ((CustomViewLabel)MedecinView.map.get("Adresse")).setText(medecin.getAdresse());
            ((CustomViewLabel)MedecinView.map.get("CodePostal")).setText(medecin.getCodePostal());
            ((CustomViewLabel)MedecinView.map.get("Téléphone")).setText(medecin.getTelephone());
            ((CustomViewLabel)MedecinView.map.get("Email")).setText(medecin.getEmail());
            ((CustomViewLabel)MedecinView.map.get("Numéro d'Agrément")).setText(Integer.toString(medecin.getAgreement()));
        }
        else {
            this.medecin = null;
            ((CustomViewLabel)MedecinView.map.get("Nom")).setText("");
            ((CustomViewLabel)MedecinView.map.get("Prenom")).setText("");
            ((CustomViewLabel)MedecinView.map.get("Adresse")).setText("");
            ((CustomViewLabel)MedecinView.map.get("CodePostal")).setText("");
            ((CustomViewLabel)MedecinView.map.get("Téléphone")).setText("");
            ((CustomViewLabel)MedecinView.map.get("Email")).setText("");
            ((CustomViewLabel)MedecinView.map.get("Numéro d'Agrément")).setText("");
        }
    }

    public Medecin getMedecin() {
        return medecin;
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

    public void saveEidtion() {
        boolean continuez = true;
        for (Map.Entry<String, JComponent> entry : map.entrySet()) {
            if (entry.getValue() instanceof CustomViewLabel) {
                CustomViewLabel value = (CustomViewLabel) entry.getValue();
                if (value.getEtat() == MISEAJOUR.INVALIDE) {
                    continuez = false;
                    break;
                }
            }
        }
        if (continuez) {
            for (Map.Entry<String, JComponent> entry : map.entrySet()) {
                if (entry.getValue() instanceof CustomViewLabel) {
                    CustomViewLabel value = (CustomViewLabel) entry.getValue();
                    value.setModifiable(false);
                }
            }
            editable = true;
        }
    }
    // </editor-fold>
    //****************************************************************************************************************//
}