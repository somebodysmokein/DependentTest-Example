![Logo](https://www.browserstack.com/images/static/header-logo.jpg)

# BrowserStack Examples TestNG

## Repository setup

- Clone the repository

- Ensure you have the following dependencies installed on the machine
    - Java >= 8
    - Maven >= 3.1+

  Maven:
    ```sh
     mvn clean test -P bstack-single
    ```

## Description


We have two tests (Test1,Test2). Test2 is dependent on Test1 and wait for the Test1 to complete. 

- The test launches are actually controlled by Test Runner, in this case TestNG
- Each test runs on separate sessions here as the driver instance is created and terminated for every test method.
