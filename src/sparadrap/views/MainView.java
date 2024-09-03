package sparadrap.views;
import sparadrap.models.MainModel;
import javax.swing.*;
import java.awt.*;
/**
 * [MainView] - class
 * @author Mathaus
 */
public class MainView {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainView.
     */
    private MainView(){}
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private static final JFrame mainFrame = new JFrame(MainModel.APP_TITLE + " - " + MainModel.APP_VERSION);
    private static final JLayeredPane mainLayers = mainFrame.getLayeredPane();
    private static JPanel mainBody = null;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Creer et affiche la fenetre principale.
     */
    public static final void show() {
        SwingUtilities.invokeLater(() -> {
            configMainContentPane();
            showMainFrame();
        });
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure la JFrame, puis creer les composants avec les donnees du MainModel.
     */
    private static void configMainContentPane() {
        Dimension frameSize = new Dimension(MainModel.APP_MIN_WIDTH, MainModel.APP_MIN_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(frameSize);
        mainFrame.setMinimumSize(frameSize);
        mainFrame.setLocationRelativeTo(null);
        createBody();
        createBackGround();
    }
    /**
     * Affiche la fenetre principale.
     */
    private static void showMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    /**
     * Creation du JPanel mainBody avec son titre et son classeur de contenu.
     * Ajoute body au contentPane de la JFrame.
     */
    private static void createBody() {
        mainBody = new JPanel();
        mainBody.setBackground(Color.WHITE);
        mainFrame.setContentPane(mainBody);
        setSpringLayout(mainLayers, mainBody, new int[]{4});
        mainLayers.setLayer(mainBody, JLayeredPane.DEFAULT_LAYER);
    }
    /**
     * Creation d'une marge via les contraintes du SpringLayout
     * @param parent avec un SpringLayout
     * @param child enfant à parametrer la marge
     * @param margin taille des marges
     */
    private static void setSpringLayout(JComponent parent, JComponent child, int[] margin) {
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
        if (margin != null && margin.length > 0) {
            switch (margin.length) {
                case 1:
                    northMargin = eastMargin = southMargin = westMargin = Math.abs(margin[0]);
                    break;
                case 2:
                    northMargin = southMargin = Math.abs(margin[0]);
                    eastMargin = westMargin = Math.abs(margin[1]);
                    break;
                case 3: break; //do nothing
                default:
                    northMargin = Math.abs(margin[0]);
                    eastMargin = Math.abs(margin[1]);
                    southMargin = Math.abs(margin[2]);
                    westMargin = Math.abs(margin[3]);
                    break;
            }
        }
        layout.putConstraint(SpringLayout.NORTH, child, northMargin, SpringLayout.NORTH, parent);
        layout.putConstraint(SpringLayout.EAST, child, -eastMargin, SpringLayout.EAST, parent);
        layout.putConstraint(SpringLayout.SOUTH, child, -southMargin, SpringLayout.SOUTH, parent);
        layout.putConstraint(SpringLayout.WEST, child, westMargin, SpringLayout.WEST, parent);
    }
    /**
     * Creer les JPanel correspondant au Background Rose et Bleu.
     */
    private static void createBackGround() {
        JPanel background = new JPanel();
        //background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        background.setBackground(Color.BLACK);
        mainLayers.add(background);
        setSpringLayout(mainLayers, background, null);
        mainLayers.setLayer(background, Integer.MIN_VALUE);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}