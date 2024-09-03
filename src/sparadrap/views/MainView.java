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
    }
    /**
     * Affiche la fenetre principale.
     */
    private static void showMainFrame() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}