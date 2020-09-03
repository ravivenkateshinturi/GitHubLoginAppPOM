Feature: Github Login functanility

Scenario: User is trying to singin in GitHub using Invalid username and password

Given User is on GitHub login Page
 When user enter Invalid username and password 
 Then 'Incorrect username or password.' Message should display

 Scenario: User is trying to singin in GitHub using valid username and password
 
 Given User is on GitHub login Page
 When user enter valid username and password 
 Then user should successfully Sigin on his Github Account 