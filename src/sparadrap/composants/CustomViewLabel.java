package sparadrap.composants;
import javax.swing.*;
import java.awt.*;
import static sparadrap.models.ModeleApplication.APP_FONT;
/**
 * [CustomViewLabel] - class
 * @author Mathaus
 */
public class CustomViewLabel extends JLabel {
    {
        Font font = new Font(APP_FONT, Font.BOLD, 20);
        setFont(font);
    }
    public CustomViewLabel() {
        super();
    }
    public CustomViewLabel(String texte) {
        super(texte);
    }
}