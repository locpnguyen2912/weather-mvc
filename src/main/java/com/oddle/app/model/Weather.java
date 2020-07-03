package com.oddle.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
