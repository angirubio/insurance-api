# Insurance API - Spring Boot

This project implements a REST API for managing insurance policies using Spring Boot and Spring Data JPA. The API allows CRUD operations on insurance policies, as well as searching and paginating policies by customer name.

## Requirements
- Java 17 or higher
- Maven or Gradle for dependency management
- In-memory H2 Database (configured for quick testing)

## Features
- Retrieve all insurance policies.
- Get an insurance policy by its ID.
- Create a new insurance policy.
- Update an existing insurance policy.
- Delete an insurance policy.
- Search for policies by customer name with pagination.

## Installation & Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/angirubio/insurance-api.git
   cd insurance-api
   ```
2. Build the project using Maven:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints

### 1. Get all policies
- **Method:** GET  
- **Path:** `/api/policies`  
- **Description:** Retrieves all stored insurance policies.  
- **Example Response:**  
  ```json
  [
    {
      "id": 1,
      "policyNumber": "POL12345",
      "customerName": "Juan Pérez",
      "startDate": "2023-01-01",
      "endDate": "2024-01-01",
      "premiumAmount": 1200.50
    },
    {
      "id": 2,
      "policyNumber": "POL12346",
      "customerName": "Ana García",
      "startDate": "2023-02-01",
      "endDate": "2024-02-01",
      "premiumAmount": 950.00
    }
  ]
  ```

### 2. Get a policy by ID
- **Method:** GET  
- **Path:** `/api/policies/{id}`  
- **Description:** Retrieves an insurance policy by its ID.  
- **Example Response:**  
  ```json
  {
    "id": 1,
    "policyNumber": "POL12345",
    "customerName": "Juan Pérez",
    "startDate": "2023-01-01",
    "endDate": "2024-01-01",
    "premiumAmount": 1200.50
  }
  ```

### 3. Create a new policy
- **Method:** POST  
- **Path:** `/api/policies`  
- **Description:** Creates a new insurance policy.  
- **Request Body:**  
  ```json
  {
    "policyNumber": "POL12347",
    "customerName": "Carlos López",
    "startDate": "2023-03-01",
    "endDate": "2024-03-01",
    "premiumAmount": 1100.00
  }
  ```

### 4. Update an existing policy
- **Method:** PUT  
- **Path:** `/api/policies/{id}`  
- **Description:** Updates an existing insurance policy.

### 5. Delete a policy
- **Method:** DELETE  
- **Path:** `/api/policies/{id}`  
- **Description:** Deletes an insurance policy.

## Database Access
The API uses an in-memory H2 database. To access the H2 console, navigate to:
```
http://localhost:8080/h2-console
```
Use the following JDBC URL:
```
jdbc:h2:mem:testdb
```

## License
This project is licensed under the MIT License.
