# Automation Testing : Find travel insurance plan for students

## Overview
This Java Selenium project automates tasks on Policy Bazaar page, including navigation, searches, and information extraction. It utilizes TestNG for testing, Apache POI for handling Excel data, Extent Report for reporting, and logging for tracking script execution.

## Requirements
1. **Navigate to travel Insurance icon**
   - Clicking on the travel Insurance icon on the home page.
2. **Search for Internation travel insurance plan**
   - Enters necessary details to get the insurance plan for two students of age 21 and 22 to any European country.
3. **Find the lowest three International insurance plan**
   - To sort and collect the three lowest insurance plan with amount and insurance provider company.
4. **Navigate back to Home page**
   - Navigating back to the home page.
5. **Navigate to car insurance page**
   - Clicking on the car insurance icon on the home page.
6. **Proceeding with dummy details to get car insurance quote while capturing the error messages with negative inputs**
   - To get a car insurance quote while capturing different error messages with negative inputs.
7. **Navigate back to Home page**
   - Navigating back to the home page.
8. **Retrieve all Health Insurance menu**
   - Click on the Health insurance drop-down on the home page and retrieve the whole list.
     
## Test Cases
1. **Click on the Travel Insurance button on the home page**

 
2. **Enter all the necessary details to get the three lowest international travel insurance paln for two students**


3. **Navigate back to home page and click on the car insurance icon**
 

4. **Click on proceed button without entering a car number and validate the error message**
 

5. **Enter a a valid car number and proceed with an invalid e-mail**


6. **capture the error message for invalid e-mail input**
 

7. **Enter all valid information and get a car insurance quote**


8. **Navigate back to the home page and click on the health insurance drop-down button**


9. **Retrieve the whole list of health insurance menu list from the drop-down**
 
 
## Dependencies
- Selenium: `<4.16.1>`
- TestNG: `<7.9.0>`
- Apache POI: `<5.2.5>`
- Extent Report: `<5.1.1>`
- Logging: `<3.0.0-beta1>`
## Scripting Language
- Java
## Framework
- Maven `<4.0.0>`
## Author
Sumedha Saha(2303442)
