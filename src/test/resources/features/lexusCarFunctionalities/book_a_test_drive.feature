Feature: Book a Test Drive

  Scenario: Fill up the form in-order to book for a test drive
    Given Navigate to HomePage
    Then Fill up the personal details in the form
      | First Name | Last Name | Email Address     | Phone Number |
      | CPL        | Test      | qa@convertium.com | 91234567     |
    And Select the following booking details
      | Preferred date | Preferred time | Preferred sales consultant | Number of pax | Test drive option          |
      | Today          | 18:00          |                            | 1             | Lexus Test Drive Concierge |
    And Verify the default Preferred model
      | Preferred models |
      | UX 300e          |
    And Check the Driving license
    And Check whether the Submit button is Disabled
    And Check the Terms and services
    And Check the Privacy policy
    And Check the Marketing consent
    And Check whether the Submit button is Enabled