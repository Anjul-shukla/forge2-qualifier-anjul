# Forge 2 Qualifier – AI-Powered Kanban Backend

## Overview

This project is an AI-powered Kanban Project Management System built for the Forge 2 Qualifier.

The application provides project management, task tracking, Kanban workflows, AI-assisted planning, and Slack-based agent collaboration using OpenClaw and Ollama.

### Tech Stack

* Java 21
* Spring Boot 3
* Spring AI
* Ollama
* Qwen 2.5 Coder (7B)
* PostgreSQL
* Spring Security
* JWT Authentication
* Maven
* Slack
* OpenClaw

---

## Features

### Authentication & Security

* User Registration
* User Login
* JWT Authentication
* Role-Based Access Control

### Project Management

* Create Project
* Update Project
* Delete Project
* View Project Details

### Task Management

* Create Tasks
* Update Tasks
* Delete Tasks
* Assign Tasks
* Change Task Status

### Kanban Workflow

Supported statuses:

* TODO
* IN_PROGRESS
* REVIEW
* DONE

### AI Features

Powered by Spring AI + Ollama:

* AI Task Description Generation
* Task Breakdown into Subtasks
* Sprint Planning Assistance
* Task Estimation Suggestions
* Project Summary Generation
* Standup Report Generation

### Agent Collaboration

* OpenClaw connected to Slack
* Ollama running locally
* Agent communication logs included
* Workspace channels configured for collaboration

---

## Architecture

```text
Client
   |
   v
Spring Boot REST API
   |
   +-- Spring Security + JWT
   |
   +-- PostgreSQL
   |
   +-- Spring AI
            |
            v
      Ollama (qwen2.5-coder:7b)

Slack
   |
   v
OpenClaw Agent
```

---

## Local Setup

### Clone Repository

```bash
git clone https://github.com/Anjul-shukla/forge2-qualifier-anjul.git
cd forge2-qualifier-anjul
```

### Start Ollama

```bash
ollama pull qwen2.5-coder:7b
ollama serve
```

Default endpoint:

```text
http://localhost:11434
```

### Configure Database

Create a PostgreSQL database:

```sql
CREATE DATABASE forge2;
```

Update application configuration:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/forge2
    username: your_username
    password: your_password
```

### Run Application

```bash
mvn clean install
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

Swagger Documentation:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## API Modules

### Authentication

* POST /api/auth/register
* POST /api/auth/login

### Users

* GET /api/users
* GET /api/users/{id}

### Projects

* POST /api/projects
* GET /api/projects
* PUT /api/projects/{id}
* DELETE /api/projects/{id}

### Tasks

* POST /api/tasks
* GET /api/tasks
* PUT /api/tasks/{id}
* DELETE /api/tasks/{id}

### AI Services

* POST /api/ai/generate-description
* POST /api/ai/breakdown-task
* POST /api/ai/project-summary
* POST /api/ai/standup-report

---

##

---

## License

MIT License

---

## Author

Anjul Shukla

B.Tech Computer Science

Java Backend Developer

