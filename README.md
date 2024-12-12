# Employee Management Application - Team 5

## Team
- **David Smith**: Backend Development and Project Setup
- **Pablo Limon-Paredes**: Test Coverage (Achieved 70% Coverage)
- **Chelsea Ogbonnia**: Frontend Development and UI Design

## Project Description

We have built a full-stack web application, the **Employee Management Application**, that allows users to manage employee data. The application supports basic CRUD (Create, Read, Update, Delete) operations for employees.

  <img width="1461" alt="Screenshot 2024-12-12 at 4 35 35 PM" src="https://github.com/user-attachments/assets/8c61b962-47d9-4c7c-a015-4bb4c6ef781a" />

### Features:
- **Create Employee**: Add new employee details.
- **List Employee**: View a list of all employees.
- **Update Employee**: Modify existing employee details.
- **Delete Employee**: Remove an employee from the database.

### Technologies Used:
- **Frontend**: React.js
- **Backend**: Spring Boot 3.4.0
- **Database**: H2
- **Authentication**: Clerk for sign-up and user authentication
- **Build Tool**: Maven
- **Server**: Embedded Tomcat 8.5+

## Demo Link
[Insert Demo Link Here]

## Installation Instructions

To run the project locally, follow these steps:

### Backend:
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/employee-management-app.git
2. Change Directories:
    ```bash
   cd employee-manager-server/
3. Install dependencies (if applicable):
   ```bash
   mvn install
4. Run the Spring Boot application:
   ```
   mvn spring-boot:run
The backend will run on the default port (usually 8080).

### Frontend:
1. Open another terminal.
2. Navigate to the frontend directory:
   ```bash
   cd employee-manager-client-frontend/
3. Install dependencies:
   ```bash
   npm install
4. Run the frontend:
   ```bash
   npm run dev
The frontend will be available at http://localhost:5134.
### Known Issues:
1. Could not archive employees.
2. Employees do not have a start and end date.

### Credits
Clerk: Used for user authentication and sign-up features.


