package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorBoundaryTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    @Test
    void letterGradeAt60ReturnsD() {
        assertEquals("D", calculator.letterGrade(60));
    }

    @Test
    void letterGradeAt59Point99ReturnsF() {
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    void letterGradeAt69Point99ReturnsD() {
        assertEquals("D", calculator.letterGrade(69.99));
    }

    @Test
    void letterGradeAt0ReturnsF() {
        assertEquals("F", calculator.letterGrade(0));
    }

    @Test
    void letterGradeAt100ReturnsA() {
        assertEquals("A", calculator.letterGrade(100));
    }

    @Test
    void letterGradeAt89Point99ReturnsB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void letterGradeAt90ReturnsA() {
        assertEquals("A", calculator.letterGrade(90));
    }
}
