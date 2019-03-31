# South Africa mobile numbers validator
- This application receive ZA mobile numbers by uploading CSV file and try to validate these numbers, saving them in three Types (VALID, FIXED, INVALID) into mysql database
- Also this application can validate one single single number

## Used technologies
- Java 8
- Mysql database
- Rest endpoints
- Liquibase
- Swagger
- HATEOAS


## How to start the application
- This application uses Liquibase, So you just need to create Mysql Database with name "validator", and Liquibase will take the control of creating the tables required ;)  
- In-case you need to change the the database name, username or password. You just need to check these configurations in 'application.properties'

## How to use the application 
This application uses SWAGGER, and HATEOAS or documentations to document all the endpoints and how to use ;)
You just need to start the application and hit `http://localhost:8080/` this will redirect you to swagger documentation UI page. 

ENJOY ;)