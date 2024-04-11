#1.  Technology Selection
The project is developed in Spring Boot, utilizing Spring Data JPA for Object-Relational Mapping (ORM) and Flyway for database migrations.


#2. Spring Data JPA Configuration
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

#3. Definition of Entity Models and Table Mappings
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


#4. Flyway Configuration for Database Migrations
Flyway is used to manage database migrations. Configuration is done in the application.properties file: Konfigurimi i Flyway është bërë në file application.properties:
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


#5. Implementation of Database Migrations
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













