# Web service for data linking with web application

We are retrieving company information for the purpose of updating our database of active businesses, we usually split business based on their company description.

## Requirements
* Java 8
* Maven 3.6.3

## Project structure (basic microservice architecture)
Each Spring Boot application includes an embedded server. Embedded server is embedded as a part of deployable application. The advantage of embedded server is, we do not require pre-installed server in the environment. With Spring Boot, default embedded server is Tomcat.
Main package : org.data.linking
* configuration : layer for classe with some configuiration
* controller : layer for rest controller, define the endpoint of api
* exceptions : layer for exception class.
* model : layer for all model : domain(entity) and dto (data transdert object)
* repository : layer for all class reporistory, to manage an interaction with database.
* service : layer for manage all intelligent metier.
* utils : layer for class helper.

## Project context : 
We invoke the Insee API to retrieve customer information by sending a siret parameter, and we store the result in an 'Etablissement' dto then we convert this object into a 'Company' entity and we persist this entity in the database, we uses the h2 in-memory database for this test and the database is: 'testdb'

At the level of the 'CompanyController' controller, the 'saveCompaniesInformation' method accepts a 'POST' method and takes as parameter in the body a list of string of sirets, in case the list is empty, we retrieve the list of sirets in the file configuration.

## Start project : 
* IntelliJ : configure in run/debug configuration, add springboot configuration and active profile 'dev'.
* Commande line : open console and execute 'java -Dspring.profiles.active=dev -jar web-application-data-linking-1.0-SNAPSHOT.jar' (in target folder)
* Maven : mvn spring-boot:run -Dspring-boot.run.profiles=dev (in root folder)

## libs and framework :
* spring-boot-starter-parent : it provides default configurations for our applications. It is used internally by all dependencies. All Spring Boot projects use spring-boot-starter-parent as a parent in pom.xml file.
* spring-boot-starter-data-jpa : it handles most of the complexity of JDBC-based database access and ORM (Object Relational Mapping). It reduces the boilerplate code required by JPA. It makes the implementation of persistence layer easier and faster.
* spring-boot-starter-web : it uses Spring MVC, REST and Tomcat as a default embedded server. The single spring-boot-starter-web dependency transitively pulls in all dependencies related to web development. It also reduces the build dependency count.
* spring-boot-starter-actuator : it's a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application. It contains the actuator endpoints (the place where the resources live).
* spring-boot-devtools : devTools stands for Developer Tool. The aim of the module is to try and improve the development time while working with the Spring Boot application. Spring Boot DevTools pick up the changes and restart the application. Spring Boot DevTools provides the following features : Property Defaults, Automatic Restart, LiveReload, Remote Debug Tunneling.
* spring-boot-starter-test : 
* commons-collections4 : 
* springdoc-openapi-ui : springdoc-openapi java library helps to automate the generation of API documentation using spring boot projects. springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations. We can simply access the API documentation at: http://localhost:8080/swagger-ui.html
* org.projectlombok : Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
  Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.

## Logging
to log, use SLF4J even in the project :
```
private static final Logger logger = LoggerFactory.getLogger(YourClass.class);
```

## Databases : H2 (url: http://localhost:8080/h2-ui)
In web console :
* Driver Class : org.h2.Driver
* JDBC URL : jdbc:h2:mem:testdb
* User Name : sa
* Password :
