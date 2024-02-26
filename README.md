# (API Automation Framework)

#  Technologies and Libraries Used
-**Java**

-**REST ASSURED**

-**TestNG**

-**GSON**

-**JACKSON** 

-**json-schema-validator** (For validating JSON Schema, Schema are kept under resources folder example artists.json is present under /src/test/resources/artists.json)

-**Hamcrest** (Hamcrest allows checking for conditions in your code via existing matchers classes. It also allows you to define your custom matcher implementations. To use Hamcrest matchers in JUnit you use the assertThat statement followed by one or several matchers)

-**EXTENT Report** (For Reporting)

-**Log4j** (For Logging)

-**Lombok** (Lombok is used to reduce boilerplate code for model/data objects.it can generate getters and setters for those object automatically by using Lombok annotations. 

The easiest way is to use the @Data annotation.

*Adding @Data annotation right on top of your class informs Lombok to automatically generate)


#  Prerequisite
Java, Maven,Lombok should be installed on your machine.

#How to Install Lombok on IntelliJ
Refer--> https://projectlombok.org/setup/intellij

## About Framework:
This framework is built using RestAssured.

We use POJO with @Data and @Builder annotations provided by Lombok to create Data at runtime without Getter and Setters

## Important Classes ,Files and Folders:

**APIConstant:** This class defines all API Paths and possible CRUD Operations on REST API .

**PropertyReader:** This class is used to read Property Files **configuration.properties** ( it contains BASE URL of the API and Username and Password , required for Basic Authentication)

**extent-config.xml:** This file contains configuration for extent Report

**log4j.properties:** This contains configurations for Logging used by Log4j to generate Logs. 

**TestReport.html** This is the Extent Report that is generated when API Test Cases are run, It is present under path (/src/main/testReport/TestReport.html)

##POJO
All classes required for API are present under (/src/test/java/pojo)

##TestData
We can Pass Test Data either using **Builder pattern** or we also have privelage to pass data using **Data Provider**

User can write Data provider under (src/test/java/testdata/Data.java)

###Utilities
All Utilities Required For API Verification, Extent Report, JSON Processing are present under (src/test/java/utilities)

**Important Classes**

**APIBase**: This is the Base class where all @BeforeSuite and @AfterMethod operations are present.
This class controls how API is executed

**APIVerification**: This class is used to verify the API Status code and Log the status of test case in Extent Report

**Extentmanager**: This class helps in generating and attaching the Extent Report

**TestListeners**: This class implements ITestListener and logs the Test case execution either pass or fail

**TestUtil**: This class helps in logging for Logs and Extent Report by Logging API response, Headers

## How to Run Test cases:

Go To **TestNG.xml** file present under path( src/test/TestNG.xml)

**Steps To Run the Test cases and generate Execution Report:**

Go To the Project location under command line or terminal:

**Enter command:**
 mvn clean test

> Wait for Tests to Execute till you  see something like
> Results:

>Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 24.218 sec


***Now Test cases have run successfully, Test Reports and Test Logs must have been generated***

**LOGS:** Test Case Execution logs should be present under (log/testlog.log)

**Test case Execution Report**: Test case Execution report should be present under (src/main/testReport/TestReport.html)

