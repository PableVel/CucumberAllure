Feature: Table Mercados

  Background:
    Given User navigate to "https://www.bmv.com.mx/en/markets/equity"

  Scenario Outline: Search by alphabetical order
    When User click "<letterToSearch>" in 'Search by alphabetical order' section
    Then User should see that the table only contains 'Issuers' that start with "<letterToSearch>"

    Examples:
      | letterToSearch |
      | A              |
      | B              |
      | C              |
      | D              |
      | E              |
      | F              |
      | G              |
      | H              |
      | I              |
      | K              |
      | L              |
      | M              |
      | N              |
      | O              |
      | P              |
      | Q              |
      | R              |
      | S              |
      | T              |
      | V              |
      | W              |

  Scenario: Filter table by MAXIMUM header
    When User clicks on the "MAXIMUM" column header twice
    Then User should see the Maximum values ordered from highest to lowest

  Scenario: Open new tab with MexDer
    When User clicks on MexDer link
    Then User is at MexDer page
