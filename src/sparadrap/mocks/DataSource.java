package sparadrap.mocks;
import sparadrap.models.enums.medecine.SPECIALITES;
import sparadrap.models.submodels.*;

import java.util.*;
import java.util.stream.Collectors;

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
    public static final List<Achat> ACHATS = new ArrayList<>();
    static {
        createClients();
        createMedecins();
        createMedicaments();
        createMutuelles();
        createAchats();
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
        String[] prenoms = {
                "Anthony", "Bernard", "Christian", "Denis", "Emmanuel",
                "Fabien", "Gilles", "Henri", "Isabelle", "Julien",
                "Karine", "Laurent", "Marie", "Nathalie", "Olivier",
                "Patricia", "Quentin", "Raphaël", "Sophie", "Thomas",
                "Ursule", "Valérie", "William", "Xavier", "Yves"
        };

        String[] noms = {
                "Dupont", "Martin", "Durand", "Moreau", "Lefevre",
                "Garcia", "Muller", "Leroy", "Simon", "Laurent",
                "Michel", "Bernard", "Robert", "Richard", "Petit",
                "Roux", "David", "Bertrand", "Morel", "Girard",
                "Andre", "Lemoine", "Fournier", "Blanc", "Guerin"
        };

        String[] adresses = {
                "123 Rue de la Paix", "45 Avenue des Champs", "10 Boulevard Saint-Germain", "22 Quai des Grands Augustins", "17 Place de la République",
                "5 Rue de Rivoli", "30 Rue des Martyrs", "9 Rue de Rennes", "55 Avenue Foch", "78 Rue de la Pompe",
                "21 Rue de Belleville", "12 Boulevard Voltaire", "8 Rue des Archives", "14 Rue de la Roquette", "6 Rue du Faubourg Saint-Antoine",
                "33 Rue de Charonne", "29 Rue de la Grange aux Belles", "19 Rue de l'Université", "47 Rue de Sèvres", "38 Rue Saint-Dominique",
                "66 Rue de Miromesnil", "72 Avenue de la Bourdonnais", "3 Rue Cler", "11 Avenue de la Motte-Picquet", "25 Rue de Grenelle"
        };

        String[] emails = {
                "contact1@medecin.fr", "contact2@medecin.fr", "contact3@medecin.fr", "contact4@medecin.fr", "contact5@medecin.fr",
                "contact6@medecin.fr", "contact7@medecin.fr", "contact8@medecin.fr", "contact9@medecin.fr", "contact10@medecin.fr",
                "contact11@medecin.fr", "contact12@medecin.fr", "contact13@medecin.fr", "contact14@medecin.fr", "contact15@medecin.fr",
                "contact16@medecin.fr", "contact17@medecin.fr", "contact18@medecin.fr", "contact19@medecin.fr", "contact20@medecin.fr",
                "contact21@medecin.fr", "contact22@medecin.fr", "contact23@medecin.fr", "contact24@medecin.fr", "contact25@medecin.fr"
        };

        String[] telephones = {
                "0102030405", "0607080910", "0123456789", "0611223344", "0555667788",
                "0622334455", "0633445566", "0644556677", "0655667788", "0666778899",
                "0677889900", "0688990011", "0699001122", "0610111213", "0612131415",
                "0614151617", "0616171819", "0618192021", "0620212223", "0622232425",
                "0624252627", "0626272829", "0628293031", "0630313233", "0632333435"
        };

        String[] codePostaux = {
                "75001", "75002", "75003", "75004", "75005",
                "75006", "75007", "75008", "75009", "75010",
                "75011", "75012", "75013", "75014", "75015",
                "75016", "75017", "75018", "75019", "75020",
                "75021", "75022", "75023", "75024", "75025"
        };

        Random random = new Random();

        for (int i = 0; i < prenoms.length; i++) {
            Medecin medecin = new Medecin(prenoms[i]);
            medecin.setNom(noms[i]);
            medecin.setAdresse(adresses[i]);
            medecin.setEmail(emails[i]);
            medecin.setTelephone(telephones[i]);
            medecin.setCodePostal(codePostaux[i]);
            medecin.setAgreement(random.nextInt(12345, 60000) + 456);

            // Ajouter des spécialités, un médecin peut en avoir plusieurs
            int nombreDeSpecialites = random.nextInt(1, 4); // Nombre aléatoire entre 1 et 3
            List<SPECIALITES> specialitesDuMedecin = new ArrayList<>();
            while (specialitesDuMedecin.size() < nombreDeSpecialites) {
                SPECIALITES specialite = SPECIALITES.values()[random.nextInt(SPECIALITES.values().length)];
                if (!specialitesDuMedecin.contains(specialite)) {
                    specialitesDuMedecin.add(specialite);
                    medecin.addSpecialite(specialite); // Ajouter la spécialité au médecin
                }
            }
            MEDECINS.add(medecin);
        }
        MEDECINS.getFirst().addSpecialite(SPECIALITES.GENERALE);
    }
    /**
     * Creer une liste de medicaments.
     */
    private static void createMedicaments() {
        String[] nomsMedicament = {
                "amoxicilline", "azithromycine", "méthicilline", "pénicilline",
                "clindamycine", "céfuroxime", "ofloxacine", "ciprofloxacine",
                "tétracycline", "vancomycine"
        };
        Random random = new Random();

        for (String nom : nomsMedicament) {
            Medicament medicament = new Medicament();
            medicament.setNom(nom);

            // Stock aléatoire entre 50 et 200
            medicament.setStock(50 + random.nextInt(151));

            // Prix aléatoire entre 2.0 et 16.0, arrondi à 2 décimales
            float prix = 2.0f + random.nextFloat() * 14.0f;
            medicament.setPrix(Math.round(prix * 100.0f) / 100.0f); // Arrondir à 2 décimales

            // Date de mise en service aléatoire dans les 5 dernières années
            Calendar calendar = Calendar.getInstance();
            // Génère une année dans les 5 dernières
            int yearsOffset = -random.nextInt(5);
            // Génère un jour aléatoire dans cette année
            int daysOffset = random.nextInt(365);
            calendar.add(Calendar.YEAR, yearsOffset);
            calendar.add(Calendar.DAY_OF_YEAR, -daysOffset);
            medicament.setDateMiseEnService(calendar.getTime());

            // Ajouter le médicament à la liste MEDICAMENTS
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
    public static List<Medecin> filtrerMedecinsGeneralistes() {
        return MEDECINS.stream()
                .filter(medecin -> medecin.getSpecialites().contains(SPECIALITES.GENERALE))
                .collect(Collectors.toList());
    }
    public static void createAchats() {
        Random random = new Random();

        for (int i = 0; i < 26; i++) {
            Achat achat = new Achat();

            // Créer une date pour l'achat
            Calendar calendar = Calendar.getInstance();

            // Aléatoirement décider d'utiliser la date du jour ou une date aléatoire autour de la date actuelle
            if (random.nextBoolean()) {
                // Date du jour
                achat.setDateAchat(calendar.getTime());
            } else {
                // Date aléatoire autour de la date actuelle (+/- 30 jours)
                int daysOffset = random.nextInt(61) - 30; // Génère un nombre entre -30 et 30
                calendar.add(Calendar.DAY_OF_MONTH, daysOffset);
                achat.setDateAchat(calendar.getTime());
            }

            // Définir les autres propriétés
            achat.setPrescription(random.nextBoolean());
            achat.setNumeroFacture(1000 + i); // Numéro de facture, par exemple incrémenté de 1000

            Map<Medicament, Integer> medicamentsAchat = new HashMap<>();
            int nombreMedicaments = random.nextInt(5) + 1; // Entre 1 et 5 types de médicaments par achat
            for (int j = 0; j < nombreMedicaments; j++) {
                Medicament medicament = MEDICAMENTS.get(random.nextInt(MEDICAMENTS.size()));
                int quantity = random.nextInt(10) + 1; // Quantité entre 1 et 10
                medicamentsAchat.put(medicament, medicamentsAchat.getOrDefault(medicament, 0) + quantity);
            }
            achat.setMedicaments(medicamentsAchat);
            // Ajouter l'achat à la liste
            ACHATS.add(achat);
        }
    }

    // </editor-fold>
    //****************************************************************************************************************//
}