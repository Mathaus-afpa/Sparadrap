package sparadrap.tests.submodels.getters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import sparadrap.models.submodels.Achat;
import sparadrap.tests.utilitaires.Assert;
import sparadrap.tests.utilitaires.Util;
import java.util.Date;
/**
 * [Achat] - test
 * @author Mathaus
 */
public class AchatTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    static Achat avecOrdonnance = new Achat();
    static Achat sansOrdonnance = new Achat();
    static
    {
        avecOrdonnance.setDateAchat(Util.dateDeTest());
        avecOrdonnance.setPrescription(true);
        avecOrdonnance.setNumeroFacture(Util.nombreDeTest());
        sansOrdonnance.setDateAchat(Util.dateDeTest());
        sansOrdonnance.setPrescription(false);
        sansOrdonnance.setNumeroFacture(Util.nombreDeTest());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @Test
    public void getDateAchat() {
        Date dateDeTest = Util.dateDeTest();
        assertEquals(dateDeTest, avecOrdonnance.getDateAchat());
        assertEquals(dateDeTest, sansOrdonnance.getDateAchat());
        Assert.assertMauvaisesDate(avecOrdonnance.getDateAchat());
        Assert.assertMauvaisesDate(sansOrdonnance.getDateAchat());
    }
    @Test
    public void isPrescription() {
        assertTrue(avecOrdonnance.isPrescription());
        assertFalse(sansOrdonnance.isPrescription());
    }
    @Test
    public void getNumeroFacture() {
        assertEquals(Util.nombreDeTest(), avecOrdonnance.getNumeroFacture());
        assertEquals(Util.nombreDeTest(), sansOrdonnance.getNumeroFacture());
        assertEquals(260000000, avecOrdonnance.getNumeroFacture());
        assertEquals(260000000, sansOrdonnance.getNumeroFacture());
        assertTrue(avecOrdonnance.getNumeroFacture() > 0);
        assertTrue(sansOrdonnance.getNumeroFacture() > 0);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}