# Selenium Automation Framework

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)]()
[![TestNG](https://img.shields.io/badge/TestNG-7.9.0-blue)]()
[![Selenium](https://img.shields.io/badge/Selenium-4.17.0-red)]()
[![Java](https://img.shields.io/badge/Java-21-orange)]()

---

## Overview
This is a **Selenium WebDriver automation framework** built using **Java, TestNG, and Page Object Model (POM)**. It includes **data-driven test cases**, **FluentWait handling**, and **ExtentReports reporting**.

The framework automates login functionality of [Practice Test Automation](https://practicetestautomation.com/practice-test-login/) with the following scenarios:

- ✅ Positive Login Test – Valid username and password  
- ❌ Negative Username Test – Invalid username  
- ❌ Negative Password Test – Invalid password  

---

## Project Structure

com.selenium/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── pages/
│ │ └── LoginPage.java
│ └── test/
│ └── java/
│ ├── base/
│ │ └── BaseTest.java
│ ├── tests/
│ │ └── LoginTest.java
│ └── utils/
│ ├── ConfigReader.java
│ ├── ExtentManager.java
│ ├── TestListener.java
│ └── WaitUtils.java
└── src/
└── test/
└── resources/
└── config.properties



---

## Prerequisites

- Java JDK 11+  
- Maven  
- Chrome browser  
- Git (for version control)  
- IDE (IntelliJ IDEA / Eclipse)  

---

## Setup

1. **Clone the repository**

```bash
git clone https://github.com/Amanlifts18/selenium-automation.git
cd selenium-automation

Update configuration
Edit src/test/resources/config.properties:
url=https://practicetestautomation.com/practice-test-login/
browser=chrome

Install dependencies
mvn clean install

Running Tests
From IDE: Right-click LoginTest.java → Run
From Terminal: mvn test

Test Reports
ExtentReports: test-output/ExtentReports/extent-report.html
Screenshots on failure: test-output/screenshots/

Features
✅ Page Object Model (POM) – Modular & maintainable
✅ Data-driven tests
✅ Fluent Wait for dynamic elements
✅ ExtentReports with screenshots
✅ TestNG Listener for automatic logging
