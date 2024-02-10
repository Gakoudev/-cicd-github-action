FROM openjdk:17
EXPOSE 8080
ADD target/springboot-cicd-image.jar springboot-cicd-image.jar
ENTRYPOINT ["java","-jar","/springboot-cicd-image.jar"]