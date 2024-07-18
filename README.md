# Assignment_RID_v1
 A REST API  to handle simple information storage and retrieval 
requests for sensor readings of the following 3 types of sensors:
* Temperature Sensor
* Humidity Sensor
* Acoustic Sensor

## Features  
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
./mvnw test
```

## Endpoints

### Sensor Endpoints

- `POST /api/sensors/new`: Add a new sensor
   - Request Body example:
   ```
  {
  "sensorId": ,
  "sensorType": "Temperature",
  "vendorName": "John",
  "vendorEmail": "john@gmail.com",
  "description": "example for the POST endpoint",
  "location": "Athens"
  }
   ```
  
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
  "id": ,
  "readingType": "example",
  "readingValue": 9.8,
  "readingDate": "1/7/2024",
  "description": "an example for the endpoint",
  "time": "15:30"
  } 
  ```
       
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
