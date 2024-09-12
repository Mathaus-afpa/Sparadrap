package sparadrap.composants;
import javax.swing.*;
import java.awt.*;
/**
 * [CustomLabel] - class
 * @author Mathaus
 */
public class CustomLabel extends JLabel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public CustomLabel() {
        super();
        setText(null);  // Désactive le rendu par défaut du texte
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private String texte = "";
    private int horizontalAlignment = 0;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Implements">
    @Override
    public void setText(String texte) {
        this.texte = texte;
        revalidate();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setColor(getForeground());
        FontMetrics fm = g2d.getFontMetrics();
        if (this.texte != null && !this.texte.isEmpty()) {
            int textWidth = fm.stringWidth(this.texte);
            int textHeight = fm.getAscent();
            int x;
            if (horizontalAlignment == 0) {
                x = (getWidth() - textWidth) / 2 - 20;
            } else {
                if (horizontalAlignment > 0) {
                    x = horizontalAlignment;
                } else {
                    x = getWidth() - textWidth + horizontalAlignment;
                }
            }
            int y = (getHeight() + textHeight) / 2 ;
            g2d.drawString(this.texte, x, y);
        }
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Defini une marge.
     * Si negative depuis la droite, sinon a gauche.
     * @param horizontalAlignment
     */
    public void setHorizontalAlignment(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }
    // </editor-fold>
    //****************************************************************************************************************//
}