import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    Kontroll kontroll;
    JFrame vindu;
    JPanel panel, knapper, verktooy, siderute, rutenett;
    JLabel[][] ruter = new JLabel[12][12];
    JLabel lengde;
    JButton stopper, hoyre, venstre, opp, ned;

    GUI (Kontroll k) {
	    kontroll = k;

	    try {
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    } catch (Exception e) {
				System.exit(1);
			}
			// Selve spillvinduet
	    vindu = new JFrame("Slangespillet");
	    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Alt innholdet i spillvinduet
	    panel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    vindu.add(panel);

			// Alt annet enn rutenettet
	    verktooy = new JPanel();
	    verktooy.setLayout(new BorderLayout());
	    panel.add(verktooy, BorderLayout.NORTH);

	    knapper = new JPanel();
	    knapper.setLayout(new BorderLayout());
	    verktooy.add(knapper, BorderLayout.WEST);
	    knapper.setPreferredSize(new Dimension(400, 100));

			// Viser slangens lengde og avslutt-knapp
	    siderute = new JPanel();
	    siderute.setLayout(new BorderLayout());
	    verktooy.add(siderute, BorderLayout.EAST);
	    siderute.setPreferredSize(new Dimension(400, 100));

	    lengde = new JLabel("Lengde: " + kontroll.hentLengde());
	    lengde.setLayout(new BorderLayout());
	    siderute.add(lengde, BorderLayout.NORTH);

	    stopper = new JButton("Avslutt");
	    class Stoppbehandler implements ActionListener {
	        @Override
	        public void actionPerformed (ActionEvent e) {
	            kontroll.lukkSpillet();
	        }
	    }
	    stopper.addActionListener(new Stoppbehandler());
	    siderute.add(stopper, BorderLayout.SOUTH);

	    class Hoyre implements ActionListener {
	        public void actionPerformed (ActionEvent e) {
	            kontroll.retningHoyre();
	        }
	    }
			hoyre = new JButton("Hoyre");
	    hoyre.addActionListener(new Hoyre());
	    knapper.add(hoyre, BorderLayout.EAST);

	    class Venstre implements ActionListener {
	        public void actionPerformed (ActionEvent e) {
	            kontroll.retningVenstre();
	        }
	    }
			venstre = new JButton("Venstre");
	    venstre.addActionListener(new Venstre());
	    knapper.add(venstre, BorderLayout.WEST);

	    class Opp implements ActionListener {
	        public void actionPerformed (ActionEvent e) {
	            kontroll.retningOpp();
	        }
	    }
			opp = new JButton("Opp");
	    opp.addActionListener(new Opp());
	    knapper.add(opp, BorderLayout.NORTH);

	    class Ned implements ActionListener {
	        public void actionPerformed (ActionEvent e) {
	            kontroll.retningNed();
	        }
	    }
			ned = new JButton("Ned");
	    ned.addActionListener(new Ned());
	    knapper.add(ned, BorderLayout.SOUTH);

	    Border border =  BorderFactory.createLineBorder(Color.darkGray);
	    rutenett = new JPanel();
	    rutenett.setLayout(new GridLayout(12,12));
	    for (int rad = 0; rad < 12; rad++) {
        for (int kol = 0; kol < 12; kol++) {
	        JLabel rute = new JLabel(" ");
	        rute.setBorder(border);
	        ruter[rad][kol] = rute;
	        rutenett.add(rute);
	        rute.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
	        rute.setBackground(Color.gray);
	        rute.setOpaque(true);
        }
      }
	    panel.add(rutenett, BorderLayout.SOUTH);
	    vindu.pack();
	    vindu.setVisible(true);
    }

		// Fargeendringer
    void ruteTilHode(int rad, int kol) {
      JLabel rute = ruter[rad][kol];
      rute.setBackground(Color.blue);
    }
    void ruteTilKropp(int rad, int kol) {
      JLabel rute = ruter[rad][kol];
      rute.setBackground(Color.green);
    }
    void slangeTilBakgrunn(int rad, int kol) {
      JLabel rute = ruter[rad][kol];
      rute.setBackground(Color.gray);
    }
    void oppdaterLengde() {
      lengde.setText("Lengde: "+kontroll.hentLengde());
    }
    void bakgrunnTilSkatt(int rad, int kol) {
      JLabel rute = ruter[rad][kol];
      rute.setText(" *");
			rute.setBackground(Color.lightGray);
    }
    void skattTilBakgrunn(int rad, int kol) {
      JLabel rute = ruter[rad][kol];
      rute.setText("");
			rute.setBackground(Color.blue);
    }

}
