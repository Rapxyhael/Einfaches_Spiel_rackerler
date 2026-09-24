/**
 *
 */
public class GewinnModel {

    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel(){
        this.gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public void berechneComputerZahl(){
        this.computerZahl = (int)(Math.random() * 9 + 1);
    }

    public void berechneRunde(int spielerZahl){
        this.spielerZahl = spielerZahl;
        if(spielerZahl == this.computerZahl){
            this.rundenErgebnis = 20;
        } else if (spielerZahl == this.computerZahl + 1 || spielerZahl == this.computerZahl - 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte += this.rundenErgebnis;

    }

    public boolean hatGewonnen(){
        if (this.gesamtPunkte >= 100){
            return true;
        }
        return false;
    }
    public boolean hatVerloren(){
        if (this.gesamtPunkte <= 0){
            return true;
        }
        return false;
    }

}
