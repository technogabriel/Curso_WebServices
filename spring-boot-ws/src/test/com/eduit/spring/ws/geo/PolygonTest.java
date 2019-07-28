package com.eduit.spring.ws.geo;

import com.eduit.spring.ws.model.geo.Coordinate;
import com.eduit.spring.ws.model.geo.Polygon;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PolygonTest {

    private Polygon polygon;
    private boolean insidePolygon;
    private boolean outSide;

    @Test
    public void shouldBeInsidePolygon(){
        givenAPolygon();
        whenCheckACoordinate();
        thenMustBeInside();
    }

    @Test
    public void shouldBeOutsidePolygon(){
        givenAPolygon();
        thenMustCheckOutSideCoordinate();
        thenMustBeOutSide();

    }

    private void thenMustCheckOutSideCoordinate() {
        Coordinate coordinate = new Coordinate(-34.504590, -58.646879);
        outSide = polygon.isInside(coordinate);
    }

    private void thenMustBeOutSide() {
        Assert.assertFalse(outSide);
    }

    private void thenMustBeInside() {
        Assert.assertTrue(insidePolygon);
    }

    private void whenCheckACoordinate() {
        Coordinate coordinate = new Coordinate(-34.607872,-58.472566);
        insidePolygon = polygon.isInside(coordinate);
    }

    private void givenAPolygon() {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(-34.477070, -58.518912));
        coordinates.add(new Coordinate(-34.652819, -58.293533));
        coordinates.add(new Coordinate(-34.732618, -58.502595));
        coordinates.add(new Coordinate( -34.608434, -58.546949));
        polygon = new Polygon(coordinates);
    }


}
