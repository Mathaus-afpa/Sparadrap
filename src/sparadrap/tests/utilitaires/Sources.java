package sparadrap.tests.utilitaires;
import java.util.Date;
import java.util.stream.Stream;
/**
 * [Sources] - class
 * @author Mathaus
 */
public class Sources {
    /**
     * Retourne une liste de chaines.
     * @return (Stream<String>)
     */
    public static Stream<String> chainesPourTest() {
        return Stream.of(
                "",                              // Chaîne vide
                " ",                             // Espace unique
                "    ",                          // Plusieurs espaces
                "Hello, World!",                 // Chaîne simple et classique
                "1234567890",                    // Chiffres uniquement
                "!@#$%^&*()_+-=[]{}|;':\",./<>?", // Caractères spéciaux courants
                "`~!#$%^&*()-_=+[]{}\\|;:'\",.<>/?",  // Autres caractères spéciaux (backslash inclus)
                "\t\n\r",                        // Caractères de contrôle : tab, nouvelle ligne, retour chariot
                "\u0000",                        // Null char (caractère null)
                "null",                          // Le mot "null"
                "undefined",                     // Le mot "undefined"
                "NaN",                           // Chaîne littérale NaN (Not a Number)
                "true",                          // Booléen sous forme de chaîne
                "false",                         // Booléen sous forme de chaîne
                " leading spaces",               // Espaces en début
                "trailing spaces ",              // Espaces en fin
                "    both    ",                  // Espaces au début et à la fin
                "😀😃😄😁😆😅😂🤣😊😇",           // Séquence d'émojis
                "éèêëáàäâîïìíóòôöúùûüñç",       // Caractères accentués et spéciaux (français)
                "很长的字符串测试",              // Chinois (Unicode)
                "これはテストです",              // Japonais (Unicode)
                "اختبار طويل جدا",              // Arabe (Unicode)
                "𐍈𐍉𐍊𐍋𐍌𐍍𐍎𐍏",            // Caractères rares en gothique
                "a".repeat(1000),                // Chaîne de 1000 "a"
                "a".repeat(10000),               // Chaîne de 10 000 "a"
                "\0",                            // Caractère null dans certaines langues (terminateur de chaîne en C)
                "aaaaaaaaaaaaaaaaaaaaaa",        // Séquence répétée simple
                "SQL Injection: ' OR 1=1 -- ",   // Tentative d'injection SQL
                "<script>alert('XSS')</script>", // Exemple de script XSS
                "<div>HTML content</div>",       // Chaîne HTML
                "{\"key\": \"value\"}",          // Objet JSON simple
                "{[(()])}",                      // Parenthèses, crochets, accolades imbriqués
                "''\"\"``''",                    // Divers types de guillemets (simple, double, backtick)
                "SELECT * FROM users;",          // Chaîne SQL simple
                "DROP TABLE users;",             // Chaîne dangereuse pour les bases de données
                "C:\\Program Files\\Test",       // Chemin de fichier Windows
                "/usr/local/bin/test",           // Chemin de fichier Unix
                "127.0.0.1",                     // Adresse IP
                "::1",                           // Adresse IPv6 locale
                "test@example.com",              // Email valide
                "user@domain@domain.com",        // Email invalide avec plusieurs @
                "http://example.com",            // URL valide
                "https://www.example.com/index.html?param=test",  // URL avec query string
                "ftp://example.com/file.txt",    // URL FTP
                "192.168.0.1:8080",              // IP et port
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",  // Longue chaîne
                "\u202Eevil\u202Etext",           // Utilisation de caractères de direction RTL (right-to-left override)
                "0xDEADBEEF",                    // Hexadécimal
                "0b110101",                      // Binaire
                "\n\n\n\n\n",                    // Séquence de plusieurs retours à la ligne
                "            ",                 // Différents types d'espaces Unicode
                "𠀋𠀌𠀍𠀎",                    // Caractères Unicode sur plusieurs octets
                "first line\nsecond line\r\nthird line", // Test multi-ligne avec différents types de retours à la ligne
                "   ; DROP DATABASE test;",      // Chaîne avec espaces menant à une injection SQL
                "🤖💻🛠️",                        // Émojis pour tester les chaînes multi-octets
                "\\x01\\x02\\x03\\x04\\x05",          // Chaînes avec des octets bas (1 à 5)
                "\\x7F\\x80\\x81",                  // Chaînes avec des octets élevés (127, 128, 129)
                "text_with_underscore",          // Chaîne avec underscore
                "text-with-hyphen",              // Chaîne avec tiret
                "test, with, commas",            // Chaîne avec virgules
                "user.name+tag@example.com",     // Email avec tag
                "´~^¨`çÇñÑ",                     // Caractères accentués espagnols et portugais
                "⁰¹²³⁴⁵⁶⁷⁸⁹",                   // Chiffres en exposant
                "₀₁₂₃₄₅₆₇₈₉",                 // Chiffres en indice
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" // Très longue chaîne
        );
    }
    /**
     * Retourne une liste de dates.
     * @return (Stream<Date>)
     */
    public static Stream<Date> datesPourTest() {
        return Stream.of(
                Util.dateDeTest(),
                new Date("06/09/2024")
        );
    }
    /**
     * Retourne une liste de nombres entiers.
     * @return (Stream<Integer>)
     */
    public static Stream<Integer> nombresEntiersPourTest() {
        return Stream.of(Integer.MIN_VALUE, -2147483648, -1234567890, -987654321, -500000000,
                0, 123456789, 987654321, 1500000000, 2000000000, 2147483647, Integer.MAX_VALUE);
    }
    /**
     * Retourne une liste de nombres decimaux.
     * @return (Stream<Float>)
     */
    public static Stream<Float> nombresDecimauxPourTest() {
        return Stream.of(
                Float.MIN_VALUE, -214748364.8f, -12345678.90f, -987654.321f, -500000000f,
                0f, 12345.6789f, 9876.54321f, 1500000000f, 2000000000f, 2147.483647f, Float.MAX_VALUE
        );
    }
}