package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import sparadrap.models.submodels.Achat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Achat] - test
 * @author Mathaus
 */
public class AchatTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Achat achat = new Achat(); //non-static pour reinitialiser la valeur.
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#datesPourTest")
    public void setDateAchat(Date date) {
        assertEquals(null, achat.getDateAchat());
        achat.setDateAchat(date);
        assertEquals(date, achat.getDateAchat());
    }
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void setPrescription(boolean prescription) {
        assertEquals(false, achat.isPrescription());
        achat.setPrescription(prescription);
        assertEquals(prescription, achat.isPrescription());
    }
    @ParameterizedTest
    @ValueSource(ints = { Integer.MIN_VALUE, -2147483648, -1234567890, -987654321, -500000000,
            0, 123456789, 987654321, 1500000000, 2000000000, 2147483647, Integer.MAX_VALUE })
    public void setNumeroFacture(int numeroFacture) {
        assertEquals(0, achat.getNumeroFacture());
        achat.setNumeroFacture(numeroFacture);
        assertEquals(numeroFacture, achat.getNumeroFacture());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}