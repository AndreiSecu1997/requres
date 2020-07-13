package in.requres.steps;

import in.requres.steps.utilities.RequestsManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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

    @Then("the response code is {int}")
    public void theResponseCodeIs(int responseCode) {
        scenarioContext.getResponse().then().statusCode(responseCode);
    }

    @And("the {string} list contains {int} entities")
    public void theListContainsEntities(String listName, int expectedSize) {
        Integer actualSize = ((List) scenarioContext.getResponse().jsonPath().get(listName)).size();
        String message = String.format(("%n The '%s' list size is: %s but must be: %s %n"), listName, actualSize, expectedSize);
        assertThat(message, expectedSize, is(actualSize));
    }

    @And("each {string} entity contains the following attributes:")
    public void eachEntityContainsTheFollowingAttributes(String listName, List<String> expectedAttributesList) {
        List<Map<String, String>> actualDataAttributes = scenarioContext.getResponse().jsonPath().get(listName);
        String message = "%n The %s entity of the '%s' list%n doesn't contain attribute '%s'";
        expectedAttributesList.forEach(attr ->
                actualDataAttributes.forEach(actualAttr ->
                        assertThat(String.format(message, actualAttr, listName, attr),
                                actualAttr.containsKey(attr))));

    }

    @And("the list {string} contains the following attributes with values:")
    public void theListContainsTheFollowingAttributesWithValues(String listName, Map<String, String> expectedAttributes) {
        List<Map<String, Object>> attributes = scenarioContext.getResponse().jsonPath().get(listName);
        expectedAttributes.forEach((k, v) -> assertListContent(k, v, attributes));
    }

    private void assertListContent(String k, String v, List<Map<String, Object>> elements) {
        String msg = String.format("%n The attribute: '%s' with value: '%s' isn't present in list:%n%s", k, v, elements);
        Optional<Map<String, Object>> entity = elements.stream()
                .filter(element -> element.containsKey(k) && element.get(k).equals(v)).findFirst();
        assertThat(msg, entity.isPresent(), is(true));
    }

    @And("the response contains the following attributes with values:")
    public void theResponseContainsTheFollowingAttributesWithValues(Map<String, String> expectedAtr) {
        expectedAtr.forEach((k, v) -> assertThat(v, is(getAttrValueAsString(k))));
    }

    private String getAttrValueAsString(String k) {
        return scenarioContext.getResponse().jsonPath().get(k).toString();
    }
}
