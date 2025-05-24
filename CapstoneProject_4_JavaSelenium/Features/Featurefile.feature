Feature: Capstone_Project

Scenario: Launch_Url 
  Given User Launch Browser
  When User opens url "https://the-internet.herokuapp.com/"
  Then user is redirected to the HomePage
	And click on A/B link
	Then user landed on A/B homepage
	And click on dropdown
	Then select the Option1
	And click frames link
	Then user landed on famespage and verifying the hyperlinks 