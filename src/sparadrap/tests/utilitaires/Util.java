package sparadrap.tests.utilitaires;
import sparadrap.models.submodels.Entite;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * [Util] - class
 * @author Mathaus
 */
public class Util {
    /**
     * Defini les valeurs de tests d'une classe heritant d'Entite.
     * @param entite
     */
    public static void definirEntite(Entite entite) {
        entite.setNom(Util.nomDeTest());
        entite.setEmail(Util.mailDeTest());
        entite.setAdresse(Util.nomDeTest());
        entite.setCodePostal(Util.codePostalDeTest());
        entite.setTelephone(Util.telephoneDeTest());
    }
    /**
     * @return "Nom de test"
     */
    public static String nomDeTest() {
        return "Nom de test";
    }
    /**
     * @return "john@doe.com"
     */
    public static String mailDeTest() {
        return "john@doe.com";
    }
    /**
     * @return "02600"
     */
    public static String codePostalDeTest() {
        return "02600";
    }
    /**
     * @return "0626001122"
     */
    public static String telephoneDeTest() {
        return "0626001122";
    }
    /**
     * Retourne l'objet Date du 01/01/2001.
     * @return (Date)
     */
    public static Date dateDeTest() {
        return new Date("01/01/2001");
    }
    /**
     * Retourne 260000000.
     * @return (int)
     */
    public static int nombreDeTest() {
        return 260000000;
    }
    /**
     * Retourne 26.26.
     * @return (float)
     */
    public static float nombreDecimalDeTest() {
        return 26.26f;
    }
    /**
     * Converti une chaine au format "dd/MM/yyyy" en Date.
     * @param date
     * @return (Date)
     * @throws ParseException
     */
    public static Date conversionEnDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(date);
    }
}