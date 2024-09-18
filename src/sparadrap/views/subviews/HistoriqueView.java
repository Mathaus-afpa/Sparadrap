package sparadrap.views.subviews;
import sparadrap.composants.CustomOptionPane;
import sparadrap.composants.PanelCellRenderer;
import sparadrap.models.submodels.Achat;
import sparadrap.views.VueApplication;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import static sparadrap.mocks.DataSource.ACHATS;
import static sparadrap.views.VueApplication.creerBoutonAfficher;
public class HistoriqueView extends JPanel {

    private List<Achat> listeMedicaments;
    JButton button;
    DefaultTableModel tableModel;

    public float getTotal() {
        return total;
    }

    float total = 0f;
    public void setDate(Date date) {
        this.date = date;
    }

    Date date = new Date();

    public HistoriqueView() {
        filterDate();
        afficherListeMedicaments();
        refresh();
    }

    public void filterDate() {
        listeMedicaments = ACHATS.stream()
                .filter(achat -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(achat.getDateAchat());
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
                    Date achatDateStart = cal.getTime();

                    cal.setTime(date);
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
                    Date filterDateStart = cal.getTime();

                    // Comparer uniquement les dates sans les heures
                    return achatDateStart.equals(filterDateStart);
                })
                .collect(Collectors.toList());
    }

    public void refresh() {
        total = 0f;
        tableModel.setRowCount(0);
        for (Achat achat : listeMedicaments) {
            tableModel.addRow(new Object[]{ creerPanelAffichagePartiel(achat), achat.toString(), achat.calcul() });
            total += achat.calcul();
        }
    }
    private static JPanel creerPanelAffichagePartiel(Achat achat) {
        JPanel label = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label.setBackground(Color.WHITE);
        JButton o = creerBoutonAfficher();
        label.add(o);
        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(achat.getNumeroFacture());
                AchatView addclientView = new AchatView();
                //addclientView;
                CustomOptionPane customOptionPane = new CustomOptionPane(addclientView);
                customOptionPane.showCustomDialog("Titre Personnalisé");
            }
        });
        return label;
    }
    public static List<Date> getUniquePurchaseDates() {
        // Utiliser un HashSet pour stocker les dates uniques
        Set<Date> uniqueDates = new HashSet<>();
        for (Achat achat : ACHATS.toArray(new Achat[0])) {
            // Créer un Calendar pour comparer les dates (sans heure)
            Calendar cal = Calendar.getInstance();
            cal.setTime(achat.getDateAchat());
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date normalizedDate = cal.getTime();
            // Ajouter la date normalisée au Set
            uniqueDates.add(normalizedDate);
        }

        // Convertir le Set en Liste
        return uniqueDates.stream().sorted().collect(Collectors.toList());
    }
    private void afficherListeMedicaments() {
        String[] columnNames = {"FACTURE", "MEDICAMENTS", "TOTAL"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellRenderer(new PanelCellRenderer());
        table.getColumnModel().getColumn(0).setCellEditor(new PanelCellRenderer());
        table.setRowHeight(60);
        refresh();
        JScrollPane panel = new JScrollPane(table);
        panel.setBackground(Color.PINK);
        this.add(panel);
        VueApplication.definirUneMiseEnPageSpring(this, panel, new int[] {0, 26, 0, 26});
    }

}