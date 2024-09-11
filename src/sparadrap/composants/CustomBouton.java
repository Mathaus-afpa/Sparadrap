package sparadrap.composants;
import javax.swing.*;
import java.awt.*;
/**
 * [CustomBouton] - class
 * @author Mathaus
 */
public class CustomBouton extends JButton {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public CustomBouton(String texte) {
        super(texte);
        this.texte = texte;
        setFocusPainted(false);
        setText(null);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private String texte;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Implements">
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Active l'anti-aliasing pour un meilleur rendu du texte
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // Définir la couleur du texte
        g2d.setColor(getForeground());
        // Récupérer les informations de la police et de la taille du texte
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(texte);
        int textHeight = fm.getAscent();  // Utilise l'ascent pour une meilleure position verticale
        // Calculer la position pour centrer le texte verticalement et horizontalement
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - 4;  // Ajuste cette valeur pour descendre ou monter le texte
        // Dessiner le texte à la position calculée
        g2d.drawString(texte, x, y);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}