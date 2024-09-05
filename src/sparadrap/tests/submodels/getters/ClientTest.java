package sparadrap.tests.submodels.getters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import sparadrap.models.submodels.Client;
import sparadrap.models.submodels.Entite;
import sparadrap.models.submodels.Personne;
import sparadrap.tests.utilitaires.Assert;
import sparadrap.tests.utilitaires.Util;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Client] - test
 * @author Mathaus
 */
public class ClientTest {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Setup">
    static Client client = new Client();
    static Client personne = (Client) PersonneTest.client;
    static {
        Util.definirEntite(client);
        client.setDateDeNaissance(Util.dateDeTest());
        client.setNumeroSecuriteSociale(Util.nombreDeTest());
        client.setPrenom(Util.nomDeTest());
        personne.setDateDeNaissance(Util.dateDeTest());
        personne.setNumeroSecuriteSociale(Util.nombreDeTest());
        personne.setPrenom(Util.nomDeTest());
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Tests">
    @Test
    public void isClient() {
        assertTrue(personne instanceof Client);
        assertTrue(client instanceof Client);
    }
    @Test
    public void isPersonne() {
        assertTrue(personne instanceof Personne);
        assertTrue(client instanceof Personne);
    }
    @Test
    public void isEntite() {
        assertTrue(personne instanceof Entite);
        assertTrue(client instanceof Entite);
    }
    @Test
    public void getNom() {
        assertEquals(Util.nomDeTest(), personne.getNom());
        assertEquals(Util.nomDeTest(), client.getNom());
        assertEquals("Nom de test", personne.getNom());
        assertEquals("Nom de test", client.getNom());
        assertFalse(personne.getNom().isBlank());
        assertFalse(client.getNom().isBlank());
    }
    @Test
    public void getAdresse() {
        assertEquals(Util.nomDeTest(), personne.getAdresse());
        assertEquals(Util.nomDeTest(), client.getAdresse());
        assertEquals("Nom de test", personne.getAdresse());
        assertEquals("Nom de test", client.getAdresse());
        assertFalse(personne.getAdresse().isBlank());
        assertFalse(client.getAdresse().isBlank());
    }
    @Test
    public void getTelephone() {
        assertEquals(Util.telephoneDeTest(), personne.getTelephone());
        assertEquals(Util.telephoneDeTest(), client.getTelephone());
        assertEquals("0626001122", personne.getTelephone());
        assertEquals("0626001122", client.getTelephone());
        assertFalse(personne.getTelephone().isBlank());
        assertFalse(client.getTelephone().isBlank());
    }
    @Test
    public void getEmail() {
        assertEquals(Util.mailDeTest(), personne.getEmail());
        assertEquals(Util.mailDeTest(), client.getEmail());
        assertEquals("john@doe.com", personne.getEmail());
        assertEquals("john@doe.com", client.getEmail());
        assertFalse(personne.getEmail().isBlank());
        assertFalse(client.getEmail().isBlank());
    }
    @Test
    public void getCodePostal() {
        assertEquals(Util.codePostalDeTest(), personne.getCodePostal());
        assertEquals(Util.codePostalDeTest(), client.getCodePostal());
        assertEquals("02600", personne.getCodePostal());
        assertEquals("02600", client.getCodePostal());
        assertFalse(personne.getCodePostal().isBlank());
        assertFalse(client.getCodePostal().isBlank());
    }
    @Test
    public void getPrenom() {
        assertEquals(Util.nomDeTest(), personne.getPrenom());
        assertEquals(Util.nomDeTest(), client.getPrenom());
        assertEquals("Nom de test", personne.getPrenom());
        assertEquals("Nom de test", client.getPrenom());
        assertFalse(personne.getPrenom().isBlank());
        assertFalse(client.getPrenom().isBlank());
    }
    @Test
    public void getDateDeNaissance() {
        Date dateDeTest = Util.dateDeTest();
        assertEquals(dateDeTest, personne.getDateDeNaissance());
        assertEquals(dateDeTest, client.getDateDeNaissance());
        Assert.assertMauvaisesDate(personne.getDateDeNaissance());
        Assert.assertMauvaisesDate(client.getDateDeNaissance());
    }
    @Test
    public void getNumeroSecuriteSociale() {
        assertEquals(Util.nombreDeTest(), personne.getNumeroSecuriteSociale());
        assertEquals(Util.nombreDeTest(), client.getNumeroSecuriteSociale());
        assertTrue(personne.getNumeroSecuriteSociale() > 0);
        assertTrue(client.getNumeroSecuriteSociale() > 0);
    }
    // </editor-fold>
    //****************************************************************************************************************//
}