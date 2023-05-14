# actjhello
Eureka client service 

## Steps to run
- Run the `eureka-server` project as Spring boot app
- Run a actjhello service (Instance 1)
- To run an another instance of a service on a different port follow the below steps
- You need to have server.port property in application.json with different other port than 8080
- Also check version compatibility for Spring cloud, Java, Spring
- MVN clean -> MVN install -> MVN build, this will create a build
- Use `java -jar target/actjhello-0.0.1-SNAPSHOT.jar -Dserver.port=8789` to run the instance.
