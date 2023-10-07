# Redcare Pharmacy Software Engineering, Java: Practical Task

---

### Author: Tamir Myblat ( tamirmayb@gmail.com )

### The services use Java 17 Spring Boot 2.7.5, Open API 3, Maven 3 and h2 as local db

#### This application exposes an internal API which searches GitHub repositories using GitHub API

---
# Build guide

### Testing
Before starting for the first time please run:
```
mvn clean install
```

Then, you can check that you are able to compile and pass the tests:
```
mvn clean test
```

### Application Start

To run the backend API locally:

```
mvn spring-boot:run
```

Otherwise, you can build a jar here:

```
mvn clean install 
java -jar target/gothub-1.0-SNAPSHOT.jar
```

## Server check

After the server started, API Documentation (Swagger) can be accessed here:

http://localhost:8080/v3/api-docs

http://localhost:8080/swagger-ui.html

## Searching Repositories
* Run http://localhost:8080/api/search/repositories?lang=Java
* Run http://localhost:8080/api/search/repositories?limit=100&from=2000-01-01&lang=Java
    * This will fetch repositories filtered by search params ```limit, from, lang```
    * Please note that:
        * At least one search params is required to trigger the search 
        * Limit has default value of 10
        * From should be formatted ```yyyy-MM-dd```
        * Language parameter searches by used language of the repository the languages are handled by `LanguageEnum`

### Thank you!
            