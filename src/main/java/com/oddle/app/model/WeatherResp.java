package com.oddle.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Getter
@Setter
@ToString
public class WeatherResp {
    private Long id;
    private String name;
    private Long visibility;
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private Clouds clouds;
}
