## 1.  Technology Selection
The project is developed in Spring Boot, utilizing Spring Data JPA for Object-Relational Mapping (ORM) and Flyway for database migrations.


## 2. Spring Data JPA Configuration
To enable JPA in a Spring Boot application, dependencies like spring-boot-starter-data-jpa are required in the pom.xml file:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
Also, configuration in the application.properties file:
```
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.database=mysql
```

## 3. Definition of Entity Models and Table Mappings
Entities are defined using JPA annotations to specify the structure of tables in the database and the relationships between them. In this example, you store User objects, each annotated as a JPA entity. The following listing shows the User class (in src/main/java/com/eCommerce/eCommerceApp/Models/User.java)
```
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    int id;
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    String phoneNumber;
    String state;
    String zipCode;
    @Enumerated(value = EnumType.ORDINAL)
    Role role;
    .
```

The User class is annotated with @Entity, indicating that it is a JPA entity. (Because no @Table annotation exists, it is assumed that this entity is mapped to a table named users.)
The Customer object’s id property is annotated with @Id so that JPA recognizes it as the object’s ID. The id property is also annotated with @GeneratedValue to indicate that the ID should be generated automatically.
The other properties, firstName and lastName and so on, are left unannotated. It is assumed that they are mapped to columns that share the same names as the properties themselves.

By extending JpaRepository, UserRepository (src/main/java/com/eCommerce/eCommerceApp/Repository/UserRepository.java) inherits various methods for performing CRUD (Create, Read, Update, Delete) operations on User entities. JpaRepository is parameterized with two types: User (the entity type this repository manages) and Integer (the type of the primary key of the User entity). 

```
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
```


## 4. Flyway Configuration for Database Migrations
Flyway is used to manage database migrations. Configuration is done in the application.properties file:
```
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration
and in the pom.xml file with dependencies:
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>
```


## 5. Implementation of Database Migrations
Database migrations are written in SQL scripts. For example:
```
-- db/migration/V1__create_user_table.sql

CREATE TABLE users (
    userid INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(20),
    state VARCHAR(255),
    zipCode VARCHAR(10),
    role ENUM('ROLE_USER', 'ROLE_ADMIN') 
);
```

This script creates the "users" table in the database with columns for user details.
## Testing
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v3.1.10)

2024-04-11T14:05:01.185+02:00  INFO 6904 --- [           main] c.e.e.ECommerceAppApplication            : Starting ECommerceAppApplication using Java 21.0.2 with PID 6904 (C:\Users\ZoneTech\Desktop\E-commerce-Web-App\target\classes started by ZoneTech in C:\Users\ZoneTech\Desktop\E-commerce-Web-App)
2024-04-11T14:05:01.211+02:00  INFO 6904 --- [           main] c.e.e.ECommerceAppApplication            : No active profile set, falling back to 1 default profile: "default"
2024-04-11T14:05:03.209+02:00  INFO 6904 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-04-11T14:05:03.370+02:00  INFO 6904 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 140 ms. Found 1 JPA repository interface.
2024-04-11T14:05:04.833+02:00  INFO 6904 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2024-04-11T14:05:04.856+02:00  INFO 6904 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-04-11T14:05:04.857+02:00  INFO 6904 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-04-11T14:05:05.086+02:00  INFO 6904 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-04-11T14:05:05.088+02:00  INFO 6904 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3747 ms
2024-04-11T14:05:05.428+02:00  INFO 6904 --- [           main] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 9.16.3 by Redgate
2024-04-11T14:05:05.428+02:00  INFO 6904 --- [           main] o.f.c.internal.license.VersionPrinter    : See release notes here: https://rd.gt/416ObMi
2024-04-11T14:05:05.428+02:00  INFO 6904 --- [           main] o.f.c.internal.license.VersionPrinter    : 
2024-04-11T14:05:05.454+02:00  INFO 6904 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-04-11T14:05:06.476+02:00  INFO 6904 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@33a8c9c9
2024-04-11T14:05:06.480+02:00  INFO 6904 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-04-11T14:05:06.539+02:00  INFO 6904 --- [           main] o.f.c.i.database.base.BaseDatabaseType   : Database: jdbc:mysql://localhost:3306/findall (MySQL 8.2)
2024-04-11T14:05:06.600+02:00  WARN 6904 --- [           main] o.f.c.internal.database.base.Database    : Flyway upgrade recommended: MySQL 8.2 is newer than this version of Flyway and support has not been tested. The latest supported version of MySQL is 8.0.
2024-04-11T14:05:06.775+02:00  INFO 6904 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 3 migrations (execution time 00:00.130s)
2024-04-11T14:05:06.829+02:00  INFO 6904 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema `findall`: 2
2024-04-11T14:05:06.832+02:00  INFO 6904 --- [           main] o.f.core.internal.command.DbMigrate      : Schema `findall` is up to date. No migration necessary.
2024-04-11T14:05:07.429+02:00  INFO 6904 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-04-11T14:05:07.662+02:00  INFO 6904 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.2.22.Final
2024-04-11T14:05:07.670+02:00  INFO 6904 --- [           main] org.hibernate.cfg.Environment            : HHH000406: Using bytecode reflection optimizer
2024-04-11T14:05:10.641+02:00  INFO 6904 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2024-04-11T14:05:10.730+02:00  INFO 6904 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-04-11T14:05:11.950+02:00  WARN 6904 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2024-04-11T14:05:12.943+02:00  INFO 6904 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@73d7e7aa, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@349686e8, org.springframework.security.web.context.SecurityContextHolderFilter@70fcd3e5, org.springframework.security.web.header.HeaderWriterFilter@7adde776, org.springframework.security.web.authentication.logout.LogoutFilter@52e34db, com.eCommerce.eCommerceApp.Filter.JwtAuthenticationFilter@4d7fba20, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@9da386c, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@299cddbf, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@5c3e7128, org.springframework.security.web.session.SessionManagementFilter@20040c6e, org.springframework.security.web.access.ExceptionTranslationFilter@39ee07a9, org.springframework.security.web.access.intercept.AuthorizationFilter@48861d1]
2024-04-11T14:05:13.642+02:00  INFO 6904 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2024-04-11T14:05:13.676+02:00  INFO 6904 --- [           main] c.e.e.ECommerceAppApplication            : Started ECommerceAppApplication in 13.419 seconds (process running for 15.638)
```
