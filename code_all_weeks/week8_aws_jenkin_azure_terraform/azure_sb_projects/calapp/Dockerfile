FROM openjdk:17-alpine
MAINTAINER email="rgupta.mtech@gmail.com"
EXPOSE 8080
ADD target/calapp.jar calapp.jar
ENTRYPOINT ["java","-jar","calapp.jar"]