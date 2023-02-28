AutomationForLanguageExchange
=============================

This project uses Selenium with Java to automate messaging on MyLanguageExchange.


Installation
------------

To run this project, you need to have the following software installed on your machine:

-   Java Development Kit (JDK) version 8 or higher
-   Selenium WebDriver
-   ChromeDriver

Usage
-----

To use this project, follow these steps:

1.  Clone this repository to your local machine.
2.  Install the required software as listed above.
3.  Open the project in your Java IDE of choice.
4.  Update the `txtEmail` and `txtPassw` fields in the `doLogin()` method with your MyLanguageExchange account credentials.
5.  Update the `CURRENTPAGE` field in the `goToSearch()` method with the URL of the search page for the language you want to message.
6.  Run the `startWebDriver()` method to start the automation.

The `startWebDriver()` method will call the `doLogin()`, `goToSearch()`, and `sendMessages()` methods in order. The `sendMessages()` method will repeatedly loop through the search results pages, click on each profile, send a message, and then go back to the search results. The message that is sent is hard-coded as "message goes here".

Notes
-----

-   The `waitForIt()` method is used to pause the automation for 5 seconds between actions. You can adjust the duration of this pause by modifying the `TimeUnit.SECONDS.sleep(5)` line in this method.
-   The `setURL()` and `goToCurrentPage()` methods are used to keep track of the current URL and return to it if necessary.
-   The `DEBUGMODE` and `DEBUGCOUNT` fields are not currently used in the code, but can be used for debugging purposes if needed.
