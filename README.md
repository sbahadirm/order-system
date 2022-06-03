# Order System

### About The Project
Order System is an online ordering application. 

### Summary

In this project;

- Each module has three letter aliases.  Every classes or interfaces that related with it start with these alliases.
- Dependencies are managed by Maven.
- Every request is validated with Spring Validation
- Documented with Swagger.
- Endpoints use DTOs instead of entities. Convert operations are done with mapstruct.
- Tests were written with Junit&Mockito.
- Lombok was used. 
- The structure of the all responses are same. It can be understood from the isSuccess field that the requests are successful or unsuccessful.

Module  | Allias
------------- | -------------
Customer  | Cus
Order  | Ord
Product  | Prd 
Generic  | Gen 


### Technologies
- Java 17
- PostgreSQL
- Spring Boot 
- Maven
- Junit, Mockito
- Swagger
- Lombok
- Mapstruct

### Prerequisites
- Java 17 or never
- Docker Desktop

# Installation
1. Clone the repo

```sh
https://github.com/sbahadirm/order-system.git
```

2. Run Docker-Compose file 
```powershell
 > mvn clean install
```

3. Run Docker-Compose file 
```powershell
 > docker-compose up
```
   
