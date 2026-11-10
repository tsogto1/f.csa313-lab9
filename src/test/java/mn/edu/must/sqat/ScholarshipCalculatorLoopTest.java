package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorLoopTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // Давталт 1 удаа: нэг A дүнгийн голч 4.0.
    @Test
    void gpaHandlesSingleScore() {
        assertEquals(
                4.0,
                calculator.gpa(new double[]{95}),
                0.000001
        );
    }

    // Давталт 2+ удаа: (4 + 3 + 2 + 1) / 4 = 2.5.
    @Test
    void gpaHandlesMultipleScores() {
        assertEquals(
                2.5,
                calculator.gpa(new double[]{95, 85, 75, 65}),
                0.000001
        );
    }
}
