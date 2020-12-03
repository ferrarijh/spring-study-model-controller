## MVC
### Controller
* Controller recognizes user request via URL, asks Model for requested data,
then responds with appropriate view with the requested data to user.
* Controller manipulates Model.

### Model
* Actual data

### View
* View is a container that wraps html/css/javascript implementation.
* View creates appropriate code by which user will directly sees on screen.

## Issues Solved
* Gradle crash in sync

Open `gradle-wrapper.properties` file and downgrade gradle version to 6.5.
(solution [here](https://github.com/gradle/gradle/issues/14155))
 
* '400 bad request' on http request

Change model properties nullable to exclude any of them in request. 

* Flyway compile error - `Caused by: org.flywaydb.core.api.FlywayException: Found non-empty schema(s) "public" but no schema history table.
Use baseline() or set baselineOnMigrate to true to initialize the schema history table.`

Add below in `application.yml`.

```yml
spring:
   flyway:
     baselineOnMigrate: true
```

* Flyway not executing migration with `~.sql`file with proper query `CREATE TABLE ~`.

Possible causes and solutions:

1) Run log warned that current Postgres version(above 13) was not supported
- downgrade postgresql to 12.5 and works like a charm

2) Flyway acknowledges previously run sql scripts. Do not change `~.sql` files if possible.
If it's really necessary to apply modified sql script to database then drop the database and recreate it.

## Unresolved
* `Optional<T>`

## Extra

### Docker and Postgresql
* To view all container images, type below:

`docker ps`

* To access running container's terminal(bash in this case), type below:

`docker exec -it ${CONTAINER_NAME_OR_ID} bash`

bash is in `bin` folder so `docker exec -it ${CONTAINER_NAME_OR_ID} bin/bash` also works.

* In container bash, to access psql, type below:

`psql -U ${USER_NAME}`

* Then, to list all the databases: `\l`

* Then, to access certain db: `\c ${DB_NAME}`

* Then, to list all tables: `\dt`

* Finally, time for your sql queries to shine