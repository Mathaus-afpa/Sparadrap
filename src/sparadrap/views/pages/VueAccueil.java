package sparadrap.views.pages;
import sparadrap.composants.CustomBouton;
import sparadrap.models.enums.PAGES;
import sparadrap.views.VueApplication;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * [VueAccueil] - class
 * @author Mathaus
 */
public class VueAccueil extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    private VueAccueil() {
        if (VueAccueil.SingletonVueAccueil.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
        configurerVueAccueil();
        VueApplication.ajouterAuPanneauParent(this);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Classes interne">
    /**
     * Classe porteuse du Singleton.
     */
    private static class SingletonVueAccueil {
        private static final VueAccueil INSTANCE = new VueAccueil();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Recupere l'instance unique du Singleton.
     * @return (JPanel)
     */
    public static JPanel getInstance() {
        return VueAccueil.SingletonVueAccueil.INSTANCE;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le JPanel
     */
    private void configurerVueAccueil() {
        this.setBackground(new Color(255, 174, 201)); // Couleur du fond de l'image.
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(creerPanneauGauche());
        this.add(creerPanneauDroit());
    }
    /**
     * Creer le panneau de gauche avec le logo en fond.
     * @return (JPanel)
     */
    private JPanel creerPanneauGauche() {
        JPanel panneauGauche = new JPanel() {
            private BufferedImage backgroundImage;
            {
                try {
                    backgroundImage = ImageIO.read(getClass().getResource("/sparadrap/ressources/AccueilBG.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Surcharger la méthode paintComponent pour dessiner l'image de fond.
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    int width = getWidth();
                    int height = getHeight();
                    g.drawImage(backgroundImage, 0, 0, width, height, this);
                }
            }
        };
        // Fixer taille du panel à la taille de l'image.
        panneauGauche.setMinimumSize(new Dimension(487, 590));
        panneauGauche.setPreferredSize(new Dimension(487, 590));
        panneauGauche.setMaximumSize(new Dimension(487, 590));
        return panneauGauche;
    }
    /***
     * Creer le panneau de droite avec les boutons.
     * @return (JPanel)
     */
    private JPanel creerPanneauDroit() {
        JPanel panneauDroit = new JPanel();
        panneauDroit.setBackground(Color.BLACK); //permet d'ajuster le pixel de la bordure.
        panneauDroit.setLayout(new BoxLayout(panneauDroit, BoxLayout.Y_AXIS));
        panneauDroit.add(creerPanneauActions());
        panneauDroit.add(creerPanneauDonnees());
        return panneauDroit;
    }
    /**
     * Creer le panneau de droite du haut avec les boutons d'actions.
     * @return (JPanel)
     */
    private JPanel creerPanneauActions() {
        JPanel panneauActions = new JPanel();
        panneauActions.setLayout(new BorderLayout());
        panneauActions.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.BLACK));
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 157, 39));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(creerBoutons("ACHAT", PAGES.ACHATS));
        panel.add(creerBoutons("HISTORIQUE", PAGES.HISTORIQUES));
        panneauActions.add(panel);
        return panneauActions;
    }
    /**
     * Creer le panneau de droite du haut avec les boutons lies aux donnees.
     * @return (JPanel)
     */
    private JPanel creerPanneauDonnees() {
        JPanel panneauDonnees = new JPanel();
        panneauDonnees.setLayout(new BorderLayout());
        panneauDonnees.setBorder(BorderFactory.createMatteBorder(4, 4, 0, 0, Color.BLACK));
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 201, 39));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(creerBoutons("CLIENTS", PAGES.CLIENTS));
        panel.add(creerBoutons("MEDECINS", PAGES.MEDECINS));
        panneauDonnees.add(panel);
        return panneauDonnees;
    }
    /**
     * Creer un bouton dans un panneau.
     * @param text
     * @param page
     * @return (JPanel)
     */
    private JPanel creerBoutons(String text, PAGES page) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0,0));
        JButton button = new CustomBouton();
        Font font = new Font("Calibri", Font.BOLD, 40);
        button.setFont(font);
        button.setText(text);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        switch (text) {
            case "ACHAT":
                button.setBackground(new Color(63, 72, 204));
                break;
            case "HISTORIQUE":
                button.setBackground(new Color(0, 162, 232));
                break;
            case "CLIENTS":
                button.setBackground(new Color(153, 217, 234));
                break;
            case "MEDECINS":
                button.setBackground(new Color(112, 146, 190));
                break;
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page != null) {
                    ManagerDesPages managerDesPages = ManagerDesPages.getInstance();
                    managerDesPages.afficherPage(page);
                } else {
                    //todo: implementer pages
                    JOptionPane.showMessageDialog(null, "Unimplemented yet", "TODO:", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        panel.add(button);
        VueApplication.definirUneMiseEnPageSpring(panel, button, new int[]{20});
        return panel;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}