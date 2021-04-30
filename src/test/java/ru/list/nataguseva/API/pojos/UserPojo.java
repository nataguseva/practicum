package ru.list.nataguseva.API.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {

    @JsonProperty("last_name")
    private String lastName;

    private int id;

    private String avatar;

    @JsonProperty("first_name")
    private String firstName;

    private String email;
}