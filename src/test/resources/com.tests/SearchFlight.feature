Feature: Search flight functionality

  Scenario: Book a flight
    Given launch browser "chrome" and navigate "https://www.makemytrip.com/"
    And Enter source "Mumbai" and distination "Delhi"
    When Search fastest and chepest flight
    Then Book the flight
    
  Scenario: Book a flight
    Given launch browser "firefox" and navigate "https://www.makemytrip.com/"
    And Enter source "Mumbai" and distination "Delhi"
    When Search fastest and chepest flight
    Then Book the flight