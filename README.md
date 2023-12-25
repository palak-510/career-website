# Career Website UI Test Automation 

## 1. Installation
Clone the project using repository link.

Branch names:

* 'master' -> main branch
* 'develop' -> develop branch

## 2. Execution

### 2.1 Executing test suites using IntelliJ

* Navigate to src/test/resources/testsuites/
* select the suite to execute
* Right click on the suite and click on Run

### 2.2 Using Command Line

* Navigate to project directory
* Open the command prompt
* Run the command - mvn clean install test

#### Mandatory Arguments
* browser - need to provide the browser in xml files
* supports edge and chrome driver for execution

## 3. Test Results/Reports

### 3.1 Cucumber html report
* After test runs results/report will be generated at target folder
* report name would be cucumber-html-report.html

### 3.2 Allure report
* After test runs a new folder would be created allure-results
* To generate allure report, navigate to project directory in File Explorer
open the command line and enter below command

    'allure serve allure-results'

## 4. Test Suites

Below are the testsuites placed at src/test/resources/testsuites folder

* smoketests.xml -> This is used to run smoke tests(having tag @SmokeTest)
* sanitytests.xml -> This is used to run sanity tests(having tag @SanityTest)
* regressiontests.xml -> This is used to run regression tests(having tag @RegressionTest)