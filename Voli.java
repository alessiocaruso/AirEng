import java.util.ArrayList;
import java.util.Objects;
import java.text.DecimalFormat;

public class Voli {
    private String nomeCompagnia;
    private int numVolo;
    private int numPosti;
    private String partenza;
    private String destinazione;
    private String orarioPartenza;
    private String orarioArrivo;
    private ArrayList<String> nomePasseggeri;
    private int postiDisponibili;

    public Voli(String nomeCompagnia, int numVolo, int numPosti, String partenza, String destinazione,
            String orarioPartenza, String orarioArrivo, ArrayList<String> nomePass) {
        this.nomeCompagnia = nomeCompagnia;
        this.numVolo = numVolo;
        this.numPosti = numPosti;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.orarioArrivo = orarioArrivo;
        this.orarioPartenza = orarioPartenza;
        this.nomePasseggeri = nomePass;
    }

    public String getNomeCompagnia() {
        return nomeCompagnia;
    }

    public int getNumVolo() {
        return numVolo;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getOrarioPartenza() {
        return orarioPartenza;
    }

    public String getOrarioArrivo() {
        return orarioArrivo;
    }

    public ArrayList getNomePasseggeri() {
        return nomePasseggeri;
    }

    public void stampaInfo() {
        System.out.println("Nome compagnia   : " + nomeCompagnia);
        System.out.println("Numero volo      : " + numVolo);
        System.out.println("Numero posti     : " + numPosti);
        System.out.println("Partenza da      : " + partenza);
        System.out.println("Destinazione     : " + destinazione);
        System.out.println("Orario partenza  : " + orarioPartenza);
        System.out.println("Orario arrivo    : " + orarioArrivo);
        System.out.println("------------------------");
    }

    public void stampaPasseggeri() {
        for (int i = 0; i < nomePasseggeri.size(); i++) {
            System.out.println("Passeggero " + i + ": " + nomePasseggeri.get(i));
        }
    }

    public void prenotaVolo(String nome) {
        numPosti = numPosti - 1;
        System.out.println("Prenotazione effettuata con successo!");
        nomePasseggeri.add(nome);
    }

    public void annullaPrenotazione(String nomeInput) {
        for (int i = 0; i < nomePasseggeri.size(); i++) {
            if (Objects.equals(nomePasseggeri.get(i), nomeInput)) {
                numPosti = numPosti + 1;
                nomePasseggeri.remove(i);
                System.out.println("Prenotazione cancellata con successo!");

            }
        }
    }
}
