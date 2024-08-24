# Spring Boot Project with Docker

## Overview

This project is a Spring Boot application that exposes various APIs. It uses Docker to containerize the application, making it easier to deploy and manage across different environments.

## Features

- **RESTful APIs**: Various endpoints for interacting with the application.
- **Docker Integration**: Containerized deployment for consistent environment setup.

## Prerequisites

- **Java 17** or higher
- **Docker**: [Install Docker](https://docs.docker.com/get-docker/)
- **Maven**: [Install Maven](https://maven.apache.org/install.html) (optional, for building without Docker)

## Notes:
For the provided request I have considered Nomralized version of the database and that's why I have splitted the data into 3 relations consisting of Supplier relation, Manufacturing relation and Supplier-Manufacturing relation, this way we would have used Normalization to avoid Redundancy of the data storage.
## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-repository.git
cd your-repository
```
### 2. Buiild your application

```bash
mvn clean package
docker build -t makerShark .
```

### 3. Run docker container
```bash
docker run -d -p 8080:8080 makerShark
```


