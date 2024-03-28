Feature: As a User, I should always be able to see what my payout would be.

    Scenario: When a user selects odds and enters a wager amount, the potential payout should be shown
      Given I initialize app
      When a user taps the button that says '-200'
      And a user enters '100' in the 'test_input' field
      Then the screen should show 'Payout: 150.0'

    Scenario: When a user enters a non-number as a wager, an error should be displayed and no payout should be shown
      Given I initialize app
      When a user enters 'test' in the 'test_input' field
      Then the screen should show 'That is not a valid wager.'
      And the screen should show 'Payout: --'