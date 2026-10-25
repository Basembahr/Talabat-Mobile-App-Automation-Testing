# Talabat Mobile App Automation Testing

## Project Overview

An Android mobile test automation project focused on the **Search feature of the Talabat application**.

The project demonstrates mobile UI automation using **Appium, Java, TestNG, Maven, and the Page Object Model (POM)** design pattern.

The main objective is to validate search-related user flows and explore functional behavior through automated test scenarios.

## Tech Stack

- **Programming Language:** Java
- **Mobile Automation:** Appium (UiAutomator2)
- **Testing Framework:** TestNG
- **Build & Dependency Management:** Maven
- **Design Pattern:** Page Object Model (POM)
- **IDE:** IntelliJ IDEA
- **Platform:** Android
- **Version Control:** Git & GitHub

## Test Coverage

The project includes test classes focused on:

- **Valid Search Testing:** Searching for valid restaurant or food keywords.
- **Invalid Search Testing:** Checking application behavior when searching with invalid or unavailable keywords.
- **Search Regression Testing:** Automating search-related scenarios to check application behavior across repeated test runs.

The automation framework also includes page objects supporting navigation and interaction with the application.

## Project Structure

```text
src/
├── main/
│   └── java/
│       ├── Base/
│       │   └── Page_Base.java
│       └── Pages/
│           ├── Country_Page.java
│           ├── Delivery_Location_Page.java
│           ├── Home_Page.java
│           ├── Login_Page.java
│           ├── Search_Page.java
│           └── System_Permission_Page.java
└── test/
    └── java/
        ├── Base/
        │   └── Test_Base.java
        └── Tests/
            ├── Valid_Search_Test.java
            ├── Invalid_Search_Test.java
            └── Search_Regression_Test.java
```

## Framework Design

The project follows the **Page Object Model (POM)** approach to separate application page interactions from test logic.

- **Page_Base:** Contains reusable page-level functionality.
- **Page Classes:** Organize application screen elements and interactions.
- **Test_Base:** Supports common test setup and execution.
- **Test Classes:** Contain search-related automated test scenarios.

This structure helps improve code readability, maintainability, and reusability.

## Running the Tests

### Prerequisites

- Java JDK
- Maven
- Node.js and Appium Server
- Appium UiAutomator2 Driver
- Android SDK
- Android device or emulator with USB debugging enabled where applicable
- IntelliJ IDEA or another Java-compatible IDE

### Execution

1. Clone the repository.
2. Open the project as a Maven project.
3. Install the required dependencies from `pom.xml`.
4. Configure the Android device and Appium capabilities according to your local environment.
5. Start the Appium server.
6. Run the desired TestNG test class through the IDE.

> **Note:** Test execution requires a properly configured Android and Appium environment. Results may depend on the installed Talabat application version, device configuration, and application availability.

## Future Improvements

- Expand automated search test coverage.
- Improve reusable test utilities.
- Add structured execution reports.
- Integrate automated execution into a CI/CD pipeline.

## Author

**Bassem Sayed Mohamed Bahr**

QA Tester | Manual & Automation Testing | Web, Mobile & API

*This project is part of my Software Quality Assurance portfolio.*
