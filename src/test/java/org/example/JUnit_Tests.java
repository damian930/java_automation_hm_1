package org.example;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class JUnit_Tests {

    static AdditionInt add;

    @BeforeAll
    static void setUp() {
        add = new AdditionInt();
    }

    @Test
    void testingAddition_1() {
        int a = 1;
        int b = 2;


        assertEquals(3, add.add(a, b));
        assertNotEquals(a, add.add(a, b));
    }

    @Test
    void testingAddition_2() {
        int a = 2;
        int b = 2;

        Assumptions.assumeTrue(a == 1);
        assertNotEquals(3, add.add(a, b));
    }

    @Test
    void testingAddition_3() {
        int a = 1;
        int b = 2;

        Assumptions.assumeFalse(a == 0 || b == 0);
        assertThat(add.add(a, b)).isEqualTo(3);
        assertThat(add.add(a, b)).isNotEqualTo(a);
    }

    @Test
    void testingAddition_4() {
        int a = 5;
        int b = -10;

        assertThat(add.add(a, b)).isLessThan(0);
        assertThat(add.add(a, b)).isNotEqualTo(a);
        assertThat(add.add(a, b)).isNotEqualTo(b);
        assertThat(add.add(a, b)).isEqualTo(-5);
    }

}
