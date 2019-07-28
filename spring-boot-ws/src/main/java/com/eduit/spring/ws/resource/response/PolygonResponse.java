package com.eduit.spring.ws.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolygonResponse {

    @JsonProperty("inside")
    private boolean inside;

    public PolygonResponse(boolean inside) {
        this.inside = inside;
    }

    public boolean isInside() {
        return inside;
    }
}
