### Generate image with jar ###

FROM eclipse-temurin:17-jre-alpine
WORKDIR /ProductCatalog
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ProductCatalog.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","./ProductCatalog.jar"]


### Generate image using Maven ###

# # https://hub.docker.com/_/maven
# FROM maven:3.8-eclipse-temurin-17-alpine AS maven_build
# # FROM eclipse-temurin:17-jre-alpine AS maven_build
# WORKDIR /tmp
# COPY pom.xml .
# # COPY .m2/settings.xml .
# COPY src ./src/
# COPY .m2/settings.xml /usr/share/maven/ref/
# # RUN apt update && apt install -y maven
# RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
# RUN mvn clean package -DskipTests

# FROM eclipse-temurin:17-jre-alpine
# WORKDIR /ProductCatalog
# ARG JAR_FILE=/tmp/target/*.jar
# COPY --from=maven_build ${JAR_FILE} ProductCatalog.jar
# EXPOSE 8081
# ENTRYPOINT ["java","-jar","/ProductCatalog.jar"]



