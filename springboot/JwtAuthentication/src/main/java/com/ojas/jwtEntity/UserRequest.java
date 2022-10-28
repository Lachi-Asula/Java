package com.ojas.jwtEntity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private String username;
	private String password;
}
