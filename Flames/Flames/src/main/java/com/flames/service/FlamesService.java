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
        UserDTO userDTO1 = UserDTO.builder().build();
        try{
            if(userDTO != null && userDTO.getFirstName() != null && userDTO.getSecondName() != null && !userDTO.getFirstName().isEmpty() && !userDTO.getSecondName().isEmpty()) {
                userDTO1 = UserDTO.builder()
                        .firstName(userDTO.getFirstName())
                        .secondName(userDTO.getSecondName())
                        .build();
                userDTO.setFirstName(userDTO.getFirstName().replaceAll("\\s", ""));
                userDTO.setSecondName(userDTO.getSecondName().replaceAll("\\s", ""));
                String relation = getFinalRelation(userDTO);
                relationDTO = RelationDTO.builder()
                        .relation(relation)
                        .firstName(userDTO1.getFirstName())
                        .secondName(userDTO1.getSecondName())
                        .description(getDescription(relation))
                        .isSuccessful(Constants.status_True)
                        .errorMsg(null)
                        .build();
                commonResponse.setSuccessful(true);
            }else {
                relationDTO = RelationDTO.builder()
                        .relation(null)
                        .firstName(userDTO1.getFirstName())
                        .secondName(userDTO1.getSecondName())
                        .description(null)
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
        relations.put('F', Constants.friendShip);
        relations.put('L', Constants.love);
        relations.put('A', Constants.affection);
        relations.put('M', Constants.marriage);
        relations.put('E', Constants.enemy);
        relations.put('S', Constants.siblings);

        return relations.get(finalChar);
    }

    public String getDescription(String relation){
        Map<String, String> description = new HashMap<>();
        description.put(Constants.friendShip, Constants.friendShipDesc);
        description.put(Constants.love, Constants.love);
        description.put(Constants.affection, Constants.affectionDesc);
        description.put(Constants.marriage, Constants.marriageDesc);
        description.put(Constants.enemy, Constants.enemyDesc);
        description.put(Constants.siblings, Constants.siblingDesc);

        return description.get(relation);
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
