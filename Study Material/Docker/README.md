# Running a Spring Boot project inside a Docker container and using a graphical user interface (GUI) to interact with it requires specific setup steps. Here's how you can achieve this:


## Create a Dockerfile for the Spring Boot Project
- create a file named 'Dockerfile' exactly this name without any .extension in project's root directory
- if your jar file doesn't exists run the command
``` bash
    ./mvnw package
```

- Example Dockerfile:
``` notepad
# Use an OpenJDK image as the base
FROM openjdk:17-jdk-slim (replace 17 with your java version)

# Set the working directory
WORKDIR /app 

# Copy the Spring Boot jar file into the container
COPY target/<your-app>.jar <your app name>.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "<your app name>.jar"]

```
## Build and Run the Docker Image (. at last is compulsory)
``` bash
docker build -t < app name of your choice only in small case >:latest .
```

## Run the Docker container:
``` bash
 docker run -d -p 8080:8080 < your app name as above in step 3 >:latest
 ```
This will make your Spring Boot application accessible at http://localhost:8080. without running your main file in springboot