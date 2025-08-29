package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {
    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @Test
    void whenCorrectCoder_ReturnsCorrectDietPlan() {
        // given
        Coder coder = new Coder(1.82, 76.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2218, 111, 74, 277);

        // when
        DietPlan actual = dietPlanner.calculateDiet(coder);

        // then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

    @RepeatedTest(4)
    void whenCorrectCoder_ReturnsCorrectDietPlan_repeatedTest() {
        // given
        Coder coder = new Coder(1.82, 76.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2218, 111, 74, 277);

        // when
        DietPlan actual = dietPlanner.calculateDiet(coder);

        // then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

    @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    void whenCorrectCoder_ReturnsCorrectDietPlan_repeatedTestWithLongDisplayName() {
        // given
        Coder coder = new Coder(1.82, 76.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2218, 111, 74, 277);

        // when
        DietPlan actual = dietPlanner.calculateDiet(coder);

        // then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

    @AfterEach
    void completion() {
        System.out.println("\nUnit Test Complete\n");
    }
}