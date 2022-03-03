FROM adoptopenjdk/openjdk11:latest

COPY ./target/commandes.jar /usr/app/

WORKDIR /usr/app


ENTRYPOINT ["java","-jar","/usr/app/commandes.jar"]
