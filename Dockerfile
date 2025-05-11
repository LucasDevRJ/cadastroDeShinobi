FROM eclipse-temurin:17
LABEL maintaner="GitHub: LucasDevRJ"
WORKDIR /app
COPY target/cadastroDeShinobi-0.0.1-SNAPSHOT.jar /app/cadastroDeShinobi.jar
ENTRYPOINT ["java", "-jar", "cadastroDeShinobi.jar"]