package jUnitTests.loeckmann;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import dom.loeckmann.BMI;
import dom.loeckmann.Person;
import dom.loeckmann.BMI.Wertung;

public class BMITest {
	private Person p;
	private BMI bmiClass;

	@Before
	public void setUp() throws Exception {
		bmiClass = new BMI();
	}

	// die Methode soll den gleichen errechneten Wert zurückgeben, wie die
	// "manuelle" Berechnung
	@Test
	public void testBerechneBMISpezifiziert() {
		p = new Person(60, 160);
		double bmi = bmiClass.berechneBMI(p);
		double result = p.getKoerpergewicht() / Math.pow((p.getKoerpergroesse() / 100), 2);
		assertTrue(bmi == result);
System.out.println(bmi);
	}

	// Gewicht muss über 0 sein, Körpergröße muss über 0 sein,

	@Test(expected = IllegalArgumentException.class)
	public void testberechneBMINonSpezifiziert() {
		p = new Person(0, 0);
		double bmi = bmiClass.berechneBMI(p);

	}

	@Test
	public void testWerteAuswertenSpezifizierteWerte() {
		p = new Person(60, 160);
		Wertung result;
		int alter = 0;
		double bmi = 0;
		// angenommen alter >= 19 && alter <= 24, ausgewählter Grenzwert 24
		alter = 24;
		// angenommen BMI- Wert > 24, Grenzwert 24
		bmi = 25;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UEBERBEWICHT);
		// angenommen BMI- Wert < 19 , Grenzwert 19
		bmi = 18;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UNTERGEWICHT);
		// angenommen BMI- Wert bmi >= 19 && <= 24 , Grenzwert 24
		bmi = 24;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.IDEALGEWICHT);

		// angenommen alter >= 25 && alter <= 34 , ausgewählter Grenzwert 25
		alter = 25;
		// angenommen BMI- Wert > 25, Grenzwert 26
		bmi = 26;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UEBERBEWICHT);
		// angenommen BMI- Wert < 20 , Grenzwert 19
		bmi = 19;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UNTERGEWICHT);
		// angenommen BMI- Wert bmi >= 19 && <= 24 , Grenzwert 20
		bmi = 20;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.IDEALGEWICHT);

		// angenommen alter >= 35 && alter <= 44  , ausgewählter Grenzwert 35
		alter = 35;
		// angenommen BMI- Wert > 26, Grenzwert 27
		bmi = 27;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UEBERBEWICHT);
		// angenommen BMI- Wert < 20 , Grenzwert 20
		bmi = 20;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UNTERGEWICHT);
		// angenommen BMI- Wert bmi >= 21 && <= 26 , ausgewählter Grenzwert 21
		bmi = 21;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.IDEALGEWICHT);
		
		// angenommen alter>=45 && alter <= 54   , ausgewählter Grenzwert 45
		alter = 45;
		// angenommen BMI- Wert > 27, Grenzwert 28
		bmi = 28;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UEBERBEWICHT);
		// angenommen BMI- Wert < 22 , Grenzwert 21
		bmi = 21;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UNTERGEWICHT);			
		// angenommen BMI- Wert bmi >= 22 && <= 27 , ausgewählter Grenzwert 22
		bmi = 22;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.IDEALGEWICHT);
		
		// angenommen alter>=55 && alter <= 64   , ausgewählter Grenzwert 55
		alter = 55;
		// angenommen BMI- Wert > 28, Grenzwert 29
		bmi = 29;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UEBERBEWICHT);
		// angenommen BMI- Wert < 23 , Grenzwert 22
		bmi = 22;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UNTERGEWICHT);			
		// angenommen BMI- Wert bmi >= 23 && <= 28 , ausgewählter Grenzwert 23
		bmi = 23;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.IDEALGEWICHT);
		
		// angenommen  < 64 , ausgewählter Grenzwert 65
		alter = 65;
		// angenommen BMI- Wert > 28, Grenzwert 29
		bmi = 30;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UEBERBEWICHT);
		// angenommen BMI- Wert < 23 , Grenzwert 22
		bmi = 23;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.UNTERGEWICHT);			
		// angenommen BMI- Wert bmi >= 24 && <= 29 , ausgewählter Grenzwert 24
		bmi = 24;
		result = bmiClass.werteAuswerten(alter, bmi);
		assertTrue(result == Wertung.IDEALGEWICHT);	

	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testWerteAuswertenUnspezifizierteWerte() {
		
		p = new Person(180, 80);
		Wertung result;
		int alter = 0;
		double bmi = 0;
		//bmi 0
		bmi = 0;
		result = bmiClass.werteAuswerten(alter, bmi);
		
		
		
		
	}

}
