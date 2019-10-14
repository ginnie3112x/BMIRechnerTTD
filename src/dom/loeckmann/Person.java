package dom.loeckmann;

public class Person {
	private double koerpergewicht;
	private double koerpergroesse;
	private int alter;
	private double bmi;

	public Person(double koerpergewicht, double koerpergroesse, int alter) {
		super();
		this.koerpergewicht = koerpergewicht;
		this.koerpergroesse = koerpergroesse;
		this.alter = alter;
	}

	public Person(double koerpergewicht, double koerpergroesse) {
		this(koerpergewicht, koerpergroesse, 25);

	}

	public double getKoerpergewicht() {
		return koerpergewicht;
	}

	public void setKoerpergewicht(double koerpergewicht) {
		this.koerpergewicht = koerpergewicht;
	}

	public double getKoerpergroesse() {
		return koerpergroesse;
	}

	public void setKoerpergroesse(double koerpergroesse) {
		this.koerpergroesse = koerpergroesse;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

}
