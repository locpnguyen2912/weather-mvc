package com.oddle.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Getter
@Setter
@ToString
public class Wind {
    private float speed;
    private int deg;
}
