# LexusAssignment
Assignment given by lexus team

## About the Project Framework used

Serenity BDD is a library to write high quality automated acceptance tests.
It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity does reduce a lot of the code that we write normally in a web test. 
The real advantage is in the use of many small, stable classes which focuses on a single job.
This application of the _Single Responsibility Principle_ goes a long way,
to make the test code more stable, easier to understand, and easier to maintain.

## Executing the tests
To run the project, just run the `CucumberTestSuite` test runner class
Or run either `mvn clean verify` from any IDE by setting working directory as `Lexus/LexusAssignment`

##Execution mode is by default in open browser mode
If need be then please change serenity.conf headless.mode = true if we want headless mode execution.
File is present `src/test/resources/serenity.conf` 

By default, the tests will run using Chrome.
You can run them in Firefox by overriding the `driver` system property,
$ mvn clean verify -Ddriver=firefox

## Accessing the Reports
The test results will be recorded in the `target/site/serenity` directory and
Report named 'index.html' is present in `target/site/serenity` directory.

## See the Results
To see the results with screenshots -
Open the index.html in chrome browser.
Click on Test Results tab beside the Summary and Scroll down then click on Scenario link
To See assertion results click on the Assertion Success/Failure button.

