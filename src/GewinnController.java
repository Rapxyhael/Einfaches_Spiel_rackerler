import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * Controller des Spiels
 * Verbindet Model und View reagiert auf Benutzereingaben und aktualisiert das GUI nach jeder runde
 * @author Raphael Ackerler
 * @version 2.0
 */
public class GewinnController implements ActionListener {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController() {
        this.model = new GewinnModel();
        this.view = new GewinnView();
        this.view.addController(this);
        this.view.setGesamtPunkte("Gesamtpunkte: " + this.model.getGesamtPunkte());
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eingabe")) {   //Checkt auf Enter
            int spielerZahl;
            try {
                spielerZahl = Integer.parseInt(this.view.getSpielerZahl().trim());
            } catch (NumberFormatException ex) {                    //Catcht falls keine Nummer eingegeben wurde
                this.view.setRundenErgebnis("Ungültige Eingabe");
                return;
            }
            if (spielerZahl < 1 || spielerZahl > 9) {
                this.view.setRundenErgebnis("Nur 1 bis 9!");
                return;
            }
            this.model.berechneComputerZahl();
            this.model.berechneRunde(spielerZahl);

            this.view.setComputerZahl("" + this.model.getComputerZahl()); //zeigt die ComputerZahl an
            if (this.model.hatGewonnen()) {
                this.view.setRundenErgebnis("Gewonnen");        //Falls das gesamte Spiel verloren
            } else if (this.model.hatVerloren()) {
                this.view.setRundenErgebnis("Verloren");        //Falls das gesamte Spiel gewonnen
            } else if (this.model.getRundenErgebnis() > 0) {
                this.view.setRundenErgebnis("+" + this.model.getRundenErgebnis()); //Bei positivem Ergebnis
            } else {
                this.view.setRundenErgebnis("" + this.model.getRundenErgebnis()); //Bei negativem Ergebnis
            }
            this.view.setGesamtPunkte("" + this.model.getGesamtPunkte());
            this.view.setEingabeAn(false);               //Eingabe sperren nach der Runde
            this.view.setNochEinmalKnopfAn(true);        //Noch einmal Button freigeben

            if (this.model.hatGewonnen()) {                     //Wahnsinnig unnötig und Code Verdopplung aber es entsteht zu 100% ein Merge Konflikt
                this.view.setLabelFarbe(Color.GREEN);
            } else if (this.model.hatVerloren()) {
                this.view.setLabelFarbe(Color.RED);
            } else if (this.model.getRundenErgebnis() > 0) {
                this.view.setLabelFarbe(Color.GREEN);
            } else if (this.model.getRundenErgebnis() < 0) {
                this.view.setLabelFarbe(Color.RED);
            } else {
                this.view.setLabelFarbe(Color.WHITE);
            }

        } else if (e.getActionCommand().equals("nochmal")) {       //Checkt auf den nochmal Knopf und setzt halt alles zurück
            this.view.setSpielerZahl("");
            this.view.setComputerZahl("");
            this.view.setRundenErgebnis("Tippe eine zahl von 1 bis 9");
            this.view.setEingabeAn(true);           //Eingabe wieder freigeben
            this.view.setNochEinmalKnopfAn(false);       //Button wieder sperren
            this.view.setLabelFarbe(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        new GewinnController();
    }
}