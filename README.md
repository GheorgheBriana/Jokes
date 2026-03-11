# Jokes Application

A simple Spring Boot application that fetches jokes from the external JokeAPI and stores valid jokes in an H2 in-memory database.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring JDBC
- H2 Database
- Maven

## Endpoints

```http
GET /jokes/{amount}
GET /jokes/{amount}/add
```

### Examples

```http
GET /jokes/5
GET /jokes/5/add
```

- `/jokes/{amount}` fetches jokes from JokeAPI
- `/jokes/{amount}/add` saves valid jokes into the database

## H2 Console

```text
http://localhost:8080/h2-console
```

```text
JDBC URL: jdbc:h2:mem:jokesdb
User Name: sa
Password:
```

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Download Maven dependencies
4. Run `Jokes2Application`
5. Test the endpoints in the browser

## Notes

- Jokes are fetched from JokeAPI.
- JokeAPI allows a maximum `amount` value of 10.
- Only jokes with non-null `category`, `joke`, and `type` are saved.
- The database is in-memory, so data is lost when the application stops.

## API Documentation

- JokeAPI documentation: https://v2.jokeapi.dev/