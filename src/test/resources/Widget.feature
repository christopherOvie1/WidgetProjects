Feature: Validate_Baz

Scenario: To validate a functionality

  Given user is on homepage
  When user  clicks the select tab
  Then user validate page header as "Select Widgets"
  When user change the value in the simple string array to baz
  #Then user verifies it has change to baz


