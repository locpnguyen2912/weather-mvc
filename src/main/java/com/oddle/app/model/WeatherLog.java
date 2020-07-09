package com.oddle.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="weather_log")
@Data
@NoArgsConstructor
public class WeatherLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "weather")
    private String weather;

    @Column(name = "raw_log")
    private String rawLog;

}
