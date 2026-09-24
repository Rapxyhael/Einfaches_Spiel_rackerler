import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        if (e.getActionCommand().equals("eingabe")) {   //Checkt auf Enter, nochmal erst beim nächsten schritt
            int spielerZahl = Integer.parseInt(this.view.getSpielerZahl()); //holt eingegebene Zahl
            this.model.berechneComputerZahl();
            this.model.berechneRunde(spielerZahl);

            this.view.setComputerZahl("" + this.model.getComputerZahl()); //zeigt die ComputerZahl an
            if (this.model.getRundenErgebnis() > 0) {
                this.view.setRundenErgebnis("+" + this.model.getRundenErgebnis()); //Bei positivem Ergebnis

            } else {
                this.view.setRundenErgebnis("" + this.model.getRundenErgebnis()); //Bei minus Zahlen
            }
            this.view.setGesamtPunkte("" + this.model.getGesamtPunkte());
        }
    }

    public static void main(String[] args) {
        new GewinnController();
    }
}