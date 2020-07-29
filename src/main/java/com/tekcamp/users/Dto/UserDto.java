package com.tekcamp.users.Dto;

public class UserDto {

	private Long id; 
	private String userId; 
	private String firstName; 
	private String lastName; 
	private String email; 
	private String password; 
	private String encryptedPassword; 
	private boolean emailVerification;
	
	
	public UserDto() {
		super();
	}


	public UserDto(Long id, String userId, String firstName, String lastName, String email, String password,
			String encryptedPassword, boolean emailVerification) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.encryptedPassword = encryptedPassword;
		this.emailVerification = emailVerification;
	}


	public Long getId() {
		return id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}


	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}


	public boolean isEmailVerification() {
		return emailVerification;
	}


	public void setEmailVerification(boolean emailVerification) {
		this.emailVerification = emailVerification;
	}
	
	
	
}
