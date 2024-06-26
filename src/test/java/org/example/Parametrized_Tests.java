package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Parametrized_Tests {

    static AdditionInt add;

    @BeforeAll
    static void setUp() {
        add = new AdditionInt();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "0, 0, 0", "-5, 10, 5"})
    void testingAddition(int a, int b, int expectedResult) {
        assertEquals(expectedResult, add.add(a, b));
    }
}
