Feature: Calculate the appropriate payout for any bet

    Scenario Outline: Expected payouts should correctly reflect the odds of the bet
        Given a bet with odds of '<odds>'
        When the user bets '100'
        Then the payout should be '<payout>'

        Examples:
            | odds | payout |
            | -200 | 150.00 |
            | -110 | 190.90 |
            |  100 | 200.00 |
            |  110 | 210.00 |
            |  200 | 300.00 |
