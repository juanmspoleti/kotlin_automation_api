@Price
Feature: As a user I want to get coins price, so that I check his actual price

  Scenario Outline: Get and validate coins price
    When get '<coin>' price on '<fiat>' in '<exchange>' exchange
    Then validates coin price response is valid

    Examples:
      | exchange | coin | fiat |
      | buenbit  | BTC  | ARS  |
      | letsbit  | ETH  | ARS  |
      | letsbit  | ETH  | USD  |