
package com.anurag.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    boolean existsByRollNumber(String rollNumber);
}
