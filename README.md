
# Hybrid Automation Framework

A comprehensive **Behavior-Driven Development (BDD)** automation testing framework built with **Java, Selenium, Cucumber, and TestNG** for automating financial website testing scenarios.

## 📋 Overview

This framework is designed to automate web testing for financial and stock market platforms using the **Hybrid Testing Model** (combining both data-driven and keyword-driven approaches). It provides robust test automation for multiple financial platforms including **Yahoo Finance, TradingView, and Tickertape**.

**Language Composition:**
- **Java** (57.8%) - Core automation logic
- **HTML** (36.1%) - Test reports
- **Gherkin** (6.1%) - BDD feature files

## 🎯 Key Features

### ✅ BDD with Cucumber
- Write tests in plain English using Gherkin syntax
- Feature files that are easily readable by non-technical stakeholders
- Step definitions bridging business language and automation code

### ✅ Web Automation
- **Selenium WebDriver 4.34** for browser automation
- Support for Chrome browser
- Advanced waits and synchronization mechanisms
- Screenshot capture for failed/passed scenarios

### ✅ Test Reporting
- **ExtentReports 5.1.2** for rich HTML reporting with visual dashboards
- Test execution analytics and detailed logs
- Screenshot attachments for easy debugging
- Customizable report formatting

### ✅ Data-Driven Testing
- **Apache POI** integration for Excel file handling
- Read test data from Excel sheets
- Support for parameterized testing scenarios

### ✅ Security & Encryption
- **AES Encryption Utility** for securing sensitive credentials (passwords)
- Encrypt credentials during test data setup
- Decrypt for use in test scenarios

### ✅ Logging & Debugging
- **Log4j2** for comprehensive logging
- Caller class name tracking
- Info and error level logging
- Detailed test execution trails

### ✅ TestNG Integration
- Parallel test execution capability
- Advanced test organization and grouping
- Assertions for validating test conditions
- Test suite configuration via XML


## 📊 **What This Automation Framework Does:**

### **Core Automation Type**: 
A **Hybrid BDD Web Automation Framework** that combines Selenium, Cucumber, and TestNG for testing financial/stock market websites.

### **Three Main Testing Platforms:**

1. **Yahoo Finance Automation** (4 test cases)
   - Stock price analysis with HIGH/LOW percentages in 5-year ranges
   - Historical trading data retrieval
   - Stock comparison and market cap analysis
   - Company profile data extraction

2. **TradingView Automation** (2 test cases)
   - Secure user authentication with encrypted credentials
   - Stock searching and candlestick chart visualization
   - Data-driven testing with Excel integration

3. **Tickertape Automation** (9 test cases)
   - Google navigation and site verification
   - Stock search and LTP (Last Traded Price) retrieval
   - Market Mood Index (MMI) analysis
   - Top gainers/losers identification
   - Stock screening by market cap (Small/Mid/Large Cap)

### **Key Technical Features:**
- ✅ **BDD Testing** with Gherkin syntax
- ✅ **Data-Driven** using Excel/POI integration
- ✅ **Secure Credentials** with AES encryption
- ✅ **Rich Reporting** with ExtentReports + HTML dashboards
- ✅ **Screenshot Capture** for debugging
- ✅ **Comprehensive Logging** with Log4j2
- ✅ **Parallel Test Execution** via TestNG
