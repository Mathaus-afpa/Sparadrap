package sparadrap.tests.utilitaires;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/**
 * [Assert] - class
 * @author Mathaus
 */
public class Assert {
    /***
     * Teste si la date est differente de: "02/01/2001", "01/02/2001", "01/01/2002", "02/02/2002".
     * @param date
     */
    public static void assertMauvaisesDate(Date date) {
        Date[] mauvaisesDates = {
                new Date("02/01/2001"),
                new Date("01/02/2001"),
                new Date("01/01/2002"),
                new Date("02/02/2002")
        };
        assertNotEquals(mauvaisesDates[0], date);
        assertNotEquals(mauvaisesDates[1], date);
        assertNotEquals(mauvaisesDates[2], date);
        assertNotEquals(mauvaisesDates[3], date);
    }
}