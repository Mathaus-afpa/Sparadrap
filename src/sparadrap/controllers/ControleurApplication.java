package sparadrap.controllers;
import sparadrap.views.VueApplication;
/**
 * [ControleurApplication] - class
 * @author Mathaus
 */
public class ControleurApplication {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique MainController.
     */
    private ControleurApplication(){}
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Affiche la vue.
     */
    public static final void demarrer() {
        VueApplication.afficher();
    }
    // </editor-fold>
    //****************************************************************************************************************//
}