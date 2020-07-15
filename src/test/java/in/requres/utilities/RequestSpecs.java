package in.requres.utilities;

import lombok.Data;

@Data
public class RequestSpecs {
public String baseUrl;
private String authServerUrl;
    {
        baseUrl = System.getProperty("env");
    }
}
