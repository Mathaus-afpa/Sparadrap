package sparadrap.composants;
import sparadrap.models.enums.MISEAJOUR;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.regex.Pattern;
import static sparadrap.models.ModeleApplication.APP_FONT;
/**
 * [CustomViewLabel] - class
 * @author Mathaus
 */
public class CustomViewLabel extends JTextField {
    private MISEAJOUR etat = MISEAJOUR.AUCUNE;
    private String regex = ".*";
    Pattern pattern = Pattern.compile(regex);
    private String lastSave = null;
    private boolean isModifiable = false;
    {
        Font font = new Font(APP_FONT, Font.BOLD, 20);
        setFont(font);
        setEditable(false);
        setBorder(null);
        setOpaque(false);
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                callto();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                callto();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("change");
            }
        });
    }
    public CustomViewLabel() {
        super();
    }
    public CustomViewLabel(String regex) {
        super();
        this.regex = regex;
        this.regex = regex;
        pattern = Pattern.compile(regex);
    }
@Override public void setText(String text) {
        super.setText(text);
}
private void callto() {
    String text = getText();
    if (text.equals(lastSave)) etat = MISEAJOUR.AUCUNE;
    else {
        if (pattern.matcher(text).matches()) {
            etat = MISEAJOUR.VALIDE;
        } else {
            etat = MISEAJOUR.INVALIDE;
        }
    }
    switch (etat) {
        case AUCUNE:
            setBackground(Color.cyan);
            break;
        case VALIDE:
            setBackground(Color.green);
            break;
        case INVALIDE:
            setBackground(Color.red);
            break;
    }
}
    public void setModifiable(boolean ouiNon) {
        isModifiable = ouiNon;
        if (isModifiable) {
            lastSave = getText();
            etat = MISEAJOUR.AUCUNE;
            setBackground(Color.cyan);
            setEditable(true);
            setBorder(BorderFactory.createLineBorder(Color.black));
            setOpaque(true);
        } else {
            this.setBackground(Color.white);
            setEditable(false);
            setBorder(null);
            setOpaque(false);
        }
    }

    public MISEAJOUR getEtat() {
        return etat;
    }
}