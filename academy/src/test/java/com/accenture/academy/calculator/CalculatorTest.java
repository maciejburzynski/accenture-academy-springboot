package com.accenture.academy.calculator;

import com.accenture.academy.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void prepareCalculatorForTest() {
        calculator = new Calculator();
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(12, 0));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-parameterized-test-add.csv")
    void whenAddTwoNumbersThenReturnTheirSum_CsvFileParameter(int x, int y, int expected) {
        Assertions.assertEquals(calculator.add(x, y), expected);
    }

    @ParameterizedTest
    @MethodSource("argumentsMethod")
    void whenAddTwoNumbersThenReturnTheirSum_MethodParameter(int x, int y, int expected) {
        Assertions.assertEquals(calculator.add(x, y), expected);
    }

    private static Stream<Arguments> argumentsMethod() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(2, 8, 10),
                Arguments.of(2, 7, 9)
        );
    }

    @ParameterizedTest
    @CsvSource({"2,3,5", "10,10,20"})
    void whenAddTwoNumbersThenReturnTheirSum_AnnotationParameter(int x, int y, int expected) {
        Assertions.assertEquals(calculator.add(x, y), expected);
    }
}