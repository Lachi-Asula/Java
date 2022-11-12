package com.flames.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flames.model.CommonResponse;
import com.flames.model.Constants;
import com.flames.model.RelationDTO;
import com.flames.model.UserDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class FlamesService {

    public CommonResponse getRelationType(UserDTO userDTO){
        CommonResponse commonResponse = new CommonResponse();
        JSONObject finalResponse = new JSONObject();
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        RelationDTO relationDTO;
        try{
            if(userDTO != null && userDTO.getFirstName() != null && userDTO.getSecondName() != null && !userDTO.getFirstName().isEmpty() && !userDTO.getSecondName().isEmpty()) {
                String relation = getFinalRelation(userDTO);
                relationDTO = RelationDTO.builder()
                        .relation(relation)
                        .isSuccessful(Constants.status_True)
                        .errorMsg(null)
                        .build();
                commonResponse.setSuccessful(true);
            }else {
                relationDTO = RelationDTO.builder()
                        .relation(null)
                        .isSuccessful(Constants.status_False)
                        .errorMsg(Constants.errorMsg)
                        .build();
                commonResponse.setSuccessful(false);
            }
                String response = mapper.writeValueAsString(relationDTO);
                finalResponse.put(Constants.response, parser.parse(response));
                commonResponse.setResponseText(finalResponse);

        }catch (Exception e){
            e.printStackTrace();
        }
        return commonResponse;
    }

    public int getLengthOfNames(UserDTO userDTO){
        StringBuffer firstName = new StringBuffer(userDTO.getFirstName().toLowerCase().trim());
        StringBuffer secondName = new StringBuffer(userDTO.getSecondName().toLowerCase().trim());
        for(int i = 0; i < firstName.length(); i++){
            for(int j = 0 ; j < secondName.length(); j++){
                if(firstName.charAt(i) == secondName.charAt(j)){
                    firstName.deleteCharAt(i);
                    secondName.deleteCharAt(j);
                    i--;
                    break;
                }
            }
        }
        return firstName.append(secondName).length();
    }

    public char getFinalFlamesChar(UserDTO userDTO){
        int nameLength = getLengthOfNames(userDTO);
        int count = 0;
        char lastChar = Constants.Flames.charAt(0);
        try{
            StringBuffer flames = new StringBuffer(Constants.Flames);
            for(int i = 0; i < flames.length(); i++){
                if(flames.length() == 1) {
                    return flames.charAt(0);
                }
                count++;
                if(count == nameLength){
                    flames.deleteCharAt(i);
                    i--;
                    count = 0;
                }
                if(i == flames.length() - 1) {
                    i = -1;
                }
            }
        }catch(Exception e){
           e.printStackTrace();
        }

        return lastChar;
    }

    public String getFinalRelation(UserDTO userDTO){
        char finalChar = getFinalFlamesChar(userDTO);
        Map<Character, String> relations = new HashMap<>();
        relations.put('F', "FRIENDSHIP");
        relations.put('L', "LOVE");
        relations.put('A', "AFFECTION");
        relations.put('M', "MARRIAGE");
        relations.put('E', "ENEMY");
        relations.put('S', "SIBLINGS");

        return relations.get(finalChar);
    }

//    public static void main(String[] args) {
//        UserDTO userDTO = UserDTO.builder()
//                .firstName("lachi")
//                .secondName("siva")
//                .build();
//
//        System.out.println(new FlamesService().getFinalRelation(userDTO));
//    }



}
