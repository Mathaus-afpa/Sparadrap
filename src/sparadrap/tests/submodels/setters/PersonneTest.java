package sparadrap.tests.submodels.setters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sparadrap.models.submodels.Client;
import sparadrap.models.submodels.Medecin;
import sparadrap.models.submodels.Personne;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Personne] - test
 * @author Mathaus
 */
public class PersonneTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    Personne personne = new Personne();
    Personne client = new Client();
    Personne medecin = new Medecin();
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setNom(String nom) {
        assertEquals(null, personne.getNom());
        assertEquals(null, client.getNom());
        assertEquals(null, medecin.getNom());
        personne.setNom(nom);
        client.setNom(nom);
        medecin.setNom(nom);
        assertEquals(nom, personne.getNom());
        assertEquals(nom, client.getNom());
        assertEquals(nom, medecin.getNom());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setAdresse(String adresse) {
        assertEquals(null, personne.getAdresse());
        assertEquals(null, client.getAdresse());
        assertEquals(null, medecin.getAdresse());
        personne.setAdresse(adresse);
        client.setAdresse(adresse);
        medecin.setAdresse(adresse);
        assertEquals(adresse, personne.getAdresse());
        assertEquals(adresse, client.getAdresse());
        assertEquals(adresse, medecin.getAdresse());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setTelephone(String telephone) {
        assertEquals(null, personne.getTelephone());
        assertEquals(null, client.getTelephone());
        assertEquals(null, medecin.getTelephone());
        personne.setTelephone(telephone);
        client.setTelephone(telephone);
        medecin.setTelephone(telephone);
        assertEquals(telephone, personne.getTelephone());
        assertEquals(telephone, client.getTelephone());
        assertEquals(telephone, medecin.getTelephone());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setEmail(String email) {
        assertEquals(null, personne.getEmail());
        assertEquals(null, client.getEmail());
        assertEquals(null, medecin.getEmail());
        personne.setEmail(email);
        client.setEmail(email);
        medecin.setEmail(email);
        assertEquals(email, personne.getEmail());
        assertEquals(email, client.getEmail());
        assertEquals(email, medecin.getEmail());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setCodePostal(String codePostal) {
        assertEquals(null, personne.getCodePostal());
        assertEquals(null, client.getCodePostal());
        assertEquals(null, medecin.getCodePostal());
        personne.setCodePostal(codePostal);
        client.setCodePostal(codePostal);
        medecin.setCodePostal(codePostal);
        assertEquals(codePostal, personne.getCodePostal());
        assertEquals(codePostal, client.getCodePostal());
        assertEquals(codePostal, medecin.getCodePostal());
    }
    @ParameterizedTest
    @MethodSource("sparadrap.tests.utilitaires.Sources#chainesPourTest")
    public void setPrenom(String prenom) {
        assertEquals(null, personne.getPrenom());
        assertEquals(null, client.getPrenom());
        assertEquals(null, medecin.getPrenom());
        personne.setPrenom(prenom);
        client.setPrenom(prenom);
        medecin.setPrenom(prenom);
        assertEquals(prenom, personne.getPrenom());
        assertEquals(prenom, client.getPrenom());
        assertEquals(prenom, medecin.getPrenom());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}