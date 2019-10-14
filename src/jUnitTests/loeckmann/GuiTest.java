/**
 * 
 */
package jUnitTests.loeckmann;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import gui.loeckmann.Gui;

/**
 * @author loeckmann
 *
 */
public class GuiTest {

	/**
	 * @throws java.lang.Exception
	 */
	Gui guitest;

	@Before
	public void setUp() throws Exception {
		guitest = new Gui();
	}

	// spezifizierter Test
	//soll die Textfelder mit Gewicht und Groesse auslesen und zurueckgeben
	//der uebergebene String wird in double geparst und soll dem
	//angenommenen Wert entsprechen
	//angenommener Wert positive natuerliche Zahl: Double 60 und angenommener String 60;	
	@Test
	public void testLeseTextfeldDouble() {
		String input = "60";
		double inputDouble = 60.0;
		JTextField tf = new JTextField(input);
		Double res = guitest.leseTextfeldDouble(tf);
		assertTrue(res == inputDouble);
	}
	//unspezifizierter Test
	//wenn die Eingabe keine Zahl und nicht geparst werden kann,
	//soll eine IllegalArgumentException geworfen werden
	//die Eingabe darf nicht negativ oder leer sein	
	@Test(expected = IllegalArgumentException.class)
	public void testLeseTextfeldDoubleUnspezifiziert() {
		String input = "foo";
		JTextField tf = new JTextField(input);
		guitest.leseTextfeldDouble(tf);
	}
	
//	@Test(expected = NumberFormatException.class)
//	public void testLeseTextfeldDoubleUnspezifiziertNullWert() {
//		String input = "";
//		JTextField tf = new JTextField(input);
//		guitest.leseTextfeldDouble(tf);
//	}
	
	//spezifizierter Test
	//soll die Textfelder mit Gewicht und Groesse auslesen und zurueckgeben 
	//der uebergebene String wird in int geparst und soll dem 
	//angenommenen Wert entsprechen
	//angenommener Wert positive natuerliche Zahl: int 60 und angenommener String 60;
	@Test
	public void testLeseTextfeldInt() {
		String input = "60";
		int inputInt = 60;
		JTextField tf = new JTextField(input);
		int res = guitest.leseTextfeldInt(tf);
		assertTrue(res == inputInt);
	}
	
	//unspezifizierter Test
	@Test
	public void testLeseTextfeldIntUnspezifiziert() {
		//nicht gemacht da s.o.
	}
	
	//spezifizierter Test
	//ein double-Wert soll ins Textfeld gesetzt werden
	//Testwert 43.0
	@Test
	public void testSetzeErgebnis() {
		Double res = 43.0;
		JTextField tf = new JTextField();
		String resString = String.format("%.2f",res);
		guitest.setzeErgebnis(res, tf);
		assertTrue(tf.getText().equals(resString));

	}
	
	//unspezifizierter Test
	//Der Wert darf nicht negativ sein, kann aber auch nicht
	
	@Test
	public void testBtnLoeschen() {
		String s = "";
		JTextField tf = new JTextField("foo");
		guitest.loescheForm(tf);
	}
}
