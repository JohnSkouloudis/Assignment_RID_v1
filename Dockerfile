FROM maven:3.8.6-eclipse-temurin-19-alpine

WORKDIR /api

COPY . .

RUN mvn clean install

EXPOSE 9090

# default enviroment variables
ENV DB_USERNAME=user
ENV DB_PASSWORD=password
ENV DB_URL=host.docker.internal:5432/postgres

CMD ["mvn", "spring-boot:run"]