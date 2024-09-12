package sparadrap.composants;
import sparadrap.models.ModeleApplication;
import sparadrap.views.VueApplication;
import javax.swing.*;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * [CustomComboBox] - class
 * @author Mathaus
 */
public class CustomComboBox<E> extends JPanel {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public CustomComboBox(E[] items) {
        this.items = items;
        this.selectedItem = null;
        creerMenuCollection();
        this.setLayout(new BorderLayout());
        this.add(bouton, BorderLayout.CENTER);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    private JButton bouton = new JButton("▼   ");
    private JComboBox comboBox = new JComboBox();
    private JComponent popupMenu = (JComponent) comboBox.getUI().getAccessibleChild(comboBox, 0);
    private CustomLabel label = new CustomLabel();
    private E[] items;
    private E selectedItem;
    private PropertyChangeSupport support;
    {
        personnaliserBouton();
        personnaliserLabel();
        bouton.add(label);
        comboBox.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                setSelectedItem((E)comboBox.getSelectedItem());
                if (popupMenu != null) {
                    popupMenu.setVisible(false);
                }
            }
        });
        JScrollPane popup = (JScrollPane) popupMenu.getUI().getAccessibleChild(popupMenu, 0);
        popup.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.support = new PropertyChangeSupport(this);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PUBLIC">
    /**
     * Change la collection d'items.
     * @param newItems
     */
    public void updateItems(E[] newItems) {
        this.items = newItems;
        creerMenuCollection();
    }
    /**
     * Permet d'ajouter un observateur.
     * @param pcl  the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
    /**
     * Permet de supprimer un observateur
     * @param pcl the PropertyChangeListener to be removed
     *
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Configure le bouton.
     */
    private void personnaliserBouton() {
        VueApplication.definirUneMiseEnPageSpring(bouton, label, new int[] {0, 24, 0, 26});
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherMenu();
            }
        });
        bouton.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                if (bouton.isShowing() && popupMenu != null) {
                    popupMenu.setVisible(false);
                }
            }
        });
        bouton.setBorder(BorderFactory.createLineBorder(ModeleApplication.APP_COULEUR_TEXTE, ModeleApplication.BTN_TAILLE_BORDURE_FINE));
        bouton.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
        bouton.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    /**
     * Configure le label.
     */
    private void personnaliserLabel() {
        Font font = new Font(ModeleApplication.APP_FONT, Font.BOLD, 20);
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 0, ModeleApplication.BTN_TAILLE_BORDURE_FINE, ModeleApplication.APP_COULEUR_TEXTE));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.LEFT);
    }
    /**
     * Affiche la selection de la combobox.
     */
    private void afficherMenu() {
        if (this.items != null) {
            Point location = bouton.getLocationOnScreen();
            popupMenu.setLocation(location.x, location.y + bouton.getHeight());
            JList<Object> list = ((ComboPopup) popupMenu).getList();
            list.setFixedCellWidth(bouton.getWidth() - 19);
            list.setBackground(ModeleApplication.APP_COULEUR_PRINCIPALE);
            popupMenu.setVisible(true);
        }
    }
    /**
     * Ajoute a la combobox les donnees.
     */
    private void creerMenuCollection() {
        comboBox.removeAll();
        for (E item : items) {
            comboBox.addItem(item);
        }
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public E getSelectedItem() {
        return selectedItem;
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setters">
    private void setSelectedItem(E item) {
        E oldSelectedItem = this.selectedItem;
        this.selectedItem = item;
        // Notifie les observateurs que selectedItem a changé
        support.firePropertyChange("selectedItem", oldSelectedItem, item);
        label.setText(item.toString());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}