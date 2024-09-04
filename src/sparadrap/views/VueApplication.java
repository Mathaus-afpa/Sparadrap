package sparadrap.views;
import sparadrap.models.ModeleApplication;
import sparadrap.views.pages.ManagerDesPages;
import javax.swing.*;
import java.awt.*;
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
    private static final JFrame fenetrePrincipale = new JFrame(ModeleApplication.APP_TITRE + " - " + ModeleApplication.APP_VERSION);
    private static final JLayeredPane calquePrincipal = fenetrePrincipale.getLayeredPane();
    private static JPanel panneauParent = null;
    private static ManagerDesPages managerDesPages;
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
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure la JFrame, puis creer les composants avec les donnees du MainModel.
     */
    private static void configurerPanneauParent() {
        Dimension frameSize = new Dimension(ModeleApplication.APP_MIN_WIDTH, ModeleApplication.APP_MIN_HEIGHT);
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
        panneauParent.setBackground(Color.WHITE);
        fenetrePrincipale.setContentPane(panneauParent);
        definirUneMiseEnPageSpring(calquePrincipal, panneauParent, new int[]{4});
        calquePrincipal.setLayer(panneauParent, JLayeredPane.DEFAULT_LAYER);
    }
    /**
     * Creation d'une marge via les contraintes du SpringLayout
     * @param parent avec un SpringLayout
     * @param enfant enfant à parametrer la marge
     * @param marges taille des marges
     */
    private static void definirUneMiseEnPageSpring(JComponent parent, JComponent enfant, int[] marges) {
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
     * Creer les JPanel correspondant au Background Rose et Bleu.
     */
    private static void creerArrierePlan() {
        JPanel arrirePlan = new JPanel();
        arrirePlan.setBackground(Color.BLACK);
        calquePrincipal.add(arrirePlan);
        definirUneMiseEnPageSpring(calquePrincipal, arrirePlan, null);
        calquePrincipal.setLayer(arrirePlan, Integer.MIN_VALUE);
    }

    public static void ajouterAuPanneauParent(JPanel panel) {
        panneauParent.add(panel);
        definirUneMiseEnPageSpring(panneauParent, panel, null);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}