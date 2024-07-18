# Assignment_RID_v1
 A REST API  to handle simple information storage and retrieval 
requests for sensor readings of the following 3 types of sensors:
* Temperature Sensor
* Humidity Sensor
* Acoustic Sensor

## Features  
* Pagination support for large data sets(the page size is set at 10)
* add,view sensors to the main database
* add,view readings for a specific sensor
* search for readings
* view the metrics of a sensor which include the mean ,max values, min values and value range 
  
## Requirements
* Java 17 or higher
* Maven
* PostgreSQL database

## Installation & Run
* Clone the repository
```
git clone https://github.com/JohnSkouloudis/Assignment_RID_v1.git
```
```
cd Assignment_RID_v1
```
* Update the application.properties to match your database
* Update the username,password,url
```
  spring.application.name=v1

  server.port = 9090

  spring.datasource.username=${DB_USERNAME}
  spring.datasource.password=${DB_PASSWORD}
  spring.datasource.url=jdbc:postgresql://${DB_URL}

  spring.jpa.generate-ddl=true
  spring.jpa.hibernate.ddl-auto=update

  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true


  spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
```

* Start Spring
```
mvn spring-boot:run
```

## Run Tests(optional)
```
.\mvnw test
```

## Endpoints

### Sensor Endpoints

- `POST /api/sensors/new`: Add a new sensor
   - Request Body example:
   ```
  {
  "sensorType": "Temperature",
  "vendorName": "John",
  "vendorEmail": "john@gmail.com",
  "description": "example for the POST endpoint",
  "location": "Athens"
  }
   ```
   - details of each field:
     - `sensorType`(string,size between 5 and 20): the type of the sensor
     - `vendorName`(string,size between 3 and 50): the name of the vendor
     - `vendorEmail`(string,size at least 5): the email of the vendor
     - `description`(string,size between 4 and 100): a description of the sensor
     - `location`(string,size between 3 and 100): the location of the sensor
  -
  
- `GET /api/sensors/all`: Get all available sensors
   - Query Parameters:
     - `page`(integer)
       
- `GET /api/sensors/{sensor_id}`: Get a sensor's info
   - Path Parameters:
     - `sensor_id`(integer)
       
- `GET /api/sensors/metrics/{sensor_id}`: Get a sensor's metrics which include mean,max values,min values and values range
   - Path Parameters:
     - `sensor_id`(integer)
  
### Reading Endpoints
- `POST /api/readings/new/{sensor_id}`: Add a new reading for a sensor
   - Path Parameters:
     - `sensor_id`(integer)
   - Request Body example:
  ```
  {
  "readingType": "example",
  "readingValue": 9.8,
  "readingDate": "1/7/2024",
  "description": "an example for the endpoint",
  "time": "15:30"
  } 
  ```
    - details of each field:
      - `readingType`(string,size between 5 and 20): the type of the reading
      - `readingValue`(double): the value of the reading
      - `readingDate`(string,size between 5 and 20): the date of the reading
      - `description`(string,size between 4 and 100): a description of the reading
      - `time`(string,size between 4 and 20): the time of the reading
       
- `GET /api/readings/{sensor_id}`: Get the readings of a sensor
   - Path Parameters:
     - `sensor_id`(integer)
   - Query Parameters:
     - `page`(integer)
       
- `GET /api/readings/search`: Search for a reading based on location,sensor type and time 
   - Query Parameters:
     - `page`(integer)
     - `sensorType`(string)
     - `location`(string)
     - `time`(string)


## See API Documentation
```
localhost:9090/swagger-ui/index.html
```
