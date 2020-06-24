package net.mikej.connectors.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResult {
    private final Integer status;
    private final String request;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MessageResult(
            @JsonProperty("status") final Integer status,
            @JsonProperty("request") final String request
    ) {
        this.status = status;
        this.request = request;
    }

    public Integer getStatus() {
        return status;
    }

    public String getRequest() {
        return request;
    }
}