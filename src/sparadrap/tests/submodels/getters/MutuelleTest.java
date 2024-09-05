package sparadrap.tests.submodels.getters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import sparadrap.models.submodels.Entite;
import sparadrap.models.submodels.Mutuelle;
import sparadrap.tests.utilitaires.Util;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Mutuelle] - test
 * @author Mathaus
 */
public class MutuelleTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    static Mutuelle mutuelle = new Mutuelle();
    static {
        Util.definirEntite(mutuelle);
        mutuelle.setTauxDeRemboursement(Util.nombreDecimalDeTest());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @Test
    public void isMutuelle() {
        assertTrue(mutuelle instanceof Mutuelle);
    }
    @Test
    public void isEntite() {
        assertTrue(mutuelle instanceof Entite);
    }
    @Test
    public void getNom() {
        assertEquals(Util.nomDeTest(), mutuelle.getNom());
        assertEquals("Nom de test", mutuelle.getNom());
        assertFalse(mutuelle.getNom().isBlank());
    }
    @Test
    public void getAdresse() {
        assertEquals(Util.nomDeTest(), mutuelle.getAdresse());
        assertEquals("Nom de test", mutuelle.getAdresse());
        assertFalse(mutuelle.getAdresse().isBlank());
    }
    @Test
    public void getTelephone() {
        assertEquals(Util.telephoneDeTest(), mutuelle.getTelephone());
        assertEquals("0626001122", mutuelle.getTelephone());
        assertFalse(mutuelle.getTelephone().isBlank());
    }
    @Test
    public void getEmail() {
        assertEquals(Util.mailDeTest(), mutuelle.getEmail());
        assertEquals("john@doe.com", mutuelle.getEmail());
        assertFalse(mutuelle.getEmail().isBlank());
    }
    @Test
    public void getCodePostal() {
        assertEquals(Util.codePostalDeTest(), mutuelle.getCodePostal());
        assertEquals("02600", mutuelle.getCodePostal());
        assertFalse(mutuelle.getCodePostal().isBlank());
    }
    @Test
    public void getTauxDeRemboursement() {
        assertEquals(Util.nombreDecimalDeTest(), mutuelle.getTauxDeRemboursement());
        assertTrue(mutuelle.getTauxDeRemboursement() >= 0 && mutuelle.getTauxDeRemboursement() <= 100);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}