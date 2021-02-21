@Smoke
Feature: Login feature testing 
	Description : note about your requirement
#	Background: common steps

@TC_001	
Scenario:
As a Zoopla user , i can login successfully with valid user name and password 
	Given Open the browser 
	When Send URL 
	And  Accept cookies 
	And Click Sign in btn 
	And Send valid email 
	And Send valid password 
	And Click submit btn 
	Then Validate login success or fail 
	When close the browser 
