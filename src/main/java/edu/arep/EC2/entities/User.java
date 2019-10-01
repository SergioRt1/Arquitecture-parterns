package edu.arep.EC2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class User {
    public static final String TABLE = "users";
    public static final String ID = "id";

    private Integer id;
    private String name;
    @JsonProperty("last_name")
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Object> toMap() {
        return new HashMap<String, Object>() {
            {
                put("id", id);
                put("name", name);
                put("last_name", lastName);
            }
        };
    }
}
