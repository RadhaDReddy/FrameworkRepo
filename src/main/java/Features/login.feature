Feature: Architect login feature
 
#Scenario: Architect login Test Scenario

#Given user is already on login page
#When title of login page is Login
#Then user enters username and password
#Then user clicks on login button
#Then user is on Home page



# with Exmaples Keyword

Scenario Outline: Architect login Test Scenario

Given user is already on login page
When title of login page is Login
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on Home page

Examples:

| username | password |
| qa_user_4 | Ap2!vE3@d2wE |