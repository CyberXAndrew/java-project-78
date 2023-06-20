### Hexlet tests and linter status:
[![Actions Status](https://github.com/CyberXAndrew/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/CyberXAndrew/java-project-78/actions)
[![.github/workflows/main.yml](https://github.com/CyberXAndrew/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/CyberXAndrew/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/fbdeff2ae274dd3b0633/maintainability)](https://codeclimate.com/github/CyberXAndrew/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/fbdeff2ae274dd3b0633/test_coverage)](https://codeclimate.com/github/CyberXAndrew/java-project-78/test_coverage)

This application implements the ability to check data of several types: strings, numbers, objects of the map-type, 
as well as to check complex (nested) data based on map collections.

***String** data type checks*: matching a string, null, empty string, finding a substring in a given string and matching the minimum specified string length.

***Integers** data type checks*: notnull value check, checking for compliance with a positive number (not including zero)
and occurrence in the specified range check.

***Map** data type checks*: checking for not null, for compliance of the map with the specified size, ad also checking the values
by the map keys for compliance with the validation scheme transmitted by the user (nested data validation realized for map collections).