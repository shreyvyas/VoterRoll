Followed the Page Object Model (POM) to keep test logic separate from page actions and locators.

Maven is used for managing project dependencies like Selenium and TestNG.

Test data is read from Excel files, and we use the Apache POI library to work with Excel.

Extent Reports are used to generate HTML test reports.

Project Structure:
src/main/java – Contains reusable utility methods organized in separate files.

src/test/java – Includes page classes, test classes, listeners, and the base test class.

Resources – Stores all external resources (like Excel files, config files).

Screenshot – Stores screenshots of failed test cases.

TestReport – Stores the HTML reports generated after test execution.
