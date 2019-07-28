package com.eduit.spring.ws.resource;

import com.eduit.spring.ws.resource.request.CoordinateRequest;
import com.eduit.spring.ws.resource.response.PolygonResponse;
import com.eduit.spring.ws.service.PolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/polygon")
public class PolygonResource {

    @Autowired
    private PolygonService polygonService;


    @PostMapping(value = "/inside" ,consumes="application/json" ,  produces="application/json")
    public @ResponseBody ResponseEntity<PolygonResponse> isInside(
                                @RequestBody CoordinateRequest coordinateRequest){
        PolygonResponse polygonResponse = polygonService.isInside(coordinateRequest);
        return ResponseEntity.ok(polygonResponse);
    }


}
