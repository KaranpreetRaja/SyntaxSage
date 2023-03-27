# Lab 5 Activity

## Implemented User Stories, Main Developers, and Testers
- Syntax Testing Tester: Karanpreet
- Progress Bar Tester: Mohammad
- Badges and Award Tester: Ryan
- Syntax Docs Tester: Abdirazak
- Sign In/Sign Up Tester: Rajendra




## End to End Manual Tests
- Syntax Testing
  - Sign in with test account (user: test, pass: test). Launch session. When a multiple select window pops up, try selecting the two correct answers displayed on the window. Click submit button.
  - Sign in with test account (user: test, pass: test). Launch session. When a multiple choice window pops up, try selecting the one correct answer displayed on the window. Click submit button.
  - Sign in with test account (user: test, pass: test). Launch session. When a multiple select window pops up, try selecting one correct answer displayed on the window. Click submit button. It should say answer is partially correct.
  - Sign in with test account (user: test, pass: test). Launch session. When a multiple choice window pops up, try selecting an incorrect answer displayed on the window. Click submit button. It should display incorrect answer.

- Progress Bar:
  - Create a new account (to ensure that no lessons have been completed for the account), once on the dashboard, click on the "Update Progress Bar" button. This should yeild in the progress bar staying at 0%.
  - Log into the same account and click on the "Update Progress Bar" button. This should again yield in the progress bar staying at 0%.
  - Log into the same account and locate any lesson, and click on "Start Lesson", Go through and complete the Lesson. Once it is completed, click on the "Update Progress Bar" button, this should start incrementing the percent on the progress bar until it reaches the percent of the course which is completed.
  - Log into the same account, and click on the "Update Progress Bar" button. It should increment to the value that it was previously at.

- Badges and Awards:
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Switch tabs to dashboard. Ensure that all achieved badges are displayed (Admin account should have 3 python badges).
  - Start Program. Switch to Sign up Page. Sign up with a brand new account (Unique Username). Switch tabs to dashboard. Ensure that there are no achieved badges. Click Update Badges. Ensure that no badges show up.
  - Start Program. Switch to Sign up Page. Sign up with a brand new account (Unique Username). Switch tabs to dashboard. Ensure there are no achieved badges. Click Update Badges. Ensure no badges show up. Switch back to home page. Start Lesson. Complete Lesson. Switch Tabs to dashboard. Click Update Badges. Ensure that All badges show up.
  - Start Program. Sign in with existing account (Not Admin Account). Switch tabs to dashboard. Ensure there are no achieved badges. Click Update Badges. Ensure no badges show up. Switch back to home page. Start Lesson. Complete Lesson. Switch Tabs to dashboard. Click Update Badges. Ensure that All badges show up.

- Syntax Docs:
  - Resize application to full screen considering there isn't any responsiveness
  added.
  - Verify that the Syntax Doc frame appears. The document will be displayed on
  the left side of the frame covering at least 80 percent of the width.
  - Verify that the navigation bar is located on the left side.
  -- Make sure that html, css, javascript, SQL, and python are there.
  - Verify navigation: There are multiple language nav links on the left side, click on
  one of them and you will be given the document for that language on the left
  panel.
  - Verify the scroll bar works.
  - Verify the document is displayed on the left panel for the given language.
  - Scroll down and verify that there is sufficient vital information displayed and its
  content is related to the selected language. (Do this with each language).
  -- You can compare this to the information that the designer scraped off of
  w3schools site.
  - Verify the back button located at the top left corner works, you will be brought
  back to the dashboard.

- Sign In/Sign Up:
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that the login page is displayed when the application is launched.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that the "Sign In" and "Register" buttons are displayed on the login page.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that clicking the "Register" button takes the user to the registration page.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that the user is able to enter their username and password in the input fields.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that clicking the "Sign In" button with valid credentials takes the user to the dashboard page.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that clicking the "Sign In" button with invalid credentials displays an error message.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that the dashboard page is displayed with the correct account details when the user logs in successfully.
  - Start Program. Sign in with existing account (Username: Admin, Password: Admin). Verify that the user is able to log out from the dashboard page and is redirected back to the login page.
  - Test that the frame is properly displayed when the class is instantiated.
  - Test that the buttons are properly displayed and can be clicked.
  - Test that the input fields are properly displayed and can be edited.
  - Test that the dropdown menu is properly displayed and courses can be selected.
  - Test that the username and password are properly entered and stored.
  - Test that the username is checked against the database and an error message is displayed if it already exists.
  - Test that a new account is created in the database if the username is available.
  - Test that the account is properly stored in the database.
  - Test that the dashboard is properly displayed after the account is created.
