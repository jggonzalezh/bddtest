Feature: Vehicle Outcome register
Scenario: the parking attendant should be able to register a vehicle outcome

Given the parking attendant is on the  outcome page
When  the parking attendant register the outcome info 
Then  the parking attendant should see an exit Success message