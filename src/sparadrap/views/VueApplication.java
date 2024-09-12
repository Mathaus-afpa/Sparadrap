package sparadrap.views;
import sparadrap.composants.CustomBouton;
import static sparadrap.models.ModeleApplication.*;
import sparadrap.models.ModeleApplication;
import sparadrap.models.enums.PAGES;
import sparadrap.views.pages.ManagerDesPages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * [VueApplication] - class
 * @author Mathaus
 */
public class VueApplication {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainView.
     */
    private VueApplication(){}
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private static final JFrame fenetrePrincipale = new JFrame(APP_TITRE + " - " + APP_VERSION);
    private static final JLayeredPane calquePrincipal = fenetrePrincipale.getLayeredPane();
    private static JPanel panneauParent = null;
    private static ManagerDesPages managerDesPages;
    private static final ImageIcon iconeBoutonAccueil = creerIconePourBoutonAccueil();
    private static final ImageIcon iconeBoutonSupprimer = creerIconePourBoutonSupprimer();
    private static final ImageIcon iconeBoutonAfficher = creerIconePourBoutonAfficher();
    private static final Color couleurPrincipale = APP_COULEUR_PRINCIPALE;
    private static final Color couleurTexte = APP_COULEUR_TEXTE;
    private static final int tailleBordureBouton = BTN_TAILLE_BORDURE;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Creer et affiche la fenetre principale.
     */
    public static final void afficher() {
        SwingUtilities.invokeLater(() -> {
            configurerPanneauParent();
            afficherFenetrePrincipale();
        });
    }
    /**
     * Permet d'ajouter un panneau au panneau parent.
     * @param panel
     */
    public static void ajouterAuPanneauParent(JPanel panel) {
        panneauParent.add(panel);
        definirUneMiseEnPageSpring(panneauParent, panel, null);
    }
    /**
     * Creation d'une marge via les contraintes du SpringLayout
     * @param parent avec un SpringLayout
     * @param enfant enfant à parametrer la marge
     * @param marges taille des marges
     */
    public static void definirUneMiseEnPageSpring(JComponent parent, JComponent enfant, int[] marges) {
        int northMargin = 0;
        int eastMargin = 0;
        int southMargin = 0;
        int westMargin = 0;
        //
        LayoutManager parentLayout = parent.getLayout();
        SpringLayout layout;
        if (!(parentLayout instanceof SpringLayout)) {
            layout = new SpringLayout();
            parent.setLayout(layout);
        } else {
            layout = (SpringLayout) parent.getLayout();
        }
        if (marges != null && marges.length > 0) {
            switch (marges.length) {
                case 1:
                    northMargin = eastMargin = southMargin = westMargin = Math.abs(marges[0]);
                    break;
                case 2:
                    northMargin = southMargin = Math.abs(marges[0]);
                    eastMargin = westMargin = Math.abs(marges[1]);
                    break;
                case 3: break; //do nothing
                default:
                    northMargin = Math.abs(marges[0]);
                    eastMargin = Math.abs(marges[1]);
                    southMargin = Math.abs(marges[2]);
                    westMargin = Math.abs(marges[3]);
                    break;
            }
        }
        layout.putConstraint(SpringLayout.NORTH, enfant, northMargin, SpringLayout.NORTH, parent);
        layout.putConstraint(SpringLayout.EAST, enfant, -eastMargin, SpringLayout.EAST, parent);
        layout.putConstraint(SpringLayout.SOUTH, enfant, -southMargin, SpringLayout.SOUTH, parent);
        layout.putConstraint(SpringLayout.WEST, enfant, westMargin, SpringLayout.WEST, parent);
    }
    /**
     * Creer le panneau du bouton d'accueil.
     * @return (JPanel)
     */
    public static JPanel ajouterPanneauAccueil() {
        JPanel colonneBoutonAccueil = new JPanel();
        JButton boutonAccueil = VueApplication.creerBoutonAccueil();
        Dimension dimensionPanel = new Dimension(174, ModeleApplication.BANDEAU_BAS_TAILLE);
        colonneBoutonAccueil.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        colonneBoutonAccueil.setMinimumSize(dimensionPanel);
        colonneBoutonAccueil.setPreferredSize(dimensionPanel);
        colonneBoutonAccueil.setMaximumSize(dimensionPanel);
        colonneBoutonAccueil.add(boutonAccueil);
        VueApplication.definirUneMiseEnPageSpring(colonneBoutonAccueil, boutonAccueil, new int[] {3});
        return colonneBoutonAccueil;
    }
    /**
     * Creer un bouton avec image pour revenir a la page d'accueil.
     * @return (JButton)
     */
    private static JButton creerBoutonAccueil() {
        // Créer le bouton avec l'image redimensionnée
        JButton imageButton = new JButton(iconeBoutonAccueil);
        Dimension imageDimension = new Dimension(BTN_ACCUEIL_WIDTH + 4, BTN_ACCUEIL_HEIGHT + 4);
        imageButton.setBorder(BorderFactory.createLineBorder(couleurPrincipale, tailleBordureBouton));
        imageButton.setMinimumSize(imageDimension);
        imageButton.setPreferredSize(imageDimension);
        imageButton.setMaximumSize(imageDimension);
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerDesPages.afficherPage(PAGES.ACCUEIL);
            }
        });
        return imageButton;
    }
    /**
     * Creer un bouton avec image pour supprimer.
     * @return (JButton)
     */
    public static JButton creerBoutonSupprimer() {
        // Créer le bouton avec l'image redimensionnée
        JButton imageButton = new JButton(iconeBoutonSupprimer);
        imageButton.setBackground(new Color(255, 85, 85));
        Dimension imageDimension = new Dimension(BTN_SUPPRIMER_WIDTH + 6, BTN_SUPPRIMER_HEIGHT + 10);
        imageButton.setBorder(BorderFactory.createLineBorder(couleurTexte, tailleBordureBouton));
        imageButton.setMinimumSize(imageDimension);
        imageButton.setPreferredSize(imageDimension);
        imageButton.setMaximumSize(imageDimension);
        imageButton.setFocusPainted(false);
        return imageButton;
    }
    /**
     * Creer un bouton pour ajouter.
     * @return (JButton)
     */
    public static JButton creerBoutonAjouter() {
        Font font = new Font(APP_FONT, Font.PLAIN, BTN_AJOUT_FONTSIZE);
        CustomBouton imageButton = new CustomBouton();
        imageButton.setText("+");
        imageButton.setFont(font);
        imageButton.setBackground(couleurPrincipale);
        Dimension imageDimension = new Dimension(BTN_AJOUT_DIMENSIONS, BTN_AJOUT_DIMENSIONS);
        imageButton.setBorder(BorderFactory.createLineBorder(couleurTexte, tailleBordureBouton));
        imageButton.setMinimumSize(imageDimension);
        imageButton.setPreferredSize(imageDimension);
        imageButton.setMaximumSize(imageDimension);
        return imageButton;
    }
    /**
     * Creer un bouton pour modifier.
     * @return (JButton)
     */
    public static JButton creerBoutonTexte(String texte) {
        // Créer le bouton avec l'image redimensionnée
        Font font = new Font(APP_FONT, Font.BOLD, 26);
        CustomBouton imageButton = new CustomBouton();
        imageButton.setText(texte);
        imageButton.setFont(font);
        imageButton.setBackground(couleurPrincipale);
        imageButton.setBorder(BorderFactory.createLineBorder(couleurTexte, tailleBordureBouton));
        return imageButton;
    }
    /**
     * Creer un bouton avec image pour afficher.
     * @return (JButton)
     */
    public static JButton creerBoutonAfficher() {
        // Créer le bouton avec l'image redimensionnée
        JButton imageButton = new JButton(iconeBoutonAfficher);
        imageButton.setBackground(couleurPrincipale);
        Dimension imageDimension = new Dimension(BTN_AFFICHER_WIDTH * 2, BTN_AFFICHER_HEIGHT + 4);
        imageButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        imageButton.setMinimumSize(imageDimension);
        imageButton.setPreferredSize(imageDimension);
        imageButton.setMaximumSize(imageDimension);
        imageButton.setFocusPainted(false);
        return imageButton;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure la JFrame, puis creer les composants avec les donnees du MainModel.
     */
    private static void configurerPanneauParent() {
        Dimension frameSize = new Dimension(APP_MIN_WIDTH, APP_MIN_HEIGHT);
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.setSize(frameSize);
        fenetrePrincipale.setMinimumSize(frameSize);
        fenetrePrincipale.setLocationRelativeTo(null);
        creerPanneauParent();
        creerArrierePlan();
        managerDesPages = ManagerDesPages.getInstance();
    }
    /**
     * Affiche la fenetre principale.
     */
    private static void afficherFenetrePrincipale() {
        fenetrePrincipale.pack();
        fenetrePrincipale.setVisible(true);
    }
    /**
     * Creation du JPanel mainBody avec son titre et son classeur de contenu.
     * Ajoute body au contentPane de la JFrame.
     */
    private static void creerPanneauParent() {
        panneauParent = new JPanel();
        panneauParent.setBackground(couleurPrincipale);
        fenetrePrincipale.setContentPane(panneauParent);
        definirUneMiseEnPageSpring(calquePrincipal, panneauParent, new int[]{4});
        calquePrincipal.setLayer(panneauParent, JLayeredPane.DEFAULT_LAYER);
    }
    /**
     * Creer les JPanel correspondant au Background Rose et Bleu.
     */
    private static void creerArrierePlan() {
        JPanel arrirePlan = new JPanel();
        arrirePlan.setBackground(couleurTexte);
        calquePrincipal.add(arrirePlan);
        definirUneMiseEnPageSpring(calquePrincipal, arrirePlan, null);
        calquePrincipal.setLayer(arrirePlan, Integer.MIN_VALUE);
    }
    /**
     * Recreer l'image du bouton accueil dans une taille coherente.
     * @return (ImageIcon)
     */
    private static ImageIcon creerIconePourBoutonAccueil() {
        ImageIcon iconeDepuisImage = new ImageIcon(VueApplication.class.getResource("/sparadrap/ressources/AccueilBouton.png"));
        Image imageTailleReelle = iconeDepuisImage.getImage();
        Image fixerDimensionsImage = imageTailleReelle.getScaledInstance(BTN_ACCUEIL_WIDTH, BTN_ACCUEIL_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon iconeRedimensionnee = new ImageIcon(fixerDimensionsImage);
        return iconeRedimensionnee;
    }
    /**
     * Recreer l'image du bouton supprimer dans une taille coherente.
     * @return (ImageIcon)
     */
    private static ImageIcon creerIconePourBoutonSupprimer() {
        ImageIcon iconeDepuisImage = new ImageIcon(VueApplication.class.getResource("/sparadrap/ressources/DeleteBouton.png"));
        Image imageTailleReelle = iconeDepuisImage.getImage();
        Image fixerDimensionsImage = imageTailleReelle.getScaledInstance(BTN_SUPPRIMER_WIDTH, BTN_SUPPRIMER_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon iconeRedimensionnee = new ImageIcon(fixerDimensionsImage);
        return iconeRedimensionnee;
    }
    /**
     * Recreer l'image du bouton afficher dans une taille coherente.
     * @return (ImageIcon)
     */
    private static ImageIcon creerIconePourBoutonAfficher() {
        ImageIcon iconeDepuisImage = new ImageIcon(VueApplication.class.getResource("/sparadrap/ressources/AfficherBouton.png"));
        Image imageTailleReelle = iconeDepuisImage.getImage();
        Image fixerDimensionsImage = imageTailleReelle.getScaledInstance(BTN_AFFICHER_WIDTH, BTN_AFFICHER_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon iconeRedimensionnee = new ImageIcon(fixerDimensionsImage);
        return iconeRedimensionnee;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Getter
     * @return (JFrame)
     */
    public static JFrame getFrame() {
        return fenetrePrincipale;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}