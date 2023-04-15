# Sample REST POC Application

## Getting Started

A sample application that exposes REST API's.

### How to run the application in Docker?

    docker build  -t rest-poc:latest .
    docker run --name rest-poc-app -p 8081:9000 -e "JAVA_OPTS=-DXmx128m" rest-poc:latest

### Ho to push the app to docker container registry?

    docker push shaninfy/rest-poc:latest

## How to deploy app through Kubernetes (from PowerShell) (app sould have been pushed to container registry) ?  

    kubectl apply -f deployment.yaml

### FAQ

 1. Run below command if we get an error like "Error response from daemon: Conflict. The container name "/rest-poc-app" is already in use by container......"**  

    docker rm rest-poc-app

 2. Login to container when container is up?  

    docker exec -it rest-poc-app sh

 3. How to delete service in kubernetes?  

    kubectl delete services rest-poc  

 4. How to delete deployments in kuberntes?  

    kubectl delete deployment rest-poc  

 5. How to delete all the items created in single shot?

    kubectl delete ns shan-rest-poc-ns

 6. View all items (pods, services, deploymets replica-sets etc) in current namespace?  

    kubectl get all --namespace=shan-rest-poc-ns
