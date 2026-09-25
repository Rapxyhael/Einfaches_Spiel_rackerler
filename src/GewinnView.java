import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        this.setLayout(new BorderLayout());


        JPanel obenPanel = new JPanel(new GridLayout(3, 2, 5, 5));

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

        obenPanel.add(rundenTitel);
        obenPanel.add(gesamtTitel);
        obenPanel.add(this.rundenErgebnisLabel);
        obenPanel.add(this.gesamtPunkteLabel);
        obenPanel.add(spielerTitel);
        obenPanel.add(computerTitel);



        JPanel mittePanel = new JPanel(new GridLayout(1, 2, 10, 0));
        mittePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.spielerZahlFeld = new JTextField();
        this.spielerZahlFeld.setHorizontalAlignment(JTextField.CENTER);
        this.spielerZahlFeld.setActionCommand("eingabe");

        this.computerZahlFeld = new JTextField();
        this.computerZahlFeld.setHorizontalAlignment(JTextField.CENTER);
        this.computerZahlFeld.setEditable(false);
        this.computerZahlFeld.setBackground(Color.WHITE);

        mittePanel.add(this.spielerZahlFeld);
        mittePanel.add(this.computerZahlFeld);


        JPanel untenPanel = new JPanel(new FlowLayout());

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

    public String getSpielerZahl() {
        return this.spielerZahlFeld.getText();
    }

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
