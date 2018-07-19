# UIAutomationII
Java based UI automation using the selenium webdriver framework

MacOS/Linux/Windows Setup

1. Just run them :-)

Running via gradle

1. cd to the project directory
2. run gradle build
3. run gradle build test
Also it's possible to run tests in Chrome or Firefox. Pass `-Dbrowser=chrome` or `firefox`.
For running headless add `-Dheadless=true` parameter

Running via Idea IDE

1. Open the project in idea and run the gradle script
2. Go to the project structure menu
3. Under the modules menu -> sources tab mark the seasonedtests and all its subdirectories as tests (green)
4. Under the modules menu -> dependencies add the selenium-server-standalone jar as well as the following libraries downloaded from gradle:
  a. testng:6.11
  b. gson 2.8.0
  c. guava:21.0
  d. json-simple:1.1.1
  e. okhttp:3.6.0
  f. okio:1.11.0
  g. converter-gson:2.2.0
  h. retrofit:2.2.0
5. Click ok.

Modify the TestSuiteData file path in TestDataImporter.java

1. Change the directory for the JSONObject testSuiteData variable to point to your directory.
