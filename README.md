## SPRING BOOT PROJECT - REST CRUD with DATABASE

GitHub: https://github.com/robmndz/SpringBoot_RestAPI.git

Create a REST API for the Employee Directory
REST clients should be able to:

- Get list of employees
- Get a single employee by id
- Add a new employee
- Update an employee
- Delete an employee

| HTTP Method | URL                              | CRUD Action                        |
| ----------- | -------------------------------- | ---------------------------------- |
| POST        | / api / employees                | Create a new employee              |
| GET         | / api / employees                | Read a list of employees           |
| GET         | / api / employees / {employeeId} | Read a single employee             |
| PUT         | / api / employees                | Update an existing employee (Url)  |
| PUT         | / api / employeesV2              | Update an existing employee (Body) |
| DELETE      | / api / employees / {employeeId} | Delete an existing employee        |
| GET         | / api / employees / size         | Number of employees                |

**Creating the project:**

Dependencies:

- Spring Boot Dev Tools

- Spring Web

- MySQL Driver

- Spring Data JPA

- Lombok
