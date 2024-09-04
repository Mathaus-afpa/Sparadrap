package sparadrap.controllers;
import sparadrap.views.AppView;
/**
 * [AppController] - class
 * @author Mathaus
 */
public class AppController {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainController.
     */
    private AppController(){}
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Affiche la vue.
     */
    public static final void demarrer() {
        AppView.afficher();
    }
    // </editor-fold>
    //****************************************************************************************************************//
}