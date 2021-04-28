package ru.list.nataguseva.API.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPojoFull{
    @JsonProperty("last_name")
	private String lastName;
	private int id;
	private String avatar;
	@JsonProperty("first_name")
	private String firstName;
	private String email;

	public UserPojoFull(String lastName, int id, String avatar, String firstName, String email) {
		this.lastName = lastName;
		this.id = id;
		this.avatar = avatar;
		this.firstName = firstName;
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}
}
