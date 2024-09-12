package sparadrap.views.subviews;
import sparadrap.composants.CustomViewLabel;
import sparadrap.models.ModeleApplication;
import sparadrap.models.submodels.Client;
import javax.swing.*;
import java.awt.*;
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
    private Client client;
    static {
        map.put("Nom", new CustomViewLabel());
        map.put("Prenom", new CustomViewLabel());
        map.put("Adresse", new CustomViewLabel());
        map.put("CodePostal", new CustomViewLabel());
        map.put("Téléphone", new CustomViewLabel());
        map.put("Email", new CustomViewLabel());
        map.put("Numéro de Sécurité Sociale", new CustomViewLabel());
        map.put("Mutuelle", creerPanelAffichagePartiel());
        map.put("Médecin référent", creerPanelAffichagePartiel());
        map.put("Spécialistes", creerPanelAffichagePartiel());
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
        label.add(creerBoutonAfficher());
        return label;
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
        this.client = client;
        ((CustomViewLabel)ClientView.map.get("Nom")).setText(client.getNom());
        ((CustomViewLabel)ClientView.map.get("Prenom")).setText(client.getPrenom());
        ((CustomViewLabel)ClientView.map.get("Adresse")).setText(client.getAdresse());
        ((CustomViewLabel)ClientView.map.get("CodePostal")).setText(client.getCodePostal());
        ((CustomViewLabel)ClientView.map.get("Téléphone")).setText(client.getTelephone());
        ((CustomViewLabel)ClientView.map.get("Email")).setText(client.getEmail());
        ((CustomViewLabel)ClientView.map.get("Numéro de Sécurité Sociale")).setText(Integer.toString(client.getNumeroSecuriteSociale()));
    }
    // </editor-fold>
    //****************************************************************************************************************//
}