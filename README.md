# SurfouAPI

SPRINGBOOT 3.2.4 + Hibernate Spatial + PostgreSQL16 (& PostGIS) + GeoJSON

REST API to retrieve locations of various nautical activities such as kitesurfing, windsurfing, etc., along with their associated ideal weather conditions. Users can query the API to get detailed information based on activity type, location, or weather conditions.

Create a database "surfoudb" with postgis extension : see createDb.sql
user: surfouAdmin & password: Pa$$w0rd

Hibernate create schema and dummy data are added on initialization : see resources/data.sql

Endpoints :
url on local database : http://localhost:9000/v1

(For spots objects : geometry a GEOJSON)

GET /spots  

GET /spots/{id}

POST /spots

DELETE /spots/{id}


GET /spottypes

POST /spottypes

GET /nauticalactivities

POST /nauticalactivities

GET /activitiesdescriptions

POST /activitiesdescriptions

GET /conditions

POST /conditions

GET /users

GET /users/{id}

POST /users

WORK IN PROGRESS 

