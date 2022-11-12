package com.flames.controller;

import com.flames.model.CommonResponse;
import com.flames.model.UserDTO;
import com.flames.service.FlamesService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/flames")
public class FlamesResource {

    @Autowired
    FlamesService flamesService;

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
