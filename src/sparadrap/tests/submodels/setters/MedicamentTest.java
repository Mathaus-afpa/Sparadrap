package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sparadrap.models.submodels.Medicament;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Medicament] - test
 * @author Mathaus
 */
public class MedicamentTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Medicament medicament = new Medicament();
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setNom(String nom) {
        assertEquals(null, medicament.getNom());
        medicament.setNom(nom);
        assertEquals(nom, medicament.getNom());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#datesPourTest")
    public void setDateMiseEnService(Date date) {
        assertEquals(null, medicament.getDateMiseEnService());
        medicament.setDateMiseEnService(date);
        assertEquals(date, medicament.getDateMiseEnService());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#nombresDecimauxPourTest")
    public void setPrix(float prix) {
        assertEquals(0, medicament.getPrix());
        medicament.setPrix(prix);
        assertEquals(prix, medicament.getPrix());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#nombresEntiersPourTest")
    public void setStock(int stock) {
        assertEquals(0, medicament.getStock());
        medicament.setStock(stock);
        assertEquals(stock, medicament.getStock());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}