package dom.loeckmann;

public class BMI {

	private Person person;

	public double berechneBMI(Person p) {
		if (p.getKoerpergewicht() <= 0 || p.getKoerpergroesse() <= 0) {
			throw new IllegalArgumentException("Bitte Werte über Null eingeben!");
		}

		return p.getKoerpergewicht() / Math.pow((p.getKoerpergroesse() / 100), 2);
	}

	public enum Wertung {

		UNTERGEWICHT("Untergewicht"), IDEALGEWICHT("Idealgewicht"), UEBERBEWICHT("Übergewicht");

		private String auswertung;

		private Wertung(String auswertung) {
			this.auswertung = auswertung;
		}

	}

	public Wertung werteAuswerten(int alter, double bmi) {

		if (alter >= 19 && alter <= 24) {
			if (bmi > 24)
				return Wertung.UEBERBEWICHT;

			else if (bmi < 19)
				return Wertung.UNTERGEWICHT;

			else
				return Wertung.IDEALGEWICHT;

		}
		
		if (alter >= 25 && alter <= 34 ) {
			if (bmi > 24)
				return Wertung.UEBERBEWICHT;

			else if (bmi < 20)
				return Wertung.UNTERGEWICHT;

			else
				return Wertung.IDEALGEWICHT;

		}
		
		if (alter >= 35 && alter <= 44  ) {
			if (bmi > 26)
				return Wertung.UEBERBEWICHT;

			else if (bmi < 21)
				return Wertung.UNTERGEWICHT;

			else
				return Wertung.IDEALGEWICHT;

		}
		if (alter >= 45 && alter <= 54  ) {
			if (bmi > 27)
				return Wertung.UEBERBEWICHT;

			else if (bmi < 22)
				return Wertung.UNTERGEWICHT;

			else
				return Wertung.IDEALGEWICHT;

		}
		if (alter >= 55 && alter <= 64  ) {
			if (bmi > 28)
				return Wertung.UEBERBEWICHT;

			else if (bmi < 23)
				return Wertung.UNTERGEWICHT;

			else
				return Wertung.IDEALGEWICHT;

		}
		if (alter > 64  ) {
			if (bmi > 29)
				return Wertung.UEBERBEWICHT;

			else if (bmi < 24)
				return Wertung.UNTERGEWICHT;

			else
				return Wertung.IDEALGEWICHT;

		}
		
		else{
			throw new IllegalArgumentException("Falscher Wert übergeben");
			
		}

		

	}

}
