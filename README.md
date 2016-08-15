# CassandraGenerator

CassandraGenerator generates Java code for Cassandra table from PostgrSQL table schema.

## Requirement system and framework

* JDK 1.8
* SPring Boot
* Gradle
* Lombok

## Usage

### Environment variables

You need to set environment variables below.

|variable name|explanation|example|
|---|---|---|
|PG_URL|JDBC URL for PostgreSQL|jdbc:postgresql://127.0.0.1/develop|
|PG_USER|PostgreSQL user name|postgres|
|PG_PSWD|PostgreSQL user password|StrongPassword|
|OUTPUT_DIRECTORY|Java code output directory|C:\temp\out|
|JAVA_PACKAGE_PATH|Java class package|com.test.dto|
