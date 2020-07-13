package in.requres.steps;

import lombok.Data;

@Data
public class RequestSpecs {
public String baseUrl;
private String authServerUrl;
    {
        baseUrl = System.getProperty("env");
    }
}
