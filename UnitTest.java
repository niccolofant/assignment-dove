import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class UnitTest {

    /**
     * Tests for the costruzioneImplicita() method
     */
    @Test
    public void Should_Throw_If_A_And_B_Are_Zero_Simultaneously() {
        LineaRetta retta = new LineaRetta();
        assertThrows("`a` e `b` non possono essere uguali a 0 contemporaneamente", AssertionError.class, () -> {
            retta.costruzioneImplicita(0, 0, 3);
        });
    }

    @Test
    public void Should_Save_The_Correct_Values() {
        LineaRetta retta = new LineaRetta();
        retta.costruzioneImplicita(1, 2, 3);
        assertEquals(1, retta.getA(), 0);
        assertEquals(2, retta.getB(), 0);
        assertEquals(3, retta.getC(), 0);
    }

    /**
     * Test for the costruzioneEsplicita() method
     */
    @Test
    public void Should_Convert_Explicit_To_Implicit() {
        LineaRetta retta = new LineaRetta();
        retta.costruzioneEsplicita(-0.5, -0.75);
        assertEquals(0.5, retta.getA(), 0);
        assertEquals(1, retta.getB(), 0);
        assertEquals(0.75, retta.getC(), 0);
    }

    /**
     * Tests for the costruzionePerPunti() method
     */

    @Test
    public void Should_Throw_If_The_Points_Are_The_Same() {
        Punto punto1 = new Punto(2, 1);
        Punto punto2 = new Punto(2, 1);
        LineaRetta retta = new LineaRetta();
        assertThrows("I due punti non possono avere le stesse coordinate", AssertionError.class, () -> {
            retta.costruzionePerPunti(punto1, punto2);
            ;
        });
    }

    @Test
    public void Should_Convert_Points_To_Implicit() {
        Punto punto1 = new Punto(2, -3);
        Punto punto2 = new Punto(3, -1);
        LineaRetta retta = new LineaRetta();
        retta.costruzionePerPunti(punto1, punto2);
        assertEquals(-2, retta.getA(), 0);
        assertEquals(1, retta.getB(), 0);
        assertEquals(7, retta.getC(), 0);
    }

    /**
     * Tests for the verificaParallellismo() method
     */
    @Test
    public void Should_Return_True_If_Two_Lines_Are_Parallel() {
        LineaRetta retta1 = new LineaRetta();
        retta1.costruzioneImplicita(4, -2, 8);
        LineaRetta retta2 = new LineaRetta();
        retta2.costruzioneImplicita(-8, 4, -2);
        assertEquals(true, retta1.verificaParallellismo(retta2));
    }

    @Test
    public void Should_Return_False_If_Two_Lines_Arent_Parallel() {
        LineaRetta retta1 = new LineaRetta();
        retta1.costruzioneImplicita(2, 3, 4);
        LineaRetta retta2 = new LineaRetta();
        retta2.costruzioneImplicita(2, -3, 4);
        assertEquals(false, retta1.verificaParallellismo(retta2));
    }

    /**
     * Tests for the verificaPerpendicolarita() method
     */

    @Test
    public void Should_Return_True_If_Two_Lines_Are_Perpendicolar() {
        LineaRetta retta1 = new LineaRetta();
        retta1.costruzioneImplicita(2, 6, -5);
        LineaRetta retta2 = new LineaRetta();
        retta2.costruzioneImplicita(-3, 1, 4);
        assertEquals(true, retta1.verificaPerpendicolarita(retta2));
    }

    @Test
    public void Should_Return_False_If_Two_Lines_Arent_Perpendicolar() {
        LineaRetta retta1 = new LineaRetta();
        retta1.costruzioneImplicita(4, -2, 8);
        LineaRetta retta2 = new LineaRetta();
        retta2.costruzioneImplicita(-8, 4, -2);
        assertEquals(false, retta1.verificaPerpendicolarita(retta2));
    }

}