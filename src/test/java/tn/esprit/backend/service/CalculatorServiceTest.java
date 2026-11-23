package tn.esprit.backend.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    void addShouldReturnSum() {
        assertEquals(5, service.add(2, 3));
    }

    @Test
    void subtractShouldReturnDifference() {
        assertEquals(1, service.subtract(3, 2));
    }

    @Test
    void divideShouldReturnQuotient() {
        assertEquals(2, service.divide(6, 3));
    }

    @Test
    void divideByZeroShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> service.divide(1, 0));
    }
}
