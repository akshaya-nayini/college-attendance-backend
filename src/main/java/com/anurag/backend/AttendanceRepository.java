
package com.anurag.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    List<Attendance> findByRollNumber(String rollNumber);

    List<Attendance> findByDate(LocalDate date);

    List<Attendance> findAllByRollNumberAndDate(String rollNumber, LocalDate date);
}
