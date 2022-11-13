package com.flames.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flames.model.CommonResponse;
import com.flames.model.UserDTO;
import com.flames.model.WelcomeDTO;
import com.flames.service.FlamesService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/flames")
public class FlamesResource {

    @Autowired
    FlamesService flamesService;

    @GetMapping("/welcome")
    public JSONObject getWelcome(){
        String res = "";
        WelcomeDTO welcomeDTO = WelcomeDTO.builder()
                .message("Welcome to the Flames Application")
                .build();
        JSONObject response = new JSONObject();
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        try {
            res = mapper.writeValueAsString(welcomeDTO);
            response = (JSONObject) parser.parse(res);
        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    @PostMapping("/getRelation")
    public JSONObject getRelation(@RequestBody UserDTO request) {
        CommonResponse response = new CommonResponse();
        try {
            response = flamesService.getRelationType(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response.getResponseText();
    }
}
