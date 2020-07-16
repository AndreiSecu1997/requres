package in.requres.utilities;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class ScenarioContext {
    private Response response;
    private static ScenarioContext scenarioContext = new ScenarioContext();

    private ScenarioContext() {

    }

    public static ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
