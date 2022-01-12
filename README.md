# URLShortener
Url shortener app in spring boot

## To run locally
### Pre-requisites
- JDK
- Maven
- Redis server
```
mvn clean package
java -jar URLShortner-0.0.1-SNAPSHOT.jar
```

## To run locally using docker
```
docker pull redis
docker run -d --name redis -p 6379:6379 redis

#navigate to root folder of project where Dockerfile is present
docker build -t url-shortener:version1 .
docker run -d --name url-shortener -p 8080:8080 --link redis url-shortener:version1
```

## To pull image from docker hub
```
docker pull ravithota7/url-shortener-v2:latest
docker pull redis
docker run -d --name redis -p 6379:6379 redis
docker run -d --name url-shortener -p 8080:8080 --link redis ravithota7/url-shortener-v2:latest
```
link to docker image [url-shortener](https://hub.docker.com/repository/docker/ravithota7/url-shortener-v2)
