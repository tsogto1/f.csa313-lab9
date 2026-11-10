package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    @Test
    void letterGradeReturnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGradeReturnsB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void letterGradeReturnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void gpaReturnsAverage() {
        assertEquals(
                3.5,
                calculator.gpa(new double[]{95, 85}),
                0.000001
        );
    }

    @Test
    void scholarshipReturnsFullAward() {
        assertEquals(
                100,
                calculator.scholarship(3.9, 16, false)
        );
    }
}
