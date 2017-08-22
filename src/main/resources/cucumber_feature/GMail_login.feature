Feature: GMail login test
#comment is here - feature description for search testing

#recurrent actions/preconditions go below - in "Background" section
#this section is optional.
#Uncomment it and delete/comment duplicating step from Scenario description

#Background:
#Given user navigates to GMail start page

@smokeTest
Scenario Outline: GMail login
Given user navigates to GMail start page
When user enters <username> and <password>
Then  GMail account page is displayed
When user fills in <recipient>, <subject>, <body> fields of mail and save mail to draft
Then mail appears in drafts folder
And user opens draft mail
Then <recipient> field is valid
And <subject> field is valid
And <body> field is valid
When user sends mail
Then mail is sent

Examples:
|username        |password  |recipient               |subject       |body     |
|test.da.10062017|testtest01|dina_abdykasheva@mail.ru|mentoring task|body text|
