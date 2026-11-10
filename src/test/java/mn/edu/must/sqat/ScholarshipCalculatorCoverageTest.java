package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScholarshipCalculatorCoverageTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // letterGrade(): D/F болон буруу оролтын замууд.
    @Test
    void letterGradeReturnsD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void letterGradeReturnsF() {
        assertEquals("F", calculator.letterGrade(55));
    }

    @Test
    void letterGradeRejectsNegativeScore() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(-1)
        );
    }

    @Test
    void letterGradeRejectsScoreAbove100() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(101)
        );
    }

    // gpa(): switch-ийн бүх зам болон оролтын хамгаалалт.
    @Test
    void gpaHandlesAllLetterGrades() {
        assertEquals(
                2.0,
                calculator.gpa(new double[]{95, 85, 75, 65, 55}),
                0.000001
        );
    }

    @Test
    void gpaRejectsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.gpa(null)
        );
    }

    @Test
    void gpaRejectsEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{})
        );
    }

    // scholarship(): || нөхцөл бүрийг тусдаа шалгана.
    @Test
    void scholarshipRejectsNegativeGpa() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 16, false)
        );
    }

    @Test
    void scholarshipRejectsGpaAbove4() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 16, false)
        );
    }

    @Test
    void scholarshipRejectsNegativeCredits() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(3.9, -1, false)
        );
    }

    @Test
    void scholarshipReturnsZeroForViolation() {
        assertEquals(
                0,
                calculator.scholarship(3.9, 16, true)
        );
    }

    @Test
    void scholarshipReturns70() {
        assertEquals(
                70,
                calculator.scholarship(3.5, 12, false)
        );
    }

    // 100%-ийн голч хүрсэн ч кредит дутуу: эхний &&-ийн баруун тал false.
    @Test
    void scholarshipReturns70WhenFullAwardCreditsAreInsufficient() {
        assertEquals(
                70,
                calculator.scholarship(3.9, 14, false)
        );
    }

    @Test
    void scholarshipReturns50() {
        assertEquals(
                50,
                calculator.scholarship(3.2, 12, false)
        );
    }

    // 70%-ийн голч хүрсэн ч кредит дутуу: хоёр дахь &&-ийн баруун тал false.
    @Test
    void scholarshipReturns50When70AwardCreditsAreInsufficient() {
        assertEquals(
                50,
                calculator.scholarship(3.5, 11, false)
        );
    }

    @Test
    void scholarshipReturnsZeroForLowGpa() {
        assertEquals(
                0,
                calculator.scholarship(2.9, 16, false)
        );
    }
}
