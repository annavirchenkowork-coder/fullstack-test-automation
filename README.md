# Fullstack Test Automation Framework
![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![JUnit5](https://img.shields.io/badge/JUnit-5-green?logo=junit5)
![Playwright](https://img.shields.io/badge/Playwright-Java-45ba4b?logo=playwright)
![REST Assured](https://img.shields.io/badge/REST--Assured-API-orange)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)
![Allure](https://img.shields.io/badge/Allure-Reporting-ff69b4)
![GitHub Actions](https://img.shields.io/badge/CI-GitHub%20Actions-black?logo=githubactions)

A Java-based test automation framework demonstrating **UI, API, Database, and CI testing** in a single project.

The framework is built with a clear separation of concerns and follows real-world automation patterns suitable for scalable and maintainable test suites.

---

## Tech Stack

* **Language:** Java 17
* **Build tool:** Maven
* **Test framework:** JUnit 5
* **UI testing:** Playwright (Java)
* **API testing:** Rest Assured
* **Database testing:** JDBC (MySQL)
* **Reporting:** Allure
* **CI/CD:** GitHub Actions

---

## Project Structure

```
fullstack-test-automation
├── .github
│   └── workflows
│       └── ci.yml
├── src
│   ├── main
│   │   └── java
│   │       └── com.netta.automation
│   │           └── pages
│   │               ├── CheckboxesPage.java
│   │               ├── DropdownPage.java
│   │               ├── DynamicLoadingExample2Page.java
│   │               └── TheInternetHomePage.java
│   └── test
│       ├── java
│       │   └── com.netta.automation
│       │       ├── config
│       │       │   ├── Env.java
│       │       │   └── TestConfig.java
│       │       ├── extensions
│       │       │   └── AllureArtifactsExtension.java
│       │       ├── tests
│       │       │   ├── api
│       │       │   │   └── UsersApiTest.java
│       │       │   ├── db
│       │       │   │   └── UsersTableDbTest.java
│       │       │   └── ui
│       │       │       ├── BaseUiTest.java
│       │       │       └── TheInternetUiTest.java
│       │       └── utils
│       │           └── DbUtils.java
│       └── resources
│           └── testdata
│               └── testdata.json
├── .env.example
├── .gitignore
├── pom.xml
└── README.md
```

---

## Test Coverage

### UI Tests
- Implemented using **Playwright Java**
- Page Object Model
- Screenshots and page URL automatically attached to Allure report on failure

### API Tests
- Implemented using **REST Assured**
- Validates HTTP status codes and response bodies
- Integrated with Allure reporting

### Database Tests
- Implemented using **JDBC**
- Validates data directly from MySQL
- Tests are skipped automatically if DB environment variables are not configured

---

## Environment Configuration

Environment variables are used for database and runtime configuration.

1. **System properties** (`-DKEY=value`)
2. **Environment variables**
3. **.env file**
4. **Default values**

### Example `.env` file

```
DB_URL=jdbc:mysql://localhost:3306/testdb
DB_USER=root
DB_PASS=password
HEADLESS=true
BASE_URL=https://the-internet.herokuapp.com/
```

An example file is provided as `.env.example.`

---

## Running Tests Locally

### Run all tests

```
mvn test
```

### Run with DB enabled

```
DB_URL=jdbc:mysql://localhost:3306/testdb \
DB_USER=root \
DB_PASS=password \
mvn test
```

---

## Allure Reports

### Generate report

```
mvn allure:report
```

### Open report

```
mvn allure:serve
```

Allure captures:

* screenshots on UI failures
* page URL on failure
* API request/response

---

## CI/CD (GitHub Actions)

* Runs on every push & PR to `main`
* Starts MySQL service automatically
* Executes UI, API, and DB tests
* Uploads Allure results and HTML report as artifacts

---

## Author

Anna "Netta" Virchenko
QA / Test Automation Engineer

LinkedIn:

![LinkedIn](https://img.shields.io/badge/LinkedIn-Anna%20Virchenko-blue?logo=linkedin)
