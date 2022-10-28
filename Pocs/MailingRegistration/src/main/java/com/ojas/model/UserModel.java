package com.ojas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	private int uid;
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	private String mobilenum;
}
