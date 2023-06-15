import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        // Gli ArrayList nomePasseggeri memorizzano i nomi dei passeggeri per ogni volo
        ArrayList<String> nomePasseggeri1 = new ArrayList<>();
        // L'ArrayList voli inserisce nell'array tutti gli oggetti volo
        ArrayList<Voli> voli = new ArrayList<>();
        // Creazioni di un nuovo oggetto volo
        Voli volo1 = new Voli("Ryanair", 1312, 20, "Napoli", "Barcellona", "8.50", "11.50", nomePasseggeri1, 100.00);
        voli.add(volo1); // Aggiunta dell'oggetto volo nell'ArrayList voli che contiene tutti gli oggetti
        ArrayList<String> nomePasseggeri2 = new ArrayList<>();
        Voli volo2 = new Voli("Ryanair", 2314, 30, "Napoli", "Parigi", "11.50", "13.50", nomePasseggeri2, 120.00);
        voli.add(volo2);
        ArrayList<String> nomePasseggeri3 = new ArrayList<>();
        Voli volo3 = new Voli("Easyjet", 1253, 40, "Napoli", "Praga", "10.05", "12.50", nomePasseggeri3, 50.00);
        voli.add(volo3);
        ArrayList<String> nomePasseggeri4 = new ArrayList<>();
        Voli volo4 = new Voli("Easyjet", 4783, 50, "Napoli", "Vienna", "6.05", "8.30", nomePasseggeri4, 70);
        voli.add(volo4);
        ArrayList<String> nomePasseggeri5 = new ArrayList<>();
        Voli volo5 = new Voli("Alitalia", 805, 120, "Roma", "Miami", "8.45", "10.30", nomePasseggeri5, 50);
        voli.add(volo5);
        ArrayList<String> nomePasseggeri6 = new ArrayList<>();
        Voli volo6 = new Voli("Air Dolomiti", 806, 200, "Parigi", "Milano", "9.50", "11.00", nomePasseggeri6, 30);
        voli.add(volo6);
        ArrayList<String> nomePasseggeri7 = new ArrayList<>();
        Voli volo7 = new Voli("Ryanair", 958, 250, "Amsterdam", "Roma", "7.30", "4.30", nomePasseggeri7, 50);
        voli.add(volo7);
        ArrayList<String> nomePasseggeri8 = new ArrayList<>();
        Voli volo8 = new Voli("Vueling", 573, 300, "Bologna", "Napoli", "6.50", "7.20", nomePasseggeri8, 45);
        voli.add(volo8);
        ArrayList<String> nomePasseggeri9 = new ArrayList<>();
        Voli volo9 = new Voli("Blue Air", 592, 250, "Napoli", "Bologna", "7.00", "8.30", nomePasseggeri9, 75);
        voli.add(volo9);
        ArrayList<String> nomePasseggeri10 = new ArrayList<>();
        Voli volo10 = new Voli("Wizz Air", 829, 150, "Parigi", "Torino", "7.30", "9.30", nomePasseggeri10, 160);
        voli.add(volo10);
        ArrayList<String> nomePasseggeri11 = new ArrayList<>();
        Voli volo11 = new Voli("Lufthansa", 5426, 100, "Bologna", "Berlino", "8.0", "14.00", nomePasseggeri11, 200);
        voli.add(volo11);
        ArrayList<String> nomePasseggeri12 = new ArrayList<>();
        Voli volo12 = new Voli("EasyJet", 8421, 20, "Forlì", "Bruxelles", "15.00", "16.30", nomePasseggeri12, 140);
        voli.add(volo12);
        ArrayList<String> nomePasseggeri13 = new ArrayList<>();
        Voli volo13 = new Voli("Ryanair", 7562, 50, "Rimini", "Roma", "10.00", "12.00", nomePasseggeri13, 40);
        voli.add(volo13);
        ArrayList<String> nomePasseggeri16 = new ArrayList<>();
        Voli volo16 = new Voli("Ryanair", 1615, 10, "Roma", "Cracovia", "9.50", "12.50", nomePasseggeri16, 35);
        voli.add(volo16);
        ArrayList<String> nomePasseggeri17 = new ArrayList<>();
        Voli volo17 = new Voli("Ryanair", 2011, 30, "Milano", "Oslo", "18.00", "21.30", nomePasseggeri17, 123);
        voli.add(volo17);
        ArrayList<String> nomePasseggeri18 = new ArrayList<>();
        Voli volo18 = new Voli("Ryanair", 8546, 17, "Napoli", "Berlino", "17.00", "19.30", nomePasseggeri18, 160);
        voli.add(volo18);
        ArrayList<String> nomePasseggeri19 = new ArrayList<>();
        Voli volo19 = new Voli("Ryanair", 1245, 45, "Bergamo", "Zagabria", "10.00", "11.00", nomePasseggeri19, 170);
        voli.add(volo19);
        ArrayList<String> nomePasseggeri20 = new ArrayList<>();
        Voli volo20 = new Voli("Ryanair", 7894, 11, "Napoli", "Verona", "15.00", "16.30", nomePasseggeri20, 180);
        voli.add(volo20);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        System.out.println("Benvenuto!");
        int scelta = 0;
        do {
            // Menu
            System.out.println("Menu:");
            System.out.println("1. Visualizza elenco voli");
            System.out.println("2. Prenota un volo");
            System.out.println("3. Annulla prenotazione");
            System.out.println("4. Visualizza le prenotazioni");
            System.out.println("5. Cercare un volo");
            System.out.println("6. Esci");
            System.out.print("Seleziona un'opzione: ");

            scelta = scannerInt.nextInt(); // scelta del menù
            switch (scelta) {
                case 1:
                    // Stampa informazioni di tutti i voli appartententi all'ArrayList voli
                    for (Voli volo : voli) {
                        volo.stampaInfo();
                    }
                    break;
                case 2:
                    // Prenotazione voli
                    boolean flagPrenotazioni = false;
                    System.out.println("Inserisci il numero del volo che vuoi prenotare");
                    int sceltaVolo = scannerInt.nextInt(); // Scelta del numero di volo
                    for (Voli volo : voli) {
                        if (volo.getNumVolo() == sceltaVolo && volo.getNumPosti() > 0) {
                            // Controllo esistenza numero volo e se quel volo ha disponibilità
                            System.out.println("Ci sono " + volo.getNumPosti() + " posti disponibili per questo volo!");
                            System.out.println("Inserisci il tuo nome e cognome");
                            String datiPasseggero = scannerString.nextLine(); // Inseriamo i dati del passeggero
                            int confermaPrenotazione = 0;
                            do {
                                // Conferma prenotazione
                                System.out.println("Vuoi confermare la tua prenotazione?");
                                System.out.println("1. Conferma la prenotazione");
                                System.out.println("2. Annulla la prenotazione");
                                confermaPrenotazione = scannerInt.nextInt();
                                if (confermaPrenotazione == 1) {
                                    // Se l'utente conferma la prenotazione allora chiamiamo il metodo prenotaVolo
                                    int sceltaPagamento = 0;
                                    do {
                                        System.out.println(
                                                "Questo volo ha un costo di " + volo.getPrezzoVolo() + " euro."); // stampa
                                                                                                                  // prezzo
                                                                                                                  // volo
                                        System.out.println("Vuoi confermare il pagamento?");
                                        System.out.println("1. Conferma il pagamento");
                                        System.out.println("2. Annulla il pagamento");
                                        sceltaPagamento = scannerInt.nextInt();
                                        if (sceltaPagamento == 1) {
                                            volo.prenotaVolo(datiPasseggero);
                                            break;
                                        } else if (sceltaPagamento == 2) {
                                            System.out.println("Hai annullato il pagamento");
                                            break;
                                        }
                                    } while (sceltaPagamento != 2);
                                    // volo.stampaPasseggeri();
                                    break;
                                } else if (confermaPrenotazione == 2) {
                                    // Se l'utente non conferma la prenotazione ritorna al menù
                                    System.out.println("Hai annullato la prenotazione!");

                                    break;
                                } else if (confermaPrenotazione > 2) {
                                    // Se l'utente preme un tasto sbagliato ritorna al menù
                                    System.out.println("Hai inserito un numero errato, riprova");
                                    break;
                                }
                            } while (confermaPrenotazione != 2);

                        }
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il numero del volo che vuoi disdire");
                    int sceltaVolo1 = scannerInt.nextInt();
                    for (Voli volo : voli) {
                        if (volo.getNumVolo() == sceltaVolo1) { // Controllo esistenza numero volo
                            System.out.println("Inserisci il tuo nome e cognome");
                            String datiPasseggero = scannerString.nextLine(); // Inseriamo i dati del passeggero
                            int annullaPrenotazione = 0;
                            do {
                                // Conferma disdetta
                                System.out.println("Vuoi confermare la tua disdetta?");
                                System.out.println("1. Conferma la disdetta");
                                System.out.println("2. Annulla la disdetta");
                                annullaPrenotazione = scannerInt.nextInt();
                                if (annullaPrenotazione == 1) {

                                    for (int i = 0; i < volo.getNumPosti(); i++) { // Controlliamo per tutti i
                                                                                   // passeggeri se esiste il passeggero
                                                                                   // con il nome inserito da tastiera
                                        // if (volo.getNumVolo() == sceltaVolo1) {}
                                        volo.annullaPrenotazione(datiPasseggero); // Metodo per confrontare i dati del
                                                                                  // passeggero e per aggiornare la
                                                                                  // lista passeggeri e il numero di
                                                                                  // passeggeri del volo
                                    }

                                    break;
                                } else if (annullaPrenotazione == 2) {
                                    // Se l'utente non conferma la disdetta ritorna al menù
                                    System.out.println("Hai annullato la disdetta!");
                                    break;
                                } else if (annullaPrenotazione > 2) {
                                    // Se l'utente preme un tasto sbagliato ritorna al menù
                                    System.out.println("Hai inserito un numero errato, riprova");
                                }
                            } while (annullaPrenotazione != 2);
                        }

                    }
                    break;
                case 4:
                    // Visualizza le prenotazioni per tutti i voli
                    for (Voli volo : voli) {
                        System.out.println("Numero volo: " + volo.getNumVolo());
                        volo.stampaPasseggeri();
                        System.out.println("------------------------");

                    }
                    break;

                case 5:
                    // Visualizza un volo specifico
                    int count = 0;
                    System.out.println("Inserisci luogo di partenza");
                    String sceltaPartenza = scannerString.nextLine();
                    System.out.println("Inserisci luogo di destinazione");
                    String sceltaDestinazione = scannerString.nextLine();
                    for (Voli volo : voli) {
                        if (Objects.equals(volo.getPartenza(), sceltaPartenza)
                                && Objects.equals(volo.getDestinazione(), sceltaDestinazione)) {
                            count = count + 1; // incrementiamo la count ogni volta che troviamo il volo
                            volo.stampaInfo();
                        }

                    }
                    if (count == 0) { // se la count è zero vuol dire che non abbiamo trovato voli
                        System.out.println("Non è stato trovato nessun volo");
                        break;
                    }
                    break;
                case 6:
                    System.out.println("Grazie e arrivederci");
                    return;
                default:
                    System.out.println("Non hai inserito una scelta giusta");
                    break;
            }
        } while (scelta != 6);
    }
}
