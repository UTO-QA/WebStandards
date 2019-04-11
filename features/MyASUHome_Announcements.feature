# new feature
# Tags: optional

Feature: My ASU ome page - Announcements Container

    Scenario: Announcement Container
        Given I am logged into <my.asu.edu>
        Then I should see "Announcments" container on the homepage

    Scenario: Announcement Container
        Given I am logged into <my.asu.edu>
        When I click on the "gear" icon in the "Announcements" container header
        Then a pop-up window appears listing categories to display in the container