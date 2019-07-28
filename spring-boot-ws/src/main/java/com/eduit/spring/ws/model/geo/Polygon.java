package com.eduit.spring.ws.model.geo;

import java.awt.geom.Path2D;
import java.util.List;

public class Polygon {

    private List<Coordinate> coordinates;
    private Path2D polygon;

    public Polygon(List<Coordinate> coordinates) {
      checkPrecondition(coordinates.size() < 3 , new IllegalArgumentException(" polygon must have at least three coordinates"));
      this.coordinates = coordinates;
      this.polygon = new Path2D.Double();
      drawPolygon(coordinates);
    }

    private void drawPolygon(List<Coordinate> coordinates) {
        Coordinate firstCoordinate = coordinates.get(0);
        this.polygon.moveTo(firstCoordinate.getLatitude(),firstCoordinate.getLongitude());
        for (int i = 1 ; i < coordinates.size() ; i++){
            Coordinate nextCoordinate = coordinates.get(i);
            polygon.lineTo( nextCoordinate.getLatitude(), nextCoordinate.getLongitude());
        }
        polygon.closePath();
    }

    public boolean isInside(Coordinate coordinate ){
     return polygon.contains(coordinate.getLatitude(),coordinate.getLongitude());
    }

    public void checkPrecondition(Boolean condition,RuntimeException e){
        if(condition){
            throw e;
        }
    }

}
