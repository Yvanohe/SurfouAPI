# SurfouAPI

SPRINGBOOT 3.2.4 + Hibernate Spatial + PostgreSQL16 (& PostGIS) + GeoJSON
and secured with SPRING SECURITY

REST API to retrieve locations of various nautical activities such as kitesurfing, windsurfing, etc., along with their associated ideal weather conditions. Users can query the API to get detailed information based on activity type, location, or weather conditions.


Create a database "surfoudb" with postgis extension : see createDb.sql
user: surfouAdmin & password: Pa$$w0rd

Hibernate create schema and dummy data are added on initialization : see resources/data.sql


Using Spring Security to secure API with JWT. You have to create rsa private & public keys with OpenSSL and put it in /resources/certs. See https://www.danvega.dev/blog/spring-security-jwt#rsa-public-private-keys :
```
# create rsa key pair
openssl genrsa -out keypair.pem 2048

# extract public key
openssl rsa -in keypair.pem -pubout -out public.pem

# create private key in PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
````

Endpoints :
url : http://localhost:[port]/v1
Get the token on /auth/login endpoint with "user"/"password" credentials.

Swagger3 on http://localhost:9000/v1/swagger-ui/index.html#/ :

![alt text](image.png)

(For spot objects : geometry a GEOJSON)

WORK IN PROGRESS 

