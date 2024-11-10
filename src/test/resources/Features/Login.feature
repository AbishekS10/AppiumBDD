Feature: User to launch and work on calculator APK

  Scenario: User to launch a app and perform sum and sub action
    Given user to launch calculator app
    When user perform addition with value "2" and "9"
    And user to check equals
    Then user should get Addition output as "11"

