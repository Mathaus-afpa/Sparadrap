package sparadrap.mocks;
import sparadrap.models.submodels.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
public class DataSource {
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide en privee de la classe statique DataSource.
     */
    private DataSource(){}
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    public static final List<Client> CLIENTS = new ArrayList<>();
    public static final List<Medecin> MEDECINS = new ArrayList<>();
    public static final List<Medicament> MEDICAMENTS = new ArrayList<>();
    public static final List<Mutuelle> MUTUELLES = new ArrayList<>();
    static {
        createClients();
        createMedecins();
        createMedicaments();
        createMutuelles();
    }
    // </editor-fold>
    //****************************************************************************************************************//
    // <editor-fold defaultstate="collapsed" desc="Methodes PRIVATE">
    /**
     * Creer une liste de clients.
     */
    private static void createClients() {
        String[] prenoms = { "Anthony", "Bernard", "Christian", "Denis", "Emmanuel"};
        Random random = new Random();
        for (String prenom : prenoms) {
            Client client = new Client(prenom);
            client.completerIdentite("Nom", "123 Rue Exemple", "0123456789", "exemple@example.com", "12345");
            client.setDateDeNaissance(new Date("09/09/2024"));
            client.setNumeroSecuriteSociale(random.nextInt(12345,50000) + 123);
            CLIENTS.add(client);
        }
    }
    /**
     * Creer une liste de medecins.
     */
    private static void createMedecins() {
        String[] prenoms = { "Anth-ony", "Bern-ard", "Chris-tian", "Den-is", "Emma-nuel"};
        Random random = new Random();
        for (String prenom : prenoms) {
            Medecin medecin = new Medecin(prenom);
            medecin.setAgreement(random.nextInt(12345,60000) + 456);
            MEDECINS.add(medecin);
        }
    }
    /**
     * Creer une liste de medicaments.
     */
    private static void createMedicaments() {
        String[] nomsMedicament = { "amoxicilline", "azithromycine", "méthicilline", "pénicilline", "clindamycine",
                "céfuroxime", "ofloxacine", "ciprofloxacine", "tétracycline", "vancomycine" };
        for (String nom : nomsMedicament) {
            Medicament medicament = new Medicament();
            medicament.setNom(nom);
            medicament.setStock(100);
            medicament.setPrix(1.23f);
            medicament.setDateMiseEnService(new Date());
            MEDICAMENTS.add(medicament);
        }
    }
    /**
     * Creer une liste de mutuelles.
     */
    private static void createMutuelles() {
        String[] nomMutuelle = { "Harmonie Mutuelle", "MAAF", "Mutuelle Générale" };
        for (String nom : nomMutuelle) {
            Mutuelle mutuelle = new Mutuelle();
            mutuelle.completerIdentite(nom, "123 Rue Exemple", "0123456789", "exemple@example.com", "12345");
            MUTUELLES.add(mutuelle);
        }
    }
    // </editor-fold>
    //****************************************************************************************************************//
}