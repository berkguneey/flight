# Airway Flight Planning Backend Application

In this application, we want to design a small-scale airway flight planning system. It plans that the aircrafts of airline companies will fly from where to where.

## Description

GET Request -> localhost:8080/api/v0/flights

## Getting Started

### Using

* Spring Boot
* Java 8
* H2 (In-memory database with initial data)
* Maven
* Docker

### Executing program

* This command executes the application with scheduler mode. For this reason, program is expected to run at midnight every day. (00:00)
* If you want to work without scheduler mode, this command should be commented out. (or can be set false)
```
scheduler.enabled=true
```

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
