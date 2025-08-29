package com.healthycoderapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class BMICalculatorTest {
    private String environment = "In Development";

    @BeforeAll
    static void beforeAll() {
        System.out.println("\nBeginning unit tests\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\nEnd all tests\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("\nUnit test");
    }

    @Nested
    class IsDietRecommendedTests {
        @ParameterizedTest
        @ValueSource(doubles = {85, 90, 100})
        @DisplayName("Display name replaces the function name")
        void whenDietRecommended_thenReturnsTrue(double coderWeight) {
            // given
            double weight = coderWeight;
            double height = 1.75;

            // when
            boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);

            // then
            assertTrue(dietRecommended);
        }

        @ParameterizedTest(name = "Weight={0}, Height={1}")
        @CsvSource({ // hidden 'value = {...}'
                "89, 1.72",
                "95, 1.75",
                "110, 1.78"
        }) //                         These values don't have to be doubles, they can be anything
        void whenDietRecommended_thenReturnsTrue(double coderWeight, double coderHeight) {
            // given
            double weight = coderWeight;
            double height = coderHeight;

            // when
            boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);

            // then
            assertTrue(dietRecommended);
        }

        @ParameterizedTest(name = "Weight={0}, Height={1}")
        @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
        void whenDietRecommended_thenReturnsTrue_withCSVFile(double coderWeight, double coderHeight) {
            // given
            double weight = coderWeight;
            double height = coderHeight;

            // when
            boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);

            // then
            assertTrue(dietRecommended);
        }

        @Disabled
        @Test
        void whenDietNotRecommended_thenReturnsFalse() {
            // given
            double weight = 50;
            double height = 1.75;

            // when
            boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);

            // then
            assertFalse(dietRecommended);
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void whenHeightIsZero_thenThrowsArithmeticException() {
            // given
            double weight = 50;
            double height = 0.0;

            // when
            Executable dietRecommended = () -> BMICalculator.isDietRecommended(weight, height);

            // then
            assertThrows(ArithmeticException.class, dietRecommended);
        }
    }

    @Nested
    class FindCoderWithWorstBMITests {
        @Test
        void whenCoderListNotEmpty_thenReturnsCoderWithWorstBMI() {
            // given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.74, 100));
            coders.add(new Coder(1.75, 80));
            coders.add(new Coder(1.76, 60));

            // when
            Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            // then
            assertAll(
                    () -> assertEquals(1.74, coderWithWorstBMI.getHeight()),
                    () -> assertEquals(100, coderWithWorstBMI.getWeight())
            );
        }

        @Test
        void whenCoderListHas10000Elements_ReturnsResultIn100ms() {
            // given
            assumeTrue(BMICalculatorTest.this.environment.equals("During Production")); // skips this test
            List<Coder> coders = new ArrayList<>();
            for (int i=0; i<10000; i++) coders.add(new Coder(1+i, 10+i));

            // when
            Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

            // then
            assertTimeout(Duration.ofMillis(100), executable);
        }

        @Test
        void whenCoderListEmpty_thenReturnsNull() {
            // given
            List<Coder> coders = new ArrayList<>();

            // when
            Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            // then
            assertNull(coderWithWorstBMI);
        }
    }

    @Nested
    class BMIScoresTests {
        @Test
        void whenCoderListNotEmpty_thenReturnsCorrectBMIs() {
            // given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.74, 100));
            coders.add(new Coder(1.75, 80));
            coders.add(new Coder(1.76, 60));
            double[] expected = {33.03, 26.12, 19.37};

            // when
            double[] actual = BMICalculator.getBMIScores(coders);

            // then
            assertArrayEquals(expected, actual);
        }
    }
}