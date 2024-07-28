# Library Management System Testing

This repository provides the test suite for the Library Management System (LMS). It includes unit tests, integration tests, and various testing methodologies to ensure the system's reliability, functionality, and robustness. The repository uses JUnit, Mockito, and JaCoCo among other tools to maintain high-quality code standards and achieve comprehensive test coverage.

### Loom video
``` bash
https://www.loom.com/share/7df3342627f44e55ad82791075a0c888
```

## Testing Features

### Unit Testing
- **Framework:** JUnit
- **Description:** Tests individual components and methods for critical functionalities related to user authentication, book management, patron management, and transaction management.

### Integration Testing
- **Framework:** JUnit
- **Description:** Validates interactions between different modules with end-to-end scenarios, such as adding books, updating patron information, and performing transactions.

### Mocking and Stubbing
- **Framework:** Mockito
- **Description:** Mocks dependencies and stubs external components to isolate and control behavior during testing.

### Parameterized Testing
- **Framework:** JUnit Parameterized Tests
- **Description:** Evaluates system behavior with various inputs and edge cases to ensure robustness.

### Exception Handling
- **Framework:** JUnit
- **Description:** Verifies that methods handle exceptions gracefully and maintain system stability.

### Code Coverage Analysis
- **Tool:** JaCoCo
- **Description:** Assesses test coverage to minimize undetected defects and vulnerabilities.

### Regression Testing
- **Framework:** JUnit
- **Description:** Updates existing tests to ensure modifications do not introduce regressions or unintended side effects.

## How to Run Tests

### Using Maven
1. Ensure Maven is installed.
2. Navigate to the project root directory.
3. Run the tests with:
    ```sh
    mvn test
    ```

## Code Quality and Coverage Reports

### JaCoCo
1. Generate coverage reports with Maven:
    ```sh
    mvn jacoco:report
    ```
