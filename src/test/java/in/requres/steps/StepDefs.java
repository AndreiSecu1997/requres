package in.requres.steps;

import in.requres.steps.utilities.RequestsManager;
import io.cucumber.java.en.Given;

import java.util.Map;

public class StepDefs {
    private RequestsManager requestsManager;

    public StepDefs(RequestsManager requestsManager) {
        this.requestsManager = requestsManager;
    }

    private final ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    @Given("GET Request on {string} is performed")
    public void getRequestOnIsPerformed(String endpoint) {
        scenarioContext.setResponse(requestsManager.getRequest(endpoint));
    }

    @Given("POST Request on {string} is performed with the following body:")
    public void postRequestOnIsPerformedWithTheFollowingBody(String endpoint, Map<String, String> bodyParams) {
        scenarioContext.setResponse(requestsManager.postRequest(endpoint, bodyParams));
    }

    @Given("PUT Request on {string} is performed with the following body:")
    public void putRequestOnIsPerformedWithTheFollowingBody(String endpoint, Map<String, String> bodyParams) {
        scenarioContext.setResponse(requestsManager.putRequest(endpoint, bodyParams));
    }

    @Given("DELETE Request on {string} is performed")
    public void deleteRequestOnIsPerformed(String endpoint) {
        scenarioContext.setResponse(requestsManager.deleteRequest(endpoint));

    }
}
