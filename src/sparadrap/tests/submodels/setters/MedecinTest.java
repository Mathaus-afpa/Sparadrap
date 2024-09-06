package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import sparadrap.models.submodels.Medecin;
import sparadrap.models.submodels.Personne;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Medecin] - test
 * @author Mathaus
 */
public class MedecinTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Medecin medecin = new Medecin();
    Personne personne = new Medecin();
    Medecin personneMedecin = (Medecin) personne;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setNom(String nom) {
        assertEquals(null, personneMedecin.getNom());
        assertEquals(null, medecin.getNom());
        personneMedecin.setNom(nom);
        medecin.setNom(nom);
        assertEquals(nom, personneMedecin.getNom());
        assertEquals(nom, medecin.getNom());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setAdresse(String adresse) {
        assertEquals(null, personneMedecin.getAdresse());
        assertEquals(null, medecin.getAdresse());
        personneMedecin.setAdresse(adresse);
        medecin.setAdresse(adresse);
        assertEquals(adresse, personneMedecin.getAdresse());
        assertEquals(adresse, medecin.getAdresse());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setTelephone(String telephone) {
        assertEquals(null, personneMedecin.getTelephone());
        assertEquals(null, medecin.getTelephone());
        personneMedecin.setTelephone(telephone);
        medecin.setTelephone(telephone);
        assertEquals(telephone, personneMedecin.getTelephone());
        assertEquals(telephone, medecin.getTelephone());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setEmail(String email) {
        assertEquals(null, personneMedecin.getEmail());
        assertEquals(null, medecin.getEmail());
        personneMedecin.setEmail(email);
        medecin.setEmail(email);
        assertEquals(email, personneMedecin.getEmail());
        assertEquals(email, medecin.getEmail());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setCodePostal(String codePostal) {
        assertEquals(null, personneMedecin.getCodePostal());
        assertEquals(null, medecin.getCodePostal());
        personneMedecin.setCodePostal(codePostal);
        medecin.setCodePostal(codePostal);
        assertEquals(codePostal, personneMedecin.getCodePostal());
        assertEquals(codePostal, medecin.getCodePostal());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setPrenom(String prenom) {
        assertEquals(null, personneMedecin.getPrenom());
        assertEquals(null, medecin.getPrenom());
        personneMedecin.setPrenom(prenom);
        medecin.setPrenom(prenom);
        assertEquals(prenom, personneMedecin.getPrenom());
        assertEquals(prenom, medecin.getPrenom());
    }
    @ParameterizedTest
    @ValueSource(ints = { Integer.MIN_VALUE, -2147483648, -1234567890, -987654321, -500000000,
            0, 123456789, 987654321, 1500000000, 2000000000, 2147483647, Integer.MAX_VALUE })
    public void setAgreement(int numeroSecuriteSociale) {
        assertEquals(0, medecin.getAgreement());
        assertEquals(0, personneMedecin.getAgreement());
        medecin.setAgreement(numeroSecuriteSociale);
        personneMedecin.setAgreement(numeroSecuriteSociale);
        assertEquals(numeroSecuriteSociale, medecin.getAgreement());
        assertEquals(numeroSecuriteSociale, personneMedecin.getAgreement());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}