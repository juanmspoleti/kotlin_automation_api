# Kotlin API - Automation

## Installation
You need to have:
* [JDK 1.8](https://www.oracle.com/ar/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* Set JAVA_HOME and MAVEN_HOME environment variables.

## How it works
We have a BDD structure, so I recommend to see first the features file, then go step by step to understand his behaviour,

## Run
### All testcases:
mvn clean test

### Specific functionality:
mvn clean test "-Dcucumber.filter=-t @Price"

#### Functionalities availables:
@Price

## Debug:
mvn clean test -DforkCount=0

## Technologies used:
* Kotlin 1.7.22
* Maven
* TestNG (runner)
* Cucumber (BDD)
* Log4j (logger)
* [Retrofit](https://square.github.io/retrofit)

## Reports
Not available

## Project structure
* src/test/resources/features = features files with the scenarios, gherkin and data (BDD).
* src/test/kotlin/steps = steps that matches with gherkin from features files
* src/main/resources = properties files: cucumber options, log4 and project configs (config.properties)
* src/main/kotlin/api = requests, responses and models from the API