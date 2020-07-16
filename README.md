# in.requres
API Automation Framework
1. Create the MAVEN Project
2. Set UP the High Level Structure:
    *Add app.properties file within the resource folder
    *Create in.requres folder (that will contain the ATF resource and core)
    *Create the steps' folder (that will hold the Steps and Hooks classes)
    *Create the utilities' folder (that will hold the additional management classes)
    *Create the features' folder (that will hold the features files)
3. Open the POM file and add the following dependencies:
    *Junit - 4.13
    *Selenium-Java - 3.141.59
    *Cucumber-Java - 4.7.4
    *Cucumber-Junit - 4.7.4
    *Cucumber-Piccontainer - 1.2.5
    *Lombok - 1.18.10
    *rest-assured - 4.1.2
    *json-path - 4.1.2
    *hamcrest - 2.1
4. Create the Test Run class and add mandatory config options:
    *features (feature directory path)
5. Create the RequestSpec class, that is going to manage and provide the base_url
6. Create a maven profile within the POM file
7. Create the RequestsManager class that is going to perform all the REST-Assured requests
8. Create the ScenarioContext class that is aimed to hold the context through the TCs
9. Create the first feature file
10. Define the first Scenario and build the steps within the steps' directory.