package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sparadrap.models.submodels.Ordonnance;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Ordonnance] - test
 * @author Mathaus
 */
public class OrdonnanceTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Ordonnance ordonnance = new Ordonnance();
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#datesPourTest")
    public void setDatePrescripton(Date date) {
        assertEquals(null, ordonnance.getDatePrescripton());
        ordonnance.setDatePrescripton(date);
        assertEquals(date, ordonnance.getDatePrescripton());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}