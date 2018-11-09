# Shopping Application

## Overview

This project is a submission for the Shopping Application tech test.

## Running the project

Software Requirements: Java 8, Maven 3

To compile and run the tests execute the following command, in a terminal, from the root directory of the project:

1. mvn clean package

If the tests are unsuccessful the build should fail

To run the application execute the following command:

1. java -jar target/shopping-app-1.0.jar

## Additional Notes

Given more time there are a couple of changes I would make:
1. I would switch over the Item price data type to BigDecimal for the purpose of maintaining precision in price calculations
2. Introduce more logging for debugging purposes.


