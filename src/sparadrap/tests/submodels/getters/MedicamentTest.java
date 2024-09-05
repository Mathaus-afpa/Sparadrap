package sparadrap.tests.submodels.getters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import sparadrap.models.submodels.Medicament;
import sparadrap.tests.utilitaires.Assert;
import sparadrap.tests.utilitaires.Util;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Medicament] - test
 * @author Mathaus
 */
public class MedicamentTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    static Medicament medicament = new Medicament();
    static {
        medicament.setNom(Util.nomDeTest());
        medicament.setPrix(Util.nombreDecimalDeTest());
        medicament.setStock(Util.nombreDeTest());
        medicament.setDateMiseEnService(Util.dateDeTest());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @Test
    public void getNom() {
        assertEquals(Util.nomDeTest(), medicament.getNom());
        assertEquals("Nom de test", medicament.getNom());
        assertFalse(medicament.getNom().isBlank());
    }
    @Test
    public void getDateMiseEnService() {
        Date dateDeTest = Util.dateDeTest();
        assertEquals(dateDeTest, medicament.getDateMiseEnService());
        Assert.assertMauvaisesDate(medicament.getDateMiseEnService());
    }
    @Test
    public void getPrix() {
        assertEquals(Util.nombreDecimalDeTest(), medicament.getPrix());
        assertTrue(medicament.getPrix() >= 0);
    }
    @Test
    public void getStock() {
        assertEquals(Util.nombreDeTest(), medicament.getStock());
        assertTrue(medicament.getStock() >= 0);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}