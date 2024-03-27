Feature: Try to do a very basic UI Test

    Scenario: When a user clicks on a button something really cool should happen
      Given I initialize app
      When a user taps the button that says 'Click Me!'
      Then the screen should show 'SURPRISE!'
