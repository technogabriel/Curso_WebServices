package com.eduit.spring.ws.resource.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse {

    @JsonProperty("message")
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageResponse{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
