# Student_Curd_Operation_Springboot

Spring Boot REST API for Student CRUD operations using Spring Data JPA, Hibernate, MySQL, and RESTful APIs.

## 🚀 Technologies Used

* Java 17
* Spring Boot
* Spring Web / REST API
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## 📁 Project Architecture

```text
src/main/java
└── in.striker.curdSpringBootDemo
    ├── Controller
    │   └── StudentController.java
    │
    ├── Service
    │   └── StudentService.java
    │
    ├── Repository
    │   └── StudentRepository.java
    │
    ├── entity
    │   └── Student.java
    │
    └── CurdSpringBootDemoApplication.java
```

### Layered Architecture

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database
```

## 🔗 API Endpoints

| Method | Endpoint                    | Description            |
| ------ | --------------------------- | ---------------------- |
| POST   | `/api/students/create`      | Create a new student   |
| GET    | `/api/students/get/{Id}`    | Get student by ID      |
| GET    | `/api/students/getall`      | Get all students       |
| PUT    | `/api/students/update/{Id}` | Update student details |
| DELETE | `/api/students/delete/{Id}` | Delete a student       |

## 📖 API Usage

### 1. Create Student

```http
POST http://localhost:8080/api/students/create
Content-Type: application/json
```

**Request Body:**

```json
{
  "name": "Rahul Sharma",
  "age": 22,
  "email": "rahul@example.com",
  "rollNo": 101,
  "subject": "Java"
}
```

### 2. Get Student By ID

```http
GET http://localhost:8080/api/students/get/1
```

### 3. Get All Students

```http
GET http://localhost:8080/api/students/getall
```

### 4. Update Student

```http
PUT http://localhost:8080/api/students/update/1
Content-Type: application/json
```

**Request Body:**

```json
{
  "name": "Rahul Sharma Updated",
  "age": 23,
  "email": "rahul.updated@example.com",
  "rollNo": 101,
  "subject": "Spring Boot"
}
```

### 5. Delete Student

```http
DELETE http://localhost:8080/api/students/delete/1
```

## ⚙️ Database Configuration

### Create MySQL Database

```sql
CREATE DATABASE student_crud_db;
```

### `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 📚 What I Learned

* Spring Boot project structure
* REST API development
* Controller-Service-Repository architecture
* Dependency Injection
* Spring Data JPA
* Hibernate ORM
* MySQL integration
* HTTP methods and status codes
* CRUD operations
* Request and response handling
