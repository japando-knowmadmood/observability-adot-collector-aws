# Imagen base con soporte para Java 21
FROM amazoncorretto:21

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/microservicio-b-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación escucha
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
