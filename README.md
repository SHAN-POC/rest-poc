# Payroll Application

### Getting Started

A sample application that exposes REST API's.

### How to run the application in Docker?
 mvn clean package  
 docker build  -t shaninfy/rest-poc .  
 docker run --name rest-poc-app -p 8081:9090 shaninfy/rest-poc 
 

### FAQ

Run below command if we get an error like "Error response from daemon: Conflict. The container name "/rest-poc-app" is already in use by container......"    
 docker rm rest-poc-app