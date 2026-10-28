## Project Overview

A personal QA portfolio project focused on the **Search feature of the Talabat Android application**, combining manual testing, defect documentation, and mobile UI automation.

The project demonstrates:

- Requirements analysis and test scenario design.
- Manual test case design, execution, and result reporting.
- Bug reporting with supporting screenshots and linked evidence.
- Mobile UI automation using Appium, Java, TestNG, Maven, and Page Object Model (POM).
- Test activity tracking and documentation using Jira.

This is an independent portfolio project and is not affiliated with Talabat.

## Test Documentation

| Document | Contents |
| --- | --- |
| [Manual Test Cases & Execution Summary](docs/Talabat_Manual_Test_Execution_Summary_Fixed.xlsx) | 25 manual test cases, test steps, expected and actual results, execution statuses, and a formula-linked summary |
| [Bug Report & Evidence](docs/Bug%20Report.xlsx) | Reported issues, reproduction steps, expected and actual behavior, and supporting screenshots accessible through View Evidence links |

**Viewing the workbooks:** Open a document link, select **Download raw file**, and open the downloaded workbook in Excel. GitHub may display “Binary file not shown” instead of a spreadsheet preview.

## Manual Testing

### Scope

Manual testing covers search-related scenarios, including:

- Valid restaurant and food item searches.
- Partial keywords and Arabic searches.
- Search without login.
- Recent search history.
- Switching search categories.
- Opening search results.
- Searching for a non-existing keyword.
- Sorting by Recommended, Fastest Delivery, and Ratings.
- Filtering by Free Delivery, Pickup, Top Rated, and cuisine.
- Applying multiple filters and clearing cuisine selections.

### Recorded Execution Results

| Metric | Result |
| --- | ---: |
| Total test cases | 25 |
| Passed | 22 |
| Failed | 3 |
| Pass rate | 88% |

These figures describe the recorded **manual test execution**, not the automated test results.

### Reported Findings

| Test Case | Report | Finding |
| --- | --- | --- |
| Ser_TC_12 | BUG_01 | Search-result relevance after applying Fastest Delivery sorting |
| Ser_TC_13 | BUG_02 | Search-result relevance after applying Ratings sorting |
| Ser_TC_16 | BUG_03 | Top Rated results were not consistently displayed in descending rating order |

**BUG_03 clarification:** The original Fail result is retained in the execution record. Whether the Top Rated filter must sort results in descending rating order requires confirmation; this behavior is not yet a confirmed requirement.

Completing the testing tasks does not indicate that the reported application issues have been fixed.

## Tech Stack

| Area | Tools |
| --- | --- |
| Programming language | Java |
| Mobile automation | Appium — UiAutomator2 |
| Testing framework | TestNG |
| Build and dependency management | Maven |
| Design pattern | Page Object Model (POM) |
| Test documentation | Excel |
| Work tracking | Jira |
| IDE | IntelliJ IDEA |
| Platform | Android |
| Version control | Git & GitHub |

## Automation Coverage

The automation implementation covers selected search scenarios. **Not all 25 manual test cases are automated.**

| Test Class | Focus |
| --- | --- |
| Valid_Search_Test | Valid search scenarios |
| Invalid_Search_Test | Invalid or unavailable search keywords |
| Search_Regression_Test | Selected sorting and filtering checks |

### Assertion Scope

- **Fastest Delivery and Ratings:** The regression tests perform the sorting flows and check the corresponding UI indicators. Search-result relevance is verified manually.
- **Top Rated:** The regression test checks the filter indicator and compares the collected restaurant ratings for descending order. This ordering expectation remains subject to the BUG_03 requirement clarification.

Search results can vary by location, time, restaurant availability, and application version. Automated UI checks and manual relevance checks are documented separately.

## Project Structure

```text
docs/
├── Bug Report.xlsx
└── Talabat_Manual_Test_Execution_Summary_Fixed.xlsx

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

The framework follows the **Page Object Model (POM)** approach to separate application screen interactions from test logic.

- **Page_Base:** Reusable page-level functionality.
- **Page Classes:** Screen elements and application interactions.
- **Test_Base:** Common test setup and execution support.
- **Test Classes:** Automated scenarios and assertions.

## Jira Workflow

The project uses Jira to organize the testing work:

- **TMT-1:** Search feature user story.
- **TMT-2:** Requirements analysis.
- **TMT-3:** Test scenario design.
- **TMT-4:** Test case design and manual execution documentation.
- **TMT-5:** Search feature automation.

The planned testing and automation tasks are marked **Done**. Updated test documentation is attached to the relevant Jira work items, with copies available in this repository.

## Running the Automated Tests

### Prerequisites

- Java JDK compatible with the project configuration.
- Maven.
- Node.js and Appium Server.
- Appium UiAutomator2 Driver.
- Android SDK.
- Android device or emulator with the Talabat application installed.
- USB debugging enabled when using a physical device.
- IntelliJ IDEA or another Java-compatible IDE.

### Execution

1. Clone the repository:

   ```bash
   git clone https://github.com/Basembahr/Talabat-Mobile-App-Automation-Testing.git
   ```

2. Open the project as a Maven project.
3. Resolve the dependencies defined in `pom.xml`.
4. Configure the device and Appium capabilities for your local environment.
5. Ensure the account, delivery address, and permissions required by the selected test flow are available.
6. Start the Appium server.
7. Run the desired TestNG test class through the IDE.

**Note:** Execution depends on the installed application version, device configuration, account state, location, and service availability.

## Future Improvements

- Expand automated search coverage.
- Improve reusable test utilities.
- Add structured automated execution reports.
- Integrate automated execution into a CI/CD pipeline.

## Author

**Bassem Sayed Mohamed Bahr**

QA Tester | Manual & Automation Testing | Web, Mobile & API

This project is part of my Software Quality Assurance portfolio.
