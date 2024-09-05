package sparadrap.tests.submodels.getters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import sparadrap.models.submodels.Ordonnance;
import sparadrap.tests.utilitaires.Assert;
import sparadrap.tests.utilitaires.Util;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Ordonnance] - test
 * @author Mathaus
 */
public class OrdonnanceTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    static Ordonnance ordonnance = new Ordonnance();
    static {
        ordonnance.setDatePrescripton(Util.dateDeTest());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @Test
    public void getDatePrescripton() {
        Date dateDeTest = Util.dateDeTest();
        assertEquals(dateDeTest, ordonnance.getDatePrescripton());
        Assert.assertMauvaisesDate(ordonnance.getDatePrescripton());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}