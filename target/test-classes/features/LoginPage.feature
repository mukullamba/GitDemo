Feature: Login Page

Scenario: Verify the title of login page
Given the browser is launched 
When user opens the rediff url 
Then user should be able to get the correct title of login page

Scenario Outline: Verify user is able to login to rediffmail
Given the browser is launched 
When user opens the rediff url 
And user enters username <username> and password <password>
Then user should be logged into rediffmail

Examples:

|username		|password		|
|mukul_lamba	|momanddad		|
|mukullamba		|dadandmom		|