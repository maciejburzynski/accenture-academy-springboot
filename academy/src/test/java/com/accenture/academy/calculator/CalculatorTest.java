package com.accenture.academy.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void prepareCalculatorForTest(){
         calculator= new Calculator();
    }

    @Test
    void whenAddTwoNumbersThenReturnTheirSum() {
//        When
        int result = calculator.add(2, 3);
//        Then
        Assertions.assertEquals(5, result);
    }

    @Test
    void testSubtract() {
//        When
        int result = calculator.subtract(10, 7);
//        Then
        Assertions.assertEquals(3, result);
    }

    @Test
    void testMultiply() {
//        When
        int result = calculator.multiply(2, 3);
//        Then
        Assertions.assertEquals(6, result);
    }

    @Test
    void testDivide() {
//        When
        int result = calculator.divide(12, 3);
//        Then
        Assertions.assertEquals(4, result);
    }
    @Test
    void testDivideBy0() {
//        Then
        Assertions.assertThrows(IllegalArgumentException.class,() -> calculator.divide(12, 0));
    }
}