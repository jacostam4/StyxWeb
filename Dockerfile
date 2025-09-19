# ========= Build stage =========
FROM maven:3.9-eclipse-temurin-23 AS build
WORKDIR /app

# Copiamos pom y resolvemos dependencias primero (cache)
COPY pom.xml .
RUN mvn -q -e -B -DskipTests dependency:go-offline

# Ahora copiamos el código y construimos
COPY src ./src
RUN mvn -q -e -B -DskipTests package

# ========= Runtime stage =========
FROM eclipse-temurin:23-jre
WORKDIR /app

# (Opcional) Zona horaria del contenedor
ENV TZ=America/Bogota

# Copiamos el JAR construido
COPY --from=build /app/target/*.jar app.jar

# Activamos el perfil docker
ENV SPRING_PROFILES_ACTIVE=docker

# Exponemos el puerto interno (debe coincidir con server.port del perfil)
EXPOSE 8074

# Para pasar variables -D si quieres, puedes usarlas desde compose
ENTRYPOINT ["java","-jar","/app/app.jar"]
