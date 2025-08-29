# Practical Java Unit Testing with JUnit 5

This repository contains my work and notes from the course **Practical Java Unit Testing with JUnit 5**. The course focuses on writing effective unit tests using the **JUnit 5** framework while following industry best practices.

## 📚 Course Overview

The course is designed for developers with basic Java knowledge who want to:

* Improve **code quality** and reliability
* Prepare for their **first Java job**
* Gain hands-on experience in **unit testing and TDD**

Key highlights:

* Learn **JUnit 5 annotations, assertions, and lifecycle methods**
* Practice with **realistic test scenarios** instead of trivial examples
* Use both **Eclipse** and **IntelliJ IDEA** for running tests
* Introduction to **Test Driven Development (TDD)**
* Includes quizzes, a **JUnit cheat sheet**, and extra exercises

## 🏥 HealthyCoderApp

A central part of the course is the **HealthyCoderApp**, a demo application used to practice testing.

### What it does

The app simulates functionality related to a health/fitness tracker, such as:

* Calculating **BMI (Body Mass Index)**
* Recommending a **diet plan** based on BMI
* Evaluating coder health data with different inputs
* Managing coders in collections (for testing streams and optionals)

### What we test

Students write unit tests for various scenarios, including:

* **Basic tests**: Checking BMI calculation correctness
* **Parameterized tests**: Running the same test with multiple data sets
* **Exception testing**: Verifying that invalid input throws the correct exceptions
* **Assertions**: Using `assertEquals`, `assertTrue`, `assertThrows`, etc.
* **Collections & streams**: Testing logic involving coder lists and optionals
* **Organizing tests**: Using `@Nested` for grouping related tests
* **Lifecycle methods**: `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`
* **TDD**: Implementing new features in HealthyCoderApp *through tests first*

## 🧪 JUnit 5 Features Practiced

In addition to the basics, the course introduces several advanced JUnit 5 features:

* **@RepeatedTest** – running the same test multiple times (useful for checking consistency or randomness).
* **@Disabled** – temporarily disabling a test (e.g., when a feature isn’t ready).
* **@EnabledOnOs / @DisabledOnOs** – enabling or disabling tests based on the operating system (great for OS-specific behavior).
* **@Nested** – structuring related tests into inner classes for better readability and organization.


## 🛠 Tools & Setup

* **Java** (basic syntax knowledge required)
* **JUnit 5** as the testing framework
* IDE: **Eclipse** or **IntelliJ IDEA** (examples shown in both)

## 🎯 Learning Outcomes

I am now able to:
* Write clean and maintainable unit tests in **JUnit 5**
* Use **best practices** for structuring and naming tests
* Apply **TDD principles** in real projects
* Confidently prepare for Java developer interviews that require testing knowledge
