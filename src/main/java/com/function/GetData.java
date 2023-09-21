package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class GetData {
    /**
     * This function listens at endpoint "/api/GetData". Two ways to invoke it using
     * "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/GetData
     * 2. curl {your host}/api/GetData?name=HTTP%20Query
     */
    @FunctionName("GetData")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = { HttpMethod.GET,
                    HttpMethod.POST }, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        return request.createResponseBuilder(HttpStatus.OK).body("Hello, getData").build();

    }
}
