package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import sparadrap.models.submodels.Client;
import sparadrap.models.submodels.Personne;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Client] - test
 * @author Mathaus
 */
public class ClientTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Client client = new Client();
    Personne personne = new Client();
    Client personneClient = (Client) personne;
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setNom(String nom) {
        assertEquals(null, personneClient.getNom());
        assertEquals(null, client.getNom());
        personneClient.setNom(nom);
        client.setNom(nom);
        assertEquals(nom, personneClient.getNom());
        assertEquals(nom, client.getNom());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setAdresse(String adresse) {
        assertEquals(null, personneClient.getAdresse());
        assertEquals(null, client.getAdresse());
        personneClient.setAdresse(adresse);
        client.setAdresse(adresse);
        assertEquals(adresse, personneClient.getAdresse());
        assertEquals(adresse, client.getAdresse());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setTelephone(String telephone) {
        assertEquals(null, personneClient.getTelephone());
        assertEquals(null, client.getTelephone());
        personneClient.setTelephone(telephone);
        client.setTelephone(telephone);
        assertEquals(telephone, personneClient.getTelephone());
        assertEquals(telephone, client.getTelephone());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setEmail(String email) {
        assertEquals(null, personneClient.getEmail());
        assertEquals(null, client.getEmail());
        personneClient.setEmail(email);
        client.setEmail(email);
        assertEquals(email, personneClient.getEmail());
        assertEquals(email, client.getEmail());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setCodePostal(String codePostal) {
        assertEquals(null, personneClient.getCodePostal());
        assertEquals(null, client.getCodePostal());
        personneClient.setCodePostal(codePostal);
        client.setCodePostal(codePostal);
        assertEquals(codePostal, personneClient.getCodePostal());
        assertEquals(codePostal, client.getCodePostal());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setPrenom(String prenom) {
        assertEquals(null, personneClient.getPrenom());
        assertEquals(null, client.getPrenom());
        personneClient.setPrenom(prenom);
        client.setPrenom(prenom);
        assertEquals(prenom, personneClient.getPrenom());
        assertEquals(prenom, client.getPrenom());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#datesPourTest")
    public void setDateDeNaissance(Date date) {
        assertEquals(null, client.getDateDeNaissance());
        assertEquals(null, personneClient.getDateDeNaissance());
        client.setDateDeNaissance(date);
        personneClient.setDateDeNaissance(date);
        assertEquals(date, client.getDateDeNaissance());
        assertEquals(date, personneClient.getDateDeNaissance());
    }
    @ParameterizedTest
    @ValueSource(ints = { Integer.MIN_VALUE, -2147483648, -1234567890, -987654321, -500000000,
            0, 123456789, 987654321, 1500000000, 2000000000, 2147483647, Integer.MAX_VALUE })
    public void setNumeroSecuriteSociale(int numeroSecuriteSociale) {
        assertEquals(0, client.getNumeroSecuriteSociale());
        assertEquals(0, personneClient.getNumeroSecuriteSociale());
        client.setNumeroSecuriteSociale(numeroSecuriteSociale);
        personneClient.setNumeroSecuriteSociale(numeroSecuriteSociale);
        assertEquals(numeroSecuriteSociale, client.getNumeroSecuriteSociale());
        assertEquals(numeroSecuriteSociale, personneClient.getNumeroSecuriteSociale());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}