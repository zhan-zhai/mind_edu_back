FROM java:8
FROM neo4j:3.5.0
VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
COPY ./ ./
#EXPOSE 8899
ENTRYPOINT ["java","-jar","mindmap-backend-0.0.1-SNAPSHOT.jar"]
