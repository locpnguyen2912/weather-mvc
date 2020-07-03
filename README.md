# weather-mvc
- A simple web app(search weather) using SpringMVC, MySQL, Maven
- Main function:
    + Search weather by city location via openweather api
    + Display weather data log in the past for archiving purpose
    + Delete weather log
- Instruction:
    + Update MySQL Server password in application.properties
    + Execute SQL scripts (src\main\resources\db_scripts\weather_log.sql)    
    + Build project with Maven and deploy on tomcat server
    + Open a browser and navigate to http://localhost:{port number}/WeatherApp/weather/list