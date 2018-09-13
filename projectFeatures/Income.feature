Feature: Vehicle Income register

Scenario: the parking attendant should be able to register a vehicle income

Given the parking attendant is on the  Income page
When  the parking attendant register the Income info 
Then  the parking attendant should see a Success message