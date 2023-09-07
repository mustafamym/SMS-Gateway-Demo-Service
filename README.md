# SMS-Gateway-Demo-Service
SMS-Gateway-Demo-Service
## bellow technologies are used 

Spring Boot 3

Spring Data

Hibernate 5 + JPA 3

Mysql Database

Lombok

Testing frameworks (JUnit, Mockito)

Maven

feign rest client

##Running the Application
using maven command 

`mvn spring-boot:run`

using java commands

`$ mvn clean package spring-boot:repackage`
`$ java -jar target/SMS-Gateway-Demo-Service-0.0.1-SNAPSHOT.jar`

##application package Structure
![Screenshot](package Structure.png)

## Business logic
after run application 

step 1: run runInboxCheckerScheduler methods under class InboxCheckerScheduler
Scheduler it trigger every 1 minute ,this time can be change.

Each time taking number of row from app_config table

Step 2: call inboxService and get all inbox message where Status = 'N' 

as per requirement document all busniess logic written under methods `findInboxByStatus` 


Step 3: success/failed data you can check calling bellow API

`localhost:8080/api/chargeFailLogs`
`localhost:8080/api/chargeSuccessLogs`

curl call 
`curl --location 'localhost:8080/api/chargeSuccessLogs`
`curl --location 'localhost:8080/api/chargeFailLogs`

Step 4 : this process will continue until app_conf table status = 0 .

## Challenges Faced when developed applications

challenge  1: after restore dump table app_conf column last_reload_time invalid date  value found 

challenge  2: charge_fail_log foreign key wrong mapped (keywordId point to ChargeConf) . i skip this issue and go ahead 










