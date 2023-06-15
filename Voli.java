import java.util.ArrayList;
import java.util.Objects;

public class Voli {
    // Proprietà dei Voli
    private String nomeCompagnia;
    private int numVolo;
    private int numPosti;
    private String partenza;
    private String destinazione;
    private String orarioPartenza;
    private String orarioArrivo;
    private ArrayList<String> nomePasseggeri;
    private double prezzoVolo;

    // Costruttore per creare gli oggetti Volo
    public Voli(String nomeCompagnia, int numVolo, int numPosti, String partenza, String destinazione,
            String orarioPartenza, String orarioArrivo, ArrayList<String> nomePass, double prezzoVolo) {
        this.nomeCompagnia = nomeCompagnia;
        this.numVolo = numVolo;
        this.numPosti = numPosti;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.orarioArrivo = orarioArrivo;
        this.orarioPartenza = orarioPartenza;
        this.nomePasseggeri = nomePass;
        this.prezzoVolo = prezzoVolo;
    }

    // Metodo per ottenere il nome della compagnia
    public String getNomeCompagnia() {
        return nomeCompagnia;
    }

    // Metodo per ottenere il numero del volo
    public int getNumVolo() {
        return numVolo;
    }

    // Metodo per ottenere il numero dei posti
    public int getNumPosti() {
        return numPosti;
    }

    // Metodo per ottenere il luogo di partenza
    public String getPartenza() {
        return partenza;
    }

    // Metodo per ottenere il luogo di destinazione
    public String getDestinazione() {
        return destinazione;
    }

    // Metodo per ottenere l'orario di partenza
    public String getOrarioPartenza() {
        return orarioPartenza;
    }

    // Metodo per ottenere l'orario di arrivo
    public String getOrarioArrivo() {
        return orarioArrivo;
    }

    // Metodo per ottenere il nome dei passeggeri
    public ArrayList getNomePasseggeri() {
        return nomePasseggeri;
    }

    // Metodo per ottenere prezzo volo
    public double getPrezzoVolo() {
        return prezzoVolo;
    }

    // Metodo per stampare le informazioni dei voli

    //CASO 1
    public void stampaInfo() {
        // Stampa del tabellone orizzontale
        System.out.printf("| %-15s | %-9d | %-10d | %-8s | %-12s | %-15s | %-13s | %-11.2f |\n",
                nomeCompagnia, numVolo, numPosti, partenza, destinazione,
                orarioPartenza, orarioArrivo, prezzoVolo);

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------");
    }

  

    //CASO 2
    // Metodo per prenotare il volo
    public void prenotaVolo(String datiPasseggero) {
        numPosti = numPosti - 1; // Riduce il numero di posti
        System.out.println("Prenotazione effettuata con successo!");
        System.out.println("Importo pagato: " + prezzoVolo + " euro");
        nomePasseggeri.add(datiPasseggero); // aggiunge il nome del passeggero all'ArrayList contentente i nomi dei
                                  // passeggeri di quel volo
    }

    //Aggiunta costo del posto con finestrino
    public void prezzoConFinestrino() {
        prezzoVolo = prezzoVolo + 20;
    }
    //Ritorno al valore originale del prezzo senza finestrino
    public void fixaPrezzoFinestrino() {
        prezzoVolo = prezzoVolo - 20;
    }

    public void stampaBiglietto() {
        // Stampa del biglietto aereo
        System.out.println("----------------------------------------------------");
        System.out.println("Nome compagnia: " + nomeCompagnia);
        System.out.println("Numero volo: " + numVolo);
        System.out.println("Partenza: " + partenza);
        System.out.println("Destinazione: " + destinazione);
        System.out.println("Orario partenza: " + orarioPartenza);
        System.out.println("Orario arrivo: " + orarioArrivo);
        System.out.println("Prezzo volo: " + prezzoVolo + " euro");
        System.out.println("----------------------------------------------------");
    }

    //CASO 3
    // Metodo per annullare la prenotazione
    public int annullaPrenotazione(String nomeInput) {
        for (int i = 0; i < nomePasseggeri.size(); i++) { // Ciclo che scorre tutti i nomi dei passeggeri
            if (Objects.equals(nomePasseggeri.get(i), nomeInput)) { // Confronta se il nome inserito da tastiera
                                                                    // corrisponde ad uno dei passeggeri di quel volo
                // se corrisponde, incrementiamo il numero di posti e rimuoviamo il passeggero
                // dall'ArrayList
                numPosti = numPosti + 1;
                nomePasseggeri.remove(i);
                int flag=1;
                return flag;
            }
        }
        return 1000;
    }

    //CASO 4
      // Metodo per stampare le informazioni dei passeggeri
    public void stampaPasseggeri() {
        for (int i = 0; i < nomePasseggeri.size(); i++) {
            System.out.println("Passeggero " + i + ": " + nomePasseggeri.get(i));
        }
    }

    //CASO 5
    //Nessun metodo nella classe Voli
}
