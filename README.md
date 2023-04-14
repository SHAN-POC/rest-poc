# Sample REST POC Application

### Getting Started

A sample application that exposes REST API's.

### How to run the application in Docker?

docker build  -t rest-poc:latest .
docker run --name rest-poc-app -p 8081:9000 -e "JAVA_OPTS=-DXmx128m" rest-poc:latest

### How to deploy app through Kubernetes (from PowerShell)?  
  kubectl create deployment rest-poc '--image=shaninfy/rest-poc' '--dry-run=client' '-o=yaml' > deployment.yaml  
  echo --- >> deployment.yaml  
  kubectl create service clusterip rest-poc '--tcp=8081:9000' '--dry-run=client' '-o=yaml' >> deployment.yaml  
  kubectl apply -f deployment.yaml
  kubectl port-forward svc/rest-poc 8081:8081  

### FAQ

**Run below command if we get an error like "Error response from daemon: Conflict. The container name "/rest-poc-app" is already in use by container......"**  
 docker rm rest-poc-app

**Login to container when container is up?**  
 docker exec -it rest-poc-app sh

**How to delete service in kuberntes?**  
 kubectl delete services rest-poc  

**How to delete deployments in kuberntes?**  
 kubectl delete deployment rest-poc  

**View all items (pods, services, deploymets replica-sets etc) in current namespace?**  
  kubectl get all