package sparadrap.tests.submodels.getters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import sparadrap.models.submodels.Client;
import sparadrap.models.submodels.Entite;
import sparadrap.models.submodels.Medecin;
import sparadrap.models.submodels.Personne;
import sparadrap.tests.utilitaires.Util;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Personne] - test
 * @author Mathaus
 */
public class PersonneTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    static Personne personne = new Personne();
    static Personne client = new Client();
    static Personne medecin = new Medecin();
    static {
        Util.definirEntite(personne);
        Util.definirEntite(client);
        Util.definirEntite(medecin);
        personne.setPrenom(Util.nomDeTest());
        client.setPrenom(Util.nomDeTest());
        medecin.setPrenom(Util.nomDeTest());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @Test
    public void isPersonne() {
        assertTrue(personne instanceof Personne);
        assertTrue(client instanceof Personne);
        assertTrue(medecin instanceof Personne);
    }
    @Test
    public void isEntite() {
        assertTrue(personne instanceof Entite);
        assertTrue(client instanceof Entite);
        assertTrue(medecin instanceof Entite);
    }
    @Test
    public void getNom() {
        assertEquals(Util.nomDeTest(), personne.getNom());
        assertEquals(Util.nomDeTest(), client.getNom());
        assertEquals(Util.nomDeTest(), medecin.getNom());
        assertEquals("Nom de test", personne.getNom());
        assertEquals("Nom de test", client.getNom());
        assertEquals("Nom de test", medecin.getNom());
        assertFalse(personne.getNom().isBlank());
        assertFalse(client.getNom().isBlank());
        assertFalse(medecin.getNom().isBlank());
    }
    @Test
    public void getAdresse() {
        assertEquals(Util.nomDeTest(), personne.getAdresse());
        assertEquals(Util.nomDeTest(), client.getAdresse());
        assertEquals(Util.nomDeTest(), medecin.getAdresse());
        assertEquals("Nom de test", personne.getAdresse());
        assertEquals("Nom de test", client.getAdresse());
        assertEquals("Nom de test", medecin.getAdresse());
        assertFalse(personne.getAdresse().isBlank());
        assertFalse(client.getAdresse().isBlank());
        assertFalse(medecin.getAdresse().isBlank());
    }
    @Test
    public void getTelephone() {
        assertEquals(Util.telephoneDeTest(), personne.getTelephone());
        assertEquals(Util.telephoneDeTest(), client.getTelephone());
        assertEquals(Util.telephoneDeTest(), medecin.getTelephone());
        assertEquals("0626001122", personne.getTelephone());
        assertEquals("0626001122", client.getTelephone());
        assertEquals("0626001122", medecin.getTelephone());
        assertFalse(personne.getTelephone().isBlank());
        assertFalse(client.getTelephone().isBlank());
        assertFalse(medecin.getTelephone().isBlank());
    }
    @Test
    public void getEmail() {
        assertEquals(Util.mailDeTest(), personne.getEmail());
        assertEquals(Util.mailDeTest(), client.getEmail());
        assertEquals(Util.mailDeTest(), medecin.getEmail());
        assertEquals("john@doe.com", personne.getEmail());
        assertEquals("john@doe.com", client.getEmail());
        assertEquals("john@doe.com", medecin.getEmail());
        assertFalse(personne.getEmail().isBlank());
        assertFalse(client.getEmail().isBlank());
        assertFalse(medecin.getEmail().isBlank());
    }
    @Test
    public void getCodePostal() {
        assertEquals(Util.codePostalDeTest(), personne.getCodePostal());
        assertEquals(Util.codePostalDeTest(), client.getCodePostal());
        assertEquals(Util.codePostalDeTest(), medecin.getCodePostal());
        assertEquals("02600", personne.getCodePostal());
        assertEquals("02600", client.getCodePostal());
        assertEquals("02600", medecin.getCodePostal());
        assertFalse(personne.getCodePostal().isBlank());
        assertFalse(client.getCodePostal().isBlank());
        assertFalse(medecin.getCodePostal().isBlank());
    }
    @Test
    public void getPrenom() {
        assertEquals(Util.nomDeTest(), personne.getPrenom());
        assertEquals(Util.nomDeTest(), client.getPrenom());
        assertEquals(Util.nomDeTest(), medecin.getPrenom());
        assertEquals("Nom de test", personne.getPrenom());
        assertEquals("Nom de test", client.getPrenom());
        assertEquals("Nom de test", medecin.getPrenom());
        assertFalse(personne.getPrenom().isBlank());
        assertFalse(client.getPrenom().isBlank());
        assertFalse(medecin.getPrenom().isBlank());
    }
    // </editor-fold>
    //****************************************************************************************************************//
}