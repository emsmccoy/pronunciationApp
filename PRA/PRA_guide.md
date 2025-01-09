# Laboratory Practice Guide: Software Development Project

## Objective

Design and implement a full-stack application using Spring Boot for the backend and React for the frontend.

## Project Structure

### Backend (Spring Boot)

1. **Project Initialization**
   
   - Use <mark>Spring Initializr</mark> to create a new Spring Boot project
   - Include dependencies: Web, JPA, and your chosen database, H2 is ok.

2. **Folder Structure DDD**
   
   ```
   com.example.project
   ├── controller
   ├── model
   ├── repository
   ├── service
   └── config
   ```

3. **Entity Design**
   
   - Create domain model classes in the `model` package
   - Use appropriate JPA annotations

4. **Repository Layer**
   
   - Develop JPA repositories in the `repository` package
   - Extend `JpaRepository` for basic CRUD operations

5. **Service Layer**
   
   - Implement business logic in the `service` package
   - Use `@Service` annotation for service classes

6. **Controller Layer**
   
   - Create REST controllers in the `controller` package
   - Use `@RestController` and appropriate HTTP method annotations

7. **Configuration**
   
   - Set up database configuration in `application.properties` or `application.yml`
   - Create additional configurations in the `config` package if needed

### Frontend (React)

1. **Project Setup**
   
   - Use Create React App: `npx create-react-app frontend` or <mark>vite</mark>
     - [Vite guide]([Getting Started | Vite](https://vite.dev/guide/))
       
       ```bash
       npm create vite@latest
       ```
       
       

2. **Folder Structure**
   
   ```
   src
   ├── components
   ├── pages
   ├── services
   └── utils
   ```

3. **Component Development**
   
   - Create reusable components in the `components` folder
   - Develop page components in the `pages` folder

4. **API Integration**
   
   - Use<mark> Axios for API calls</mark>
   - Create an API service in the `services` folder

5. **State Management**
   
   - Utilize React <mark>hooks</mark> for local state management
   - Consider Redux or <u>Context API for global state if needed</u>

6. **Routing**
   
   - Implement routing using <mark>React Router</mark>

## Development Process

1. **Backend Development**
   - Implement entities, repositories, services, and controllers
   - Test API endpoints using Postman or Swagger
2. **Frontend Development**
   - Create React components and implement UI
   - Integrate with backend API using Axios
3. **Testing**
   - Write unit tests for both backend and frontend
   - Implement integration tests for API endpoints
4. **Documentation**
   - Document API endpoints:<mark> Postman or Swagger.</mark>
   - Create README files for both backend and frontend

## Best Practices

- Follow SOLID principles
- Use meaningful naming conventions
- Implement proper error handling
- Write clean, readable, and well-commented code
- Utilize <mark>dependency injection in Spring Boot</mark>
- Follow React best practices and h<mark>ooks guidelines</mark>

### Submission Guidelines

- Fork the existing [pronunciationApp](https://github.com/AlbertProfe/pronunciationApp) repository and clone it to your local environment.
- Create a new branch named `PRA01-YourName` from the latest commit.
- Commit your changes with clear, descriptive messages.
- Push your branch to your forked repository.
- <mark>Create a pull request to the AlbertProfe</mark> repository with a summary of your changes, titled:
  - `PRA01-YourName-NameLaboratory`
- Initial pull request must be submitted before the two-week deadline
- Students who does not complete the lab before the deadline must create a second pull request with additional enhancements or features

### Evaluation Criteria

**Backend (Spring Boot)**

- Correct implementation of JPA entities and repositories.
- Proper use of Spring Boot annotations and best practices.
- Functionality of service layer and controllers.
- Quality and coverage of Swagger API tests.
- Code clarity and documentation.

**Frontend (React)**

- Proper component structure and reusability
- Effective use of React hooks (useState, useEffect, etc.)
- Correct implementation of state management 
- Proper handling of API calls and asynchronous operations 
- Responsive and user-friendly UI design

> Remember to test your application thoroughly and ensure it meets all specified requirements.
