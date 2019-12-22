# burnleydeplasmani
It's a REST API application that uses Spring Boot and Mongo DB.

# Requirements
Spring Boot, MongoDB, Docker

# Build
After installation of Docker, you may run "docker-compose build" from command line.

# Run
After a successful build, you should run "docker-compose-up" from command line. Application runs on http://localhost:18080 address.

# Methods
#### Inserting a number to DB ####
POST request to http://localhost:18080/number/1 (You should change 1 with any integer number)
#### Getting maximum number from DB ####
GET request to http://localhost:18080/number/maximum
#### Getting minimum number from DB ####
GET request to http://localhost:18080/number/minimum
#### Delete a number from DB ####
DELETE request to http://localhost:18080/number/1 (You should change 1 with any integer number)
#### Getting all numbers from DB (default ascending) ####
GET request to http://localhost:18080/number/
#### Getting all numbers from DB ascending order ####
GET request to http://localhost:18080/number/ascending
#### Getting all numbers from DB descending order ####
GET request to http://localhost:18080/number/descending
