Feature: Mail using


  Scenario: Login to mail and send message from draft folder
    Given I login to mail
    When I write message with subject "test" and text "ВСЕМ ХАЙ"
    Then I left it as draft
    And I send message from draft folder
    Then Message disappears form draft folder
    Then Message appears in sent folder
    And I exit from account