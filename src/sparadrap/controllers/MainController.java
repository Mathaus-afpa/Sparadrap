package sparadrap.controllers;
import sparadrap.views.MainView;
/**
 * [MainController] - class
 * @author Mathaus
 */
public class MainController {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainController.
     */
    private MainController(){}
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Affiche la vue.
     */
    public static final void start() {
        MainView.show();
    }
    // </editor-fold>
    //****************************************************************************************************************//
}