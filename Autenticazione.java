import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Autenticazione {
    public ArrayList<String> username = new ArrayList<>();
    public ArrayList<String> password = new ArrayList<>();
    public ArrayList<Voli> voli = new ArrayList<>();
    public String currentUser; // Ci serve per rimozione, modifica e lettura degli utenti

        public void menuAutenticazione(ArrayList<Voli> voli) {
        int scelta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cosa vuoi fare?:");
        System.out.println("1. Registrazione");
        System.out.println("2. Login");
        System.out.println("3. Login master");
        System.out.println("4. Uscire");
        System.out.print("Seleziona un'opzione: ");
        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                registration();
                System.out.println("LOGIN:");
                verify();
                break;
            case 2:
                verify();
                break;
            case 3:
                loginMaster(voli);

                break;
            case 4:
                System.out.println("Grazie per aver usato la nostra app!");
                System.exit(0);

            default:
                System.out.println("Scelta non valida");
                break;
        }

    }
public void menuMaster(ArrayList<Voli> voli) {
        int scelta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Aggiungi un volo");
        System.out.println("2. Elimina volo");
        System.out.println("3. Elimina user");
        System.out.println("4. Modifica username");
        System.out.println("5. Visualizza lista utenti");
        System.out.println("6. Menu autenticazione");
        System.out.println("7. Esci");
        scelta = scanner.nextInt();
        switch (scelta) {

            case 1:
                aggiungiVolo(voli);
                menuMaster(voli);
                break;

            case 2:
                rimuovoVolo(voli);
                menuMaster(voli);
                break;

            case 3:
                deleteUser();
                break;
            case 4:

                modifyUser();
                break;
            case 5:
                readUser();
                break;
            case 6:
                menuAutenticazione(voli);
                break;
            case 7:
                System.out.println("Grazie per aver utilizzato la nostra app!");
                System.exit(0);
                return;
            default:
                System.out.println("Scelta non corretta");

        }
    }

    public void registration() {
        // Registrazione
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un nuovo username");
        String usernameString = scanner.nextLine();
        System.out.println("Inserisci una password");
        String passwordString = scanner.nextLine();
        if (username.contains(usernameString)) {
            // Se esiste già un utente con quell'username la registrazione fallirà
            System.out.println("Username già in uso. Registrazione fallita.");
            return;
        }
        // aggiunta dei dati nei database username e password
        username.add(usernameString);
        password.add(passwordString);
    }

    public int verify() {
        // Verifica per il login
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Inserisci il tuo username");
        String usernameVerify = scanner.nextLine();
        System.out.println("Inserisci la tua password");
        String passwordVerify = scanner.nextLine();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);
            String currentPassword = password.get(i);

            if (currentUsername.equals(usernameVerify) && currentPassword.equals(passwordVerify)) {
                // Se le credenziali sono giuste l'utente potrà accedere e impostiamo la
                // booleana a true
                System.out.println("ACCESSO CONSENTITO");
                isValid = true;
                // Salviamo il nome dell'User perchè ci servirà per il database
                currentUser = currentUsername;
                break;
            }
        }
        if (isValid) {
            // Se l'utente si logga ritorniamo il valore 1, altrimenti 0
            return 1;
        } else {
            return 0;
        }
    }


    public void loginMaster(ArrayList<Voli> voli) {
        // Verifica per il login
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Inserisci PIN segreto");
        int pinVerify = scanner.nextInt();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali

        if (pinVerify == 1234) {
            System.out.println("Accesso consentito");
            menuMaster(voli);

        } else {
            System.out.println("Accesso negato!");
            return; // chiusura dell'applicazione
        }
    }

    
    public void aggiungiVolo(ArrayList<Voli> voli) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerDouble = new Scanner(System.in);
        System.out.println("Inserisci il nome della compagnia");
        String nomeCompagnia = scanner.nextLine();
        System.out.println("Inserisci il numero del volo");
        int numVolo = scannerInt.nextInt();
        // Vediamo se ID del nuovo è già esistente
        for (Voli volo : voli) {
            if (numVolo == volo.getNumVolo()) {
                System.out.println("ID volo già esistente, impossibile aggiungere questo volo");
                System.exit(0);
            }
        }
        System.out.println("Inserisci il numero dei posti");
        int numPosti = scannerInt.nextInt();
        System.out.println("Inserisci il luogo di partenza");
        String partenza = scanner.nextLine();
        System.out.println("Inserisci il luogo di destinazione");
        String destinazione = scanner.nextLine();
        System.out.println("Inserisci orario di partenza");
        String orarioPartenza = scanner.nextLine();
        System.out.println("Inserisci orario di arrivo");
        String orarioArrivo = scanner.nextLine();
        ArrayList<String> nomePasseggeri = new ArrayList<>();
        System.out.println("Inserisci il prezzo del volo");
        double prezzoVolo = scannerDouble.nextDouble();
        Voli nuovoVolo = new Voli(nomeCompagnia, numVolo, numPosti, partenza, destinazione, orarioPartenza,
                orarioArrivo, nomePasseggeri, prezzoVolo);
        voli.add(nuovoVolo);
    }

    public void rimuovoVolo(ArrayList<Voli> voli) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("Inserisci il numero del volo");
        int numVolo = scannerInt.nextInt();
        Voli voloDaRimuovere = null; // creiamo un oggetto Voli

        for (Voli volo : voli) {
            if (numVolo == volo.getNumVolo()) {
                // Se il numero del volo è esistente salviamo il volo nell'oggetto
                // voloDaRimuovere
                voloDaRimuovere = volo;
                break;
            }
        }
        if (voloDaRimuovere != null) {
            // Se voloDaRimuovere non è vuoto allora rimuoviamo il volo dall'arraylist voli
            voli.remove(voloDaRimuovere);
            System.out.println("Volo eliminato correttamente");
        } else {
            // Altrimenti se non troviamo nessun volo con quell'id non rimuoviamo niente
            System.out.println("Nessun volo trovato con il numero specificato");
        }

    }
   public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci username che vuoi eliminare");
        String usernameVerify = scanner.nextLine();

        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);

            if (currentUsername.equals(usernameVerify)) {
                username.remove(i);
                password.remove(i);
                System.out.println("Utente eliminato correttamente");
                break;
            }
        }
    }

    public void modifyUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il tuo username");
        String usernameVerify = scanner.nextLine();
        System.out.println("Inserisci la tua password");
        String passwordVerify = scanner.nextLine();

        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);
            String currentPassword = password.get(i);

            if (currentUsername.equals(usernameVerify) && currentPassword.equals(passwordVerify)) {
                System.out.println("ACCESSO CONSENTITO");
                System.out.println("Inserisci il nuovo username");
                String newUsername = scanner.nextLine();
                username.set(i, newUsername);
                currentUser = newUsername;
                System.out.println("Username modificato correttamente");
                break;
            } else {
                System.out.println("Accesso non consentito");
                break;
            }
        }
    }


    public void readUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci PIN segreto per la visualizzazione della lista di utenti registrati");
        int pinVerify = scanner.nextInt();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        if (pinVerify == 1234) {
            System.out.println("Accesso consentito");

            for (int i = 0; i < username.size(); i++) {
                String currentUsername = username.get(i);
                System.out.println("Username: " + i + ": " + currentUsername);

            }
        } else {
            System.out.println("Accesso non consentito");

        }
    }

}
