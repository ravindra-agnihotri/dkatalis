Feature: midtrans checkout
  Scenario Outline: checkout successfully
    Given user opens midtrans website
    When user fills details and payment options
    Then enters "<CARD NUMBER>", "<CVV>", "<Expiry>" and "<OTP>"
    Examples:

      | CARD NUMBER         | CVV  | Expiry     | OTP    |
      | 4811 1111 1111 1114 | 123  |    12/24   | 112233 |
      | 4911 1111 1111 1113 | 123  |    02/24   | 112233 |



