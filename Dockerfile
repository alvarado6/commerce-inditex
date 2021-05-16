FROM openjdk:12
VOLUME /tmp
EXPOSE 8080
ADD ./target/commerce-0.0.1-SNAPSHOT.jar commerce.jar
ENTRYPOINT ["java","-jar","/commerce.jar"]