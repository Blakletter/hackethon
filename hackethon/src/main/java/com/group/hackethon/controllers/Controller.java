package com.group.hackethon.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.group.hackethon.models.Request;
import com.group.hackethon.models.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @Autowired
    private WebClient.Builder webClient;

    @RequestMapping(value="/requestcarbonfootprint", method= RequestMethod.GET)
    public ResponseEntity<Response> footprint(@RequestParam(name="origin") String origin, @RequestParam(name="destination") String destination) throws JSONException {
        double originX = Double.valueOf(origin.split(",")[0]);
        double originY = Double.valueOf(origin.split(",")[1]);
        double destX = Double.valueOf(destination.split(",")[0]);
        double destY = Double.valueOf(destination.split(",")[1]);
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+originX+","+originY+"&destinations="+destX+","+destY+"&key=AIzaSyATB_BqUvfTNkWx2HEBSuUF0AolG_d88Lg";
        System.out.println(url);
        String response = webClient.build().get().uri(url)
                .retrieve().toEntity(String.class).block().getBody();
        System.out.println(response);
        JsonObject data = new Gson().fromJson(response, JsonObject.class);
        JsonObject parent = data.get("rows").getAsJsonArray().get(0).getAsJsonObject().get("elements").getAsJsonArray().get(0).getAsJsonObject();
        String distanceS = parent.get("distance").getAsJsonObject().get("value").toString();
        String timeS = parent.get("duration").getAsJsonObject().get("value").toString();
        String distanceText = parent.get("distance").getAsJsonObject().get("text").toString().replace("\"", "");
        String timeText = parent.get("duration").getAsJsonObject().get("text").toString().replace("\"", "");;

        double time = Integer.valueOf(timeS)*.0166; //get time in minutes
        double distance = Integer.valueOf(distanceS)*0.000621371; //get distance in miles
        double mpg = 35.0;
        //car, bus, airplane, passenger train, motorcycle, hybrid, running
        double[] mpgs = new double[] {35.7, 38.3, 42.6, 71.6,71.8, 110.6, 315};
        double[] co2 = new double[mpgs.length];
        double gallons;
        for (int i =0; i<mpgs.length; i++) {
            co2[i] = (distance/mpgs[i])*.008887;
        }
        return ResponseEntity.status(HttpStatus.OK).body(new Response(distanceText, timeText, co2[0], co2[1], co2[2], co2[3],co2[4], co2[5], co2[6]));
    }
}
