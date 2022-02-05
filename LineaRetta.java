public class LineaRetta {

    private double a;
    private double b;
    private double c;

    /**
     * Metodo utilizzato per la costruzione di una linea retta attraverso
     * la forma implicita (ax + by + c = 0)
     * 
     * @param a Primo parametro
     * @param b Secondo parametro
     * @param c Terzo parametro
     */
    public void costruzioneImplicita(double a, double b, double c) {
        if (a == 0)
            assert b != 0 : "`a` e `b` non possono essere uguali a 0 contemporaneamente";
        if (b == 0)
            assert a != 0 : "`a` e `b` non possono essere uguali a 0 contemporaneamente";

        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Metodo utilizzato per la costruzione di una linea retta attraverso
     * la forma esplicita (y = mx + q)
     * 
     * @param m Coefficiente angolare
     * @param q Ordinata all'origine
     */
    public void costruzioneEsplicita(double m, double q) {
        this.a = -m;
        this.b = 1;
        this.c = -q;
    }

    /**
     * Metodo utilizzato per la costruzione di una linea retta attraverso
     * le coordinate di due punti
     * 
     * @param punto1 Coordinate del primo punto
     * @param punto2 Coordinate del secondo punto
     */
    public void costruzionePerPunti(Punto punto1, Punto punto2) {
        if (punto1.getX() == punto2.getX())
            assert punto1.getY() != punto2.getY() : "I due punti non possono avere le stesse coordinate";
        if (punto1.getY() == punto2.getY())
            assert punto1.getX() != punto2.getX() : "I due punti non possono avere le stesse coordinate";

        // Trasformazione in forma esplicita
        double m = (punto2.getY() - punto1.getY()) / (punto2.getX() - punto1.getX());
        double q = punto1.getY() - punto1.getX() * m;

        // Trasformazione in forma implicita
        costruzioneEsplicita(m, q);
    }

    /**
     * Metodo utilizzato per controllare se due rette sono parallele
     * 
     * @param retta2 Linea retta messa a confronto
     * @return se le due rette sono parallele o meno
     */
    public boolean verificaParallellismo(LineaRetta retta2) {
        return (this.a * retta2.b == retta2.a * this.b);
    }

    /**
     * Metodo utilizzato per controllare se due rette sono perpendicolari
     * 
     * @param retta2 Linea retta messa a confronto
     * @return se le due rette sono perpendicolari o meno
     */
    public boolean verificaPerpendicolarita(LineaRetta retta2) {
        return (this.a * retta2.a + this.b * retta2.b == 0);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
