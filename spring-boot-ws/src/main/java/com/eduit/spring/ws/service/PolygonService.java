package com.eduit.spring.ws.service;

import com.eduit.spring.ws.model.geo.Coordinate;
import com.eduit.spring.ws.model.geo.Polygon;
import com.eduit.spring.ws.resource.request.CoordinateRequest;
import com.eduit.spring.ws.resource.response.PolygonResponse;

public class PolygonService {

    private Polygon polygon;

    public PolygonService(Polygon polygon) {
        this.polygon = polygon;
    }


    public PolygonResponse isInside(CoordinateRequest coordinateRequest){
        Coordinate coordinate = new Coordinate(coordinateRequest.getLatitude(), coordinateRequest.getLongitude());
        boolean inside = polygon.isInside(coordinate);
        return new PolygonResponse(inside);
    }


}
