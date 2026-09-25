import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View des Spiels
 * Zeigt das GUI an und beinhaltet Methoden zum Anzeigen, ändern und um Eingaben auszulesen.
 * @author Raphael Ackerler
 * @version 2.0
 */
public class GewinnView extends JFrame {

    private JLabel rundenErgebnisLabel;
    private JLabel gesamtPunkteLabel;
    private JTextField spielerZahlFeld;
    private JTextField computerZahlFeld;
    private JButton nochEinmalKnopf;

    public GewinnView() {
        this.setTitle("Zahlen-Gewinnspiel (v1.0)");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout()); //Zur Übersicht


        JPanel obenPanel = new JPanel(new GridLayout(3, 2, 5, 5));  //Erstes von 3 Panel

        JLabel rundenTitel = new JLabel("Rundenergebnis:", JLabel.CENTER);

        JLabel gesamtTitel = new JLabel("Gesamtpunkte:", JLabel.CENTER);


        this.rundenErgebnisLabel = new JLabel("Tippe eine Zahl von 1 bis 9", JLabel.CENTER);

        this.rundenErgebnisLabel.setOpaque(true);
        this.rundenErgebnisLabel.setBackground(Color.WHITE);

        this.gesamtPunkteLabel = new JLabel("", JLabel.CENTER);

        this.gesamtPunkteLabel.setOpaque(true);
        this.gesamtPunkteLabel.setBackground(Color.WHITE);

        JLabel spielerTitel = new JLabel("Deine Zahl:", JLabel.CENTER);
        JLabel computerTitel = new JLabel("Computer:", JLabel.CENTER);

        obenPanel.add(rundenTitel);                //Alle Komponenten werden hinzugefügt
        obenPanel.add(gesamtTitel);
        obenPanel.add(this.rundenErgebnisLabel);
        obenPanel.add(this.gesamtPunkteLabel);
        obenPanel.add(spielerTitel);
        obenPanel.add(computerTitel);



        JPanel mittePanel = new JPanel(new GridLayout(1, 2, 10, 0));        //Das mittlere Panel das die TextFelder hält 3 Attribut macht den Abstand zwischen den Feldern
        mittePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));   //BorderFactory bringt einfach einen leichten Außenabstand an

        this.spielerZahlFeld = new JTextField();
        this.spielerZahlFeld.setHorizontalAlignment(JTextField.CENTER);
        this.spielerZahlFeld.setActionCommand("eingabe");

        this.computerZahlFeld = new JTextField();
        this.computerZahlFeld.setHorizontalAlignment(JTextField.CENTER);
        this.computerZahlFeld.setEditable(false);
        this.computerZahlFeld.setBackground(Color.WHITE);

        mittePanel.add(this.spielerZahlFeld);
        mittePanel.add(this.computerZahlFeld);


        JPanel untenPanel = new JPanel(new FlowLayout());   //Letztes Panel das den Knopf hält

        this.nochEinmalKnopf = new JButton("Noch einmal!");
        this.nochEinmalKnopf.setActionCommand("nochmal");
        this.nochEinmalKnopf.setEnabled(false);

        untenPanel.add(this.nochEinmalKnopf);

        this.add(obenPanel, BorderLayout.NORTH);
        this.add(mittePanel, BorderLayout.CENTER);
        this.add(untenPanel, BorderLayout.SOUTH);
    }

    public void addController(ActionListener listener) {
        this.spielerZahlFeld.addActionListener(listener);
        this.nochEinmalKnopf.addActionListener(listener);
    }

    public String getSpielerZahl() {            //Damit der Controller Zugriff auf die eingegebene Zahl hat.
        return this.spielerZahlFeld.getText();
    }

    //Setter Methoden die es dem Controller ermöglichen alles Mögliche zu verändern.
    public void setSpielerZahl(String text) {
        this.spielerZahlFeld.setText(text);
    }

    public void setComputerZahl(String text) {
        this.computerZahlFeld.setText(text);
    }
    public void setRundenErgebnis(String text) {
        this.rundenErgebnisLabel.setText(text);
    }

    public void setGesamtPunkte(String text) {
        this.gesamtPunkteLabel.setText(text);
    }

    public void setEingabeAn(boolean an) {
        this.spielerZahlFeld.setEnabled(an);
    }

    public void setNochEinmalKnopfAn(boolean an) {
        this.nochEinmalKnopf.setEnabled(an);
    }

    public void setLabelFarbe(Color farbe) {
        this.rundenErgebnisLabel.setBackground(farbe);
        this.gesamtPunkteLabel.setBackground(farbe);
    }
}
