public class Main {

    public static void main(String[] args) {
        LineaRetta r1 = new LineaRetta();
        r1.costruzioneImplicita(1, 0, 2);
        System.out.println(r1.getA() + " " + r1.getB() + " " + r1.getC());
    }
}
