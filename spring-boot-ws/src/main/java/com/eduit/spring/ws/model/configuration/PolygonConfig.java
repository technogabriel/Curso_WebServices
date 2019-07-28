package com.eduit.spring.ws.model.configuration;

import com.eduit.spring.ws.model.geo.Coordinate;
import com.eduit.spring.ws.model.geo.Polygon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class PolygonConfig {

    @Bean
    public Polygon polygon(){
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(-34.477070, -58.518912));
        coordinates.add(new Coordinate(-34.652819, -58.293533));
        coordinates.add(new Coordinate(-34.732618, -58.502595));
        coordinates.add(new Coordinate( -34.608434, -58.546949));
        return new Polygon(coordinates);
    }

}
