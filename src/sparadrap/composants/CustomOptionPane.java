package sparadrap.composants;

import sparadrap.models.submodels.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomOptionPane extends JOptionPane {

    private boolean isValid;
    JButton validateButton = new JButton("Valider");
    public void setValidateListener(ActionListener validateListener) {
        validateButton.addActionListener(validateListener);
    }

    ActionListener validateListener = null;
    public CustomOptionPane(JPanel panel) {
        // Appel au constructeur de JOptionPane avec le panel
        super(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        //this.customPanel = panel; // Stocker le panel
        isValid = false; // Initialement, le bouton "Valider" n'a pas été cliqué
    }

    public void showCustomDialog(String title) {
        // Créer un JDialog personnalisé
        JDialog dialog = this.createDialog(title);

        // Créer les boutons personnalisés

        JButton cancelButton = new JButton("Annuler");


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel(); // Action lors du clic sur "Annuler"
                dialog.dispose(); // Fermer la boîte de dialogue
            }
        });

        // Ajouter les boutons au JOptionPane
        this.setOptions(new Object[] {validateButton, cancelButton});

        // Afficher la boîte de dialogue
        dialog.setVisible(true);
    }

    public JButton validerButto(){
        return validateButton;
    }
    // Méthode à surcharger pour la logique de validation
    protected void onValidate() {
        // Retourne true si la validation est réussie, false sinon
        // Ici, vous pouvez ajouter votre logique de validation
        System.out.println("Valider cliqué.");
    }

    // Méthode à surcharger pour gérer l'action d'annulation
    protected void onCancel() {
        System.out.println("Annuler cliqué.");
    }

}