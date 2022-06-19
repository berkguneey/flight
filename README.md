# Airway Flight Planning Backend Application

In this application, we want to design a small-scale airway flight planning system. It plans that the aircrafts of airline companies will fly from where to where within certain rules.

* There must be daily at most 3 flights for an airline between 2 destinations.
* The aircraft must be owned by an airline.
* The aircraft must not be on another flight at the same time.
* The aircraft cannot make a new flight before returning to the source airport.
* The source airport and the destination airport should not be the same.

## Description

* GET Airlines Request -> localhost:8080/api/v0/airlines
* GET Airports Request -> localhost:8080/api/v0/airports
* GET Aircrafts Request -> localhost:8080/api/v0/aircrafts
* POST Create Flight Request -> localhost:8080/api/v0/flights

Create Flight Sample POST Request ->

{  
&emsp;&emsp;"airlineId": "fc2e0d68-1352-4dc9-8224-b585cf3a257b",  
&emsp;&emsp;"aircraftId": "6c05786a-c15d-474e-9cdf-bab199b2b2c9",  
&emsp;&emsp;"airportDestinationId": "3dbc4cdd-2c24-4930-bc65-4d2001943d9f",  
&emsp;&emsp;"airportSourceId": "9fdafcfb-4395-416b-9187-fdb7b2e7c0d2",  
&emsp;&emsp;"flightDate": "17-02-2022",  
&emsp;&emsp;"flightTime": "10:00:00",  
&emsp;&emsp;"flightDuration": 1  
}

Using API For Countries: https://countriesnow.space/api/v0.1/countries/iso  
Using API For Airports in a Country: https://airlabs.co/api/v9/airports?api_key={apiKey}?country_code={countryISO2}

All countries and all airports in Turkey, Spain, Italy, Poland, Sweden and Swiss have been added to the system.

![Untitled](https://user-images.githubusercontent.com/32336289/173224887-98e8bf60-e882-4061-ab81-e7fa90eeeb71.png)

## Getting Started

### Using

* Spring Boot
* Java 8
* H2 (In-memory database with initial data)
* Maven
* Junit 5
* Docker

### Executing program

* The application can be run locally or in a docker container, the requirements for each setup are listed below.
* You can execute the program on 8080 port with Docker. Go to the project folder then execute following commands.
```
docker build --tag flight-planning-be-api .
docker run -p 8080:8080 flight-planning-be-api
```
### Requirements

* Docker
* Java 8 SDK
* Maven

## License

Distributed under the MIT License. See [`LICENSE`](https://choosealicense.com/licenses/mit/) for more information.

## Contact

Berk Can Güney - [Github](https://github.com/berkguneey)
