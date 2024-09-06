package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sparadrap.models.submodels.Mutuelle;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Mutuelle] - test
 * @author Mathaus
 */
public class MutuelleTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Mutuelle mutuelle = new Mutuelle();
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setNom(String nom) {
        assertEquals(null, mutuelle.getNom());
        mutuelle.setNom(nom);
        assertEquals(nom, mutuelle.getNom());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setAdresse(String adresse) {
        assertEquals(null, mutuelle.getAdresse());
        mutuelle.setAdresse(adresse);
        assertEquals(adresse, mutuelle.getAdresse());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setTelephone(String telephone) {
        assertEquals(null, mutuelle.getTelephone());
        mutuelle.setTelephone(telephone);
        assertEquals(telephone, mutuelle.getTelephone());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setEmail(String email) {
        assertEquals(null, mutuelle.getEmail());
        mutuelle.setEmail(email);
        assertEquals(email, mutuelle.getEmail());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setCodePostal(String codePostal) {
        assertEquals(null, mutuelle.getCodePostal());
        mutuelle.setCodePostal(codePostal);
        assertEquals(codePostal, mutuelle.getCodePostal());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#nombresDecimauxPourTest")
    public void setTauxDeRemboursement(float tauxDeRemboursement) {
        assertEquals(0, mutuelle.getTauxDeRemboursement());
        mutuelle.setTauxDeRemboursement(tauxDeRemboursement);
        assertEquals(tauxDeRemboursement, mutuelle.getTauxDeRemboursement());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}