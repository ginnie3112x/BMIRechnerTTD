package gui.loeckmann;

import java.awt.*;
import javax.swing.*;

import dom.loeckmann.BMI;
import dom.loeckmann.BMI.Wertung;
import dom.loeckmann.Person;

import java.awt.event.*;

public class Gui extends JFrame {
	private JTextField tfGroesse;
	private JTextField tfGewicht;
	private JTextField tfResult;
	private JTextField tfAlter;
	private BMI bmiCalc;
	private Person p;
	private JLabel lblresultText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {

		// new BMI
		bmiCalc = new BMI();

		// def Layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JLabel lblTitleh2 = new JLabel(
				"Zur Berechnung Ihres BMI (body mass index) ben\u00F6tigen wir folgende Angaben:");
		getContentPane().add(lblTitleh2);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(6, 2, 10, 0));

		JLabel lblGewicht = new JLabel("Ihr Gewicht (kg)");
		panel.add(lblGewicht);

		this.tfGewicht = new JTextField();
		panel.add(this.tfGewicht);
		this.tfGewicht.setColumns(10);

		JLabel lblGroesse = new JLabel("Ihre Groesse (cm)");
		panel.add(lblGroesse);

		this.tfGroesse = new JTextField();
		panel.add(this.tfGroesse);
		this.tfGroesse.setColumns(10);

		JLabel lblAlter = new JLabel("Alter");
		panel.add(lblAlter);

		this.tfAlter = new JTextField();
		panel.add(this.tfAlter);
		this.tfAlter.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Ihr BMI betraegt\t");
		panel.add(lblNewLabel);

		this.tfResult = new JTextField();
		panel.add(this.tfResult);
		this.tfResult.setColumns(10);
		
		this.lblresultText = new JLabel("");
		panel.add(lblresultText);
		
		JLabel lblLeer = new JLabel("");
		panel.add(lblLeer);

		//liest die Eingabe und verwertet Sie, gibt die Auswertung als String aus
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double gew = leseTextfeldDouble(tfGewicht);
				Double gr = leseTextfeldDouble(tfGroesse);
				int alter = leseTextfeldInt(tfAlter);
				p = new Person(gew, gr, alter);
				double bmiRes = bmiCalc.berechneBMI(p);
				setzeErgebnis(bmiRes, tfResult);
				Wertung wert = bmiCalc.werteAuswerten(alter, bmiRes);
				lblresultText.setText("Sie haben "+ wert);

			}
		});
		getContentPane().add(btnBerechnen);

		//leert das Formular
		JButton btnLoeschen = new JButton("Loeschen");
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField[] tfarr = {tfGewicht, tfGroesse, tfAlter};
				for (JTextField tfs : tfarr)
					loescheForm(tfs);
			}
		});
		getContentPane().add(btnLoeschen);

	}

	//gibt die Werte aus dem Textfeld als double zurueck
	public Double leseTextfeldDouble(JTextField tf) {
		double d = 0;
		try
		{
			d = Double.parseDouble(tf.getText());

		} catch (NumberFormatException e)
		{
			System.out.println("Bitte eine Zahl eingeben");
		}
		if (d > 0)
			return d;
		else
			throw new IllegalArgumentException(
					"Bitte eine Zahl ueber Null eingeben");
	}

	//gibt die Werte aus dem Textfeld als int zurueck
	public int leseTextfeldInt(JTextField tf) {
		int i = 0;
		try
		{
			i = Integer.parseInt(tf.getText());
		} catch (NumberFormatException e)
		{
			System.out.println("Bitte eine Zahl eingeben");
		}
		if (i > 0)
			return i;
		else
			throw new IllegalArgumentException(
					"Bitte eine Zahl ueber Null eingeben");

	}
	//setzt die Ergebnisse in die Textfelder
	public void setzeErgebnis(Double res, JTextField tf) {
		tf.setText(String.format("%.2f", res));

	}
	
	//Löscht das Formular
	public void loescheForm(JTextField tf) {
		tf.setText("");
	}
}
