package com.flames.model;

import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class CommonResponse {

	private JSONObject responseText;
	private boolean isSuccessful;
}
	
