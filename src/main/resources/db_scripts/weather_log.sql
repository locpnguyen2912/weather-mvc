CREATE DATABASE weather;
use weather;
CREATE TABLE weather_log
(
  id          	bigint 	  	NOT NULL      	   	AUTO_INCREMENT,
  city		  	varchar(50)   DEFAULT NULL ,
  temperature 	float         DEFAULT NULL ,
  weather     	varchar(50)   DEFAULT NULL ,
  raw_log     text    		DEFAULT NULL ,
  PRIMARY KEY (id)
);
